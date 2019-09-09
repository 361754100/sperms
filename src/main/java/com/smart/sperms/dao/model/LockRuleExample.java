package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class LockRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LockRuleExample() {
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

        public Criteria andLrNoIsNull() {
            addCriterion("lr_no is null");
            return (Criteria) this;
        }

        public Criteria andLrNoIsNotNull() {
            addCriterion("lr_no is not null");
            return (Criteria) this;
        }

        public Criteria andLrNoEqualTo(String value) {
            addCriterion("lr_no =", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoNotEqualTo(String value) {
            addCriterion("lr_no <>", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoGreaterThan(String value) {
            addCriterion("lr_no >", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoGreaterThanOrEqualTo(String value) {
            addCriterion("lr_no >=", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoLessThan(String value) {
            addCriterion("lr_no <", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoLessThanOrEqualTo(String value) {
            addCriterion("lr_no <=", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoLike(String value) {
            addCriterion("lr_no like", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoNotLike(String value) {
            addCriterion("lr_no not like", value, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoIn(List<String> values) {
            addCriterion("lr_no in", values, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoNotIn(List<String> values) {
            addCriterion("lr_no not in", values, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoBetween(String value1, String value2) {
            addCriterion("lr_no between", value1, value2, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNoNotBetween(String value1, String value2) {
            addCriterion("lr_no not between", value1, value2, "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNameIsNull() {
            addCriterion("lr_name is null");
            return (Criteria) this;
        }

        public Criteria andLrNameIsNotNull() {
            addCriterion("lr_name is not null");
            return (Criteria) this;
        }

        public Criteria andLrNameEqualTo(String value) {
            addCriterion("lr_name =", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameNotEqualTo(String value) {
            addCriterion("lr_name <>", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameGreaterThan(String value) {
            addCriterion("lr_name >", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameGreaterThanOrEqualTo(String value) {
            addCriterion("lr_name >=", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameLessThan(String value) {
            addCriterion("lr_name <", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameLessThanOrEqualTo(String value) {
            addCriterion("lr_name <=", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameLike(String value) {
            addCriterion("lr_name like", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameNotLike(String value) {
            addCriterion("lr_name not like", value, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameIn(List<String> values) {
            addCriterion("lr_name in", values, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameNotIn(List<String> values) {
            addCriterion("lr_name not in", values, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameBetween(String value1, String value2) {
            addCriterion("lr_name between", value1, value2, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrNameNotBetween(String value1, String value2) {
            addCriterion("lr_name not between", value1, value2, "lrName");
            return (Criteria) this;
        }

        public Criteria andLrTypeIsNull() {
            addCriterion("lr_type is null");
            return (Criteria) this;
        }

        public Criteria andLrTypeIsNotNull() {
            addCriterion("lr_type is not null");
            return (Criteria) this;
        }

        public Criteria andLrTypeEqualTo(Integer value) {
            addCriterion("lr_type =", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeNotEqualTo(Integer value) {
            addCriterion("lr_type <>", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeGreaterThan(Integer value) {
            addCriterion("lr_type >", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lr_type >=", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeLessThan(Integer value) {
            addCriterion("lr_type <", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lr_type <=", value, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeIn(List<Integer> values) {
            addCriterion("lr_type in", values, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeNotIn(List<Integer> values) {
            addCriterion("lr_type not in", values, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeBetween(Integer value1, Integer value2) {
            addCriterion("lr_type between", value1, value2, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lr_type not between", value1, value2, "lrType");
            return (Criteria) this;
        }

        public Criteria andLrUnitIsNull() {
            addCriterion("lr_unit is null");
            return (Criteria) this;
        }

        public Criteria andLrUnitIsNotNull() {
            addCriterion("lr_unit is not null");
            return (Criteria) this;
        }

        public Criteria andLrUnitEqualTo(Integer value) {
            addCriterion("lr_unit =", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitNotEqualTo(Integer value) {
            addCriterion("lr_unit <>", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitGreaterThan(Integer value) {
            addCriterion("lr_unit >", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("lr_unit >=", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitLessThan(Integer value) {
            addCriterion("lr_unit <", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitLessThanOrEqualTo(Integer value) {
            addCriterion("lr_unit <=", value, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitIn(List<Integer> values) {
            addCriterion("lr_unit in", values, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitNotIn(List<Integer> values) {
            addCriterion("lr_unit not in", values, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitBetween(Integer value1, Integer value2) {
            addCriterion("lr_unit between", value1, value2, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("lr_unit not between", value1, value2, "lrUnit");
            return (Criteria) this;
        }

        public Criteria andLrTotalIsNull() {
            addCriterion("lr_total is null");
            return (Criteria) this;
        }

        public Criteria andLrTotalIsNotNull() {
            addCriterion("lr_total is not null");
            return (Criteria) this;
        }

        public Criteria andLrTotalEqualTo(Double value) {
            addCriterion("lr_total =", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalNotEqualTo(Double value) {
            addCriterion("lr_total <>", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalGreaterThan(Double value) {
            addCriterion("lr_total >", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("lr_total >=", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalLessThan(Double value) {
            addCriterion("lr_total <", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalLessThanOrEqualTo(Double value) {
            addCriterion("lr_total <=", value, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalIn(List<Double> values) {
            addCriterion("lr_total in", values, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalNotIn(List<Double> values) {
            addCriterion("lr_total not in", values, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalBetween(Double value1, Double value2) {
            addCriterion("lr_total between", value1, value2, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrTotalNotBetween(Double value1, Double value2) {
            addCriterion("lr_total not between", value1, value2, "lrTotal");
            return (Criteria) this;
        }

        public Criteria andLrNoLikeInsensitive(String value) {
            addCriterion("upper(lr_no) like", value.toUpperCase(), "lrNo");
            return (Criteria) this;
        }

        public Criteria andLrNameLikeInsensitive(String value) {
            addCriterion("upper(lr_name) like", value.toUpperCase(), "lrName");
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