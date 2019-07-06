package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentEnableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentEnableExample() {
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(String value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(String value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(String value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(String value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(String value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(String value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLike(String value) {
            addCriterion("e_id like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotLike(String value) {
            addCriterion("e_id not like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<String> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<String> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(String value1, String value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(String value1, String value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEeEnableIsNull() {
            addCriterion("ee_enable is null");
            return (Criteria) this;
        }

        public Criteria andEeEnableIsNotNull() {
            addCriterion("ee_enable is not null");
            return (Criteria) this;
        }

        public Criteria andEeEnableEqualTo(Integer value) {
            addCriterion("ee_enable =", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableNotEqualTo(Integer value) {
            addCriterion("ee_enable <>", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableGreaterThan(Integer value) {
            addCriterion("ee_enable >", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("ee_enable >=", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableLessThan(Integer value) {
            addCriterion("ee_enable <", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableLessThanOrEqualTo(Integer value) {
            addCriterion("ee_enable <=", value, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableIn(List<Integer> values) {
            addCriterion("ee_enable in", values, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableNotIn(List<Integer> values) {
            addCriterion("ee_enable not in", values, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableBetween(Integer value1, Integer value2) {
            addCriterion("ee_enable between", value1, value2, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("ee_enable not between", value1, value2, "eeEnable");
            return (Criteria) this;
        }

        public Criteria andEeConditionIsNull() {
            addCriterion("ee_condition is null");
            return (Criteria) this;
        }

        public Criteria andEeConditionIsNotNull() {
            addCriterion("ee_condition is not null");
            return (Criteria) this;
        }

        public Criteria andEeConditionEqualTo(String value) {
            addCriterion("ee_condition =", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionNotEqualTo(String value) {
            addCriterion("ee_condition <>", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionGreaterThan(String value) {
            addCriterion("ee_condition >", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionGreaterThanOrEqualTo(String value) {
            addCriterion("ee_condition >=", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionLessThan(String value) {
            addCriterion("ee_condition <", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionLessThanOrEqualTo(String value) {
            addCriterion("ee_condition <=", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionLike(String value) {
            addCriterion("ee_condition like", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionNotLike(String value) {
            addCriterion("ee_condition not like", value, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionIn(List<String> values) {
            addCriterion("ee_condition in", values, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionNotIn(List<String> values) {
            addCriterion("ee_condition not in", values, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionBetween(String value1, String value2) {
            addCriterion("ee_condition between", value1, value2, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeConditionNotBetween(String value1, String value2) {
            addCriterion("ee_condition not between", value1, value2, "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeIsNull() {
            addCriterion("ee_longitude is null");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeIsNotNull() {
            addCriterion("ee_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeEqualTo(String value) {
            addCriterion("ee_longitude =", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeNotEqualTo(String value) {
            addCriterion("ee_longitude <>", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeGreaterThan(String value) {
            addCriterion("ee_longitude >", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ee_longitude >=", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeLessThan(String value) {
            addCriterion("ee_longitude <", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeLessThanOrEqualTo(String value) {
            addCriterion("ee_longitude <=", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeLike(String value) {
            addCriterion("ee_longitude like", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeNotLike(String value) {
            addCriterion("ee_longitude not like", value, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeIn(List<String> values) {
            addCriterion("ee_longitude in", values, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeNotIn(List<String> values) {
            addCriterion("ee_longitude not in", values, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeBetween(String value1, String value2) {
            addCriterion("ee_longitude between", value1, value2, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeNotBetween(String value1, String value2) {
            addCriterion("ee_longitude not between", value1, value2, "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeIsNull() {
            addCriterion("ee_latitude is null");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeIsNotNull() {
            addCriterion("ee_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeEqualTo(String value) {
            addCriterion("ee_latitude =", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeNotEqualTo(String value) {
            addCriterion("ee_latitude <>", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeGreaterThan(String value) {
            addCriterion("ee_latitude >", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ee_latitude >=", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeLessThan(String value) {
            addCriterion("ee_latitude <", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeLessThanOrEqualTo(String value) {
            addCriterion("ee_latitude <=", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeLike(String value) {
            addCriterion("ee_latitude like", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeNotLike(String value) {
            addCriterion("ee_latitude not like", value, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeIn(List<String> values) {
            addCriterion("ee_latitude in", values, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeNotIn(List<String> values) {
            addCriterion("ee_latitude not in", values, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeBetween(String value1, String value2) {
            addCriterion("ee_latitude between", value1, value2, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeNotBetween(String value1, String value2) {
            addCriterion("ee_latitude not between", value1, value2, "eeLatitude");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andEeConditionLikeInsensitive(String value) {
            addCriterion("upper(ee_condition) like", value.toUpperCase(), "eeCondition");
            return (Criteria) this;
        }

        public Criteria andEeLongitudeLikeInsensitive(String value) {
            addCriterion("upper(ee_longitude) like", value.toUpperCase(), "eeLongitude");
            return (Criteria) this;
        }

        public Criteria andEeLatitudeLikeInsensitive(String value) {
            addCriterion("upper(ee_latitude) like", value.toUpperCase(), "eeLatitude");
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