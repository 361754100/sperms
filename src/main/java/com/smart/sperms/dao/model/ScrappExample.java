package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScrappExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScrappExample() {
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

        public Criteria andScTimeIsNull() {
            addCriterion("sc_time is null");
            return (Criteria) this;
        }

        public Criteria andScTimeIsNotNull() {
            addCriterion("sc_time is not null");
            return (Criteria) this;
        }

        public Criteria andScTimeEqualTo(Date value) {
            addCriterion("sc_time =", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeNotEqualTo(Date value) {
            addCriterion("sc_time <>", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeGreaterThan(Date value) {
            addCriterion("sc_time >", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sc_time >=", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeLessThan(Date value) {
            addCriterion("sc_time <", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeLessThanOrEqualTo(Date value) {
            addCriterion("sc_time <=", value, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeIn(List<Date> values) {
            addCriterion("sc_time in", values, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeNotIn(List<Date> values) {
            addCriterion("sc_time not in", values, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeBetween(Date value1, Date value2) {
            addCriterion("sc_time between", value1, value2, "scTime");
            return (Criteria) this;
        }

        public Criteria andScTimeNotBetween(Date value1, Date value2) {
            addCriterion("sc_time not between", value1, value2, "scTime");
            return (Criteria) this;
        }

        public Criteria andScReasonIsNull() {
            addCriterion("sc_reason is null");
            return (Criteria) this;
        }

        public Criteria andScReasonIsNotNull() {
            addCriterion("sc_reason is not null");
            return (Criteria) this;
        }

        public Criteria andScReasonEqualTo(String value) {
            addCriterion("sc_reason =", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonNotEqualTo(String value) {
            addCriterion("sc_reason <>", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonGreaterThan(String value) {
            addCriterion("sc_reason >", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonGreaterThanOrEqualTo(String value) {
            addCriterion("sc_reason >=", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonLessThan(String value) {
            addCriterion("sc_reason <", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonLessThanOrEqualTo(String value) {
            addCriterion("sc_reason <=", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonLike(String value) {
            addCriterion("sc_reason like", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonNotLike(String value) {
            addCriterion("sc_reason not like", value, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonIn(List<String> values) {
            addCriterion("sc_reason in", values, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonNotIn(List<String> values) {
            addCriterion("sc_reason not in", values, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonBetween(String value1, String value2) {
            addCriterion("sc_reason between", value1, value2, "scReason");
            return (Criteria) this;
        }

        public Criteria andScReasonNotBetween(String value1, String value2) {
            addCriterion("sc_reason not between", value1, value2, "scReason");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andScReasonLikeInsensitive(String value) {
            addCriterion("upper(sc_reason) like", value.toUpperCase(), "scReason");
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