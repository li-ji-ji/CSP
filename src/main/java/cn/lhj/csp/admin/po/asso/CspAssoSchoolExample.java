package cn.lhj.csp.admin.po.asso;

import java.util.ArrayList;
import java.util.List;

public class CspAssoSchoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoSchoolExample() {
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

        public Criteria andSchoolNoIsNull() {
            addCriterion("school_no is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNoIsNotNull() {
            addCriterion("school_no is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNoEqualTo(String value) {
            addCriterion("school_no =", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoNotEqualTo(String value) {
            addCriterion("school_no <>", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoGreaterThan(String value) {
            addCriterion("school_no >", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoGreaterThanOrEqualTo(String value) {
            addCriterion("school_no >=", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoLessThan(String value) {
            addCriterion("school_no <", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoLessThanOrEqualTo(String value) {
            addCriterion("school_no <=", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoLike(String value) {
            addCriterion("school_no like", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoNotLike(String value) {
            addCriterion("school_no not like", value, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoIn(List<String> values) {
            addCriterion("school_no in", values, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoNotIn(List<String> values) {
            addCriterion("school_no not in", values, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoBetween(String value1, String value2) {
            addCriterion("school_no between", value1, value2, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNoNotBetween(String value1, String value2) {
            addCriterion("school_no not between", value1, value2, "schoolNo");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressIsNull() {
            addCriterion("school_address is null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressIsNotNull() {
            addCriterion("school_address is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressEqualTo(String value) {
            addCriterion("school_address =", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressNotEqualTo(String value) {
            addCriterion("school_address <>", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressGreaterThan(String value) {
            addCriterion("school_address >", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressGreaterThanOrEqualTo(String value) {
            addCriterion("school_address >=", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressLessThan(String value) {
            addCriterion("school_address <", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressLessThanOrEqualTo(String value) {
            addCriterion("school_address <=", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressLike(String value) {
            addCriterion("school_address like", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressNotLike(String value) {
            addCriterion("school_address not like", value, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressIn(List<String> values) {
            addCriterion("school_address in", values, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressNotIn(List<String> values) {
            addCriterion("school_address not in", values, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressBetween(String value1, String value2) {
            addCriterion("school_address between", value1, value2, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressNotBetween(String value1, String value2) {
            addCriterion("school_address not between", value1, value2, "schoolAddress");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIsNull() {
            addCriterion("school_address_province is null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIsNotNull() {
            addCriterion("school_address_province is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceEqualTo(String value) {
            addCriterion("school_address_province =", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceNotEqualTo(String value) {
            addCriterion("school_address_province <>", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceGreaterThan(String value) {
            addCriterion("school_address_province >", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("school_address_province >=", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceLessThan(String value) {
            addCriterion("school_address_province <", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("school_address_province <=", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceLike(String value) {
            addCriterion("school_address_province like", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceNotLike(String value) {
            addCriterion("school_address_province not like", value, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIn(List<String> values) {
            addCriterion("school_address_province in", values, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceNotIn(List<String> values) {
            addCriterion("school_address_province not in", values, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceBetween(String value1, String value2) {
            addCriterion("school_address_province between", value1, value2, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("school_address_province not between", value1, value2, "schoolAddressProvince");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdIsNull() {
            addCriterion("school_address_province_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdIsNotNull() {
            addCriterion("school_address_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdEqualTo(Integer value) {
            addCriterion("school_address_province_id =", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdNotEqualTo(Integer value) {
            addCriterion("school_address_province_id <>", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdGreaterThan(Integer value) {
            addCriterion("school_address_province_id >", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_address_province_id >=", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdLessThan(Integer value) {
            addCriterion("school_address_province_id <", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_address_province_id <=", value, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdIn(List<Integer> values) {
            addCriterion("school_address_province_id in", values, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdNotIn(List<Integer> values) {
            addCriterion("school_address_province_id not in", values, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("school_address_province_id between", value1, value2, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_address_province_id not between", value1, value2, "schoolAddressProvinceId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIsNull() {
            addCriterion("school_address_city is null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIsNotNull() {
            addCriterion("school_address_city is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityEqualTo(String value) {
            addCriterion("school_address_city =", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityNotEqualTo(String value) {
            addCriterion("school_address_city <>", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityGreaterThan(String value) {
            addCriterion("school_address_city >", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("school_address_city >=", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityLessThan(String value) {
            addCriterion("school_address_city <", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityLessThanOrEqualTo(String value) {
            addCriterion("school_address_city <=", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityLike(String value) {
            addCriterion("school_address_city like", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityNotLike(String value) {
            addCriterion("school_address_city not like", value, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIn(List<String> values) {
            addCriterion("school_address_city in", values, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityNotIn(List<String> values) {
            addCriterion("school_address_city not in", values, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityBetween(String value1, String value2) {
            addCriterion("school_address_city between", value1, value2, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityNotBetween(String value1, String value2) {
            addCriterion("school_address_city not between", value1, value2, "schoolAddressCity");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdIsNull() {
            addCriterion("school_address_city_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdIsNotNull() {
            addCriterion("school_address_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdEqualTo(Integer value) {
            addCriterion("school_address_city_id =", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdNotEqualTo(Integer value) {
            addCriterion("school_address_city_id <>", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdGreaterThan(Integer value) {
            addCriterion("school_address_city_id >", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_address_city_id >=", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdLessThan(Integer value) {
            addCriterion("school_address_city_id <", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_address_city_id <=", value, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdIn(List<Integer> values) {
            addCriterion("school_address_city_id in", values, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdNotIn(List<Integer> values) {
            addCriterion("school_address_city_id not in", values, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdBetween(Integer value1, Integer value2) {
            addCriterion("school_address_city_id between", value1, value2, "schoolAddressCityId");
            return (Criteria) this;
        }

        public Criteria andSchoolAddressCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_address_city_id not between", value1, value2, "schoolAddressCityId");
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