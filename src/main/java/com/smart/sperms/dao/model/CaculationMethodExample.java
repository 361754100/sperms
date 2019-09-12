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

        public Criteria andCmNameIsNull() {
            addCriterion("cm_name is null");
            return (Criteria) this;
        }

        public Criteria andCmNameIsNotNull() {
            addCriterion("cm_name is not null");
            return (Criteria) this;
        }

        public Criteria andCmNameEqualTo(String value) {
            addCriterion("cm_name =", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotEqualTo(String value) {
            addCriterion("cm_name <>", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameGreaterThan(String value) {
            addCriterion("cm_name >", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameGreaterThanOrEqualTo(String value) {
            addCriterion("cm_name >=", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLessThan(String value) {
            addCriterion("cm_name <", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLessThanOrEqualTo(String value) {
            addCriterion("cm_name <=", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLike(String value) {
            addCriterion("cm_name like", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotLike(String value) {
            addCriterion("cm_name not like", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameIn(List<String> values) {
            addCriterion("cm_name in", values, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotIn(List<String> values) {
            addCriterion("cm_name not in", values, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameBetween(String value1, String value2) {
            addCriterion("cm_name between", value1, value2, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotBetween(String value1, String value2) {
            addCriterion("cm_name not between", value1, value2, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmTypeIsNull() {
            addCriterion("cm_type is null");
            return (Criteria) this;
        }

        public Criteria andCmTypeIsNotNull() {
            addCriterion("cm_type is not null");
            return (Criteria) this;
        }

        public Criteria andCmTypeEqualTo(Integer value) {
            addCriterion("cm_type =", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotEqualTo(Integer value) {
            addCriterion("cm_type <>", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeGreaterThan(Integer value) {
            addCriterion("cm_type >", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_type >=", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeLessThan(Integer value) {
            addCriterion("cm_type <", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cm_type <=", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeIn(List<Integer> values) {
            addCriterion("cm_type in", values, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotIn(List<Integer> values) {
            addCriterion("cm_type not in", values, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeBetween(Integer value1, Integer value2) {
            addCriterion("cm_type between", value1, value2, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_type not between", value1, value2, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmUnitIsNull() {
            addCriterion("cm_unit is null");
            return (Criteria) this;
        }

        public Criteria andCmUnitIsNotNull() {
            addCriterion("cm_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCmUnitEqualTo(Integer value) {
            addCriterion("cm_unit =", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitNotEqualTo(Integer value) {
            addCriterion("cm_unit <>", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitGreaterThan(Integer value) {
            addCriterion("cm_unit >", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_unit >=", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitLessThan(Integer value) {
            addCriterion("cm_unit <", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitLessThanOrEqualTo(Integer value) {
            addCriterion("cm_unit <=", value, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitIn(List<Integer> values) {
            addCriterion("cm_unit in", values, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitNotIn(List<Integer> values) {
            addCriterion("cm_unit not in", values, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitBetween(Integer value1, Integer value2) {
            addCriterion("cm_unit between", value1, value2, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_unit not between", value1, value2, "cmUnit");
            return (Criteria) this;
        }

        public Criteria andCmPriceIsNull() {
            addCriterion("cm_price is null");
            return (Criteria) this;
        }

        public Criteria andCmPriceIsNotNull() {
            addCriterion("cm_price is not null");
            return (Criteria) this;
        }

        public Criteria andCmPriceEqualTo(Double value) {
            addCriterion("cm_price =", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceNotEqualTo(Double value) {
            addCriterion("cm_price <>", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceGreaterThan(Double value) {
            addCriterion("cm_price >", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("cm_price >=", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceLessThan(Double value) {
            addCriterion("cm_price <", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceLessThanOrEqualTo(Double value) {
            addCriterion("cm_price <=", value, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceIn(List<Double> values) {
            addCriterion("cm_price in", values, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceNotIn(List<Double> values) {
            addCriterion("cm_price not in", values, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceBetween(Double value1, Double value2) {
            addCriterion("cm_price between", value1, value2, "cmPrice");
            return (Criteria) this;
        }

        public Criteria andCmPriceNotBetween(Double value1, Double value2) {
            addCriterion("cm_price not between", value1, value2, "cmPrice");
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

        public Criteria andCmNameLikeInsensitive(String value) {
            addCriterion("upper(cm_name) like", value.toUpperCase(), "cmName");
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