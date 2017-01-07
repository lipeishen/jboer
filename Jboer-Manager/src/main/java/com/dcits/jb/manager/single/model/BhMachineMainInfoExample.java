package com.dcits.jb.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BhMachineMainInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhMachineMainInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMachineIdIsNull() {
            addCriterion("machine_id is null");
            return (Criteria) this;
        }

        public Criteria andMachineIdIsNotNull() {
            addCriterion("machine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMachineIdEqualTo(String value) {
            addCriterion("machine_id =", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotEqualTo(String value) {
            addCriterion("machine_id <>", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdGreaterThan(String value) {
            addCriterion("machine_id >", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdGreaterThanOrEqualTo(String value) {
            addCriterion("machine_id >=", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLessThan(String value) {
            addCriterion("machine_id <", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLessThanOrEqualTo(String value) {
            addCriterion("machine_id <=", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLike(String value) {
            addCriterion("machine_id like", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotLike(String value) {
            addCriterion("machine_id not like", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdIn(List<String> values) {
            addCriterion("machine_id in", values, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotIn(List<String> values) {
            addCriterion("machine_id not in", values, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdBetween(String value1, String value2) {
            addCriterion("machine_id between", value1, value2, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotBetween(String value1, String value2) {
            addCriterion("machine_id not between", value1, value2, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNull() {
            addCriterion("machine_type is null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNotNull() {
            addCriterion("machine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeEqualTo(String value) {
            addCriterion("machine_type =", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotEqualTo(String value) {
            addCriterion("machine_type <>", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThan(String value) {
            addCriterion("machine_type >", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("machine_type >=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThan(String value) {
            addCriterion("machine_type <", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThanOrEqualTo(String value) {
            addCriterion("machine_type <=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLike(String value) {
            addCriterion("machine_type like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotLike(String value) {
            addCriterion("machine_type not like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIn(List<String> values) {
            addCriterion("machine_type in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotIn(List<String> values) {
            addCriterion("machine_type not in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeBetween(String value1, String value2) {
            addCriterion("machine_type between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotBetween(String value1, String value2) {
            addCriterion("machine_type not between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineNameIsNull() {
            addCriterion("machine_name is null");
            return (Criteria) this;
        }

        public Criteria andMachineNameIsNotNull() {
            addCriterion("machine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNameEqualTo(String value) {
            addCriterion("machine_name =", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotEqualTo(String value) {
            addCriterion("machine_name <>", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThan(String value) {
            addCriterion("machine_name >", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThanOrEqualTo(String value) {
            addCriterion("machine_name >=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThan(String value) {
            addCriterion("machine_name <", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThanOrEqualTo(String value) {
            addCriterion("machine_name <=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLike(String value) {
            addCriterion("machine_name like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotLike(String value) {
            addCriterion("machine_name not like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameIn(List<String> values) {
            addCriterion("machine_name in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotIn(List<String> values) {
            addCriterion("machine_name not in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameBetween(String value1, String value2) {
            addCriterion("machine_name between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotBetween(String value1, String value2) {
            addCriterion("machine_name not between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineCodeIsNull() {
            addCriterion("machine_code is null");
            return (Criteria) this;
        }

        public Criteria andMachineCodeIsNotNull() {
            addCriterion("machine_code is not null");
            return (Criteria) this;
        }

        public Criteria andMachineCodeEqualTo(String value) {
            addCriterion("machine_code =", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeNotEqualTo(String value) {
            addCriterion("machine_code <>", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeGreaterThan(String value) {
            addCriterion("machine_code >", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeGreaterThanOrEqualTo(String value) {
            addCriterion("machine_code >=", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeLessThan(String value) {
            addCriterion("machine_code <", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeLessThanOrEqualTo(String value) {
            addCriterion("machine_code <=", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeLike(String value) {
            addCriterion("machine_code like", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeNotLike(String value) {
            addCriterion("machine_code not like", value, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeIn(List<String> values) {
            addCriterion("machine_code in", values, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeNotIn(List<String> values) {
            addCriterion("machine_code not in", values, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeBetween(String value1, String value2) {
            addCriterion("machine_code between", value1, value2, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachineCodeNotBetween(String value1, String value2) {
            addCriterion("machine_code not between", value1, value2, "machineCode");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlIsNull() {
            addCriterion("machine_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlIsNotNull() {
            addCriterion("machine_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlEqualTo(String value) {
            addCriterion("machine_pic_url =", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlNotEqualTo(String value) {
            addCriterion("machine_pic_url <>", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlGreaterThan(String value) {
            addCriterion("machine_pic_url >", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("machine_pic_url >=", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlLessThan(String value) {
            addCriterion("machine_pic_url <", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlLessThanOrEqualTo(String value) {
            addCriterion("machine_pic_url <=", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlLike(String value) {
            addCriterion("machine_pic_url like", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlNotLike(String value) {
            addCriterion("machine_pic_url not like", value, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlIn(List<String> values) {
            addCriterion("machine_pic_url in", values, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlNotIn(List<String> values) {
            addCriterion("machine_pic_url not in", values, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlBetween(String value1, String value2) {
            addCriterion("machine_pic_url between", value1, value2, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePicUrlNotBetween(String value1, String value2) {
            addCriterion("machine_pic_url not between", value1, value2, "machinePicUrl");
            return (Criteria) this;
        }

        public Criteria andMachinePriceIsNull() {
            addCriterion("machine_price is null");
            return (Criteria) this;
        }

        public Criteria andMachinePriceIsNotNull() {
            addCriterion("machine_price is not null");
            return (Criteria) this;
        }

        public Criteria andMachinePriceEqualTo(Long value) {
            addCriterion("machine_price =", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceNotEqualTo(Long value) {
            addCriterion("machine_price <>", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceGreaterThan(Long value) {
            addCriterion("machine_price >", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_price >=", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceLessThan(Long value) {
            addCriterion("machine_price <", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceLessThanOrEqualTo(Long value) {
            addCriterion("machine_price <=", value, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceIn(List<Long> values) {
            addCriterion("machine_price in", values, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceNotIn(List<Long> values) {
            addCriterion("machine_price not in", values, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceBetween(Long value1, Long value2) {
            addCriterion("machine_price between", value1, value2, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachinePriceNotBetween(Long value1, Long value2) {
            addCriterion("machine_price not between", value1, value2, "machinePrice");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalIsNull() {
            addCriterion("machine_stock_total is null");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalIsNotNull() {
            addCriterion("machine_stock_total is not null");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalEqualTo(Long value) {
            addCriterion("machine_stock_total =", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalNotEqualTo(Long value) {
            addCriterion("machine_stock_total <>", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalGreaterThan(Long value) {
            addCriterion("machine_stock_total >", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_stock_total >=", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalLessThan(Long value) {
            addCriterion("machine_stock_total <", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalLessThanOrEqualTo(Long value) {
            addCriterion("machine_stock_total <=", value, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalIn(List<Long> values) {
            addCriterion("machine_stock_total in", values, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalNotIn(List<Long> values) {
            addCriterion("machine_stock_total not in", values, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalBetween(Long value1, Long value2) {
            addCriterion("machine_stock_total between", value1, value2, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockTotalNotBetween(Long value1, Long value2) {
            addCriterion("machine_stock_total not between", value1, value2, "machineStockTotal");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainIsNull() {
            addCriterion("machine_stock_remain is null");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainIsNotNull() {
            addCriterion("machine_stock_remain is not null");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainEqualTo(Long value) {
            addCriterion("machine_stock_remain =", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainNotEqualTo(Long value) {
            addCriterion("machine_stock_remain <>", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainGreaterThan(Long value) {
            addCriterion("machine_stock_remain >", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_stock_remain >=", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainLessThan(Long value) {
            addCriterion("machine_stock_remain <", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainLessThanOrEqualTo(Long value) {
            addCriterion("machine_stock_remain <=", value, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainIn(List<Long> values) {
            addCriterion("machine_stock_remain in", values, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainNotIn(List<Long> values) {
            addCriterion("machine_stock_remain not in", values, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainBetween(Long value1, Long value2) {
            addCriterion("machine_stock_remain between", value1, value2, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineStockRemainNotBetween(Long value1, Long value2) {
            addCriterion("machine_stock_remain not between", value1, value2, "machineStockRemain");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeIsNull() {
            addCriterion("machine_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeIsNotNull() {
            addCriterion("machine_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("machine_create_time =", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("machine_create_time <>", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("machine_create_time >", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("machine_create_time >=", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("machine_create_time <", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("machine_create_time <=", value, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("machine_create_time in", values, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("machine_create_time not in", values, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("machine_create_time between", value1, value2, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("machine_create_time not between", value1, value2, "machineCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleIsNull() {
            addCriterion("machine_issale is null");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleIsNotNull() {
            addCriterion("machine_issale is not null");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleEqualTo(String value) {
            addCriterion("machine_issale =", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleNotEqualTo(String value) {
            addCriterion("machine_issale <>", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleGreaterThan(String value) {
            addCriterion("machine_issale >", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleGreaterThanOrEqualTo(String value) {
            addCriterion("machine_issale >=", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleLessThan(String value) {
            addCriterion("machine_issale <", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleLessThanOrEqualTo(String value) {
            addCriterion("machine_issale <=", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleLike(String value) {
            addCriterion("machine_issale like", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleNotLike(String value) {
            addCriterion("machine_issale not like", value, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleIn(List<String> values) {
            addCriterion("machine_issale in", values, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleNotIn(List<String> values) {
            addCriterion("machine_issale not in", values, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleBetween(String value1, String value2) {
            addCriterion("machine_issale between", value1, value2, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIssaleNotBetween(String value1, String value2) {
            addCriterion("machine_issale not between", value1, value2, "machineIssale");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidIsNull() {
            addCriterion("machine_isvalid is null");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidIsNotNull() {
            addCriterion("machine_isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidEqualTo(String value) {
            addCriterion("machine_isvalid =", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidNotEqualTo(String value) {
            addCriterion("machine_isvalid <>", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidGreaterThan(String value) {
            addCriterion("machine_isvalid >", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidGreaterThanOrEqualTo(String value) {
            addCriterion("machine_isvalid >=", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidLessThan(String value) {
            addCriterion("machine_isvalid <", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidLessThanOrEqualTo(String value) {
            addCriterion("machine_isvalid <=", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidLike(String value) {
            addCriterion("machine_isvalid like", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidNotLike(String value) {
            addCriterion("machine_isvalid not like", value, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidIn(List<String> values) {
            addCriterion("machine_isvalid in", values, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidNotIn(List<String> values) {
            addCriterion("machine_isvalid not in", values, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidBetween(String value1, String value2) {
            addCriterion("machine_isvalid between", value1, value2, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineIsvalidNotBetween(String value1, String value2) {
            addCriterion("machine_isvalid not between", value1, value2, "machineIsvalid");
            return (Criteria) this;
        }

        public Criteria andMachineMacIsNull() {
            addCriterion("machine_mac is null");
            return (Criteria) this;
        }

        public Criteria andMachineMacIsNotNull() {
            addCriterion("machine_mac is not null");
            return (Criteria) this;
        }

        public Criteria andMachineMacEqualTo(String value) {
            addCriterion("machine_mac =", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacNotEqualTo(String value) {
            addCriterion("machine_mac <>", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacGreaterThan(String value) {
            addCriterion("machine_mac >", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacGreaterThanOrEqualTo(String value) {
            addCriterion("machine_mac >=", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacLessThan(String value) {
            addCriterion("machine_mac <", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacLessThanOrEqualTo(String value) {
            addCriterion("machine_mac <=", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacLike(String value) {
            addCriterion("machine_mac like", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacNotLike(String value) {
            addCriterion("machine_mac not like", value, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacIn(List<String> values) {
            addCriterion("machine_mac in", values, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacNotIn(List<String> values) {
            addCriterion("machine_mac not in", values, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacBetween(String value1, String value2) {
            addCriterion("machine_mac between", value1, value2, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineMacNotBetween(String value1, String value2) {
            addCriterion("machine_mac not between", value1, value2, "machineMac");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceIsNull() {
            addCriterion("machine_hasvoice is null");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceIsNotNull() {
            addCriterion("machine_hasvoice is not null");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceEqualTo(String value) {
            addCriterion("machine_hasvoice =", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceNotEqualTo(String value) {
            addCriterion("machine_hasvoice <>", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceGreaterThan(String value) {
            addCriterion("machine_hasvoice >", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("machine_hasvoice >=", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceLessThan(String value) {
            addCriterion("machine_hasvoice <", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceLessThanOrEqualTo(String value) {
            addCriterion("machine_hasvoice <=", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceLike(String value) {
            addCriterion("machine_hasvoice like", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceNotLike(String value) {
            addCriterion("machine_hasvoice not like", value, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceIn(List<String> values) {
            addCriterion("machine_hasvoice in", values, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceNotIn(List<String> values) {
            addCriterion("machine_hasvoice not in", values, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceBetween(String value1, String value2) {
            addCriterion("machine_hasvoice between", value1, value2, "machineHasvoice");
            return (Criteria) this;
        }

        public Criteria andMachineHasvoiceNotBetween(String value1, String value2) {
            addCriterion("machine_hasvoice not between", value1, value2, "machineHasvoice");
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