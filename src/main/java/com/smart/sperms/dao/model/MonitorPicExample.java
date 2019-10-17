package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorPicExample() {
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

        public Criteria andPicIdIsNull() {
            addCriterion("pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Integer value) {
            addCriterion("pic_id =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Integer value) {
            addCriterion("pic_id <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Integer value) {
            addCriterion("pic_id >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_id >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Integer value) {
            addCriterion("pic_id <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_id <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Integer> values) {
            addCriterion("pic_id in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Integer> values) {
            addCriterion("pic_id not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_id between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_id not between", value1, value2, "picId");
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

        public Criteria andPicTimeIsNull() {
            addCriterion("pic_time is null");
            return (Criteria) this;
        }

        public Criteria andPicTimeIsNotNull() {
            addCriterion("pic_time is not null");
            return (Criteria) this;
        }

        public Criteria andPicTimeEqualTo(Date value) {
            addCriterion("pic_time =", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotEqualTo(Date value) {
            addCriterion("pic_time <>", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeGreaterThan(Date value) {
            addCriterion("pic_time >", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pic_time >=", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeLessThan(Date value) {
            addCriterion("pic_time <", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeLessThanOrEqualTo(Date value) {
            addCriterion("pic_time <=", value, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeIn(List<Date> values) {
            addCriterion("pic_time in", values, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotIn(List<Date> values) {
            addCriterion("pic_time not in", values, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeBetween(Date value1, Date value2) {
            addCriterion("pic_time between", value1, value2, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicTimeNotBetween(Date value1, Date value2) {
            addCriterion("pic_time not between", value1, value2, "picTime");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("pic_path not between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicFilenameIsNull() {
            addCriterion("pic_filename is null");
            return (Criteria) this;
        }

        public Criteria andPicFilenameIsNotNull() {
            addCriterion("pic_filename is not null");
            return (Criteria) this;
        }

        public Criteria andPicFilenameEqualTo(String value) {
            addCriterion("pic_filename =", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameNotEqualTo(String value) {
            addCriterion("pic_filename <>", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameGreaterThan(String value) {
            addCriterion("pic_filename >", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_filename >=", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameLessThan(String value) {
            addCriterion("pic_filename <", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameLessThanOrEqualTo(String value) {
            addCriterion("pic_filename <=", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameLike(String value) {
            addCriterion("pic_filename like", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameNotLike(String value) {
            addCriterion("pic_filename not like", value, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameIn(List<String> values) {
            addCriterion("pic_filename in", values, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameNotIn(List<String> values) {
            addCriterion("pic_filename not in", values, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameBetween(String value1, String value2) {
            addCriterion("pic_filename between", value1, value2, "picFilename");
            return (Criteria) this;
        }

        public Criteria andPicFilenameNotBetween(String value1, String value2) {
            addCriterion("pic_filename not between", value1, value2, "picFilename");
            return (Criteria) this;
        }

        public Criteria andEIdLikeInsensitive(String value) {
            addCriterion("upper(e_id) like", value.toUpperCase(), "eId");
            return (Criteria) this;
        }

        public Criteria andPicPathLikeInsensitive(String value) {
            addCriterion("upper(pic_path) like", value.toUpperCase(), "picPath");
            return (Criteria) this;
        }

        public Criteria andPicFilenameLikeInsensitive(String value) {
            addCriterion("upper(pic_filename) like", value.toUpperCase(), "picFilename");
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