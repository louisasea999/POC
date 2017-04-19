var config = require('../config');
var util = require('../common/util');
var rq = require('../common/request');
var qs = require('querystring');

exports.getIssueList = function(type) {  
    var jql = 'project=' + config.v2.projectId;

    if(type === 'Task') {
        jql += ' AND type in (StoreSupportCase)';
    } else {
        jql  += ' AND type in (VendorSupportCase)';
    }
    return rq.getRequest("/search?jql="  + jql);
}

exports.getIssueById = function(issueId) {
    return rq.getRequest(config.v2.getIssueById + issueId);
}

exports.createIssue = function(issue) {
    return rq.postRequest(config.v2.createIssue, issue);
}

exports.updateIssue = function(issueId, issue) {
    return rq.putRequest(config.v2.getIssueById + issueId, issue);
}

exports.endIssue = function(issueId, body) {
    return rq.endIssueRequest(`/issue/${issueId}/transitions?expand=transitions.fields`, body);
}

