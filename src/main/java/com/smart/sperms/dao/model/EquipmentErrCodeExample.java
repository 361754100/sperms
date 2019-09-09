package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentErrCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentErrCodeExample() {
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

        public Criteria andErrNameIsNull() {
            addCriterion("err_name is null");
            return (Criteria) this;
        }

        public Criteria andErrNameIsNotNull() {
            addCriterion("err_name is not null");
            return (Criteria) this;
        }

        public Criteria andErrNameEqualTo(String value) {
            addCriterion("err_name =", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameNotEqualTo(String value) {
            addCriterion("err_name <>", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameGreaterThan(String value) {
            addCriterion("err_name >", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameGreaterThanOrEqualTo(String value) {
            addCriterion("err_name >=", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameLessThan(String value) {
            addCriterion("err_name <", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameLessThanOrEqualTo(String value) {
            addCriterion("err_name <=", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameLike(String value) {
            addCriterion("err_name like", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameNotLike(String value) {
            addCriterion("err_name not like", value, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameIn(List<String> values) {
            addCriterion("err_name in", values, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameNotIn(List<String> values) {
            addCriterion("err_name not in", values, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameBetween(String value1, String value2) {
            addCriterion("err_name between", value1, value2, "errName");
            return (Criteria) this;
        }

        public Criteria andErrNameNotBetween(String value1, String value2) {
            addCriterion("err_name not between", value1, value2, "errName");
            return (Criteria) this;
        }

        public Criteria andErrDescIsNull() {
            addCriterion("err_desc is null");
            return (Criteria) this;
        }

        public Criteria andErrDescIsNotNull() {
            addCriterion("err_desc is not null");
            return (Criteria) this;
        }

        public Criteria andErrDescEqualTo(String value) {
            addCriterion("err_desc =", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotEqualTo(String value) {
            addCriterion("err_desc <>", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescGreaterThan(String value) {
            addCriterion("err_desc >", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescGreaterThanOrEqualTo(String value) {
            addCriterion("err_desc >=", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLessThan(String value) {
            addCriterion("err_desc <", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLessThanOrEqualTo(String value) {
            addCriterion("err_desc <=", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLike(String value) {
            addCriterion("err_desc like", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotLike(String value) {
            addCriterion("err_desc not like", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescIn(List<String> values) {
            addCriterion("err_desc in", values, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotIn(List<String> values) {
            addCriterion("err_desc not in", values, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescBetween(String value1, String value2) {
            addCriterion("err_desc between", value1, value2, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotBetween(String value1, String value2) {
            addCriterion("err_desc not between", value1, value2, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrCodeLikeInsensitive(String value) {
            addCriterion("upper(err_code) like", value.toUpperCase(), "errCode");
            return (Criteria) this;
        }

        public Criteria andErrNameLikeInsensitive(String value) {
            addCriterion("upper(err_name) like", value.toUpperCase(), "errName");
            return (Criteria) this;
        }

        public Criteria andErrDescLikeInsensitive(String value) {
            addCriterion("upper(err_desc) like", value.toUpperCase(), "errDesc");
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