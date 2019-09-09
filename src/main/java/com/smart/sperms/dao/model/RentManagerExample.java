package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentManagerExample() {
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

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
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

        public Criteria andCustomerNoIsNull() {
            addCriterion("customer_no is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIsNotNull() {
            addCriterion("customer_no is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoEqualTo(String value) {
            addCriterion("customer_no =", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotEqualTo(String value) {
            addCriterion("customer_no <>", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThan(String value) {
            addCriterion("customer_no >", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_no >=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThan(String value) {
            addCriterion("customer_no <", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThanOrEqualTo(String value) {
            addCriterion("customer_no <=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLike(String value) {
            addCriterion("customer_no like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotLike(String value) {
            addCriterion("customer_no not like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIn(List<String> values) {
            addCriterion("customer_no in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotIn(List<String> values) {
            addCriterion("customer_no not in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoBetween(String value1, String value2) {
            addCriterion("customer_no between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotBetween(String value1, String value2) {
            addCriterion("customer_no not between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andRentDateIsNull() {
            addCriterion("rent_date is null");
            return (Criteria) this;
        }

        public Criteria andRentDateIsNotNull() {
            addCriterion("rent_date is not null");
            return (Criteria) this;
        }

        public Criteria andRentDateEqualTo(Date value) {
            addCriterion("rent_date =", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotEqualTo(Date value) {
            addCriterion("rent_date <>", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateGreaterThan(Date value) {
            addCriterion("rent_date >", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rent_date >=", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateLessThan(Date value) {
            addCriterion("rent_date <", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateLessThanOrEqualTo(Date value) {
            addCriterion("rent_date <=", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateIn(List<Date> values) {
            addCriterion("rent_date in", values, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotIn(List<Date> values) {
            addCriterion("rent_date not in", values, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateBetween(Date value1, Date value2) {
            addCriterion("rent_date between", value1, value2, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotBetween(Date value1, Date value2) {
            addCriterion("rent_date not between", value1, value2, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateIsNull() {
            addCriterion("rent_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateIsNotNull() {
            addCriterion("rent_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateEqualTo(Date value) {
            addCriterion("rent_begin_date =", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateNotEqualTo(Date value) {
            addCriterion("rent_begin_date <>", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateGreaterThan(Date value) {
            addCriterion("rent_begin_date >", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rent_begin_date >=", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateLessThan(Date value) {
            addCriterion("rent_begin_date <", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("rent_begin_date <=", value, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateIn(List<Date> values) {
            addCriterion("rent_begin_date in", values, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateNotIn(List<Date> values) {
            addCriterion("rent_begin_date not in", values, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateBetween(Date value1, Date value2) {
            addCriterion("rent_begin_date between", value1, value2, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("rent_begin_date not between", value1, value2, "rentBeginDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateIsNull() {
            addCriterion("rent_end_date is null");
            return (Criteria) this;
        }

        public Criteria andRentEndDateIsNotNull() {
            addCriterion("rent_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andRentEndDateEqualTo(Date value) {
            addCriterion("rent_end_date =", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateNotEqualTo(Date value) {
            addCriterion("rent_end_date <>", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateGreaterThan(Date value) {
            addCriterion("rent_end_date >", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rent_end_date >=", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateLessThan(Date value) {
            addCriterion("rent_end_date <", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateLessThanOrEqualTo(Date value) {
            addCriterion("rent_end_date <=", value, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateIn(List<Date> values) {
            addCriterion("rent_end_date in", values, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateNotIn(List<Date> values) {
            addCriterion("rent_end_date not in", values, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateBetween(Date value1, Date value2) {
            addCriterion("rent_end_date between", value1, value2, "rentEndDate");
            return (Criteria) this;
        }

        public Criteria andRentEndDateNotBetween(Date value1, Date value2) {
            addCriterion("rent_end_date not between", value1, value2, "rentEndDate");
            return (Criteria) this;
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

        public Criteria andRentPlaceIsNull() {
            addCriterion("rent_place is null");
            return (Criteria) this;
        }

        public Criteria andRentPlaceIsNotNull() {
            addCriterion("rent_place is not null");
            return (Criteria) this;
        }

        public Criteria andRentPlaceEqualTo(String value) {
            addCriterion("rent_place =", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceNotEqualTo(String value) {
            addCriterion("rent_place <>", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceGreaterThan(String value) {
            addCriterion("rent_place >", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("rent_place >=", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceLessThan(String value) {
            addCriterion("rent_place <", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceLessThanOrEqualTo(String value) {
            addCriterion("rent_place <=", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceLike(String value) {
            addCriterion("rent_place like", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceNotLike(String value) {
            addCriterion("rent_place not like", value, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceIn(List<String> values) {
            addCriterion("rent_place in", values, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceNotIn(List<String> values) {
            addCriterion("rent_place not in", values, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceBetween(String value1, String value2) {
            addCriterion("rent_place between", value1, value2, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andRentPlaceNotBetween(String value1, String value2) {
            addCriterion("rent_place not between", value1, value2, "rentPlace");
            return (Criteria) this;
        }

        public Criteria andAutoLockIsNull() {
            addCriterion("auto_lock is null");
            return (Criteria) this;
        }

        public Criteria andAutoLockIsNotNull() {
            addCriterion("auto_lock is not null");
            return (Criteria) this;
        }

        public Criteria andAutoLockEqualTo(Integer value) {
            addCriterion("auto_lock =", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockNotEqualTo(Integer value) {
            addCriterion("auto_lock <>", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockGreaterThan(Integer value) {
            addCriterion("auto_lock >", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_lock >=", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockLessThan(Integer value) {
            addCriterion("auto_lock <", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockLessThanOrEqualTo(Integer value) {
            addCriterion("auto_lock <=", value, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockIn(List<Integer> values) {
            addCriterion("auto_lock in", values, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockNotIn(List<Integer> values) {
            addCriterion("auto_lock not in", values, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockBetween(Integer value1, Integer value2) {
            addCriterion("auto_lock between", value1, value2, "autoLock");
            return (Criteria) this;
        }

        public Criteria andAutoLockNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_lock not between", value1, value2, "autoLock");
            return (Criteria) this;
        }

        public Criteria andLrMountIsNull() {
            addCriterion("lr_mount is null");
            return (Criteria) this;
        }

        public Criteria andLrMountIsNotNull() {
            addCriterion("lr_mount is not null");
            return (Criteria) this;
        }

        public Criteria andLrMountEqualTo(Integer value) {
            addCriterion("lr_mount =", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountNotEqualTo(Integer value) {
            addCriterion("lr_mount <>", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountGreaterThan(Integer value) {
            addCriterion("lr_mount >", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lr_mount >=", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountLessThan(Integer value) {
            addCriterion("lr_mount <", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountLessThanOrEqualTo(Integer value) {
            addCriterion("lr_mount <=", value, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountIn(List<Integer> values) {
            addCriterion("lr_mount in", values, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountNotIn(List<Integer> values) {
            addCriterion("lr_mount not in", values, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountBetween(Integer value1, Integer value2) {
            addCriterion("lr_mount between", value1, value2, "lrMount");
            return (Criteria) this;
        }

        public Criteria andLrMountNotBetween(Integer value1, Integer value2) {
            addCriterion("lr_mount not between", value1, value2, "lrMount");
            return (Criteria) this;
        }

        public Criteria andTradeNoLikeInsensitive(String value) {
            addCriterion("upper(trade_no) like", value.toUpperCase(), "tradeNo");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLikeInsensitive(String value) {
            addCriterion("upper(customer_no) like", value.toUpperCase(), "customerNo");
            return (Criteria) this;
        }

        public Criteria andCmNoLikeInsensitive(String value) {
            addCriterion("upper(cm_no) like", value.toUpperCase(), "cmNo");
            return (Criteria) this;
        }

        public Criteria andRentPlaceLikeInsensitive(String value) {
            addCriterion("upper(rent_place) like", value.toUpperCase(), "rentPlace");
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