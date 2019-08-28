package cn.lhj.csp.assomanagement.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CspAssoActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoActivityExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(Integer value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(Integer value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(Integer value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(Integer value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<Integer> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<Integer> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(Integer value1, Integer value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdIsNull() {
            addCriterion("activity_asso_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdIsNotNull() {
            addCriterion("activity_asso_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdEqualTo(String value) {
            addCriterion("activity_asso_id =", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdNotEqualTo(String value) {
            addCriterion("activity_asso_id <>", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdGreaterThan(String value) {
            addCriterion("activity_asso_id >", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_asso_id >=", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdLessThan(String value) {
            addCriterion("activity_asso_id <", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdLessThanOrEqualTo(String value) {
            addCriterion("activity_asso_id <=", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdLike(String value) {
            addCriterion("activity_asso_id like", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdNotLike(String value) {
            addCriterion("activity_asso_id not like", value, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdIn(List<String> values) {
            addCriterion("activity_asso_id in", values, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdNotIn(List<String> values) {
            addCriterion("activity_asso_id not in", values, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdBetween(String value1, String value2) {
            addCriterion("activity_asso_id between", value1, value2, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityAssoIdNotBetween(String value1, String value2) {
            addCriterion("activity_asso_id not between", value1, value2, "activityAssoId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdIsNull() {
            addCriterion("activity_kind_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdIsNotNull() {
            addCriterion("activity_kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdEqualTo(Integer value) {
            addCriterion("activity_kind_id =", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdNotEqualTo(Integer value) {
            addCriterion("activity_kind_id <>", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdGreaterThan(Integer value) {
            addCriterion("activity_kind_id >", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_kind_id >=", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdLessThan(Integer value) {
            addCriterion("activity_kind_id <", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_kind_id <=", value, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdIn(List<Integer> values) {
            addCriterion("activity_kind_id in", values, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdNotIn(List<Integer> values) {
            addCriterion("activity_kind_id not in", values, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_kind_id between", value1, value2, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_kind_id not between", value1, value2, "activityKindId");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameIsNull() {
            addCriterion("activity_kind_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameIsNotNull() {
            addCriterion("activity_kind_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameEqualTo(String value) {
            addCriterion("activity_kind_name =", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameNotEqualTo(String value) {
            addCriterion("activity_kind_name <>", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameGreaterThan(String value) {
            addCriterion("activity_kind_name >", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_kind_name >=", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameLessThan(String value) {
            addCriterion("activity_kind_name <", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameLessThanOrEqualTo(String value) {
            addCriterion("activity_kind_name <=", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameLike(String value) {
            addCriterion("activity_kind_name like", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameNotLike(String value) {
            addCriterion("activity_kind_name not like", value, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameIn(List<String> values) {
            addCriterion("activity_kind_name in", values, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameNotIn(List<String> values) {
            addCriterion("activity_kind_name not in", values, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameBetween(String value1, String value2) {
            addCriterion("activity_kind_name between", value1, value2, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityKindNameNotBetween(String value1, String value2) {
            addCriterion("activity_kind_name not between", value1, value2, "activityKindName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameIsNull() {
            addCriterion("activity_asso_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameIsNotNull() {
            addCriterion("activity_asso_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameEqualTo(String value) {
            addCriterion("activity_asso_name =", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameNotEqualTo(String value) {
            addCriterion("activity_asso_name <>", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameGreaterThan(String value) {
            addCriterion("activity_asso_name >", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_asso_name >=", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameLessThan(String value) {
            addCriterion("activity_asso_name <", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameLessThanOrEqualTo(String value) {
            addCriterion("activity_asso_name <=", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameLike(String value) {
            addCriterion("activity_asso_name like", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameNotLike(String value) {
            addCriterion("activity_asso_name not like", value, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameIn(List<String> values) {
            addCriterion("activity_asso_name in", values, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameNotIn(List<String> values) {
            addCriterion("activity_asso_name not in", values, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameBetween(String value1, String value2) {
            addCriterion("activity_asso_name between", value1, value2, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityAssoNameNotBetween(String value1, String value2) {
            addCriterion("activity_asso_name not between", value1, value2, "activityAssoName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdIsNull() {
            addCriterion("activity_organizer_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdIsNotNull() {
            addCriterion("activity_organizer_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdEqualTo(String value) {
            addCriterion("activity_organizer_id =", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdNotEqualTo(String value) {
            addCriterion("activity_organizer_id <>", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdGreaterThan(String value) {
            addCriterion("activity_organizer_id >", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_organizer_id >=", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdLessThan(String value) {
            addCriterion("activity_organizer_id <", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdLessThanOrEqualTo(String value) {
            addCriterion("activity_organizer_id <=", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdLike(String value) {
            addCriterion("activity_organizer_id like", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdNotLike(String value) {
            addCriterion("activity_organizer_id not like", value, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdIn(List<String> values) {
            addCriterion("activity_organizer_id in", values, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdNotIn(List<String> values) {
            addCriterion("activity_organizer_id not in", values, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdBetween(String value1, String value2) {
            addCriterion("activity_organizer_id between", value1, value2, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerIdNotBetween(String value1, String value2) {
            addCriterion("activity_organizer_id not between", value1, value2, "activityOrganizerId");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameIsNull() {
            addCriterion("activity_organizer_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameIsNotNull() {
            addCriterion("activity_organizer_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameEqualTo(String value) {
            addCriterion("activity_organizer_name =", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameNotEqualTo(String value) {
            addCriterion("activity_organizer_name <>", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameGreaterThan(String value) {
            addCriterion("activity_organizer_name >", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_organizer_name >=", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameLessThan(String value) {
            addCriterion("activity_organizer_name <", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameLessThanOrEqualTo(String value) {
            addCriterion("activity_organizer_name <=", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameLike(String value) {
            addCriterion("activity_organizer_name like", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameNotLike(String value) {
            addCriterion("activity_organizer_name not like", value, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameIn(List<String> values) {
            addCriterion("activity_organizer_name in", values, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameNotIn(List<String> values) {
            addCriterion("activity_organizer_name not in", values, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameBetween(String value1, String value2) {
            addCriterion("activity_organizer_name between", value1, value2, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityOrganizerNameNotBetween(String value1, String value2) {
            addCriterion("activity_organizer_name not between", value1, value2, "activityOrganizerName");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusIsNull() {
            addCriterion("activity_part_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusIsNotNull() {
            addCriterion("activity_part_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusEqualTo(Integer value) {
            addCriterion("activity_part_status =", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusNotEqualTo(Integer value) {
            addCriterion("activity_part_status <>", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusGreaterThan(Integer value) {
            addCriterion("activity_part_status >", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_part_status >=", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusLessThan(Integer value) {
            addCriterion("activity_part_status <", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("activity_part_status <=", value, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusIn(List<Integer> values) {
            addCriterion("activity_part_status in", values, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusNotIn(List<Integer> values) {
            addCriterion("activity_part_status not in", values, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusBetween(Integer value1, Integer value2) {
            addCriterion("activity_part_status between", value1, value2, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityPartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_part_status not between", value1, value2, "activityPartStatus");
            return (Criteria) this;
        }

        public Criteria andActivityNumIsNull() {
            addCriterion("activity_num is null");
            return (Criteria) this;
        }

        public Criteria andActivityNumIsNotNull() {
            addCriterion("activity_num is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNumEqualTo(Integer value) {
            addCriterion("activity_num =", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotEqualTo(Integer value) {
            addCriterion("activity_num <>", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThan(Integer value) {
            addCriterion("activity_num >", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_num >=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThan(Integer value) {
            addCriterion("activity_num <", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThanOrEqualTo(Integer value) {
            addCriterion("activity_num <=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumIn(List<Integer> values) {
            addCriterion("activity_num in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotIn(List<Integer> values) {
            addCriterion("activity_num not in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumBetween(Integer value1, Integer value2) {
            addCriterion("activity_num between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_num not between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumIsNull() {
            addCriterion("activity_part_num is null");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumIsNotNull() {
            addCriterion("activity_part_num is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumEqualTo(Integer value) {
            addCriterion("activity_part_num =", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumNotEqualTo(Integer value) {
            addCriterion("activity_part_num <>", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumGreaterThan(Integer value) {
            addCriterion("activity_part_num >", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_part_num >=", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumLessThan(Integer value) {
            addCriterion("activity_part_num <", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumLessThanOrEqualTo(Integer value) {
            addCriterion("activity_part_num <=", value, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumIn(List<Integer> values) {
            addCriterion("activity_part_num in", values, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumNotIn(List<Integer> values) {
            addCriterion("activity_part_num not in", values, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumBetween(Integer value1, Integer value2) {
            addCriterion("activity_part_num between", value1, value2, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityPartNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_part_num not between", value1, value2, "activityPartNum");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIsNull() {
            addCriterion("activity_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIsNotNull() {
            addCriterion("activity_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeEqualTo(Date value) {
            addCriterion("activity_start_time =", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotEqualTo(Date value) {
            addCriterion("activity_start_time <>", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeGreaterThan(Date value) {
            addCriterion("activity_start_time >", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_start_time >=", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeLessThan(Date value) {
            addCriterion("activity_start_time <", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_start_time <=", value, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeIn(List<Date> values) {
            addCriterion("activity_start_time in", values, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotIn(List<Date> values) {
            addCriterion("activity_start_time not in", values, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeBetween(Date value1, Date value2) {
            addCriterion("activity_start_time between", value1, value2, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_start_time not between", value1, value2, "activityStartTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeIsNull() {
            addCriterion("activity_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeIsNotNull() {
            addCriterion("activity_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeEqualTo(Date value) {
            addCriterion("activity_finish_time =", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeNotEqualTo(Date value) {
            addCriterion("activity_finish_time <>", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeGreaterThan(Date value) {
            addCriterion("activity_finish_time >", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_finish_time >=", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeLessThan(Date value) {
            addCriterion("activity_finish_time <", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_finish_time <=", value, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeIn(List<Date> values) {
            addCriterion("activity_finish_time in", values, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeNotIn(List<Date> values) {
            addCriterion("activity_finish_time not in", values, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeBetween(Date value1, Date value2) {
            addCriterion("activity_finish_time between", value1, value2, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_finish_time not between", value1, value2, "activityFinishTime");
            return (Criteria) this;
        }

        public Criteria andActivityIntroIsNull() {
            addCriterion("activity_intro is null");
            return (Criteria) this;
        }

        public Criteria andActivityIntroIsNotNull() {
            addCriterion("activity_intro is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIntroEqualTo(String value) {
            addCriterion("activity_intro =", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroNotEqualTo(String value) {
            addCriterion("activity_intro <>", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroGreaterThan(String value) {
            addCriterion("activity_intro >", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroGreaterThanOrEqualTo(String value) {
            addCriterion("activity_intro >=", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroLessThan(String value) {
            addCriterion("activity_intro <", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroLessThanOrEqualTo(String value) {
            addCriterion("activity_intro <=", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroLike(String value) {
            addCriterion("activity_intro like", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroNotLike(String value) {
            addCriterion("activity_intro not like", value, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroIn(List<String> values) {
            addCriterion("activity_intro in", values, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroNotIn(List<String> values) {
            addCriterion("activity_intro not in", values, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroBetween(String value1, String value2) {
            addCriterion("activity_intro between", value1, value2, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityIntroNotBetween(String value1, String value2) {
            addCriterion("activity_intro not between", value1, value2, "activityIntro");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNull() {
            addCriterion("activity_content is null");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNotNull() {
            addCriterion("activity_content is not null");
            return (Criteria) this;
        }

        public Criteria andActivityContentEqualTo(String value) {
            addCriterion("activity_content =", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotEqualTo(String value) {
            addCriterion("activity_content <>", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThan(String value) {
            addCriterion("activity_content >", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThanOrEqualTo(String value) {
            addCriterion("activity_content >=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThan(String value) {
            addCriterion("activity_content <", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThanOrEqualTo(String value) {
            addCriterion("activity_content <=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLike(String value) {
            addCriterion("activity_content like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotLike(String value) {
            addCriterion("activity_content not like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentIn(List<String> values) {
            addCriterion("activity_content in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotIn(List<String> values) {
            addCriterion("activity_content not in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentBetween(String value1, String value2) {
            addCriterion("activity_content between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotBetween(String value1, String value2) {
            addCriterion("activity_content not between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityImgIsNull() {
            addCriterion("activity_img is null");
            return (Criteria) this;
        }

        public Criteria andActivityImgIsNotNull() {
            addCriterion("activity_img is not null");
            return (Criteria) this;
        }

        public Criteria andActivityImgEqualTo(String value) {
            addCriterion("activity_img =", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgNotEqualTo(String value) {
            addCriterion("activity_img <>", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgGreaterThan(String value) {
            addCriterion("activity_img >", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgGreaterThanOrEqualTo(String value) {
            addCriterion("activity_img >=", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgLessThan(String value) {
            addCriterion("activity_img <", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgLessThanOrEqualTo(String value) {
            addCriterion("activity_img <=", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgLike(String value) {
            addCriterion("activity_img like", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgNotLike(String value) {
            addCriterion("activity_img not like", value, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgIn(List<String> values) {
            addCriterion("activity_img in", values, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgNotIn(List<String> values) {
            addCriterion("activity_img not in", values, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgBetween(String value1, String value2) {
            addCriterion("activity_img between", value1, value2, "activityImg");
            return (Criteria) this;
        }

        public Criteria andActivityImgNotBetween(String value1, String value2) {
            addCriterion("activity_img not between", value1, value2, "activityImg");
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