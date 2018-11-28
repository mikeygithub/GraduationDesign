package com.mikey.design.entity;

import java.util.ArrayList;
import java.util.List;

public class WishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WishExample() {
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

        public Criteria andWishIdIsNull() {
            addCriterion("wish_id is null");
            return (Criteria) this;
        }

        public Criteria andWishIdIsNotNull() {
            addCriterion("wish_id is not null");
            return (Criteria) this;
        }

        public Criteria andWishIdEqualTo(Integer value) {
            addCriterion("wish_id =", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotEqualTo(Integer value) {
            addCriterion("wish_id <>", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThan(Integer value) {
            addCriterion("wish_id >", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wish_id >=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThan(Integer value) {
            addCriterion("wish_id <", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThanOrEqualTo(Integer value) {
            addCriterion("wish_id <=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdIn(List<Integer> values) {
            addCriterion("wish_id in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotIn(List<Integer> values) {
            addCriterion("wish_id not in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdBetween(Integer value1, Integer value2) {
            addCriterion("wish_id between", value1, value2, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wish_id not between", value1, value2, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishFistIsNull() {
            addCriterion("wish_fist is null");
            return (Criteria) this;
        }

        public Criteria andWishFistIsNotNull() {
            addCriterion("wish_fist is not null");
            return (Criteria) this;
        }

        public Criteria andWishFistEqualTo(String value) {
            addCriterion("wish_fist =", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistNotEqualTo(String value) {
            addCriterion("wish_fist <>", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistGreaterThan(String value) {
            addCriterion("wish_fist >", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistGreaterThanOrEqualTo(String value) {
            addCriterion("wish_fist >=", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistLessThan(String value) {
            addCriterion("wish_fist <", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistLessThanOrEqualTo(String value) {
            addCriterion("wish_fist <=", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistLike(String value) {
            addCriterion("wish_fist like", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistNotLike(String value) {
            addCriterion("wish_fist not like", value, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistIn(List<String> values) {
            addCriterion("wish_fist in", values, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistNotIn(List<String> values) {
            addCriterion("wish_fist not in", values, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistBetween(String value1, String value2) {
            addCriterion("wish_fist between", value1, value2, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishFistNotBetween(String value1, String value2) {
            addCriterion("wish_fist not between", value1, value2, "wishFist");
            return (Criteria) this;
        }

        public Criteria andWishSecondIsNull() {
            addCriterion("wish_second is null");
            return (Criteria) this;
        }

        public Criteria andWishSecondIsNotNull() {
            addCriterion("wish_second is not null");
            return (Criteria) this;
        }

        public Criteria andWishSecondEqualTo(String value) {
            addCriterion("wish_second =", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondNotEqualTo(String value) {
            addCriterion("wish_second <>", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondGreaterThan(String value) {
            addCriterion("wish_second >", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondGreaterThanOrEqualTo(String value) {
            addCriterion("wish_second >=", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondLessThan(String value) {
            addCriterion("wish_second <", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondLessThanOrEqualTo(String value) {
            addCriterion("wish_second <=", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondLike(String value) {
            addCriterion("wish_second like", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondNotLike(String value) {
            addCriterion("wish_second not like", value, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondIn(List<String> values) {
            addCriterion("wish_second in", values, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondNotIn(List<String> values) {
            addCriterion("wish_second not in", values, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondBetween(String value1, String value2) {
            addCriterion("wish_second between", value1, value2, "wishSecond");
            return (Criteria) this;
        }

        public Criteria andWishSecondNotBetween(String value1, String value2) {
            addCriterion("wish_second not between", value1, value2, "wishSecond");
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