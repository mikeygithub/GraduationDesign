package com.mikey.design.entity;

import java.util.ArrayList;
import java.util.List;

public class DesignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignExample() {
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

        public Criteria andDesignIdIsNull() {
            addCriterion("design_id is null");
            return (Criteria) this;
        }

        public Criteria andDesignIdIsNotNull() {
            addCriterion("design_id is not null");
            return (Criteria) this;
        }

        public Criteria andDesignIdEqualTo(Integer value) {
            addCriterion("design_id =", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdNotEqualTo(Integer value) {
            addCriterion("design_id <>", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdGreaterThan(Integer value) {
            addCriterion("design_id >", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("design_id >=", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdLessThan(Integer value) {
            addCriterion("design_id <", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdLessThanOrEqualTo(Integer value) {
            addCriterion("design_id <=", value, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdIn(List<Integer> values) {
            addCriterion("design_id in", values, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdNotIn(List<Integer> values) {
            addCriterion("design_id not in", values, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdBetween(Integer value1, Integer value2) {
            addCriterion("design_id between", value1, value2, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignIdNotBetween(Integer value1, Integer value2) {
            addCriterion("design_id not between", value1, value2, "designId");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherIsNull() {
            addCriterion("design_of_teacher is null");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherIsNotNull() {
            addCriterion("design_of_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherEqualTo(Integer value) {
            addCriterion("design_of_teacher =", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherNotEqualTo(Integer value) {
            addCriterion("design_of_teacher <>", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherGreaterThan(Integer value) {
            addCriterion("design_of_teacher >", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("design_of_teacher >=", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherLessThan(Integer value) {
            addCriterion("design_of_teacher <", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherLessThanOrEqualTo(Integer value) {
            addCriterion("design_of_teacher <=", value, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherIn(List<Integer> values) {
            addCriterion("design_of_teacher in", values, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherNotIn(List<Integer> values) {
            addCriterion("design_of_teacher not in", values, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherBetween(Integer value1, Integer value2) {
            addCriterion("design_of_teacher between", value1, value2, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignOfTeacherNotBetween(Integer value1, Integer value2) {
            addCriterion("design_of_teacher not between", value1, value2, "designOfTeacher");
            return (Criteria) this;
        }

        public Criteria andDesignTitleIsNull() {
            addCriterion("design_title is null");
            return (Criteria) this;
        }

        public Criteria andDesignTitleIsNotNull() {
            addCriterion("design_title is not null");
            return (Criteria) this;
        }

        public Criteria andDesignTitleEqualTo(String value) {
            addCriterion("design_title =", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleNotEqualTo(String value) {
            addCriterion("design_title <>", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleGreaterThan(String value) {
            addCriterion("design_title >", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleGreaterThanOrEqualTo(String value) {
            addCriterion("design_title >=", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleLessThan(String value) {
            addCriterion("design_title <", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleLessThanOrEqualTo(String value) {
            addCriterion("design_title <=", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleLike(String value) {
            addCriterion("design_title like", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleNotLike(String value) {
            addCriterion("design_title not like", value, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleIn(List<String> values) {
            addCriterion("design_title in", values, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleNotIn(List<String> values) {
            addCriterion("design_title not in", values, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleBetween(String value1, String value2) {
            addCriterion("design_title between", value1, value2, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignTitleNotBetween(String value1, String value2) {
            addCriterion("design_title not between", value1, value2, "designTitle");
            return (Criteria) this;
        }

        public Criteria andDesignNumIsNull() {
            addCriterion("design_num is null");
            return (Criteria) this;
        }

        public Criteria andDesignNumIsNotNull() {
            addCriterion("design_num is not null");
            return (Criteria) this;
        }

        public Criteria andDesignNumEqualTo(Integer value) {
            addCriterion("design_num =", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumNotEqualTo(Integer value) {
            addCriterion("design_num <>", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumGreaterThan(Integer value) {
            addCriterion("design_num >", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("design_num >=", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumLessThan(Integer value) {
            addCriterion("design_num <", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumLessThanOrEqualTo(Integer value) {
            addCriterion("design_num <=", value, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumIn(List<Integer> values) {
            addCriterion("design_num in", values, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumNotIn(List<Integer> values) {
            addCriterion("design_num not in", values, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumBetween(Integer value1, Integer value2) {
            addCriterion("design_num between", value1, value2, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignNumNotBetween(Integer value1, Integer value2) {
            addCriterion("design_num not between", value1, value2, "designNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumIsNull() {
            addCriterion("design_fill_num is null");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumIsNotNull() {
            addCriterion("design_fill_num is not null");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumEqualTo(Integer value) {
            addCriterion("design_fill_num =", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumNotEqualTo(Integer value) {
            addCriterion("design_fill_num <>", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumGreaterThan(Integer value) {
            addCriterion("design_fill_num >", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("design_fill_num >=", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumLessThan(Integer value) {
            addCriterion("design_fill_num <", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumLessThanOrEqualTo(Integer value) {
            addCriterion("design_fill_num <=", value, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumIn(List<Integer> values) {
            addCriterion("design_fill_num in", values, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumNotIn(List<Integer> values) {
            addCriterion("design_fill_num not in", values, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumBetween(Integer value1, Integer value2) {
            addCriterion("design_fill_num between", value1, value2, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignFillNumNotBetween(Integer value1, Integer value2) {
            addCriterion("design_fill_num not between", value1, value2, "designFillNum");
            return (Criteria) this;
        }

        public Criteria andDesignRequireIsNull() {
            addCriterion("design_require is null");
            return (Criteria) this;
        }

        public Criteria andDesignRequireIsNotNull() {
            addCriterion("design_require is not null");
            return (Criteria) this;
        }

        public Criteria andDesignRequireEqualTo(String value) {
            addCriterion("design_require =", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireNotEqualTo(String value) {
            addCriterion("design_require <>", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireGreaterThan(String value) {
            addCriterion("design_require >", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireGreaterThanOrEqualTo(String value) {
            addCriterion("design_require >=", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireLessThan(String value) {
            addCriterion("design_require <", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireLessThanOrEqualTo(String value) {
            addCriterion("design_require <=", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireLike(String value) {
            addCriterion("design_require like", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireNotLike(String value) {
            addCriterion("design_require not like", value, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireIn(List<String> values) {
            addCriterion("design_require in", values, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireNotIn(List<String> values) {
            addCriterion("design_require not in", values, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireBetween(String value1, String value2) {
            addCriterion("design_require between", value1, value2, "designRequire");
            return (Criteria) this;
        }

        public Criteria andDesignRequireNotBetween(String value1, String value2) {
            addCriterion("design_require not between", value1, value2, "designRequire");
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