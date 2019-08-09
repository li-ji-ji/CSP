package cn.lhj.csp.assomanagement.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CspAssoManagementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoManagementExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAssoIdIsNull() {
            addCriterion("asso_id is null");
            return (Criteria) this;
        }

        public Criteria andAssoIdIsNotNull() {
            addCriterion("asso_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssoIdEqualTo(String value) {
            addCriterion("asso_id =", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotEqualTo(String value) {
            addCriterion("asso_id <>", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThan(String value) {
            addCriterion("asso_id >", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThanOrEqualTo(String value) {
            addCriterion("asso_id >=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThan(String value) {
            addCriterion("asso_id <", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThanOrEqualTo(String value) {
            addCriterion("asso_id <=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLike(String value) {
            addCriterion("asso_id like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotLike(String value) {
            addCriterion("asso_id not like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdIn(List<String> values) {
            addCriterion("asso_id in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotIn(List<String> values) {
            addCriterion("asso_id not in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdBetween(String value1, String value2) {
            addCriterion("asso_id between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotBetween(String value1, String value2) {
            addCriterion("asso_id not between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoNameIsNull() {
            addCriterion("asso_name is null");
            return (Criteria) this;
        }

        public Criteria andAssoNameIsNotNull() {
            addCriterion("asso_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssoNameEqualTo(String value) {
            addCriterion("asso_name =", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotEqualTo(String value) {
            addCriterion("asso_name <>", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameGreaterThan(String value) {
            addCriterion("asso_name >", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameGreaterThanOrEqualTo(String value) {
            addCriterion("asso_name >=", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLessThan(String value) {
            addCriterion("asso_name <", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLessThanOrEqualTo(String value) {
            addCriterion("asso_name <=", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLike(String value) {
            addCriterion("asso_name like", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotLike(String value) {
            addCriterion("asso_name not like", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameIn(List<String> values) {
            addCriterion("asso_name in", values, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotIn(List<String> values) {
            addCriterion("asso_name not in", values, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameBetween(String value1, String value2) {
            addCriterion("asso_name between", value1, value2, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotBetween(String value1, String value2) {
            addCriterion("asso_name not between", value1, value2, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoStatusIsNull() {
            addCriterion("asso_status is null");
            return (Criteria) this;
        }

        public Criteria andAssoStatusIsNotNull() {
            addCriterion("asso_status is not null");
            return (Criteria) this;
        }

        public Criteria andAssoStatusEqualTo(Integer value) {
            addCriterion("asso_status =", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusNotEqualTo(Integer value) {
            addCriterion("asso_status <>", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusGreaterThan(Integer value) {
            addCriterion("asso_status >", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("asso_status >=", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusLessThan(Integer value) {
            addCriterion("asso_status <", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("asso_status <=", value, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusIn(List<Integer> values) {
            addCriterion("asso_status in", values, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusNotIn(List<Integer> values) {
            addCriterion("asso_status not in", values, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusBetween(Integer value1, Integer value2) {
            addCriterion("asso_status between", value1, value2, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("asso_status not between", value1, value2, "assoStatus");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoIsNull() {
            addCriterion("asso_affiliate_no is null");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoIsNotNull() {
            addCriterion("asso_affiliate_no is not null");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoEqualTo(String value) {
            addCriterion("asso_affiliate_no =", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoNotEqualTo(String value) {
            addCriterion("asso_affiliate_no <>", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoGreaterThan(String value) {
            addCriterion("asso_affiliate_no >", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoGreaterThanOrEqualTo(String value) {
            addCriterion("asso_affiliate_no >=", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoLessThan(String value) {
            addCriterion("asso_affiliate_no <", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoLessThanOrEqualTo(String value) {
            addCriterion("asso_affiliate_no <=", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoLike(String value) {
            addCriterion("asso_affiliate_no like", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoNotLike(String value) {
            addCriterion("asso_affiliate_no not like", value, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoIn(List<String> values) {
            addCriterion("asso_affiliate_no in", values, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoNotIn(List<String> values) {
            addCriterion("asso_affiliate_no not in", values, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoBetween(String value1, String value2) {
            addCriterion("asso_affiliate_no between", value1, value2, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNoNotBetween(String value1, String value2) {
            addCriterion("asso_affiliate_no not between", value1, value2, "assoAffiliateNo");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameIsNull() {
            addCriterion("asso_affiliate_name is null");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameIsNotNull() {
            addCriterion("asso_affiliate_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameEqualTo(String value) {
            addCriterion("asso_affiliate_name =", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameNotEqualTo(String value) {
            addCriterion("asso_affiliate_name <>", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameGreaterThan(String value) {
            addCriterion("asso_affiliate_name >", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameGreaterThanOrEqualTo(String value) {
            addCriterion("asso_affiliate_name >=", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameLessThan(String value) {
            addCriterion("asso_affiliate_name <", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameLessThanOrEqualTo(String value) {
            addCriterion("asso_affiliate_name <=", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameLike(String value) {
            addCriterion("asso_affiliate_name like", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameNotLike(String value) {
            addCriterion("asso_affiliate_name not like", value, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameIn(List<String> values) {
            addCriterion("asso_affiliate_name in", values, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameNotIn(List<String> values) {
            addCriterion("asso_affiliate_name not in", values, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameBetween(String value1, String value2) {
            addCriterion("asso_affiliate_name between", value1, value2, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoAffiliateNameNotBetween(String value1, String value2) {
            addCriterion("asso_affiliate_name not between", value1, value2, "assoAffiliateName");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedIsNull() {
            addCriterion("asso_examined is null");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedIsNotNull() {
            addCriterion("asso_examined is not null");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedEqualTo(Integer value) {
            addCriterion("asso_examined =", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedNotEqualTo(Integer value) {
            addCriterion("asso_examined <>", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedGreaterThan(Integer value) {
            addCriterion("asso_examined >", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedGreaterThanOrEqualTo(Integer value) {
            addCriterion("asso_examined >=", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedLessThan(Integer value) {
            addCriterion("asso_examined <", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedLessThanOrEqualTo(Integer value) {
            addCriterion("asso_examined <=", value, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedIn(List<Integer> values) {
            addCriterion("asso_examined in", values, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedNotIn(List<Integer> values) {
            addCriterion("asso_examined not in", values, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedBetween(Integer value1, Integer value2) {
            addCriterion("asso_examined between", value1, value2, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoExaminedNotBetween(Integer value1, Integer value2) {
            addCriterion("asso_examined not between", value1, value2, "assoExamined");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdIsNull() {
            addCriterion("asso_guider_id is null");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdIsNotNull() {
            addCriterion("asso_guider_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdEqualTo(Integer value) {
            addCriterion("asso_guider_id =", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdNotEqualTo(Integer value) {
            addCriterion("asso_guider_id <>", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdGreaterThan(Integer value) {
            addCriterion("asso_guider_id >", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("asso_guider_id >=", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdLessThan(Integer value) {
            addCriterion("asso_guider_id <", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdLessThanOrEqualTo(Integer value) {
            addCriterion("asso_guider_id <=", value, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdIn(List<Integer> values) {
            addCriterion("asso_guider_id in", values, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdNotIn(List<Integer> values) {
            addCriterion("asso_guider_id not in", values, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdBetween(Integer value1, Integer value2) {
            addCriterion("asso_guider_id between", value1, value2, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("asso_guider_id not between", value1, value2, "assoGuiderId");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameIsNull() {
            addCriterion("asso_guider_name is null");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameIsNotNull() {
            addCriterion("asso_guider_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameEqualTo(String value) {
            addCriterion("asso_guider_name =", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameNotEqualTo(String value) {
            addCriterion("asso_guider_name <>", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameGreaterThan(String value) {
            addCriterion("asso_guider_name >", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameGreaterThanOrEqualTo(String value) {
            addCriterion("asso_guider_name >=", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameLessThan(String value) {
            addCriterion("asso_guider_name <", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameLessThanOrEqualTo(String value) {
            addCriterion("asso_guider_name <=", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameLike(String value) {
            addCriterion("asso_guider_name like", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameNotLike(String value) {
            addCriterion("asso_guider_name not like", value, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameIn(List<String> values) {
            addCriterion("asso_guider_name in", values, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameNotIn(List<String> values) {
            addCriterion("asso_guider_name not in", values, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameBetween(String value1, String value2) {
            addCriterion("asso_guider_name between", value1, value2, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoGuiderNameNotBetween(String value1, String value2) {
            addCriterion("asso_guider_name not between", value1, value2, "assoGuiderName");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderIsNull() {
            addCriterion("asso_leader is null");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderIsNotNull() {
            addCriterion("asso_leader is not null");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderEqualTo(String value) {
            addCriterion("asso_leader =", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderNotEqualTo(String value) {
            addCriterion("asso_leader <>", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderGreaterThan(String value) {
            addCriterion("asso_leader >", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("asso_leader >=", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderLessThan(String value) {
            addCriterion("asso_leader <", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderLessThanOrEqualTo(String value) {
            addCriterion("asso_leader <=", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderLike(String value) {
            addCriterion("asso_leader like", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderNotLike(String value) {
            addCriterion("asso_leader not like", value, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderIn(List<String> values) {
            addCriterion("asso_leader in", values, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderNotIn(List<String> values) {
            addCriterion("asso_leader not in", values, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderBetween(String value1, String value2) {
            addCriterion("asso_leader between", value1, value2, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoLeaderNotBetween(String value1, String value2) {
            addCriterion("asso_leader not between", value1, value2, "assoLeader");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeIsNull() {
            addCriterion("asso_establishment_time is null");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeIsNotNull() {
            addCriterion("asso_establishment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeEqualTo(Date value) {
            addCriterionForJDBCDate("asso_establishment_time =", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("asso_establishment_time <>", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("asso_establishment_time >", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("asso_establishment_time >=", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeLessThan(Date value) {
            addCriterionForJDBCDate("asso_establishment_time <", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("asso_establishment_time <=", value, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeIn(List<Date> values) {
            addCriterionForJDBCDate("asso_establishment_time in", values, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("asso_establishment_time not in", values, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("asso_establishment_time between", value1, value2, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoEstablishmentTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("asso_establishment_time not between", value1, value2, "assoEstablishmentTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeIsNull() {
            addCriterion("asso_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeIsNotNull() {
            addCriterion("asso_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeEqualTo(Date value) {
            addCriterion("asso_modify_time =", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeNotEqualTo(Date value) {
            addCriterion("asso_modify_time <>", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeGreaterThan(Date value) {
            addCriterion("asso_modify_time >", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("asso_modify_time >=", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeLessThan(Date value) {
            addCriterion("asso_modify_time <", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("asso_modify_time <=", value, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeIn(List<Date> values) {
            addCriterion("asso_modify_time in", values, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeNotIn(List<Date> values) {
            addCriterion("asso_modify_time not in", values, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeBetween(Date value1, Date value2) {
            addCriterion("asso_modify_time between", value1, value2, "assoModifyTime");
            return (Criteria) this;
        }

        public Criteria andAssoModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("asso_modify_time not between", value1, value2, "assoModifyTime");
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