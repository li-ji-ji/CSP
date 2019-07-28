package cn.lhj.csp.admin.po.asso;

import java.util.ArrayList;
import java.util.List;

public class CspAssoSchoolUnitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoSchoolUnitExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUnitNoIsNull() {
            addCriterion("unit_no is null");
            return (Criteria) this;
        }

        public Criteria andUnitNoIsNotNull() {
            addCriterion("unit_no is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNoEqualTo(String value) {
            addCriterion("unit_no =", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotEqualTo(String value) {
            addCriterion("unit_no <>", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoGreaterThan(String value) {
            addCriterion("unit_no >", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoGreaterThanOrEqualTo(String value) {
            addCriterion("unit_no >=", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLessThan(String value) {
            addCriterion("unit_no <", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLessThanOrEqualTo(String value) {
            addCriterion("unit_no <=", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLike(String value) {
            addCriterion("unit_no like", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotLike(String value) {
            addCriterion("unit_no not like", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoIn(List<String> values) {
            addCriterion("unit_no in", values, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotIn(List<String> values) {
            addCriterion("unit_no not in", values, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoBetween(String value1, String value2) {
            addCriterion("unit_no between", value1, value2, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotBetween(String value1, String value2) {
            addCriterion("unit_no not between", value1, value2, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andPUnitNoIsNull() {
            addCriterion("p_unit_no is null");
            return (Criteria) this;
        }

        public Criteria andPUnitNoIsNotNull() {
            addCriterion("p_unit_no is not null");
            return (Criteria) this;
        }

        public Criteria andPUnitNoEqualTo(String value) {
            addCriterion("p_unit_no =", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoNotEqualTo(String value) {
            addCriterion("p_unit_no <>", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoGreaterThan(String value) {
            addCriterion("p_unit_no >", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoGreaterThanOrEqualTo(String value) {
            addCriterion("p_unit_no >=", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoLessThan(String value) {
            addCriterion("p_unit_no <", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoLessThanOrEqualTo(String value) {
            addCriterion("p_unit_no <=", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoLike(String value) {
            addCriterion("p_unit_no like", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoNotLike(String value) {
            addCriterion("p_unit_no not like", value, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoIn(List<String> values) {
            addCriterion("p_unit_no in", values, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoNotIn(List<String> values) {
            addCriterion("p_unit_no not in", values, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoBetween(String value1, String value2) {
            addCriterion("p_unit_no between", value1, value2, "pUnitNo");
            return (Criteria) this;
        }

        public Criteria andPUnitNoNotBetween(String value1, String value2) {
            addCriterion("p_unit_no not between", value1, value2, "pUnitNo");
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