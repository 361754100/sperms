package com.smart.sperms.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNull() {
            addCriterion("customer_sex is null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNotNull() {
            addCriterion("customer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexEqualTo(String value) {
            addCriterion("customer_sex =", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotEqualTo(String value) {
            addCriterion("customer_sex <>", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThan(String value) {
            addCriterion("customer_sex >", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThanOrEqualTo(String value) {
            addCriterion("customer_sex >=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThan(String value) {
            addCriterion("customer_sex <", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThanOrEqualTo(String value) {
            addCriterion("customer_sex <=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLike(String value) {
            addCriterion("customer_sex like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotLike(String value) {
            addCriterion("customer_sex not like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIn(List<String> values) {
            addCriterion("customer_sex in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotIn(List<String> values) {
            addCriterion("customer_sex not in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexBetween(String value1, String value2) {
            addCriterion("customer_sex between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotBetween(String value1, String value2) {
            addCriterion("customer_sex not between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNull() {
            addCriterion("customer_age is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNotNull() {
            addCriterion("customer_age is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeEqualTo(Integer value) {
            addCriterion("customer_age =", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotEqualTo(Integer value) {
            addCriterion("customer_age <>", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThan(Integer value) {
            addCriterion("customer_age >", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_age >=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThan(Integer value) {
            addCriterion("customer_age <", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("customer_age <=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIn(List<Integer> values) {
            addCriterion("customer_age in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotIn(List<Integer> values) {
            addCriterion("customer_age not in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeBetween(Integer value1, Integer value2) {
            addCriterion("customer_age between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_age not between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("customer_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("customer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("customer_phone =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("customer_phone <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("customer_phone >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_phone >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("customer_phone <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_phone <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("customer_phone like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("customer_phone not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("customer_phone in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("customer_phone not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("customer_phone between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_phone not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNull() {
            addCriterion("customer_email is null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNotNull() {
            addCriterion("customer_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailEqualTo(String value) {
            addCriterion("customer_email =", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotEqualTo(String value) {
            addCriterion("customer_email <>", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThan(String value) {
            addCriterion("customer_email >", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("customer_email >=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThan(String value) {
            addCriterion("customer_email <", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThanOrEqualTo(String value) {
            addCriterion("customer_email <=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLike(String value) {
            addCriterion("customer_email like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotLike(String value) {
            addCriterion("customer_email not like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIn(List<String> values) {
            addCriterion("customer_email in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotIn(List<String> values) {
            addCriterion("customer_email not in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailBetween(String value1, String value2) {
            addCriterion("customer_email between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotBetween(String value1, String value2) {
            addCriterion("customer_email not between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNull() {
            addCriterion("customer_qq is null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNotNull() {
            addCriterion("customer_qq is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqEqualTo(String value) {
            addCriterion("customer_qq =", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotEqualTo(String value) {
            addCriterion("customer_qq <>", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThan(String value) {
            addCriterion("customer_qq >", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThanOrEqualTo(String value) {
            addCriterion("customer_qq >=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThan(String value) {
            addCriterion("customer_qq <", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThanOrEqualTo(String value) {
            addCriterion("customer_qq <=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLike(String value) {
            addCriterion("customer_qq like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotLike(String value) {
            addCriterion("customer_qq not like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIn(List<String> values) {
            addCriterion("customer_qq in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotIn(List<String> values) {
            addCriterion("customer_qq not in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqBetween(String value1, String value2) {
            addCriterion("customer_qq between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotBetween(String value1, String value2) {
            addCriterion("customer_qq not between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerWxIsNull() {
            addCriterion("customer_wx is null");
            return (Criteria) this;
        }

        public Criteria andCustomerWxIsNotNull() {
            addCriterion("customer_wx is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerWxEqualTo(String value) {
            addCriterion("customer_wx =", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxNotEqualTo(String value) {
            addCriterion("customer_wx <>", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxGreaterThan(String value) {
            addCriterion("customer_wx >", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxGreaterThanOrEqualTo(String value) {
            addCriterion("customer_wx >=", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxLessThan(String value) {
            addCriterion("customer_wx <", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxLessThanOrEqualTo(String value) {
            addCriterion("customer_wx <=", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxLike(String value) {
            addCriterion("customer_wx like", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxNotLike(String value) {
            addCriterion("customer_wx not like", value, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxIn(List<String> values) {
            addCriterion("customer_wx in", values, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxNotIn(List<String> values) {
            addCriterion("customer_wx not in", values, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxBetween(String value1, String value2) {
            addCriterion("customer_wx between", value1, value2, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerWxNotBetween(String value1, String value2) {
            addCriterion("customer_wx not between", value1, value2, "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrIsNull() {
            addCriterion("customer_addr is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrIsNotNull() {
            addCriterion("customer_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrEqualTo(String value) {
            addCriterion("customer_addr =", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrNotEqualTo(String value) {
            addCriterion("customer_addr <>", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrGreaterThan(String value) {
            addCriterion("customer_addr >", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrGreaterThanOrEqualTo(String value) {
            addCriterion("customer_addr >=", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrLessThan(String value) {
            addCriterion("customer_addr <", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrLessThanOrEqualTo(String value) {
            addCriterion("customer_addr <=", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrLike(String value) {
            addCriterion("customer_addr like", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrNotLike(String value) {
            addCriterion("customer_addr not like", value, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrIn(List<String> values) {
            addCriterion("customer_addr in", values, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrNotIn(List<String> values) {
            addCriterion("customer_addr not in", values, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrBetween(String value1, String value2) {
            addCriterion("customer_addr between", value1, value2, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrNotBetween(String value1, String value2) {
            addCriterion("customer_addr not between", value1, value2, "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNull() {
            addCriterion("customer_company is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNotNull() {
            addCriterion("customer_company is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyEqualTo(String value) {
            addCriterion("customer_company =", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotEqualTo(String value) {
            addCriterion("customer_company <>", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThan(String value) {
            addCriterion("customer_company >", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_company >=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThan(String value) {
            addCriterion("customer_company <", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThanOrEqualTo(String value) {
            addCriterion("customer_company <=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLike(String value) {
            addCriterion("customer_company like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotLike(String value) {
            addCriterion("customer_company not like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIn(List<String> values) {
            addCriterion("customer_company in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotIn(List<String> values) {
            addCriterion("customer_company not in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyBetween(String value1, String value2) {
            addCriterion("customer_company between", value1, value2, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotBetween(String value1, String value2) {
            addCriterion("customer_company not between", value1, value2, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLikeInsensitive(String value) {
            addCriterion("upper(customer_no) like", value.toUpperCase(), "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLikeInsensitive(String value) {
            addCriterion("upper(customer_name) like", value.toUpperCase(), "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLikeInsensitive(String value) {
            addCriterion("upper(customer_sex) like", value.toUpperCase(), "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLikeInsensitive(String value) {
            addCriterion("upper(customer_phone) like", value.toUpperCase(), "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLikeInsensitive(String value) {
            addCriterion("upper(customer_email) like", value.toUpperCase(), "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLikeInsensitive(String value) {
            addCriterion("upper(customer_qq) like", value.toUpperCase(), "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerWxLikeInsensitive(String value) {
            addCriterion("upper(customer_wx) like", value.toUpperCase(), "customerWx");
            return (Criteria) this;
        }

        public Criteria andCustomerAddrLikeInsensitive(String value) {
            addCriterion("upper(customer_addr) like", value.toUpperCase(), "customerAddr");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLikeInsensitive(String value) {
            addCriterion("upper(customer_company) like", value.toUpperCase(), "customerCompany");
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