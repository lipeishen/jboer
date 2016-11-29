package com.dcits.djk.manager.single.model;

import java.util.ArrayList;
import java.util.List;

public class BhSysServRouterMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhSysServRouterMainExample() {
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

        public Criteria andRouterIdIsNull() {
            addCriterion("router_id is null");
            return (Criteria) this;
        }

        public Criteria andRouterIdIsNotNull() {
            addCriterion("router_id is not null");
            return (Criteria) this;
        }

        public Criteria andRouterIdEqualTo(String value) {
            addCriterion("router_id =", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotEqualTo(String value) {
            addCriterion("router_id <>", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdGreaterThan(String value) {
            addCriterion("router_id >", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdGreaterThanOrEqualTo(String value) {
            addCriterion("router_id >=", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLessThan(String value) {
            addCriterion("router_id <", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLessThanOrEqualTo(String value) {
            addCriterion("router_id <=", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdLike(String value) {
            addCriterion("router_id like", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotLike(String value) {
            addCriterion("router_id not like", value, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdIn(List<String> values) {
            addCriterion("router_id in", values, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotIn(List<String> values) {
            addCriterion("router_id not in", values, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdBetween(String value1, String value2) {
            addCriterion("router_id between", value1, value2, "routerId");
            return (Criteria) this;
        }

        public Criteria andRouterIdNotBetween(String value1, String value2) {
            addCriterion("router_id not between", value1, value2, "routerId");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNull() {
            addCriterion("service_ip is null");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNotNull() {
            addCriterion("service_ip is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIpEqualTo(String value) {
            addCriterion("service_ip =", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotEqualTo(String value) {
            addCriterion("service_ip <>", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThan(String value) {
            addCriterion("service_ip >", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("service_ip >=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThan(String value) {
            addCriterion("service_ip <", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThanOrEqualTo(String value) {
            addCriterion("service_ip <=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLike(String value) {
            addCriterion("service_ip like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotLike(String value) {
            addCriterion("service_ip not like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpIn(List<String> values) {
            addCriterion("service_ip in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotIn(List<String> values) {
            addCriterion("service_ip not in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpBetween(String value1, String value2) {
            addCriterion("service_ip between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotBetween(String value1, String value2) {
            addCriterion("service_ip not between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNull() {
            addCriterion("service_port is null");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNotNull() {
            addCriterion("service_port is not null");
            return (Criteria) this;
        }

        public Criteria andServicePortEqualTo(String value) {
            addCriterion("service_port =", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotEqualTo(String value) {
            addCriterion("service_port <>", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThan(String value) {
            addCriterion("service_port >", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThanOrEqualTo(String value) {
            addCriterion("service_port >=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThan(String value) {
            addCriterion("service_port <", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThanOrEqualTo(String value) {
            addCriterion("service_port <=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLike(String value) {
            addCriterion("service_port like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotLike(String value) {
            addCriterion("service_port not like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortIn(List<String> values) {
            addCriterion("service_port in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotIn(List<String> values) {
            addCriterion("service_port not in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortBetween(String value1, String value2) {
            addCriterion("service_port between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotBetween(String value1, String value2) {
            addCriterion("service_port not between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServiceContextIsNull() {
            addCriterion("service_context is null");
            return (Criteria) this;
        }

        public Criteria andServiceContextIsNotNull() {
            addCriterion("service_context is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContextEqualTo(String value) {
            addCriterion("service_context =", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextNotEqualTo(String value) {
            addCriterion("service_context <>", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextGreaterThan(String value) {
            addCriterion("service_context >", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextGreaterThanOrEqualTo(String value) {
            addCriterion("service_context >=", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextLessThan(String value) {
            addCriterion("service_context <", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextLessThanOrEqualTo(String value) {
            addCriterion("service_context <=", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextLike(String value) {
            addCriterion("service_context like", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextNotLike(String value) {
            addCriterion("service_context not like", value, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextIn(List<String> values) {
            addCriterion("service_context in", values, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextNotIn(List<String> values) {
            addCriterion("service_context not in", values, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextBetween(String value1, String value2) {
            addCriterion("service_context between", value1, value2, "serviceContext");
            return (Criteria) this;
        }

        public Criteria andServiceContextNotBetween(String value1, String value2) {
            addCriterion("service_context not between", value1, value2, "serviceContext");
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