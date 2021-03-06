const express = require('express');
const util = require('util');
const multer = require('multer');
const config = require('../config');
const output = require('../common/output').output;
const ctrl = require('../controllers/controllers');
const slaHelper = require('../common/slaHelper');

const router = express.Router();

router.get('/list/:type', function (req, res, next) {
    var type = ""
    if (req.params.type.toUpperCase() === "TASK") {
        type = "Task";
    } else {
        type = "Sub-task"
    }

    ctrl.getIssueList(type).then(function (issues) {
        if (typeof issues === "string") {
            res.json(JSON.parse(issues));
        } else {
            res.json(issues);
        }
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.get('/:issueId', function (req, res, next) {
    ctrl.getIssueById(req.params.issueId).then(function (issue) {
        if (typeof issue === "string") {
            res.json(JSON.parse(issue));
        } else {
            res.json(issue);
        }
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.get('/changelog/:issueId', function (req, res, next) {
    ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function (issue) {
        if (typeof issue === "string") {
            res.json(JSON.parse(issue));
        } else {
            res.json(issue);
        }
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.get('/sla/:issueId', function (req, res, next) {
    ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function (issue) {
        var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
        // var myIssue = config.sample.changelog;		

        if (!myIssue.fields[global.customFields.endIssueDate.id]) {
            res.json({ sla: 0, expression: null, issue: myIssue });
        } else {
            var histories = myIssue.changelog.histories;
            var watchers = slaHelper.getWatchers(histories);

            if (watchers === -1) {
                res.status(400).json({ error: 'Please check the issue status.' });
                return;
            }
            var endDate = myIssue.fields[global.customFields.endIssueDate.id]; //'2017-04-19T09:34:11.748+0000'; // todo
            var startDate = myIssue.fields.created; //'2017-04-12T09:34:11.748+0000'; // todo		
            var priority = myIssue.fields.priority.name;
            var serveHours = 0;

            if (priority === "P3") {
                serveHours = slaHelper.getServeHours(startDate, endDate, watchers, global.standard.noWorkHours[0], global.standard.noWorkHours[1]);
            } else {
                serveHours = slaHelper.getServeHours(startDate, endDate, watchers, global.standard.workHours[0], global.standard.workHours[1]);
            }

            var sla = 0;
            var zone = myIssue.fields[global.customFields.zone.id] || "1"; // todo
            var standardHours = 0; // todo
            var timeoutCount = 1; //todo

            slaHelper.getStandardHours(parseInt(zone, 10), priority, function (err, hour) {
                if (err) {
                    res.status(400).json(err);
                }
                standardHours = hour;

                slaHours = slaHelper.getSLAHours(serveHours, standardHours, timeoutCount);
                var expression = `(${serveHours} - ${standardHours}) / ${standardHours} + ${timeoutCount} = ${slaHours}`

                res.json({ sla: slaHours, expression: expression, issue: myIssue });
            });
        }

    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.post('/create', function (req, res, next) {
    var issue = req.body;

    ctrl.createIssue(issue).then(function (newIssue) {
        res.json(newIssue);
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.put('/:issueId', function (req, res, next) {
    var issue = req.body;

    ctrl.updateIssue(req.params.issueId, issue).then(function (data) {
        res.json({ status: 'ok' });
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.post('/plugin/update/:issueId', function (req, res, next) {
})

router.post('/end/:issueId', function (req, res, next) {
    var issueId = req.params.issueId;
    var body = req.body;

    ctrl.endIssue(issueId, body).then(function (result) {
        res.json(result);
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.post('/plugin/update/:issueId', function (req, res, next) {
    ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function (issue) {
        var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
        var eventType = myIssue.fields[global.customFields.eventType.id];
        var storeArea = myIssue.fields[global.customFields.storeArea.id];
        var storeNo = myIssue.fields[global.customFields.storeNo.id];
        var histories = myIssue.changelog.histories;

        var defaultEventType = "";
        if (eventType == null) {
            defaultEventType = "甲服务商项目组";
        } else {
            defaultEventType = eventType.value;
        }
        if (defaultEventType !== "") {
            var requestUrl = config.ddtalk + "?districtname=" + storeArea + "&diningname=" + storeNo + "&vendorname=" + defaultEventType;

            ctrl.extService(encodeURI(requestUrl)).then(function (result) {
                var result = typeof result === "string" ? JSON.parse(result) : result;
                if (result && result.data && result.data.serviceDeskName) {
                    var serveStationId = global.customFields.serveStation.id;
                    var serveStation = result.data.serviceDeskName;

                    var body = {
                        "fields": {}
                    };
                    body["fields"][serveStationId] = serveStation;

                    slaHelper.getZone(serveStation, storeNo, function (err, myZone) {
                        body["fields"][global.customFields.zone.id] = myZone + "";
                        // update serve station
                        ctrl.updateIssue(req.params.issueId, body).then(function () {
                            var vendor = defaultEventType.indexOf("乙") !== -1 ? "Vendor2" : "Vendor1";
                            // update assignee
                            ctrl.updateAssignee(req.params.issueId, vendor);
                        })
                    })
                }
            }).catch(function (err) {
                output(err);
            });
        }
    })
});

router.post('/plugin/robot/:issueId', function (req, res, next) {
    ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function (issue) {
        var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;

        var defaultEventType = "";
        if (eventType == null) {
            defaultEventType = "甲服务商项目组";
        } else {
            defaultEventType = eventType.value;
        }
        if (defaultEventType !== "") {
            var requestUrl = config.ddtalk + "?districtname=" + storeArea + "&diningname=" + storeNo + "&vendorname=" + defaultEventType;

            ctrl.extService(encodeURI(requestUrl)).then(function (result) {
                var result = typeof result === "string" ? JSON.parse(result) : result;
                // call itsm robot
                var serveStation = myIssue.fields[global.customFields.serveStation.id];
                if (result && result.data && result.data.serviceDeskName) {
                    var serveStationId = global.customFields.serveStation.id;
                    var serveStation = result.data.serviceDeskName;
                    if (serveStation) {
                        // ctrl.extService(encodeURI(config.ddRobot + "?issuekey=" + myIssue.key + "&deskname=" + serveStation));
                        slaHelper.getRobotToken(function (err, rows) {
                            var token = '';
                            if (err) { return; }
                            for (var k = 0; k < rows.length; k++) {
                                if (serveStation === rows[k]['service_desk_name']) {
                                    token = rows[k]['custom_robot_token'];
                                    break;
                                }
                            }
                            var link = {
                                "msgtype": "link",
                                "link": {
                                    "text": myIssue.key,
                                    "title": myIssue.key,
                                    "picUrl": "",
                                    "messageUrl": "http://itsmpoc6341.cloudapp.net:7777/pages/requestCloseCase.html?key=" + myIssue.key
                                }
                            }
                            ctrl.sendLink(config.itsmRobot + token, link);
                        })
                    }
                }
            });
        }
    })
});


module.exports = router;