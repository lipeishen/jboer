package com.dcits.djk.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BhProductionOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhProductionOrderInfoExample() {
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

        public Criteria andProOrderIdIsNull() {
            addCriterion("pro_order_id is null");
            return (Criteria) this;
        }

        public Criteria andProOrderIdIsNotNull() {
            addCriterion("pro_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderIdEqualTo(String value) {
            addCriterion("pro_order_id =", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdNotEqualTo(String value) {
            addCriterion("pro_order_id <>", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdGreaterThan(String value) {
            addCriterion("pro_order_id >", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_order_id >=", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdLessThan(String value) {
            addCriterion("pro_order_id <", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdLessThanOrEqualTo(String value) {
            addCriterion("pro_order_id <=", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdLike(String value) {
            addCriterion("pro_order_id like", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdNotLike(String value) {
            addCriterion("pro_order_id not like", value, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdIn(List<String> values) {
            addCriterion("pro_order_id in", values, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdNotIn(List<String> values) {
            addCriterion("pro_order_id not in", values, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdBetween(String value1, String value2) {
            addCriterion("pro_order_id between", value1, value2, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderIdNotBetween(String value1, String value2) {
            addCriterion("pro_order_id not between", value1, value2, "proOrderId");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeIsNull() {
            addCriterion("pro_order_type is null");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeIsNotNull() {
            addCriterion("pro_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeEqualTo(String value) {
            addCriterion("pro_order_type =", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeNotEqualTo(String value) {
            addCriterion("pro_order_type <>", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeGreaterThan(String value) {
            addCriterion("pro_order_type >", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_order_type >=", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeLessThan(String value) {
            addCriterion("pro_order_type <", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_order_type <=", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeLike(String value) {
            addCriterion("pro_order_type like", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeNotLike(String value) {
            addCriterion("pro_order_type not like", value, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeIn(List<String> values) {
            addCriterion("pro_order_type in", values, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeNotIn(List<String> values) {
            addCriterion("pro_order_type not in", values, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeBetween(String value1, String value2) {
            addCriterion("pro_order_type between", value1, value2, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderTypeNotBetween(String value1, String value2) {
            addCriterion("pro_order_type not between", value1, value2, "proOrderType");
            return (Criteria) this;
        }

        public Criteria andProOrderNumIsNull() {
            addCriterion("pro_order_num is null");
            return (Criteria) this;
        }

        public Criteria andProOrderNumIsNotNull() {
            addCriterion("pro_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderNumEqualTo(String value) {
            addCriterion("pro_order_num =", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumNotEqualTo(String value) {
            addCriterion("pro_order_num <>", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumGreaterThan(String value) {
            addCriterion("pro_order_num >", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("pro_order_num >=", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumLessThan(String value) {
            addCriterion("pro_order_num <", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumLessThanOrEqualTo(String value) {
            addCriterion("pro_order_num <=", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumLike(String value) {
            addCriterion("pro_order_num like", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumNotLike(String value) {
            addCriterion("pro_order_num not like", value, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumIn(List<String> values) {
            addCriterion("pro_order_num in", values, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumNotIn(List<String> values) {
            addCriterion("pro_order_num not in", values, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumBetween(String value1, String value2) {
            addCriterion("pro_order_num between", value1, value2, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderNumNotBetween(String value1, String value2) {
            addCriterion("pro_order_num not between", value1, value2, "proOrderNum");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeIsNull() {
            addCriterion("pro_order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeIsNotNull() {
            addCriterion("pro_order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeEqualTo(Date value) {
            addCriterion("pro_order_create_time =", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("pro_order_create_time <>", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeGreaterThan(Date value) {
            addCriterion("pro_order_create_time >", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_order_create_time >=", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeLessThan(Date value) {
            addCriterion("pro_order_create_time <", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("pro_order_create_time <=", value, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeIn(List<Date> values) {
            addCriterion("pro_order_create_time in", values, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("pro_order_create_time not in", values, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("pro_order_create_time between", value1, value2, "proOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andProOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("pro_order_create_time not between", value1, value2, "proOrderCreateTime");
            return (Criteria) this;
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

        public Criteria andProOrderQuantityIsNull() {
            addCriterion("pro_order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityIsNotNull() {
            addCriterion("pro_order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityEqualTo(Long value) {
            addCriterion("pro_order_quantity =", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityNotEqualTo(Long value) {
            addCriterion("pro_order_quantity <>", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityGreaterThan(Long value) {
            addCriterion("pro_order_quantity >", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_order_quantity >=", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityLessThan(Long value) {
            addCriterion("pro_order_quantity <", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityLessThanOrEqualTo(Long value) {
            addCriterion("pro_order_quantity <=", value, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityIn(List<Long> values) {
            addCriterion("pro_order_quantity in", values, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityNotIn(List<Long> values) {
            addCriterion("pro_order_quantity not in", values, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityBetween(Long value1, Long value2) {
            addCriterion("pro_order_quantity between", value1, value2, "proOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andProOrderQuantityNotBetween(Long value1, Long value2) {
            addCriterion("pro_order_quantity not between", value1, value2, "proOrderQuantity");
            return (Criteria) this;
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

        public Criteria andProOrderAmountIsNull() {
            addCriterion("pro_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountIsNotNull() {
            addCriterion("pro_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountEqualTo(Long value) {
            addCriterion("pro_order_amount =", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountNotEqualTo(Long value) {
            addCriterion("pro_order_amount <>", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountGreaterThan(Long value) {
            addCriterion("pro_order_amount >", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_order_amount >=", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountLessThan(Long value) {
            addCriterion("pro_order_amount <", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("pro_order_amount <=", value, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountIn(List<Long> values) {
            addCriterion("pro_order_amount in", values, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountNotIn(List<Long> values) {
            addCriterion("pro_order_amount not in", values, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountBetween(Long value1, Long value2) {
            addCriterion("pro_order_amount between", value1, value2, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("pro_order_amount not between", value1, value2, "proOrderAmount");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusIsNull() {
            addCriterion("pro_order_status is null");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusIsNotNull() {
            addCriterion("pro_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusEqualTo(String value) {
            addCriterion("pro_order_status =", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusNotEqualTo(String value) {
            addCriterion("pro_order_status <>", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusGreaterThan(String value) {
            addCriterion("pro_order_status >", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pro_order_status >=", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusLessThan(String value) {
            addCriterion("pro_order_status <", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("pro_order_status <=", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusLike(String value) {
            addCriterion("pro_order_status like", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusNotLike(String value) {
            addCriterion("pro_order_status not like", value, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusIn(List<String> values) {
            addCriterion("pro_order_status in", values, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusNotIn(List<String> values) {
            addCriterion("pro_order_status not in", values, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusBetween(String value1, String value2) {
            addCriterion("pro_order_status between", value1, value2, "proOrderStatus");
            return (Criteria) this;
        }

        public Criteria andProOrderStatusNotBetween(String value1, String value2) {
            addCriterion("pro_order_status not between", value1, value2, "proOrderStatus");
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