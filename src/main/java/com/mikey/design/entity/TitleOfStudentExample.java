package com.mikey.design.entity;

import java.util.ArrayList;
import java.util.List;

public class TitleOfStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TitleOfStudentExample() {
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

        public Criteria andDesOfStuIdIsNull() {
            addCriterion("des_of_stu_id is null");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdIsNotNull() {
            addCriterion("des_of_stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdEqualTo(Integer value) {
            addCriterion("des_of_stu_id =", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdNotEqualTo(Integer value) {
            addCriterion("des_of_stu_id <>", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdGreaterThan(Integer value) {
            addCriterion("des_of_stu_id >", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("des_of_stu_id >=", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdLessThan(Integer value) {
            addCriterion("des_of_stu_id <", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("des_of_stu_id <=", value, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdIn(List<Integer> values) {
            addCriterion("des_of_stu_id in", values, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdNotIn(List<Integer> values) {
            addCriterion("des_of_stu_id not in", values, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdBetween(Integer value1, Integer value2) {
            addCriterion("des_of_stu_id between", value1, value2, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("des_of_stu_id not between", value1, value2, "desOfStuId");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIsNull() {
            addCriterion("des_of_stu is null");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIsNotNull() {
            addCriterion("des_of_stu is not null");
            return (Criteria) this;
        }

        public Criteria andDesOfStuEqualTo(Integer value) {
            addCriterion("des_of_stu =", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuNotEqualTo(Integer value) {
            addCriterion("des_of_stu <>", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuGreaterThan(Integer value) {
            addCriterion("des_of_stu >", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuGreaterThanOrEqualTo(Integer value) {
            addCriterion("des_of_stu >=", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuLessThan(Integer value) {
            addCriterion("des_of_stu <", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuLessThanOrEqualTo(Integer value) {
            addCriterion("des_of_stu <=", value, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuIn(List<Integer> values) {
            addCriterion("des_of_stu in", values, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuNotIn(List<Integer> values) {
            addCriterion("des_of_stu not in", values, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuBetween(Integer value1, Integer value2) {
            addCriterion("des_of_stu between", value1, value2, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfStuNotBetween(Integer value1, Integer value2) {
            addCriterion("des_of_stu not between", value1, value2, "desOfStu");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleIsNull() {
            addCriterion("des_of_title is null");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleIsNotNull() {
            addCriterion("des_of_title is not null");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleEqualTo(Integer value) {
            addCriterion("des_of_title =", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleNotEqualTo(Integer value) {
            addCriterion("des_of_title <>", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleGreaterThan(Integer value) {
            addCriterion("des_of_title >", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleGreaterThanOrEqualTo(Integer value) {
            addCriterion("des_of_title >=", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleLessThan(Integer value) {
            addCriterion("des_of_title <", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleLessThanOrEqualTo(Integer value) {
            addCriterion("des_of_title <=", value, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleIn(List<Integer> values) {
            addCriterion("des_of_title in", values, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleNotIn(List<Integer> values) {
            addCriterion("des_of_title not in", values, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleBetween(Integer value1, Integer value2) {
            addCriterion("des_of_title between", value1, value2, "desOfTitle");
            return (Criteria) this;
        }

        public Criteria andDesOfTitleNotBetween(Integer value1, Integer value2) {
            addCriterion("des_of_title not between", value1, value2, "desOfTitle");
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