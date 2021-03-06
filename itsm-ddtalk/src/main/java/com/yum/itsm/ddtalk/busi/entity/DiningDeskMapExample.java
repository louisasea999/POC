package com.yum.itsm.ddtalk.busi.entity;

import java.util.ArrayList;
import java.util.List;

public class DiningDeskMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiningDeskMapExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDiningDeskIdIsNull() {
            addCriterion("dining_desk_id is null");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdIsNotNull() {
            addCriterion("dining_desk_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdEqualTo(Long value) {
            addCriterion("dining_desk_id =", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdNotEqualTo(Long value) {
            addCriterion("dining_desk_id <>", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdGreaterThan(Long value) {
            addCriterion("dining_desk_id >", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dining_desk_id >=", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdLessThan(Long value) {
            addCriterion("dining_desk_id <", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdLessThanOrEqualTo(Long value) {
            addCriterion("dining_desk_id <=", value, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdIn(List<Long> values) {
            addCriterion("dining_desk_id in", values, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdNotIn(List<Long> values) {
            addCriterion("dining_desk_id not in", values, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdBetween(Long value1, Long value2) {
            addCriterion("dining_desk_id between", value1, value2, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningDeskIdNotBetween(Long value1, Long value2) {
            addCriterion("dining_desk_id not between", value1, value2, "diningDeskId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdIsNull() {
            addCriterion("dining_room_id is null");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdIsNotNull() {
            addCriterion("dining_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdEqualTo(Long value) {
            addCriterion("dining_room_id =", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdNotEqualTo(Long value) {
            addCriterion("dining_room_id <>", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdGreaterThan(Long value) {
            addCriterion("dining_room_id >", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dining_room_id >=", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdLessThan(Long value) {
            addCriterion("dining_room_id <", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("dining_room_id <=", value, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdIn(List<Long> values) {
            addCriterion("dining_room_id in", values, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdNotIn(List<Long> values) {
            addCriterion("dining_room_id not in", values, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdBetween(Long value1, Long value2) {
            addCriterion("dining_room_id between", value1, value2, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andDiningRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("dining_room_id not between", value1, value2, "diningRoomId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIsNull() {
            addCriterion("service_desk_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIsNotNull() {
            addCriterion("service_desk_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdEqualTo(Long value) {
            addCriterion("service_desk_id =", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotEqualTo(Long value) {
            addCriterion("service_desk_id <>", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdGreaterThan(Long value) {
            addCriterion("service_desk_id >", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_desk_id >=", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdLessThan(Long value) {
            addCriterion("service_desk_id <", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdLessThanOrEqualTo(Long value) {
            addCriterion("service_desk_id <=", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIn(List<Long> values) {
            addCriterion("service_desk_id in", values, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotIn(List<Long> values) {
            addCriterion("service_desk_id not in", values, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdBetween(Long value1, Long value2) {
            addCriterion("service_desk_id between", value1, value2, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotBetween(Long value1, Long value2) {
            addCriterion("service_desk_id not between", value1, value2, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andZoneLevelIsNull() {
            addCriterion("zone_level is null");
            return (Criteria) this;
        }

        public Criteria andZoneLevelIsNotNull() {
            addCriterion("zone_level is not null");
            return (Criteria) this;
        }

        public Criteria andZoneLevelEqualTo(Integer value) {
            addCriterion("zone_level =", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelNotEqualTo(Integer value) {
            addCriterion("zone_level <>", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelGreaterThan(Integer value) {
            addCriterion("zone_level >", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("zone_level >=", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelLessThan(Integer value) {
            addCriterion("zone_level <", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelLessThanOrEqualTo(Integer value) {
            addCriterion("zone_level <=", value, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelIn(List<Integer> values) {
            addCriterion("zone_level in", values, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelNotIn(List<Integer> values) {
            addCriterion("zone_level not in", values, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelBetween(Integer value1, Integer value2) {
            addCriterion("zone_level between", value1, value2, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andZoneLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("zone_level not between", value1, value2, "zoneLevel");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}