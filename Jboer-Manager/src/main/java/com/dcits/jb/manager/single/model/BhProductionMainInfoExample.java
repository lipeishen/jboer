package com.dcits.jb.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BhProductionMainInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhProductionMainInfoExample() {
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

        public Criteria andProductionIdIsNull() {
            addCriterion("production_id is null");
            return (Criteria) this;
        }

        public Criteria andProductionIdIsNotNull() {
            addCriterion("production_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductionIdEqualTo(String value) {
            addCriterion("production_id =", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdNotEqualTo(String value) {
            addCriterion("production_id <>", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdGreaterThan(String value) {
            addCriterion("production_id >", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdGreaterThanOrEqualTo(String value) {
            addCriterion("production_id >=", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdLessThan(String value) {
            addCriterion("production_id <", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdLessThanOrEqualTo(String value) {
            addCriterion("production_id <=", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdLike(String value) {
            addCriterion("production_id like", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdNotLike(String value) {
            addCriterion("production_id not like", value, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdIn(List<String> values) {
            addCriterion("production_id in", values, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdNotIn(List<String> values) {
            addCriterion("production_id not in", values, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdBetween(String value1, String value2) {
            addCriterion("production_id between", value1, value2, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionIdNotBetween(String value1, String value2) {
            addCriterion("production_id not between", value1, value2, "productionId");
            return (Criteria) this;
        }

        public Criteria andProductionNameIsNull() {
            addCriterion("production_name is null");
            return (Criteria) this;
        }

        public Criteria andProductionNameIsNotNull() {
            addCriterion("production_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductionNameEqualTo(String value) {
            addCriterion("production_name =", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotEqualTo(String value) {
            addCriterion("production_name <>", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameGreaterThan(String value) {
            addCriterion("production_name >", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameGreaterThanOrEqualTo(String value) {
            addCriterion("production_name >=", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLessThan(String value) {
            addCriterion("production_name <", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLessThanOrEqualTo(String value) {
            addCriterion("production_name <=", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLike(String value) {
            addCriterion("production_name like", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotLike(String value) {
            addCriterion("production_name not like", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameIn(List<String> values) {
            addCriterion("production_name in", values, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotIn(List<String> values) {
            addCriterion("production_name not in", values, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameBetween(String value1, String value2) {
            addCriterion("production_name between", value1, value2, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotBetween(String value1, String value2) {
            addCriterion("production_name not between", value1, value2, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionTypeIsNull() {
            addCriterion("production_type is null");
            return (Criteria) this;
        }

        public Criteria andProductionTypeIsNotNull() {
            addCriterion("production_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTypeEqualTo(String value) {
            addCriterion("production_type =", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeNotEqualTo(String value) {
            addCriterion("production_type <>", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeGreaterThan(String value) {
            addCriterion("production_type >", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("production_type >=", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeLessThan(String value) {
            addCriterion("production_type <", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeLessThanOrEqualTo(String value) {
            addCriterion("production_type <=", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeLike(String value) {
            addCriterion("production_type like", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeNotLike(String value) {
            addCriterion("production_type not like", value, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeIn(List<String> values) {
            addCriterion("production_type in", values, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeNotIn(List<String> values) {
            addCriterion("production_type not in", values, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeBetween(String value1, String value2) {
            addCriterion("production_type between", value1, value2, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionTypeNotBetween(String value1, String value2) {
            addCriterion("production_type not between", value1, value2, "productionType");
            return (Criteria) this;
        }

        public Criteria andProductionCodeIsNull() {
            addCriterion("production_code is null");
            return (Criteria) this;
        }

        public Criteria andProductionCodeIsNotNull() {
            addCriterion("production_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductionCodeEqualTo(String value) {
            addCriterion("production_code =", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeNotEqualTo(String value) {
            addCriterion("production_code <>", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeGreaterThan(String value) {
            addCriterion("production_code >", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("production_code >=", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeLessThan(String value) {
            addCriterion("production_code <", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeLessThanOrEqualTo(String value) {
            addCriterion("production_code <=", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeLike(String value) {
            addCriterion("production_code like", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeNotLike(String value) {
            addCriterion("production_code not like", value, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeIn(List<String> values) {
            addCriterion("production_code in", values, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeNotIn(List<String> values) {
            addCriterion("production_code not in", values, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeBetween(String value1, String value2) {
            addCriterion("production_code between", value1, value2, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionCodeNotBetween(String value1, String value2) {
            addCriterion("production_code not between", value1, value2, "productionCode");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlIsNull() {
            addCriterion("production_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlIsNotNull() {
            addCriterion("production_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlEqualTo(String value) {
            addCriterion("production_pic_url =", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlNotEqualTo(String value) {
            addCriterion("production_pic_url <>", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlGreaterThan(String value) {
            addCriterion("production_pic_url >", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("production_pic_url >=", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlLessThan(String value) {
            addCriterion("production_pic_url <", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlLessThanOrEqualTo(String value) {
            addCriterion("production_pic_url <=", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlLike(String value) {
            addCriterion("production_pic_url like", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlNotLike(String value) {
            addCriterion("production_pic_url not like", value, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlIn(List<String> values) {
            addCriterion("production_pic_url in", values, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlNotIn(List<String> values) {
            addCriterion("production_pic_url not in", values, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlBetween(String value1, String value2) {
            addCriterion("production_pic_url between", value1, value2, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPicUrlNotBetween(String value1, String value2) {
            addCriterion("production_pic_url not between", value1, value2, "productionPicUrl");
            return (Criteria) this;
        }

        public Criteria andProductionPriceIsNull() {
            addCriterion("production_price is null");
            return (Criteria) this;
        }

        public Criteria andProductionPriceIsNotNull() {
            addCriterion("production_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductionPriceEqualTo(Double value) {
            addCriterion("production_price =", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceNotEqualTo(Double value) {
            addCriterion("production_price <>", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceGreaterThan(Double value) {
            addCriterion("production_price >", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("production_price >=", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceLessThan(Double value) {
            addCriterion("production_price <", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceLessThanOrEqualTo(Double value) {
            addCriterion("production_price <=", value, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceIn(List<Double> values) {
            addCriterion("production_price in", values, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceNotIn(List<Double> values) {
            addCriterion("production_price not in", values, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceBetween(Double value1, Double value2) {
            addCriterion("production_price between", value1, value2, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionPriceNotBetween(Double value1, Double value2) {
            addCriterion("production_price not between", value1, value2, "productionPrice");
            return (Criteria) this;
        }

        public Criteria andProductionSizeIsNull() {
            addCriterion("production_size is null");
            return (Criteria) this;
        }

        public Criteria andProductionSizeIsNotNull() {
            addCriterion("production_size is not null");
            return (Criteria) this;
        }

        public Criteria andProductionSizeEqualTo(String value) {
            addCriterion("production_size =", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeNotEqualTo(String value) {
            addCriterion("production_size <>", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeGreaterThan(String value) {
            addCriterion("production_size >", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeGreaterThanOrEqualTo(String value) {
            addCriterion("production_size >=", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeLessThan(String value) {
            addCriterion("production_size <", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeLessThanOrEqualTo(String value) {
            addCriterion("production_size <=", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeLike(String value) {
            addCriterion("production_size like", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeNotLike(String value) {
            addCriterion("production_size not like", value, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeIn(List<String> values) {
            addCriterion("production_size in", values, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeNotIn(List<String> values) {
            addCriterion("production_size not in", values, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeBetween(String value1, String value2) {
            addCriterion("production_size between", value1, value2, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionSizeNotBetween(String value1, String value2) {
            addCriterion("production_size not between", value1, value2, "productionSize");
            return (Criteria) this;
        }

        public Criteria andProductionColorIsNull() {
            addCriterion("production_color is null");
            return (Criteria) this;
        }

        public Criteria andProductionColorIsNotNull() {
            addCriterion("production_color is not null");
            return (Criteria) this;
        }

        public Criteria andProductionColorEqualTo(String value) {
            addCriterion("production_color =", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorNotEqualTo(String value) {
            addCriterion("production_color <>", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorGreaterThan(String value) {
            addCriterion("production_color >", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorGreaterThanOrEqualTo(String value) {
            addCriterion("production_color >=", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorLessThan(String value) {
            addCriterion("production_color <", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorLessThanOrEqualTo(String value) {
            addCriterion("production_color <=", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorLike(String value) {
            addCriterion("production_color like", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorNotLike(String value) {
            addCriterion("production_color not like", value, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorIn(List<String> values) {
            addCriterion("production_color in", values, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorNotIn(List<String> values) {
            addCriterion("production_color not in", values, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorBetween(String value1, String value2) {
            addCriterion("production_color between", value1, value2, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProductionColorNotBetween(String value1, String value2) {
            addCriterion("production_color not between", value1, value2, "productionColor");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageIsNull() {
            addCriterion("prodction_usage is null");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageIsNotNull() {
            addCriterion("prodction_usage is not null");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageEqualTo(String value) {
            addCriterion("prodction_usage =", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageNotEqualTo(String value) {
            addCriterion("prodction_usage <>", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageGreaterThan(String value) {
            addCriterion("prodction_usage >", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageGreaterThanOrEqualTo(String value) {
            addCriterion("prodction_usage >=", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageLessThan(String value) {
            addCriterion("prodction_usage <", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageLessThanOrEqualTo(String value) {
            addCriterion("prodction_usage <=", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageLike(String value) {
            addCriterion("prodction_usage like", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageNotLike(String value) {
            addCriterion("prodction_usage not like", value, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageIn(List<String> values) {
            addCriterion("prodction_usage in", values, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageNotIn(List<String> values) {
            addCriterion("prodction_usage not in", values, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageBetween(String value1, String value2) {
            addCriterion("prodction_usage between", value1, value2, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProdctionUsageNotBetween(String value1, String value2) {
            addCriterion("prodction_usage not between", value1, value2, "prodctionUsage");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialIsNull() {
            addCriterion("production_material is null");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialIsNotNull() {
            addCriterion("production_material is not null");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialEqualTo(String value) {
            addCriterion("production_material =", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialNotEqualTo(String value) {
            addCriterion("production_material <>", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialGreaterThan(String value) {
            addCriterion("production_material >", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("production_material >=", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialLessThan(String value) {
            addCriterion("production_material <", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialLessThanOrEqualTo(String value) {
            addCriterion("production_material <=", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialLike(String value) {
            addCriterion("production_material like", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialNotLike(String value) {
            addCriterion("production_material not like", value, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialIn(List<String> values) {
            addCriterion("production_material in", values, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialNotIn(List<String> values) {
            addCriterion("production_material not in", values, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialBetween(String value1, String value2) {
            addCriterion("production_material between", value1, value2, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionMaterialNotBetween(String value1, String value2) {
            addCriterion("production_material not between", value1, value2, "productionMaterial");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainIsNull() {
            addCriterion("production_stock_remain is null");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainIsNotNull() {
            addCriterion("production_stock_remain is not null");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainEqualTo(Long value) {
            addCriterion("production_stock_remain =", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainNotEqualTo(Long value) {
            addCriterion("production_stock_remain <>", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainGreaterThan(Long value) {
            addCriterion("production_stock_remain >", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainGreaterThanOrEqualTo(Long value) {
            addCriterion("production_stock_remain >=", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainLessThan(Long value) {
            addCriterion("production_stock_remain <", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainLessThanOrEqualTo(Long value) {
            addCriterion("production_stock_remain <=", value, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainIn(List<Long> values) {
            addCriterion("production_stock_remain in", values, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainNotIn(List<Long> values) {
            addCriterion("production_stock_remain not in", values, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainBetween(Long value1, Long value2) {
            addCriterion("production_stock_remain between", value1, value2, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionStockRemainNotBetween(Long value1, Long value2) {
            addCriterion("production_stock_remain not between", value1, value2, "productionStockRemain");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeIsNull() {
            addCriterion("production_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeIsNotNull() {
            addCriterion("production_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("production_create_time =", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("production_create_time <>", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("production_create_time >", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_create_time >=", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("production_create_time <", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_create_time <=", value, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("production_create_time in", values, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("production_create_time not in", values, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_create_time between", value1, value2, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_create_time not between", value1, value2, "productionCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfIsNull() {
            addCriterion("production_isself is null");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfIsNotNull() {
            addCriterion("production_isself is not null");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfEqualTo(String value) {
            addCriterion("production_isself =", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfNotEqualTo(String value) {
            addCriterion("production_isself <>", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfGreaterThan(String value) {
            addCriterion("production_isself >", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfGreaterThanOrEqualTo(String value) {
            addCriterion("production_isself >=", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfLessThan(String value) {
            addCriterion("production_isself <", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfLessThanOrEqualTo(String value) {
            addCriterion("production_isself <=", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfLike(String value) {
            addCriterion("production_isself like", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfNotLike(String value) {
            addCriterion("production_isself not like", value, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfIn(List<String> values) {
            addCriterion("production_isself in", values, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfNotIn(List<String> values) {
            addCriterion("production_isself not in", values, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfBetween(String value1, String value2) {
            addCriterion("production_isself between", value1, value2, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionIsselfNotBetween(String value1, String value2) {
            addCriterion("production_isself not between", value1, value2, "productionIsself");
            return (Criteria) this;
        }

        public Criteria andProductionSourceIsNull() {
            addCriterion("production_source is null");
            return (Criteria) this;
        }

        public Criteria andProductionSourceIsNotNull() {
            addCriterion("production_source is not null");
            return (Criteria) this;
        }

        public Criteria andProductionSourceEqualTo(String value) {
            addCriterion("production_source =", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceNotEqualTo(String value) {
            addCriterion("production_source <>", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceGreaterThan(String value) {
            addCriterion("production_source >", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceGreaterThanOrEqualTo(String value) {
            addCriterion("production_source >=", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceLessThan(String value) {
            addCriterion("production_source <", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceLessThanOrEqualTo(String value) {
            addCriterion("production_source <=", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceLike(String value) {
            addCriterion("production_source like", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceNotLike(String value) {
            addCriterion("production_source not like", value, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceIn(List<String> values) {
            addCriterion("production_source in", values, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceNotIn(List<String> values) {
            addCriterion("production_source not in", values, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceBetween(String value1, String value2) {
            addCriterion("production_source between", value1, value2, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionSourceNotBetween(String value1, String value2) {
            addCriterion("production_source not between", value1, value2, "productionSource");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeIsNull() {
            addCriterion("production_invalid_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeIsNotNull() {
            addCriterion("production_invalid_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeEqualTo(Date value) {
            addCriterionForJDBCDate("production_invalid_time =", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("production_invalid_time <>", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("production_invalid_time >", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_invalid_time >=", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeLessThan(Date value) {
            addCriterionForJDBCDate("production_invalid_time <", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_invalid_time <=", value, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeIn(List<Date> values) {
            addCriterionForJDBCDate("production_invalid_time in", values, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("production_invalid_time not in", values, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_invalid_time between", value1, value2, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_invalid_time not between", value1, value2, "productionInvalidTime");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleIsNull() {
            addCriterion("production_issale is null");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleIsNotNull() {
            addCriterion("production_issale is not null");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleEqualTo(String value) {
            addCriterion("production_issale =", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleNotEqualTo(String value) {
            addCriterion("production_issale <>", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleGreaterThan(String value) {
            addCriterion("production_issale >", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleGreaterThanOrEqualTo(String value) {
            addCriterion("production_issale >=", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleLessThan(String value) {
            addCriterion("production_issale <", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleLessThanOrEqualTo(String value) {
            addCriterion("production_issale <=", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleLike(String value) {
            addCriterion("production_issale like", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleNotLike(String value) {
            addCriterion("production_issale not like", value, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleIn(List<String> values) {
            addCriterion("production_issale in", values, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleNotIn(List<String> values) {
            addCriterion("production_issale not in", values, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleBetween(String value1, String value2) {
            addCriterion("production_issale between", value1, value2, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIssaleNotBetween(String value1, String value2) {
            addCriterion("production_issale not between", value1, value2, "productionIssale");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidIsNull() {
            addCriterion("production_isvalid is null");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidIsNotNull() {
            addCriterion("production_isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidEqualTo(String value) {
            addCriterion("production_isvalid =", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidNotEqualTo(String value) {
            addCriterion("production_isvalid <>", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidGreaterThan(String value) {
            addCriterion("production_isvalid >", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidGreaterThanOrEqualTo(String value) {
            addCriterion("production_isvalid >=", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidLessThan(String value) {
            addCriterion("production_isvalid <", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidLessThanOrEqualTo(String value) {
            addCriterion("production_isvalid <=", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidLike(String value) {
            addCriterion("production_isvalid like", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidNotLike(String value) {
            addCriterion("production_isvalid not like", value, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidIn(List<String> values) {
            addCriterion("production_isvalid in", values, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidNotIn(List<String> values) {
            addCriterion("production_isvalid not in", values, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidBetween(String value1, String value2) {
            addCriterion("production_isvalid between", value1, value2, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andProductionIsvalidNotBetween(String value1, String value2) {
            addCriterion("production_isvalid not between", value1, value2, "productionIsvalid");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNull() {
            addCriterion("import_time is null");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNotNull() {
            addCriterion("import_time is not null");
            return (Criteria) this;
        }

        public Criteria andImportTimeEqualTo(Date value) {
            addCriterion("import_time =", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotEqualTo(Date value) {
            addCriterion("import_time <>", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThan(Date value) {
            addCriterion("import_time >", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_time >=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThan(Date value) {
            addCriterion("import_time <", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThanOrEqualTo(Date value) {
            addCriterion("import_time <=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeIn(List<Date> values) {
            addCriterion("import_time in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotIn(List<Date> values) {
            addCriterion("import_time not in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeBetween(Date value1, Date value2) {
            addCriterion("import_time between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotBetween(Date value1, Date value2) {
            addCriterion("import_time not between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportPersonIsNull() {
            addCriterion("import_person is null");
            return (Criteria) this;
        }

        public Criteria andImportPersonIsNotNull() {
            addCriterion("import_person is not null");
            return (Criteria) this;
        }

        public Criteria andImportPersonEqualTo(String value) {
            addCriterion("import_person =", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonNotEqualTo(String value) {
            addCriterion("import_person <>", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonGreaterThan(String value) {
            addCriterion("import_person >", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonGreaterThanOrEqualTo(String value) {
            addCriterion("import_person >=", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonLessThan(String value) {
            addCriterion("import_person <", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonLessThanOrEqualTo(String value) {
            addCriterion("import_person <=", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonLike(String value) {
            addCriterion("import_person like", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonNotLike(String value) {
            addCriterion("import_person not like", value, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonIn(List<String> values) {
            addCriterion("import_person in", values, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonNotIn(List<String> values) {
            addCriterion("import_person not in", values, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonBetween(String value1, String value2) {
            addCriterion("import_person between", value1, value2, "importPerson");
            return (Criteria) this;
        }

        public Criteria andImportPersonNotBetween(String value1, String value2) {
            addCriterion("import_person not between", value1, value2, "importPerson");
            return (Criteria) this;
        }

        public Criteria andProductionDescIsNull() {
            addCriterion("production_desc is null");
            return (Criteria) this;
        }

        public Criteria andProductionDescIsNotNull() {
            addCriterion("production_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProductionDescEqualTo(String value) {
            addCriterion("production_desc =", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescNotEqualTo(String value) {
            addCriterion("production_desc <>", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescGreaterThan(String value) {
            addCriterion("production_desc >", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescGreaterThanOrEqualTo(String value) {
            addCriterion("production_desc >=", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescLessThan(String value) {
            addCriterion("production_desc <", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescLessThanOrEqualTo(String value) {
            addCriterion("production_desc <=", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescLike(String value) {
            addCriterion("production_desc like", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescNotLike(String value) {
            addCriterion("production_desc not like", value, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescIn(List<String> values) {
            addCriterion("production_desc in", values, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescNotIn(List<String> values) {
            addCriterion("production_desc not in", values, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescBetween(String value1, String value2) {
            addCriterion("production_desc between", value1, value2, "productionDesc");
            return (Criteria) this;
        }

        public Criteria andProductionDescNotBetween(String value1, String value2) {
            addCriterion("production_desc not between", value1, value2, "productionDesc");
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