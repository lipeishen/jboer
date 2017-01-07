package com.dcits.jb.manager.single.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BhSysFeedbackInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BhSysFeedbackInfoExample() {
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

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(String value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(String value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(String value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(String value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(String value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLike(String value) {
            addCriterion("feedback_id like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotLike(String value) {
            addCriterion("feedback_id not like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<String> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<String> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(String value1, String value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(String value1, String value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andServUserIdIsNull() {
            addCriterion("serv_user_id is null");
            return (Criteria) this;
        }

        public Criteria andServUserIdIsNotNull() {
            addCriterion("serv_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andServUserIdEqualTo(String value) {
            addCriterion("serv_user_id =", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdNotEqualTo(String value) {
            addCriterion("serv_user_id <>", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdGreaterThan(String value) {
            addCriterion("serv_user_id >", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("serv_user_id >=", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdLessThan(String value) {
            addCriterion("serv_user_id <", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdLessThanOrEqualTo(String value) {
            addCriterion("serv_user_id <=", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdLike(String value) {
            addCriterion("serv_user_id like", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdNotLike(String value) {
            addCriterion("serv_user_id not like", value, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdIn(List<String> values) {
            addCriterion("serv_user_id in", values, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdNotIn(List<String> values) {
            addCriterion("serv_user_id not in", values, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdBetween(String value1, String value2) {
            addCriterion("serv_user_id between", value1, value2, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserIdNotBetween(String value1, String value2) {
            addCriterion("serv_user_id not between", value1, value2, "servUserId");
            return (Criteria) this;
        }

        public Criteria andServUserNameIsNull() {
            addCriterion("serv_user_name is null");
            return (Criteria) this;
        }

        public Criteria andServUserNameIsNotNull() {
            addCriterion("serv_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andServUserNameEqualTo(String value) {
            addCriterion("serv_user_name =", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameNotEqualTo(String value) {
            addCriterion("serv_user_name <>", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameGreaterThan(String value) {
            addCriterion("serv_user_name >", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("serv_user_name >=", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameLessThan(String value) {
            addCriterion("serv_user_name <", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameLessThanOrEqualTo(String value) {
            addCriterion("serv_user_name <=", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameLike(String value) {
            addCriterion("serv_user_name like", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameNotLike(String value) {
            addCriterion("serv_user_name not like", value, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameIn(List<String> values) {
            addCriterion("serv_user_name in", values, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameNotIn(List<String> values) {
            addCriterion("serv_user_name not in", values, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameBetween(String value1, String value2) {
            addCriterion("serv_user_name between", value1, value2, "servUserName");
            return (Criteria) this;
        }

        public Criteria andServUserNameNotBetween(String value1, String value2) {
            addCriterion("serv_user_name not between", value1, value2, "servUserName");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentIsNull() {
            addCriterion("feedback_user_content is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentIsNotNull() {
            addCriterion("feedback_user_content is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentEqualTo(String value) {
            addCriterion("feedback_user_content =", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentNotEqualTo(String value) {
            addCriterion("feedback_user_content <>", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentGreaterThan(String value) {
            addCriterion("feedback_user_content >", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_user_content >=", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentLessThan(String value) {
            addCriterion("feedback_user_content <", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentLessThanOrEqualTo(String value) {
            addCriterion("feedback_user_content <=", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentLike(String value) {
            addCriterion("feedback_user_content like", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentNotLike(String value) {
            addCriterion("feedback_user_content not like", value, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentIn(List<String> values) {
            addCriterion("feedback_user_content in", values, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentNotIn(List<String> values) {
            addCriterion("feedback_user_content not in", values, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentBetween(String value1, String value2) {
            addCriterion("feedback_user_content between", value1, value2, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackUserContentNotBetween(String value1, String value2) {
            addCriterion("feedback_user_content not between", value1, value2, "feedbackUserContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentIsNull() {
            addCriterion("feedback_serv_content is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentIsNotNull() {
            addCriterion("feedback_serv_content is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentEqualTo(String value) {
            addCriterion("feedback_serv_content =", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentNotEqualTo(String value) {
            addCriterion("feedback_serv_content <>", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentGreaterThan(String value) {
            addCriterion("feedback_serv_content >", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_serv_content >=", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentLessThan(String value) {
            addCriterion("feedback_serv_content <", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentLessThanOrEqualTo(String value) {
            addCriterion("feedback_serv_content <=", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentLike(String value) {
            addCriterion("feedback_serv_content like", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentNotLike(String value) {
            addCriterion("feedback_serv_content not like", value, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentIn(List<String> values) {
            addCriterion("feedback_serv_content in", values, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentNotIn(List<String> values) {
            addCriterion("feedback_serv_content not in", values, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentBetween(String value1, String value2) {
            addCriterion("feedback_serv_content between", value1, value2, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackServContentNotBetween(String value1, String value2) {
            addCriterion("feedback_serv_content not between", value1, value2, "feedbackServContent");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNull() {
            addCriterion("feedback_time is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNotNull() {
            addCriterion("feedback_time is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeEqualTo(Date value) {
            addCriterion("feedback_time =", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotEqualTo(Date value) {
            addCriterion("feedback_time <>", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThan(Date value) {
            addCriterion("feedback_time >", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feedback_time >=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThan(Date value) {
            addCriterion("feedback_time <", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("feedback_time <=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIn(List<Date> values) {
            addCriterion("feedback_time in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotIn(List<Date> values) {
            addCriterion("feedback_time not in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeBetween(Date value1, Date value2) {
            addCriterion("feedback_time between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("feedback_time not between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNull() {
            addCriterion("feedback_status is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNotNull() {
            addCriterion("feedback_status is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusEqualTo(String value) {
            addCriterion("feedback_status =", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotEqualTo(String value) {
            addCriterion("feedback_status <>", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThan(String value) {
            addCriterion("feedback_status >", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_status >=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThan(String value) {
            addCriterion("feedback_status <", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThanOrEqualTo(String value) {
            addCriterion("feedback_status <=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLike(String value) {
            addCriterion("feedback_status like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotLike(String value) {
            addCriterion("feedback_status not like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIn(List<String> values) {
            addCriterion("feedback_status in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotIn(List<String> values) {
            addCriterion("feedback_status not in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusBetween(String value1, String value2) {
            addCriterion("feedback_status between", value1, value2, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotBetween(String value1, String value2) {
            addCriterion("feedback_status not between", value1, value2, "feedbackStatus");
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