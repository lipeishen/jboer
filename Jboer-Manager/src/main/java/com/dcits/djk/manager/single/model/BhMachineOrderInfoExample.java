package com.dcits.djk.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BhMachineOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhMachineOrderInfoExample() {
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

        public Criteria andMachineOrderIdIsNull() {
            addCriterion("machine_order_id is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdIsNotNull() {
            addCriterion("machine_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdEqualTo(String value) {
            addCriterion("machine_order_id =", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdNotEqualTo(String value) {
            addCriterion("machine_order_id <>", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdGreaterThan(String value) {
            addCriterion("machine_order_id >", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("machine_order_id >=", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdLessThan(String value) {
            addCriterion("machine_order_id <", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdLessThanOrEqualTo(String value) {
            addCriterion("machine_order_id <=", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdLike(String value) {
            addCriterion("machine_order_id like", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdNotLike(String value) {
            addCriterion("machine_order_id not like", value, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdIn(List<String> values) {
            addCriterion("machine_order_id in", values, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdNotIn(List<String> values) {
            addCriterion("machine_order_id not in", values, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdBetween(String value1, String value2) {
            addCriterion("machine_order_id between", value1, value2, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderIdNotBetween(String value1, String value2) {
            addCriterion("machine_order_id not between", value1, value2, "machineOrderId");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeIsNull() {
            addCriterion("machine_order_type is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeIsNotNull() {
            addCriterion("machine_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeEqualTo(String value) {
            addCriterion("machine_order_type =", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeNotEqualTo(String value) {
            addCriterion("machine_order_type <>", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeGreaterThan(String value) {
            addCriterion("machine_order_type >", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("machine_order_type >=", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeLessThan(String value) {
            addCriterion("machine_order_type <", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("machine_order_type <=", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeLike(String value) {
            addCriterion("machine_order_type like", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeNotLike(String value) {
            addCriterion("machine_order_type not like", value, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeIn(List<String> values) {
            addCriterion("machine_order_type in", values, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeNotIn(List<String> values) {
            addCriterion("machine_order_type not in", values, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeBetween(String value1, String value2) {
            addCriterion("machine_order_type between", value1, value2, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderTypeNotBetween(String value1, String value2) {
            addCriterion("machine_order_type not between", value1, value2, "machineOrderType");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumIsNull() {
            addCriterion("machine_order_num is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumIsNotNull() {
            addCriterion("machine_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumEqualTo(String value) {
            addCriterion("machine_order_num =", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumNotEqualTo(String value) {
            addCriterion("machine_order_num <>", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumGreaterThan(String value) {
            addCriterion("machine_order_num >", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("machine_order_num >=", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumLessThan(String value) {
            addCriterion("machine_order_num <", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumLessThanOrEqualTo(String value) {
            addCriterion("machine_order_num <=", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumLike(String value) {
            addCriterion("machine_order_num like", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumNotLike(String value) {
            addCriterion("machine_order_num not like", value, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumIn(List<String> values) {
            addCriterion("machine_order_num in", values, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumNotIn(List<String> values) {
            addCriterion("machine_order_num not in", values, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumBetween(String value1, String value2) {
            addCriterion("machine_order_num between", value1, value2, "machineOrderNum");
            return (Criteria) this;
        }

        public Criteria andMachineOrderNumNotBetween(String value1, String value2) {
            addCriterion("machine_order_num not between", value1, value2, "machineOrderNum");
            return (Criteria) this;
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

        public Criteria andMachineOrderCreateTimeIsNull() {
            addCriterion("machine_order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeIsNotNull() {
            addCriterion("machine_order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeEqualTo(Date value) {
            addCriterion("machine_order_create_time =", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("machine_order_create_time <>", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeGreaterThan(Date value) {
            addCriterion("machine_order_create_time >", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("machine_order_create_time >=", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeLessThan(Date value) {
            addCriterion("machine_order_create_time <", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("machine_order_create_time <=", value, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeIn(List<Date> values) {
            addCriterion("machine_order_create_time in", values, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("machine_order_create_time not in", values, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("machine_order_create_time between", value1, value2, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("machine_order_create_time not between", value1, value2, "machineOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityIsNull() {
            addCriterion("machine_order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityIsNotNull() {
            addCriterion("machine_order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityEqualTo(Long value) {
            addCriterion("machine_order_quantity =", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityNotEqualTo(Long value) {
            addCriterion("machine_order_quantity <>", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityGreaterThan(Long value) {
            addCriterion("machine_order_quantity >", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_order_quantity >=", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityLessThan(Long value) {
            addCriterion("machine_order_quantity <", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityLessThanOrEqualTo(Long value) {
            addCriterion("machine_order_quantity <=", value, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityIn(List<Long> values) {
            addCriterion("machine_order_quantity in", values, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityNotIn(List<Long> values) {
            addCriterion("machine_order_quantity not in", values, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityBetween(Long value1, Long value2) {
            addCriterion("machine_order_quantity between", value1, value2, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderQuantityNotBetween(Long value1, Long value2) {
            addCriterion("machine_order_quantity not between", value1, value2, "machineOrderQuantity");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountIsNull() {
            addCriterion("machine_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountIsNotNull() {
            addCriterion("machine_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountEqualTo(Long value) {
            addCriterion("machine_order_amount =", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountNotEqualTo(Long value) {
            addCriterion("machine_order_amount <>", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountGreaterThan(Long value) {
            addCriterion("machine_order_amount >", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_order_amount >=", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountLessThan(Long value) {
            addCriterion("machine_order_amount <", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("machine_order_amount <=", value, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountIn(List<Long> values) {
            addCriterion("machine_order_amount in", values, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountNotIn(List<Long> values) {
            addCriterion("machine_order_amount not in", values, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountBetween(Long value1, Long value2) {
            addCriterion("machine_order_amount between", value1, value2, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("machine_order_amount not between", value1, value2, "machineOrderAmount");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusIsNull() {
            addCriterion("machine_order_status is null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusIsNotNull() {
            addCriterion("machine_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusEqualTo(String value) {
            addCriterion("machine_order_status =", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusNotEqualTo(String value) {
            addCriterion("machine_order_status <>", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusGreaterThan(String value) {
            addCriterion("machine_order_status >", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("machine_order_status >=", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusLessThan(String value) {
            addCriterion("machine_order_status <", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("machine_order_status <=", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusLike(String value) {
            addCriterion("machine_order_status like", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusNotLike(String value) {
            addCriterion("machine_order_status not like", value, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusIn(List<String> values) {
            addCriterion("machine_order_status in", values, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusNotIn(List<String> values) {
            addCriterion("machine_order_status not in", values, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusBetween(String value1, String value2) {
            addCriterion("machine_order_status between", value1, value2, "machineOrderStatus");
            return (Criteria) this;
        }

        public Criteria andMachineOrderStatusNotBetween(String value1, String value2) {
            addCriterion("machine_order_status not between", value1, value2, "machineOrderStatus");
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