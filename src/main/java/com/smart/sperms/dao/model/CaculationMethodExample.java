package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class CaculationMethodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaculationMethodExample() {
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

        public Criteria andCmNoIsNull() {
            addCriterion("cm_no is null");
            return (Criteria) this;
        }

        public Criteria andCmNoIsNotNull() {
            addCriterion("cm_no is not null");
            return (Criteria) this;
        }

        public Criteria andCmNoEqualTo(String value) {
            addCriterion("cm_no =", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoNotEqualTo(String value) {
            addCriterion("cm_no <>", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoGreaterThan(String value) {
            addCriterion("cm_no >", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoGreaterThanOrEqualTo(String value) {
            addCriterion("cm_no >=", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoLessThan(String value) {
            addCriterion("cm_no <", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoLessThanOrEqualTo(String value) {
            addCriterion("cm_no <=", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoLike(String value) {
            addCriterion("cm_no like", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoNotLike(String value) {
            addCriterion("cm_no not like", value, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoIn(List<String> values) {
            addCriterion("cm_no in", values, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoNotIn(List<String> values) {
            addCriterion("cm_no not in", values, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoBetween(String value1, String value2) {
            addCriterion("cm_no between", value1, value2, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmNoNotBetween(String value1, String value2) {
            addCriterion("cm_no not between", value1, value2, "cmNo");
            return (Criteria) this;
        }

        public Criteria andCmDayIsNull() {
            addCriterion("cm_day is null");
            return (Criteria) this;
        }

        public Criteria andCmDayIsNotNull() {
            addCriterion("cm_day is not null");
            return (Criteria) this;
        }

        public Criteria andCmDayEqualTo(Integer value) {
            addCriterion("cm_day =", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayNotEqualTo(Integer value) {
            addCriterion("cm_day <>", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayGreaterThan(Integer value) {
            addCriterion("cm_day >", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_day >=", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayLessThan(Integer value) {
            addCriterion("cm_day <", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayLessThanOrEqualTo(Integer value) {
            addCriterion("cm_day <=", value, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayIn(List<Integer> values) {
            addCriterion("cm_day in", values, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayNotIn(List<Integer> values) {
            addCriterion("cm_day not in", values, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayBetween(Integer value1, Integer value2) {
            addCriterion("cm_day between", value1, value2, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmDayNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_day not between", value1, value2, "cmDay");
            return (Criteria) this;
        }

        public Criteria andCmFeeIsNull() {
            addCriterion("cm_fee is null");
            return (Criteria) this;
        }

        public Criteria andCmFeeIsNotNull() {
            addCriterion("cm_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCmFeeEqualTo(Double value) {
            addCriterion("cm_fee =", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeNotEqualTo(Double value) {
            addCriterion("cm_fee <>", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeGreaterThan(Double value) {
            addCriterion("cm_fee >", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("cm_fee >=", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeLessThan(Double value) {
            addCriterion("cm_fee <", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeLessThanOrEqualTo(Double value) {
            addCriterion("cm_fee <=", value, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeIn(List<Double> values) {
            addCriterion("cm_fee in", values, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeNotIn(List<Double> values) {
            addCriterion("cm_fee not in", values, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeBetween(Double value1, Double value2) {
            addCriterion("cm_fee between", value1, value2, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmFeeNotBetween(Double value1, Double value2) {
            addCriterion("cm_fee not between", value1, value2, "cmFee");
            return (Criteria) this;
        }

        public Criteria andCmRemainIsNull() {
            addCriterion("cm_remain is null");
            return (Criteria) this;
        }

        public Criteria andCmRemainIsNotNull() {
            addCriterion("cm_remain is not null");
            return (Criteria) this;
        }

        public Criteria andCmRemainEqualTo(Integer value) {
            addCriterion("cm_remain =", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainNotEqualTo(Integer value) {
            addCriterion("cm_remain <>", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainGreaterThan(Integer value) {
            addCriterion("cm_remain >", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_remain >=", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainLessThan(Integer value) {
            addCriterion("cm_remain <", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainLessThanOrEqualTo(Integer value) {
            addCriterion("cm_remain <=", value, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainIn(List<Integer> values) {
            addCriterion("cm_remain in", values, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainNotIn(List<Integer> values) {
            addCriterion("cm_remain not in", values, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainBetween(Integer value1, Integer value2) {
            addCriterion("cm_remain between", value1, value2, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmRemainNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_remain not between", value1, value2, "cmRemain");
            return (Criteria) this;
        }

        public Criteria andCmNoLikeInsensitive(String value) {
            addCriterion("upper(cm_no) like", value.toUpperCase(), "cmNo");
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