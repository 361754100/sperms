package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andRTimeIsNull() {
            addCriterion("r_time is null");
            return (Criteria) this;
        }

        public Criteria andRTimeIsNotNull() {
            addCriterion("r_time is not null");
            return (Criteria) this;
        }

        public Criteria andRTimeEqualTo(Date value) {
            addCriterion("r_time =", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotEqualTo(Date value) {
            addCriterion("r_time <>", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeGreaterThan(Date value) {
            addCriterion("r_time >", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("r_time >=", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeLessThan(Date value) {
            addCriterion("r_time <", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeLessThanOrEqualTo(Date value) {
            addCriterion("r_time <=", value, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeIn(List<Date> values) {
            addCriterion("r_time in", values, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotIn(List<Date> values) {
            addCriterion("r_time not in", values, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeBetween(Date value1, Date value2) {
            addCriterion("r_time between", value1, value2, "rTime");
            return (Criteria) this;
        }

        public Criteria andRTimeNotBetween(Date value1, Date value2) {
            addCriterion("r_time not between", value1, value2, "rTime");
            return (Criteria) this;
        }

        public Criteria andRManufacturerIsNull() {
            addCriterion("r_manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andRManufacturerIsNotNull() {
            addCriterion("r_manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andRManufacturerEqualTo(String value) {
            addCriterion("r_manufacturer =", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerNotEqualTo(String value) {
            addCriterion("r_manufacturer <>", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerGreaterThan(String value) {
            addCriterion("r_manufacturer >", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("r_manufacturer >=", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerLessThan(String value) {
            addCriterion("r_manufacturer <", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerLessThanOrEqualTo(String value) {
            addCriterion("r_manufacturer <=", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerLike(String value) {
            addCriterion("r_manufacturer like", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerNotLike(String value) {
            addCriterion("r_manufacturer not like", value, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerIn(List<String> values) {
            addCriterion("r_manufacturer in", values, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerNotIn(List<String> values) {
            addCriterion("r_manufacturer not in", values, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerBetween(String value1, String value2) {
            addCriterion("r_manufacturer between", value1, value2, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andRManufacturerNotBetween(String value1, String value2) {
            addCriterion("r_manufacturer not between", value1, value2, "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("err_code is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("err_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("err_code =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("err_code <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("err_code >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("err_code >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("err_code <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("err_code <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("err_code like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("err_code not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("err_code in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("err_code not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("err_code between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("err_code not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andRStateIsNull() {
            addCriterion("r_state is null");
            return (Criteria) this;
        }

        public Criteria andRStateIsNotNull() {
            addCriterion("r_state is not null");
            return (Criteria) this;
        }

        public Criteria andRStateEqualTo(String value) {
            addCriterion("r_state =", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotEqualTo(String value) {
            addCriterion("r_state <>", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateGreaterThan(String value) {
            addCriterion("r_state >", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateGreaterThanOrEqualTo(String value) {
            addCriterion("r_state >=", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateLessThan(String value) {
            addCriterion("r_state <", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateLessThanOrEqualTo(String value) {
            addCriterion("r_state <=", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateLike(String value) {
            addCriterion("r_state like", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotLike(String value) {
            addCriterion("r_state not like", value, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateIn(List<String> values) {
            addCriterion("r_state in", values, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotIn(List<String> values) {
            addCriterion("r_state not in", values, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateBetween(String value1, String value2) {
            addCriterion("r_state between", value1, value2, "rState");
            return (Criteria) this;
        }

        public Criteria andRStateNotBetween(String value1, String value2) {
            addCriterion("r_state not between", value1, value2, "rState");
            return (Criteria) this;
        }

        public Criteria andRCostIsNull() {
            addCriterion("r_cost is null");
            return (Criteria) this;
        }

        public Criteria andRCostIsNotNull() {
            addCriterion("r_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRCostEqualTo(Double value) {
            addCriterion("r_cost =", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostNotEqualTo(Double value) {
            addCriterion("r_cost <>", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostGreaterThan(Double value) {
            addCriterion("r_cost >", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostGreaterThanOrEqualTo(Double value) {
            addCriterion("r_cost >=", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostLessThan(Double value) {
            addCriterion("r_cost <", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostLessThanOrEqualTo(Double value) {
            addCriterion("r_cost <=", value, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostIn(List<Double> values) {
            addCriterion("r_cost in", values, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostNotIn(List<Double> values) {
            addCriterion("r_cost not in", values, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostBetween(Double value1, Double value2) {
            addCriterion("r_cost between", value1, value2, "rCost");
            return (Criteria) this;
        }

        public Criteria andRCostNotBetween(Double value1, Double value2) {
            addCriterion("r_cost not between", value1, value2, "rCost");
            return (Criteria) this;
        }

        public Criteria andRPersonIsNull() {
            addCriterion("r_person is null");
            return (Criteria) this;
        }

        public Criteria andRPersonIsNotNull() {
            addCriterion("r_person is not null");
            return (Criteria) this;
        }

        public Criteria andRPersonEqualTo(String value) {
            addCriterion("r_person =", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonNotEqualTo(String value) {
            addCriterion("r_person <>", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonGreaterThan(String value) {
            addCriterion("r_person >", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonGreaterThanOrEqualTo(String value) {
            addCriterion("r_person >=", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonLessThan(String value) {
            addCriterion("r_person <", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonLessThanOrEqualTo(String value) {
            addCriterion("r_person <=", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonLike(String value) {
            addCriterion("r_person like", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonNotLike(String value) {
            addCriterion("r_person not like", value, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonIn(List<String> values) {
            addCriterion("r_person in", values, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonNotIn(List<String> values) {
            addCriterion("r_person not in", values, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonBetween(String value1, String value2) {
            addCriterion("r_person between", value1, value2, "rPerson");
            return (Criteria) this;
        }

        public Criteria andRPersonNotBetween(String value1, String value2) {
            addCriterion("r_person not between", value1, value2, "rPerson");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andRManufacturerLikeInsensitive(String value) {
            addCriterion("upper(r_manufacturer) like", value.toUpperCase(), "rManufacturer");
            return (Criteria) this;
        }

        public Criteria andErrCodeLikeInsensitive(String value) {
            addCriterion("upper(err_code) like", value.toUpperCase(), "errCode");
            return (Criteria) this;
        }

        public Criteria andRStateLikeInsensitive(String value) {
            addCriterion("upper(r_state) like", value.toUpperCase(), "rState");
            return (Criteria) this;
        }

        public Criteria andRPersonLikeInsensitive(String value) {
            addCriterion("upper(r_person) like", value.toUpperCase(), "rPerson");
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