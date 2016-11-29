package com.dcits.djk.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BhAuthUserMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhAuthUserMainExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSurnameIsNull() {
            addCriterion("surname is null");
            return (Criteria) this;
        }

        public Criteria andSurnameIsNotNull() {
            addCriterion("surname is not null");
            return (Criteria) this;
        }

        public Criteria andSurnameEqualTo(String value) {
            addCriterion("surname =", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotEqualTo(String value) {
            addCriterion("surname <>", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameGreaterThan(String value) {
            addCriterion("surname >", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameGreaterThanOrEqualTo(String value) {
            addCriterion("surname >=", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLessThan(String value) {
            addCriterion("surname <", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLessThanOrEqualTo(String value) {
            addCriterion("surname <=", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLike(String value) {
            addCriterion("surname like", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotLike(String value) {
            addCriterion("surname not like", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameIn(List<String> values) {
            addCriterion("surname in", values, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotIn(List<String> values) {
            addCriterion("surname not in", values, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameBetween(String value1, String value2) {
            addCriterion("surname between", value1, value2, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotBetween(String value1, String value2) {
            addCriterion("surname not between", value1, value2, "surname");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIsNull() {
            addCriterion("identification_type is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIsNotNull() {
            addCriterion("identification_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeEqualTo(String value) {
            addCriterion("identification_type =", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotEqualTo(String value) {
            addCriterion("identification_type <>", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeGreaterThan(String value) {
            addCriterion("identification_type >", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("identification_type >=", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeLessThan(String value) {
            addCriterion("identification_type <", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeLessThanOrEqualTo(String value) {
            addCriterion("identification_type <=", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeLike(String value) {
            addCriterion("identification_type like", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotLike(String value) {
            addCriterion("identification_type not like", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIn(List<String> values) {
            addCriterion("identification_type in", values, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotIn(List<String> values) {
            addCriterion("identification_type not in", values, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeBetween(String value1, String value2) {
            addCriterion("identification_type between", value1, value2, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotBetween(String value1, String value2) {
            addCriterion("identification_type not between", value1, value2, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumIsNull() {
            addCriterion("identification_num is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumIsNotNull() {
            addCriterion("identification_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumEqualTo(String value) {
            addCriterion("identification_num =", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumNotEqualTo(String value) {
            addCriterion("identification_num <>", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumGreaterThan(String value) {
            addCriterion("identification_num >", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumGreaterThanOrEqualTo(String value) {
            addCriterion("identification_num >=", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumLessThan(String value) {
            addCriterion("identification_num <", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumLessThanOrEqualTo(String value) {
            addCriterion("identification_num <=", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumLike(String value) {
            addCriterion("identification_num like", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumNotLike(String value) {
            addCriterion("identification_num not like", value, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumIn(List<String> values) {
            addCriterion("identification_num in", values, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumNotIn(List<String> values) {
            addCriterion("identification_num not in", values, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumBetween(String value1, String value2) {
            addCriterion("identification_num between", value1, value2, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumNotBetween(String value1, String value2) {
            addCriterion("identification_num not between", value1, value2, "identificationNum");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNull() {
            addCriterion("tel_area_code is null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNotNull() {
            addCriterion("tel_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeEqualTo(String value) {
            addCriterion("tel_area_code =", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotEqualTo(String value) {
            addCriterion("tel_area_code <>", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThan(String value) {
            addCriterion("tel_area_code >", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tel_area_code >=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThan(String value) {
            addCriterion("tel_area_code <", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("tel_area_code <=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLike(String value) {
            addCriterion("tel_area_code like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotLike(String value) {
            addCriterion("tel_area_code not like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIn(List<String> values) {
            addCriterion("tel_area_code in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotIn(List<String> values) {
            addCriterion("tel_area_code not in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeBetween(String value1, String value2) {
            addCriterion("tel_area_code between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotBetween(String value1, String value2) {
            addCriterion("tel_area_code not between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNull() {
            addCriterion("tel_number is null");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNotNull() {
            addCriterion("tel_number is not null");
            return (Criteria) this;
        }

        public Criteria andTelNumberEqualTo(String value) {
            addCriterion("tel_number =", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotEqualTo(String value) {
            addCriterion("tel_number <>", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThan(String value) {
            addCriterion("tel_number >", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tel_number >=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThan(String value) {
            addCriterion("tel_number <", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThanOrEqualTo(String value) {
            addCriterion("tel_number <=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLike(String value) {
            addCriterion("tel_number like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotLike(String value) {
            addCriterion("tel_number not like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberIn(List<String> values) {
            addCriterion("tel_number in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotIn(List<String> values) {
            addCriterion("tel_number not in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberBetween(String value1, String value2) {
            addCriterion("tel_number between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotBetween(String value1, String value2) {
            addCriterion("tel_number not between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeIsNull() {
            addCriterion("tel_tran_code is null");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeIsNotNull() {
            addCriterion("tel_tran_code is not null");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeEqualTo(String value) {
            addCriterion("tel_tran_code =", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeNotEqualTo(String value) {
            addCriterion("tel_tran_code <>", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeGreaterThan(String value) {
            addCriterion("tel_tran_code >", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tel_tran_code >=", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeLessThan(String value) {
            addCriterion("tel_tran_code <", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeLessThanOrEqualTo(String value) {
            addCriterion("tel_tran_code <=", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeLike(String value) {
            addCriterion("tel_tran_code like", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeNotLike(String value) {
            addCriterion("tel_tran_code not like", value, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeIn(List<String> values) {
            addCriterion("tel_tran_code in", values, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeNotIn(List<String> values) {
            addCriterion("tel_tran_code not in", values, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeBetween(String value1, String value2) {
            addCriterion("tel_tran_code between", value1, value2, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andTelTranCodeNotBetween(String value1, String value2) {
            addCriterion("tel_tran_code not between", value1, value2, "telTranCode");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNull() {
            addCriterion("addr_province is null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNotNull() {
            addCriterion("addr_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceEqualTo(String value) {
            addCriterion("addr_province =", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotEqualTo(String value) {
            addCriterion("addr_province <>", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThan(String value) {
            addCriterion("addr_province >", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("addr_province >=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThan(String value) {
            addCriterion("addr_province <", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThanOrEqualTo(String value) {
            addCriterion("addr_province <=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLike(String value) {
            addCriterion("addr_province like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotLike(String value) {
            addCriterion("addr_province not like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIn(List<String> values) {
            addCriterion("addr_province in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotIn(List<String> values) {
            addCriterion("addr_province not in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceBetween(String value1, String value2) {
            addCriterion("addr_province between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotBetween(String value1, String value2) {
            addCriterion("addr_province not between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNull() {
            addCriterion("addr_city is null");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNotNull() {
            addCriterion("addr_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCityEqualTo(String value) {
            addCriterion("addr_city =", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotEqualTo(String value) {
            addCriterion("addr_city <>", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThan(String value) {
            addCriterion("addr_city >", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThanOrEqualTo(String value) {
            addCriterion("addr_city >=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThan(String value) {
            addCriterion("addr_city <", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThanOrEqualTo(String value) {
            addCriterion("addr_city <=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLike(String value) {
            addCriterion("addr_city like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotLike(String value) {
            addCriterion("addr_city not like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityIn(List<String> values) {
            addCriterion("addr_city in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotIn(List<String> values) {
            addCriterion("addr_city not in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityBetween(String value1, String value2) {
            addCriterion("addr_city between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotBetween(String value1, String value2) {
            addCriterion("addr_city not between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCountyIsNull() {
            addCriterion("addr_county is null");
            return (Criteria) this;
        }

        public Criteria andAddrCountyIsNotNull() {
            addCriterion("addr_county is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCountyEqualTo(String value) {
            addCriterion("addr_county =", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyNotEqualTo(String value) {
            addCriterion("addr_county <>", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyGreaterThan(String value) {
            addCriterion("addr_county >", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyGreaterThanOrEqualTo(String value) {
            addCriterion("addr_county >=", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyLessThan(String value) {
            addCriterion("addr_county <", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyLessThanOrEqualTo(String value) {
            addCriterion("addr_county <=", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyLike(String value) {
            addCriterion("addr_county like", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyNotLike(String value) {
            addCriterion("addr_county not like", value, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyIn(List<String> values) {
            addCriterion("addr_county in", values, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyNotIn(List<String> values) {
            addCriterion("addr_county not in", values, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyBetween(String value1, String value2) {
            addCriterion("addr_county between", value1, value2, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrCountyNotBetween(String value1, String value2) {
            addCriterion("addr_county not between", value1, value2, "addrCounty");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIsNull() {
            addCriterion("addr_area is null");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIsNotNull() {
            addCriterion("addr_area is not null");
            return (Criteria) this;
        }

        public Criteria andAddrAreaEqualTo(String value) {
            addCriterion("addr_area =", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotEqualTo(String value) {
            addCriterion("addr_area <>", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaGreaterThan(String value) {
            addCriterion("addr_area >", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaGreaterThanOrEqualTo(String value) {
            addCriterion("addr_area >=", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLessThan(String value) {
            addCriterion("addr_area <", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLessThanOrEqualTo(String value) {
            addCriterion("addr_area <=", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLike(String value) {
            addCriterion("addr_area like", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotLike(String value) {
            addCriterion("addr_area not like", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIn(List<String> values) {
            addCriterion("addr_area in", values, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotIn(List<String> values) {
            addCriterion("addr_area not in", values, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaBetween(String value1, String value2) {
            addCriterion("addr_area between", value1, value2, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotBetween(String value1, String value2) {
            addCriterion("addr_area not between", value1, value2, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNull() {
            addCriterion("addr_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNotNull() {
            addCriterion("addr_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailEqualTo(String value) {
            addCriterion("addr_detail =", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotEqualTo(String value) {
            addCriterion("addr_detail <>", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThan(String value) {
            addCriterion("addr_detail >", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThanOrEqualTo(String value) {
            addCriterion("addr_detail >=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThan(String value) {
            addCriterion("addr_detail <", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThanOrEqualTo(String value) {
            addCriterion("addr_detail <=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLike(String value) {
            addCriterion("addr_detail like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotLike(String value) {
            addCriterion("addr_detail not like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIn(List<String> values) {
            addCriterion("addr_detail in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotIn(List<String> values) {
            addCriterion("addr_detail not in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailBetween(String value1, String value2) {
            addCriterion("addr_detail between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotBetween(String value1, String value2) {
            addCriterion("addr_detail not between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNull() {
            addCriterion("head_portrait is null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNotNull() {
            addCriterion("head_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitEqualTo(String value) {
            addCriterion("head_portrait =", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotEqualTo(String value) {
            addCriterion("head_portrait <>", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThan(String value) {
            addCriterion("head_portrait >", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("head_portrait >=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThan(String value) {
            addCriterion("head_portrait <", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThanOrEqualTo(String value) {
            addCriterion("head_portrait <=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLike(String value) {
            addCriterion("head_portrait like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotLike(String value) {
            addCriterion("head_portrait not like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIn(List<String> values) {
            addCriterion("head_portrait in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotIn(List<String> values) {
            addCriterion("head_portrait not in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitBetween(String value1, String value2) {
            addCriterion("head_portrait between", value1, value2, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotBetween(String value1, String value2) {
            addCriterion("head_portrait not between", value1, value2, "headPortrait");
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