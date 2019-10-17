package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProSizeIsNull() {
            addCriterion("pro_size is null");
            return (Criteria) this;
        }

        public Criteria andProSizeIsNotNull() {
            addCriterion("pro_size is not null");
            return (Criteria) this;
        }

        public Criteria andProSizeEqualTo(String value) {
            addCriterion("pro_size =", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotEqualTo(String value) {
            addCriterion("pro_size <>", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeGreaterThan(String value) {
            addCriterion("pro_size >", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_size >=", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLessThan(String value) {
            addCriterion("pro_size <", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLessThanOrEqualTo(String value) {
            addCriterion("pro_size <=", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLike(String value) {
            addCriterion("pro_size like", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotLike(String value) {
            addCriterion("pro_size not like", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeIn(List<String> values) {
            addCriterion("pro_size in", values, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotIn(List<String> values) {
            addCriterion("pro_size not in", values, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeBetween(String value1, String value2) {
            addCriterion("pro_size between", value1, value2, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotBetween(String value1, String value2) {
            addCriterion("pro_size not between", value1, value2, "proSize");
            return (Criteria) this;
        }

        public Criteria andProMaterialIsNull() {
            addCriterion("pro_material is null");
            return (Criteria) this;
        }

        public Criteria andProMaterialIsNotNull() {
            addCriterion("pro_material is not null");
            return (Criteria) this;
        }

        public Criteria andProMaterialEqualTo(String value) {
            addCriterion("pro_material =", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialNotEqualTo(String value) {
            addCriterion("pro_material <>", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialGreaterThan(String value) {
            addCriterion("pro_material >", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("pro_material >=", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialLessThan(String value) {
            addCriterion("pro_material <", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialLessThanOrEqualTo(String value) {
            addCriterion("pro_material <=", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialLike(String value) {
            addCriterion("pro_material like", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialNotLike(String value) {
            addCriterion("pro_material not like", value, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialIn(List<String> values) {
            addCriterion("pro_material in", values, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialNotIn(List<String> values) {
            addCriterion("pro_material not in", values, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialBetween(String value1, String value2) {
            addCriterion("pro_material between", value1, value2, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProMaterialNotBetween(String value1, String value2) {
            addCriterion("pro_material not between", value1, value2, "proMaterial");
            return (Criteria) this;
        }

        public Criteria andProLengthIsNull() {
            addCriterion("pro_length is null");
            return (Criteria) this;
        }

        public Criteria andProLengthIsNotNull() {
            addCriterion("pro_length is not null");
            return (Criteria) this;
        }

        public Criteria andProLengthEqualTo(Double value) {
            addCriterion("pro_length =", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthNotEqualTo(Double value) {
            addCriterion("pro_length <>", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthGreaterThan(Double value) {
            addCriterion("pro_length >", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_length >=", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthLessThan(Double value) {
            addCriterion("pro_length <", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthLessThanOrEqualTo(Double value) {
            addCriterion("pro_length <=", value, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthIn(List<Double> values) {
            addCriterion("pro_length in", values, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthNotIn(List<Double> values) {
            addCriterion("pro_length not in", values, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthBetween(Double value1, Double value2) {
            addCriterion("pro_length between", value1, value2, "proLength");
            return (Criteria) this;
        }

        public Criteria andProLengthNotBetween(Double value1, Double value2) {
            addCriterion("pro_length not between", value1, value2, "proLength");
            return (Criteria) this;
        }

        public Criteria andProWeightStdIsNull() {
            addCriterion("pro_weight_std is null");
            return (Criteria) this;
        }

        public Criteria andProWeightStdIsNotNull() {
            addCriterion("pro_weight_std is not null");
            return (Criteria) this;
        }

        public Criteria andProWeightStdEqualTo(Double value) {
            addCriterion("pro_weight_std =", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdNotEqualTo(Double value) {
            addCriterion("pro_weight_std <>", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdGreaterThan(Double value) {
            addCriterion("pro_weight_std >", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_weight_std >=", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdLessThan(Double value) {
            addCriterion("pro_weight_std <", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdLessThanOrEqualTo(Double value) {
            addCriterion("pro_weight_std <=", value, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdIn(List<Double> values) {
            addCriterion("pro_weight_std in", values, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdNotIn(List<Double> values) {
            addCriterion("pro_weight_std not in", values, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdBetween(Double value1, Double value2) {
            addCriterion("pro_weight_std between", value1, value2, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightStdNotBetween(Double value1, Double value2) {
            addCriterion("pro_weight_std not between", value1, value2, "proWeightStd");
            return (Criteria) this;
        }

        public Criteria andProWeightActualIsNull() {
            addCriterion("pro_weight_actual is null");
            return (Criteria) this;
        }

        public Criteria andProWeightActualIsNotNull() {
            addCriterion("pro_weight_actual is not null");
            return (Criteria) this;
        }

        public Criteria andProWeightActualEqualTo(Double value) {
            addCriterion("pro_weight_actual =", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualNotEqualTo(Double value) {
            addCriterion("pro_weight_actual <>", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualGreaterThan(Double value) {
            addCriterion("pro_weight_actual >", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_weight_actual >=", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualLessThan(Double value) {
            addCriterion("pro_weight_actual <", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualLessThanOrEqualTo(Double value) {
            addCriterion("pro_weight_actual <=", value, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualIn(List<Double> values) {
            addCriterion("pro_weight_actual in", values, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualNotIn(List<Double> values) {
            addCriterion("pro_weight_actual not in", values, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualBetween(Double value1, Double value2) {
            addCriterion("pro_weight_actual between", value1, value2, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProWeightActualNotBetween(Double value1, Double value2) {
            addCriterion("pro_weight_actual not between", value1, value2, "proWeightActual");
            return (Criteria) this;
        }

        public Criteria andProIdLikeInsensitive(String value) {
            addCriterion("upper(pro_id) like", value.toUpperCase(), "proId");
            return (Criteria) this;
        }

        public Criteria andProNameLikeInsensitive(String value) {
            addCriterion("upper(pro_name) like", value.toUpperCase(), "proName");
            return (Criteria) this;
        }

        public Criteria andProTypeLikeInsensitive(String value) {
            addCriterion("upper(pro_type) like", value.toUpperCase(), "proType");
            return (Criteria) this;
        }

        public Criteria andProSizeLikeInsensitive(String value) {
            addCriterion("upper(pro_size) like", value.toUpperCase(), "proSize");
            return (Criteria) this;
        }

        public Criteria andProMaterialLikeInsensitive(String value) {
            addCriterion("upper(pro_material) like", value.toUpperCase(), "proMaterial");
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