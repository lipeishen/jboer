package com.dcits.jb.manager.single.model;

import java.util.ArrayList;
import java.util.List;

public class BhSysUserModularInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhSysUserModularInfoExample() {
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

        public Criteria andModularIdIsNull() {
            addCriterion("modular_id is null");
            return (Criteria) this;
        }

        public Criteria andModularIdIsNotNull() {
            addCriterion("modular_id is not null");
            return (Criteria) this;
        }

        public Criteria andModularIdEqualTo(String value) {
            addCriterion("modular_id =", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotEqualTo(String value) {
            addCriterion("modular_id <>", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThan(String value) {
            addCriterion("modular_id >", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThanOrEqualTo(String value) {
            addCriterion("modular_id >=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThan(String value) {
            addCriterion("modular_id <", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThanOrEqualTo(String value) {
            addCriterion("modular_id <=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLike(String value) {
            addCriterion("modular_id like", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotLike(String value) {
            addCriterion("modular_id not like", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdIn(List<String> values) {
            addCriterion("modular_id in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotIn(List<String> values) {
            addCriterion("modular_id not in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdBetween(String value1, String value2) {
            addCriterion("modular_id between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotBetween(String value1, String value2) {
            addCriterion("modular_id not between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularNameIsNull() {
            addCriterion("modular_name is null");
            return (Criteria) this;
        }

        public Criteria andModularNameIsNotNull() {
            addCriterion("modular_name is not null");
            return (Criteria) this;
        }

        public Criteria andModularNameEqualTo(String value) {
            addCriterion("modular_name =", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotEqualTo(String value) {
            addCriterion("modular_name <>", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThan(String value) {
            addCriterion("modular_name >", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThanOrEqualTo(String value) {
            addCriterion("modular_name >=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThan(String value) {
            addCriterion("modular_name <", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThanOrEqualTo(String value) {
            addCriterion("modular_name <=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLike(String value) {
            addCriterion("modular_name like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotLike(String value) {
            addCriterion("modular_name not like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameIn(List<String> values) {
            addCriterion("modular_name in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotIn(List<String> values) {
            addCriterion("modular_name not in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameBetween(String value1, String value2) {
            addCriterion("modular_name between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotBetween(String value1, String value2) {
            addCriterion("modular_name not between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularParentIdIsNull() {
            addCriterion("modular_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andModularParentIdIsNotNull() {
            addCriterion("modular_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andModularParentIdEqualTo(String value) {
            addCriterion("modular_parent_id =", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdNotEqualTo(String value) {
            addCriterion("modular_parent_id <>", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdGreaterThan(String value) {
            addCriterion("modular_parent_id >", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("modular_parent_id >=", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdLessThan(String value) {
            addCriterion("modular_parent_id <", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdLessThanOrEqualTo(String value) {
            addCriterion("modular_parent_id <=", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdLike(String value) {
            addCriterion("modular_parent_id like", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdNotLike(String value) {
            addCriterion("modular_parent_id not like", value, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdIn(List<String> values) {
            addCriterion("modular_parent_id in", values, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdNotIn(List<String> values) {
            addCriterion("modular_parent_id not in", values, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdBetween(String value1, String value2) {
            addCriterion("modular_parent_id between", value1, value2, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularParentIdNotBetween(String value1, String value2) {
            addCriterion("modular_parent_id not between", value1, value2, "modularParentId");
            return (Criteria) this;
        }

        public Criteria andModularCodeIsNull() {
            addCriterion("modular_code is null");
            return (Criteria) this;
        }

        public Criteria andModularCodeIsNotNull() {
            addCriterion("modular_code is not null");
            return (Criteria) this;
        }

        public Criteria andModularCodeEqualTo(String value) {
            addCriterion("modular_code =", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeNotEqualTo(String value) {
            addCriterion("modular_code <>", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeGreaterThan(String value) {
            addCriterion("modular_code >", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeGreaterThanOrEqualTo(String value) {
            addCriterion("modular_code >=", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeLessThan(String value) {
            addCriterion("modular_code <", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeLessThanOrEqualTo(String value) {
            addCriterion("modular_code <=", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeLike(String value) {
            addCriterion("modular_code like", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeNotLike(String value) {
            addCriterion("modular_code not like", value, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeIn(List<String> values) {
            addCriterion("modular_code in", values, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeNotIn(List<String> values) {
            addCriterion("modular_code not in", values, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeBetween(String value1, String value2) {
            addCriterion("modular_code between", value1, value2, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularCodeNotBetween(String value1, String value2) {
            addCriterion("modular_code not between", value1, value2, "modularCode");
            return (Criteria) this;
        }

        public Criteria andModularUrlIsNull() {
            addCriterion("modular_url is null");
            return (Criteria) this;
        }

        public Criteria andModularUrlIsNotNull() {
            addCriterion("modular_url is not null");
            return (Criteria) this;
        }

        public Criteria andModularUrlEqualTo(String value) {
            addCriterion("modular_url =", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlNotEqualTo(String value) {
            addCriterion("modular_url <>", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlGreaterThan(String value) {
            addCriterion("modular_url >", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlGreaterThanOrEqualTo(String value) {
            addCriterion("modular_url >=", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlLessThan(String value) {
            addCriterion("modular_url <", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlLessThanOrEqualTo(String value) {
            addCriterion("modular_url <=", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlLike(String value) {
            addCriterion("modular_url like", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlNotLike(String value) {
            addCriterion("modular_url not like", value, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlIn(List<String> values) {
            addCriterion("modular_url in", values, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlNotIn(List<String> values) {
            addCriterion("modular_url not in", values, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlBetween(String value1, String value2) {
            addCriterion("modular_url between", value1, value2, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andModularUrlNotBetween(String value1, String value2) {
            addCriterion("modular_url not between", value1, value2, "modularUrl");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
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