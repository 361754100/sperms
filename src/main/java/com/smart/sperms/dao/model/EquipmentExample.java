package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentExample() {
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

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andEStandardIsNull() {
            addCriterion("e_standard is null");
            return (Criteria) this;
        }

        public Criteria andEStandardIsNotNull() {
            addCriterion("e_standard is not null");
            return (Criteria) this;
        }

        public Criteria andEStandardEqualTo(String value) {
            addCriterion("e_standard =", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardNotEqualTo(String value) {
            addCriterion("e_standard <>", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardGreaterThan(String value) {
            addCriterion("e_standard >", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardGreaterThanOrEqualTo(String value) {
            addCriterion("e_standard >=", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardLessThan(String value) {
            addCriterion("e_standard <", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardLessThanOrEqualTo(String value) {
            addCriterion("e_standard <=", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardLike(String value) {
            addCriterion("e_standard like", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardNotLike(String value) {
            addCriterion("e_standard not like", value, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardIn(List<String> values) {
            addCriterion("e_standard in", values, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardNotIn(List<String> values) {
            addCriterion("e_standard not in", values, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardBetween(String value1, String value2) {
            addCriterion("e_standard between", value1, value2, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEStandardNotBetween(String value1, String value2) {
            addCriterion("e_standard not between", value1, value2, "eStandard");
            return (Criteria) this;
        }

        public Criteria andEManufacturerIsNull() {
            addCriterion("e_manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andEManufacturerIsNotNull() {
            addCriterion("e_manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andEManufacturerEqualTo(String value) {
            addCriterion("e_manufacturer =", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerNotEqualTo(String value) {
            addCriterion("e_manufacturer <>", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerGreaterThan(String value) {
            addCriterion("e_manufacturer >", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("e_manufacturer >=", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerLessThan(String value) {
            addCriterion("e_manufacturer <", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerLessThanOrEqualTo(String value) {
            addCriterion("e_manufacturer <=", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerLike(String value) {
            addCriterion("e_manufacturer like", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerNotLike(String value) {
            addCriterion("e_manufacturer not like", value, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerIn(List<String> values) {
            addCriterion("e_manufacturer in", values, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerNotIn(List<String> values) {
            addCriterion("e_manufacturer not in", values, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerBetween(String value1, String value2) {
            addCriterion("e_manufacturer between", value1, value2, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andEManufacturerNotBetween(String value1, String value2) {
            addCriterion("e_manufacturer not between", value1, value2, "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andETypeIsNull() {
            addCriterion("e_type is null");
            return (Criteria) this;
        }

        public Criteria andETypeIsNotNull() {
            addCriterion("e_type is not null");
            return (Criteria) this;
        }

        public Criteria andETypeEqualTo(String value) {
            addCriterion("e_type =", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotEqualTo(String value) {
            addCriterion("e_type <>", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeGreaterThan(String value) {
            addCriterion("e_type >", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeGreaterThanOrEqualTo(String value) {
            addCriterion("e_type >=", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeLessThan(String value) {
            addCriterion("e_type <", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeLessThanOrEqualTo(String value) {
            addCriterion("e_type <=", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeLike(String value) {
            addCriterion("e_type like", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotLike(String value) {
            addCriterion("e_type not like", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeIn(List<String> values) {
            addCriterion("e_type in", values, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotIn(List<String> values) {
            addCriterion("e_type not in", values, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeBetween(String value1, String value2) {
            addCriterion("e_type between", value1, value2, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotBetween(String value1, String value2) {
            addCriterion("e_type not between", value1, value2, "eType");
            return (Criteria) this;
        }

        public Criteria andEDateIsNull() {
            addCriterion("e_date is null");
            return (Criteria) this;
        }

        public Criteria andEDateIsNotNull() {
            addCriterion("e_date is not null");
            return (Criteria) this;
        }

        public Criteria andEDateEqualTo(Date value) {
            addCriterion("e_date =", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotEqualTo(Date value) {
            addCriterion("e_date <>", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateGreaterThan(Date value) {
            addCriterion("e_date >", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateGreaterThanOrEqualTo(Date value) {
            addCriterion("e_date >=", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateLessThan(Date value) {
            addCriterion("e_date <", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateLessThanOrEqualTo(Date value) {
            addCriterion("e_date <=", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateIn(List<Date> values) {
            addCriterion("e_date in", values, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotIn(List<Date> values) {
            addCriterion("e_date not in", values, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateBetween(Date value1, Date value2) {
            addCriterion("e_date between", value1, value2, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotBetween(Date value1, Date value2) {
            addCriterion("e_date not between", value1, value2, "eDate");
            return (Criteria) this;
        }

        public Criteria andEStateIsNull() {
            addCriterion("e_state is null");
            return (Criteria) this;
        }

        public Criteria andEStateIsNotNull() {
            addCriterion("e_state is not null");
            return (Criteria) this;
        }

        public Criteria andEStateEqualTo(String value) {
            addCriterion("e_state =", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotEqualTo(String value) {
            addCriterion("e_state <>", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateGreaterThan(String value) {
            addCriterion("e_state >", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateGreaterThanOrEqualTo(String value) {
            addCriterion("e_state >=", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateLessThan(String value) {
            addCriterion("e_state <", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateLessThanOrEqualTo(String value) {
            addCriterion("e_state <=", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateLike(String value) {
            addCriterion("e_state like", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotLike(String value) {
            addCriterion("e_state not like", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateIn(List<String> values) {
            addCriterion("e_state in", values, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotIn(List<String> values) {
            addCriterion("e_state not in", values, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateBetween(String value1, String value2) {
            addCriterion("e_state between", value1, value2, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotBetween(String value1, String value2) {
            addCriterion("e_state not between", value1, value2, "eState");
            return (Criteria) this;
        }

        public Criteria andEEnableIsNull() {
            addCriterion("e_enable is null");
            return (Criteria) this;
        }

        public Criteria andEEnableIsNotNull() {
            addCriterion("e_enable is not null");
            return (Criteria) this;
        }

        public Criteria andEEnableEqualTo(Integer value) {
            addCriterion("e_enable =", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableNotEqualTo(Integer value) {
            addCriterion("e_enable <>", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableGreaterThan(Integer value) {
            addCriterion("e_enable >", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_enable >=", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableLessThan(Integer value) {
            addCriterion("e_enable <", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableLessThanOrEqualTo(Integer value) {
            addCriterion("e_enable <=", value, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableIn(List<Integer> values) {
            addCriterion("e_enable in", values, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableNotIn(List<Integer> values) {
            addCriterion("e_enable not in", values, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableBetween(Integer value1, Integer value2) {
            addCriterion("e_enable between", value1, value2, "eEnable");
            return (Criteria) this;
        }

        public Criteria andEEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("e_enable not between", value1, value2, "eEnable");
            return (Criteria) this;
        }

        public Criteria andELongitudeIsNull() {
            addCriterion("e_longitude is null");
            return (Criteria) this;
        }

        public Criteria andELongitudeIsNotNull() {
            addCriterion("e_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andELongitudeEqualTo(String value) {
            addCriterion("e_longitude =", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeNotEqualTo(String value) {
            addCriterion("e_longitude <>", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeGreaterThan(String value) {
            addCriterion("e_longitude >", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("e_longitude >=", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeLessThan(String value) {
            addCriterion("e_longitude <", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeLessThanOrEqualTo(String value) {
            addCriterion("e_longitude <=", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeLike(String value) {
            addCriterion("e_longitude like", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeNotLike(String value) {
            addCriterion("e_longitude not like", value, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeIn(List<String> values) {
            addCriterion("e_longitude in", values, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeNotIn(List<String> values) {
            addCriterion("e_longitude not in", values, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeBetween(String value1, String value2) {
            addCriterion("e_longitude between", value1, value2, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELongitudeNotBetween(String value1, String value2) {
            addCriterion("e_longitude not between", value1, value2, "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeIsNull() {
            addCriterion("e_latitude is null");
            return (Criteria) this;
        }

        public Criteria andELatitudeIsNotNull() {
            addCriterion("e_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andELatitudeEqualTo(String value) {
            addCriterion("e_latitude =", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeNotEqualTo(String value) {
            addCriterion("e_latitude <>", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeGreaterThan(String value) {
            addCriterion("e_latitude >", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("e_latitude >=", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeLessThan(String value) {
            addCriterion("e_latitude <", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeLessThanOrEqualTo(String value) {
            addCriterion("e_latitude <=", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeLike(String value) {
            addCriterion("e_latitude like", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeNotLike(String value) {
            addCriterion("e_latitude not like", value, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeIn(List<String> values) {
            addCriterion("e_latitude in", values, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeNotIn(List<String> values) {
            addCriterion("e_latitude not in", values, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeBetween(String value1, String value2) {
            addCriterion("e_latitude between", value1, value2, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeNotBetween(String value1, String value2) {
            addCriterion("e_latitude not between", value1, value2, "eLatitude");
            return (Criteria) this;
        }

        public Criteria andEConditionIsNull() {
            addCriterion("e_condition is null");
            return (Criteria) this;
        }

        public Criteria andEConditionIsNotNull() {
            addCriterion("e_condition is not null");
            return (Criteria) this;
        }

        public Criteria andEConditionEqualTo(String value) {
            addCriterion("e_condition =", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionNotEqualTo(String value) {
            addCriterion("e_condition <>", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionGreaterThan(String value) {
            addCriterion("e_condition >", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionGreaterThanOrEqualTo(String value) {
            addCriterion("e_condition >=", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionLessThan(String value) {
            addCriterion("e_condition <", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionLessThanOrEqualTo(String value) {
            addCriterion("e_condition <=", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionLike(String value) {
            addCriterion("e_condition like", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionNotLike(String value) {
            addCriterion("e_condition not like", value, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionIn(List<String> values) {
            addCriterion("e_condition in", values, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionNotIn(List<String> values) {
            addCriterion("e_condition not in", values, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionBetween(String value1, String value2) {
            addCriterion("e_condition between", value1, value2, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEConditionNotBetween(String value1, String value2) {
            addCriterion("e_condition not between", value1, value2, "eCondition");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andENameLikeInsensitive(String value) {
            addCriterion("upper(e_name) like", value.toUpperCase(), "eName");
            return (Criteria) this;
        }

        public Criteria andEStandardLikeInsensitive(String value) {
            addCriterion("upper(e_standard) like", value.toUpperCase(), "eStandard");
            return (Criteria) this;
        }

        public Criteria andEManufacturerLikeInsensitive(String value) {
            addCriterion("upper(e_manufacturer) like", value.toUpperCase(), "eManufacturer");
            return (Criteria) this;
        }

        public Criteria andETypeLikeInsensitive(String value) {
            addCriterion("upper(e_type) like", value.toUpperCase(), "eType");
            return (Criteria) this;
        }

        public Criteria andEStateLikeInsensitive(String value) {
            addCriterion("upper(e_state) like", value.toUpperCase(), "eState");
            return (Criteria) this;
        }

        public Criteria andELongitudeLikeInsensitive(String value) {
            addCriterion("upper(e_longitude) like", value.toUpperCase(), "eLongitude");
            return (Criteria) this;
        }

        public Criteria andELatitudeLikeInsensitive(String value) {
            addCriterion("upper(e_latitude) like", value.toUpperCase(), "eLatitude");
            return (Criteria) this;
        }

        public Criteria andEConditionLikeInsensitive(String value) {
            addCriterion("upper(e_condition) like", value.toUpperCase(), "eCondition");
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