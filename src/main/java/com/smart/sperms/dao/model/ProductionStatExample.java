package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductionStatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductionStatExample() {
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

        public Criteria andPsDateIsNull() {
            addCriterion("ps_date is null");
            return (Criteria) this;
        }

        public Criteria andPsDateIsNotNull() {
            addCriterion("ps_date is not null");
            return (Criteria) this;
        }

        public Criteria andPsDateEqualTo(Date value) {
            addCriterion("ps_date =", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotEqualTo(Date value) {
            addCriterion("ps_date <>", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateGreaterThan(Date value) {
            addCriterion("ps_date >", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ps_date >=", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateLessThan(Date value) {
            addCriterion("ps_date <", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateLessThanOrEqualTo(Date value) {
            addCriterion("ps_date <=", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateIn(List<Date> values) {
            addCriterion("ps_date in", values, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotIn(List<Date> values) {
            addCriterion("ps_date not in", values, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateBetween(Date value1, Date value2) {
            addCriterion("ps_date between", value1, value2, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotBetween(Date value1, Date value2) {
            addCriterion("ps_date not between", value1, value2, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateIsNull() {
            addCriterion("ps_end_date is null");
            return (Criteria) this;
        }

        public Criteria andPsEndDateIsNotNull() {
            addCriterion("ps_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andPsEndDateEqualTo(Date value) {
            addCriterion("ps_end_date =", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateNotEqualTo(Date value) {
            addCriterion("ps_end_date <>", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateGreaterThan(Date value) {
            addCriterion("ps_end_date >", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ps_end_date >=", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateLessThan(Date value) {
            addCriterion("ps_end_date <", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateLessThanOrEqualTo(Date value) {
            addCriterion("ps_end_date <=", value, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateIn(List<Date> values) {
            addCriterion("ps_end_date in", values, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateNotIn(List<Date> values) {
            addCriterion("ps_end_date not in", values, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateBetween(Date value1, Date value2) {
            addCriterion("ps_end_date between", value1, value2, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsEndDateNotBetween(Date value1, Date value2) {
            addCriterion("ps_end_date not between", value1, value2, "psEndDate");
            return (Criteria) this;
        }

        public Criteria andPsMountIsNull() {
            addCriterion("ps_mount is null");
            return (Criteria) this;
        }

        public Criteria andPsMountIsNotNull() {
            addCriterion("ps_mount is not null");
            return (Criteria) this;
        }

        public Criteria andPsMountEqualTo(Integer value) {
            addCriterion("ps_mount =", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountNotEqualTo(Integer value) {
            addCriterion("ps_mount <>", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountGreaterThan(Integer value) {
            addCriterion("ps_mount >", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ps_mount >=", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountLessThan(Integer value) {
            addCriterion("ps_mount <", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountLessThanOrEqualTo(Integer value) {
            addCriterion("ps_mount <=", value, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountIn(List<Integer> values) {
            addCriterion("ps_mount in", values, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountNotIn(List<Integer> values) {
            addCriterion("ps_mount not in", values, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountBetween(Integer value1, Integer value2) {
            addCriterion("ps_mount between", value1, value2, "psMount");
            return (Criteria) this;
        }

        public Criteria andPsMountNotBetween(Integer value1, Integer value2) {
            addCriterion("ps_mount not between", value1, value2, "psMount");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("pro_id like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("pro_id not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andPsQuantityIsNull() {
            addCriterion("ps_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPsQuantityIsNotNull() {
            addCriterion("ps_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPsQuantityEqualTo(Integer value) {
            addCriterion("ps_quantity =", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityNotEqualTo(Integer value) {
            addCriterion("ps_quantity <>", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityGreaterThan(Integer value) {
            addCriterion("ps_quantity >", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("ps_quantity >=", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityLessThan(Integer value) {
            addCriterion("ps_quantity <", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("ps_quantity <=", value, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityIn(List<Integer> values) {
            addCriterion("ps_quantity in", values, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityNotIn(List<Integer> values) {
            addCriterion("ps_quantity not in", values, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("ps_quantity between", value1, value2, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andPsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("ps_quantity not between", value1, value2, "psQuantity");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andProIdLikeInsensitive(String value) {
            addCriterion("upper(pro_id) like", value.toUpperCase(), "proId");
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