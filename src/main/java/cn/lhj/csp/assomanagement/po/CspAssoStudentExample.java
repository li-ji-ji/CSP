package cn.lhj.csp.assomanagement.po;

import java.util.ArrayList;
import java.util.List;

public class CspAssoStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoStudentExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(String value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(String value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(String value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(String value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(String value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(String value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLike(String value) {
            addCriterion("s_id like", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotLike(String value) {
            addCriterion("s_id not like", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<String> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<String> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(String value1, String value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(String value1, String value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSSexIsNull() {
            addCriterion("s_sex is null");
            return (Criteria) this;
        }

        public Criteria andSSexIsNotNull() {
            addCriterion("s_sex is not null");
            return (Criteria) this;
        }

        public Criteria andSSexEqualTo(Integer value) {
            addCriterion("s_sex =", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotEqualTo(Integer value) {
            addCriterion("s_sex <>", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThan(Integer value) {
            addCriterion("s_sex >", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_sex >=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThan(Integer value) {
            addCriterion("s_sex <", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThanOrEqualTo(Integer value) {
            addCriterion("s_sex <=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexIn(List<Integer> values) {
            addCriterion("s_sex in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotIn(List<Integer> values) {
            addCriterion("s_sex not in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexBetween(Integer value1, Integer value2) {
            addCriterion("s_sex between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotBetween(Integer value1, Integer value2) {
            addCriterion("s_sex not between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSPhotoIsNull() {
            addCriterion("s_photo is null");
            return (Criteria) this;
        }

        public Criteria andSPhotoIsNotNull() {
            addCriterion("s_photo is not null");
            return (Criteria) this;
        }

        public Criteria andSPhotoEqualTo(String value) {
            addCriterion("s_photo =", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoNotEqualTo(String value) {
            addCriterion("s_photo <>", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoGreaterThan(String value) {
            addCriterion("s_photo >", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("s_photo >=", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoLessThan(String value) {
            addCriterion("s_photo <", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoLessThanOrEqualTo(String value) {
            addCriterion("s_photo <=", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoLike(String value) {
            addCriterion("s_photo like", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoNotLike(String value) {
            addCriterion("s_photo not like", value, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoIn(List<String> values) {
            addCriterion("s_photo in", values, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoNotIn(List<String> values) {
            addCriterion("s_photo not in", values, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoBetween(String value1, String value2) {
            addCriterion("s_photo between", value1, value2, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSPhotoNotBetween(String value1, String value2) {
            addCriterion("s_photo not between", value1, value2, "sPhoto");
            return (Criteria) this;
        }

        public Criteria andSGradeIsNull() {
            addCriterion("s_grade is null");
            return (Criteria) this;
        }

        public Criteria andSGradeIsNotNull() {
            addCriterion("s_grade is not null");
            return (Criteria) this;
        }

        public Criteria andSGradeEqualTo(Integer value) {
            addCriterion("s_grade =", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotEqualTo(Integer value) {
            addCriterion("s_grade <>", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeGreaterThan(Integer value) {
            addCriterion("s_grade >", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_grade >=", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeLessThan(Integer value) {
            addCriterion("s_grade <", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeLessThanOrEqualTo(Integer value) {
            addCriterion("s_grade <=", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeIn(List<Integer> values) {
            addCriterion("s_grade in", values, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotIn(List<Integer> values) {
            addCriterion("s_grade not in", values, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeBetween(Integer value1, Integer value2) {
            addCriterion("s_grade between", value1, value2, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("s_grade not between", value1, value2, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSMajorIsNull() {
            addCriterion("s_major is null");
            return (Criteria) this;
        }

        public Criteria andSMajorIsNotNull() {
            addCriterion("s_major is not null");
            return (Criteria) this;
        }

        public Criteria andSMajorEqualTo(String value) {
            addCriterion("s_major =", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorNotEqualTo(String value) {
            addCriterion("s_major <>", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorGreaterThan(String value) {
            addCriterion("s_major >", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorGreaterThanOrEqualTo(String value) {
            addCriterion("s_major >=", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorLessThan(String value) {
            addCriterion("s_major <", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorLessThanOrEqualTo(String value) {
            addCriterion("s_major <=", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorLike(String value) {
            addCriterion("s_major like", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorNotLike(String value) {
            addCriterion("s_major not like", value, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorIn(List<String> values) {
            addCriterion("s_major in", values, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorNotIn(List<String> values) {
            addCriterion("s_major not in", values, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorBetween(String value1, String value2) {
            addCriterion("s_major between", value1, value2, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSMajorNotBetween(String value1, String value2) {
            addCriterion("s_major not between", value1, value2, "sMajor");
            return (Criteria) this;
        }

        public Criteria andSTelIsNull() {
            addCriterion("s_tel is null");
            return (Criteria) this;
        }

        public Criteria andSTelIsNotNull() {
            addCriterion("s_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSTelEqualTo(Integer value) {
            addCriterion("s_tel =", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelNotEqualTo(Integer value) {
            addCriterion("s_tel <>", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelGreaterThan(Integer value) {
            addCriterion("s_tel >", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_tel >=", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelLessThan(Integer value) {
            addCriterion("s_tel <", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelLessThanOrEqualTo(Integer value) {
            addCriterion("s_tel <=", value, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelIn(List<Integer> values) {
            addCriterion("s_tel in", values, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelNotIn(List<Integer> values) {
            addCriterion("s_tel not in", values, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelBetween(Integer value1, Integer value2) {
            addCriterion("s_tel between", value1, value2, "sTel");
            return (Criteria) this;
        }

        public Criteria andSTelNotBetween(Integer value1, Integer value2) {
            addCriterion("s_tel not between", value1, value2, "sTel");
            return (Criteria) this;
        }

        public Criteria andSWechatIsNull() {
            addCriterion("s_wechat is null");
            return (Criteria) this;
        }

        public Criteria andSWechatIsNotNull() {
            addCriterion("s_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andSWechatEqualTo(String value) {
            addCriterion("s_wechat =", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatNotEqualTo(String value) {
            addCriterion("s_wechat <>", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatGreaterThan(String value) {
            addCriterion("s_wechat >", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatGreaterThanOrEqualTo(String value) {
            addCriterion("s_wechat >=", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatLessThan(String value) {
            addCriterion("s_wechat <", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatLessThanOrEqualTo(String value) {
            addCriterion("s_wechat <=", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatLike(String value) {
            addCriterion("s_wechat like", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatNotLike(String value) {
            addCriterion("s_wechat not like", value, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatIn(List<String> values) {
            addCriterion("s_wechat in", values, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatNotIn(List<String> values) {
            addCriterion("s_wechat not in", values, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatBetween(String value1, String value2) {
            addCriterion("s_wechat between", value1, value2, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSWechatNotBetween(String value1, String value2) {
            addCriterion("s_wechat not between", value1, value2, "sWechat");
            return (Criteria) this;
        }

        public Criteria andSQqIsNull() {
            addCriterion("s_qq is null");
            return (Criteria) this;
        }

        public Criteria andSQqIsNotNull() {
            addCriterion("s_qq is not null");
            return (Criteria) this;
        }

        public Criteria andSQqEqualTo(Integer value) {
            addCriterion("s_qq =", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqNotEqualTo(Integer value) {
            addCriterion("s_qq <>", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqGreaterThan(Integer value) {
            addCriterion("s_qq >", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_qq >=", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqLessThan(Integer value) {
            addCriterion("s_qq <", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqLessThanOrEqualTo(Integer value) {
            addCriterion("s_qq <=", value, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqIn(List<Integer> values) {
            addCriterion("s_qq in", values, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqNotIn(List<Integer> values) {
            addCriterion("s_qq not in", values, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqBetween(Integer value1, Integer value2) {
            addCriterion("s_qq between", value1, value2, "sQq");
            return (Criteria) this;
        }

        public Criteria andSQqNotBetween(Integer value1, Integer value2) {
            addCriterion("s_qq not between", value1, value2, "sQq");
            return (Criteria) this;
        }

        public Criteria andSMailIsNull() {
            addCriterion("s_mail is null");
            return (Criteria) this;
        }

        public Criteria andSMailIsNotNull() {
            addCriterion("s_mail is not null");
            return (Criteria) this;
        }

        public Criteria andSMailEqualTo(String value) {
            addCriterion("s_mail =", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailNotEqualTo(String value) {
            addCriterion("s_mail <>", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailGreaterThan(String value) {
            addCriterion("s_mail >", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailGreaterThanOrEqualTo(String value) {
            addCriterion("s_mail >=", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailLessThan(String value) {
            addCriterion("s_mail <", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailLessThanOrEqualTo(String value) {
            addCriterion("s_mail <=", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailLike(String value) {
            addCriterion("s_mail like", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailNotLike(String value) {
            addCriterion("s_mail not like", value, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailIn(List<String> values) {
            addCriterion("s_mail in", values, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailNotIn(List<String> values) {
            addCriterion("s_mail not in", values, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailBetween(String value1, String value2) {
            addCriterion("s_mail between", value1, value2, "sMail");
            return (Criteria) this;
        }

        public Criteria andSMailNotBetween(String value1, String value2) {
            addCriterion("s_mail not between", value1, value2, "sMail");
            return (Criteria) this;
        }

        public Criteria andSAssoNumIsNull() {
            addCriterion("s_asso_num is null");
            return (Criteria) this;
        }

        public Criteria andSAssoNumIsNotNull() {
            addCriterion("s_asso_num is not null");
            return (Criteria) this;
        }

        public Criteria andSAssoNumEqualTo(Integer value) {
            addCriterion("s_asso_num =", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumNotEqualTo(Integer value) {
            addCriterion("s_asso_num <>", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumGreaterThan(Integer value) {
            addCriterion("s_asso_num >", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_asso_num >=", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumLessThan(Integer value) {
            addCriterion("s_asso_num <", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumLessThanOrEqualTo(Integer value) {
            addCriterion("s_asso_num <=", value, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumIn(List<Integer> values) {
            addCriterion("s_asso_num in", values, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumNotIn(List<Integer> values) {
            addCriterion("s_asso_num not in", values, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumBetween(Integer value1, Integer value2) {
            addCriterion("s_asso_num between", value1, value2, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSAssoNumNotBetween(Integer value1, Integer value2) {
            addCriterion("s_asso_num not between", value1, value2, "sAssoNum");
            return (Criteria) this;
        }

        public Criteria andSActIdIsNull() {
            addCriterion("s_act_id is null");
            return (Criteria) this;
        }

        public Criteria andSActIdIsNotNull() {
            addCriterion("s_act_id is not null");
            return (Criteria) this;
        }

        public Criteria andSActIdEqualTo(String value) {
            addCriterion("s_act_id =", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdNotEqualTo(String value) {
            addCriterion("s_act_id <>", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdGreaterThan(String value) {
            addCriterion("s_act_id >", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdGreaterThanOrEqualTo(String value) {
            addCriterion("s_act_id >=", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdLessThan(String value) {
            addCriterion("s_act_id <", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdLessThanOrEqualTo(String value) {
            addCriterion("s_act_id <=", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdLike(String value) {
            addCriterion("s_act_id like", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdNotLike(String value) {
            addCriterion("s_act_id not like", value, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdIn(List<String> values) {
            addCriterion("s_act_id in", values, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdNotIn(List<String> values) {
            addCriterion("s_act_id not in", values, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdBetween(String value1, String value2) {
            addCriterion("s_act_id between", value1, value2, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActIdNotBetween(String value1, String value2) {
            addCriterion("s_act_id not between", value1, value2, "sActId");
            return (Criteria) this;
        }

        public Criteria andSActNameIsNull() {
            addCriterion("s_act_name is null");
            return (Criteria) this;
        }

        public Criteria andSActNameIsNotNull() {
            addCriterion("s_act_name is not null");
            return (Criteria) this;
        }

        public Criteria andSActNameEqualTo(String value) {
            addCriterion("s_act_name =", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameNotEqualTo(String value) {
            addCriterion("s_act_name <>", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameGreaterThan(String value) {
            addCriterion("s_act_name >", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_act_name >=", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameLessThan(String value) {
            addCriterion("s_act_name <", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameLessThanOrEqualTo(String value) {
            addCriterion("s_act_name <=", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameLike(String value) {
            addCriterion("s_act_name like", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameNotLike(String value) {
            addCriterion("s_act_name not like", value, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameIn(List<String> values) {
            addCriterion("s_act_name in", values, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameNotIn(List<String> values) {
            addCriterion("s_act_name not in", values, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameBetween(String value1, String value2) {
            addCriterion("s_act_name between", value1, value2, "sActName");
            return (Criteria) this;
        }

        public Criteria andSActNameNotBetween(String value1, String value2) {
            addCriterion("s_act_name not between", value1, value2, "sActName");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstIsNull() {
            addCriterion("s_asso_first is null");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstIsNotNull() {
            addCriterion("s_asso_first is not null");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstEqualTo(String value) {
            addCriterion("s_asso_first =", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstNotEqualTo(String value) {
            addCriterion("s_asso_first <>", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstGreaterThan(String value) {
            addCriterion("s_asso_first >", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstGreaterThanOrEqualTo(String value) {
            addCriterion("s_asso_first >=", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstLessThan(String value) {
            addCriterion("s_asso_first <", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstLessThanOrEqualTo(String value) {
            addCriterion("s_asso_first <=", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstLike(String value) {
            addCriterion("s_asso_first like", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstNotLike(String value) {
            addCriterion("s_asso_first not like", value, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstIn(List<String> values) {
            addCriterion("s_asso_first in", values, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstNotIn(List<String> values) {
            addCriterion("s_asso_first not in", values, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstBetween(String value1, String value2) {
            addCriterion("s_asso_first between", value1, value2, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoFirstNotBetween(String value1, String value2) {
            addCriterion("s_asso_first not between", value1, value2, "sAssoFirst");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondIsNull() {
            addCriterion("s_asso_second is null");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondIsNotNull() {
            addCriterion("s_asso_second is not null");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondEqualTo(String value) {
            addCriterion("s_asso_second =", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondNotEqualTo(String value) {
            addCriterion("s_asso_second <>", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondGreaterThan(String value) {
            addCriterion("s_asso_second >", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondGreaterThanOrEqualTo(String value) {
            addCriterion("s_asso_second >=", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondLessThan(String value) {
            addCriterion("s_asso_second <", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondLessThanOrEqualTo(String value) {
            addCriterion("s_asso_second <=", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondLike(String value) {
            addCriterion("s_asso_second like", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondNotLike(String value) {
            addCriterion("s_asso_second not like", value, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondIn(List<String> values) {
            addCriterion("s_asso_second in", values, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondNotIn(List<String> values) {
            addCriterion("s_asso_second not in", values, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondBetween(String value1, String value2) {
            addCriterion("s_asso_second between", value1, value2, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoSecondNotBetween(String value1, String value2) {
            addCriterion("s_asso_second not between", value1, value2, "sAssoSecond");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdIsNull() {
            addCriterion("s_asso_third is null");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdIsNotNull() {
            addCriterion("s_asso_third is not null");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdEqualTo(String value) {
            addCriterion("s_asso_third =", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdNotEqualTo(String value) {
            addCriterion("s_asso_third <>", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdGreaterThan(String value) {
            addCriterion("s_asso_third >", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdGreaterThanOrEqualTo(String value) {
            addCriterion("s_asso_third >=", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdLessThan(String value) {
            addCriterion("s_asso_third <", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdLessThanOrEqualTo(String value) {
            addCriterion("s_asso_third <=", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdLike(String value) {
            addCriterion("s_asso_third like", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdNotLike(String value) {
            addCriterion("s_asso_third not like", value, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdIn(List<String> values) {
            addCriterion("s_asso_third in", values, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdNotIn(List<String> values) {
            addCriterion("s_asso_third not in", values, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdBetween(String value1, String value2) {
            addCriterion("s_asso_third between", value1, value2, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSAssoThirdNotBetween(String value1, String value2) {
            addCriterion("s_asso_third not between", value1, value2, "sAssoThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumIsNull() {
            addCriterion("s_duties_num is null");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumIsNotNull() {
            addCriterion("s_duties_num is not null");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumEqualTo(Integer value) {
            addCriterion("s_duties_num =", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumNotEqualTo(Integer value) {
            addCriterion("s_duties_num <>", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumGreaterThan(Integer value) {
            addCriterion("s_duties_num >", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_duties_num >=", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumLessThan(Integer value) {
            addCriterion("s_duties_num <", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumLessThanOrEqualTo(Integer value) {
            addCriterion("s_duties_num <=", value, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumIn(List<Integer> values) {
            addCriterion("s_duties_num in", values, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumNotIn(List<Integer> values) {
            addCriterion("s_duties_num not in", values, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumBetween(Integer value1, Integer value2) {
            addCriterion("s_duties_num between", value1, value2, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesNumNotBetween(Integer value1, Integer value2) {
            addCriterion("s_duties_num not between", value1, value2, "sDutiesNum");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstIsNull() {
            addCriterion("s_duties_first is null");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstIsNotNull() {
            addCriterion("s_duties_first is not null");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstEqualTo(String value) {
            addCriterion("s_duties_first =", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstNotEqualTo(String value) {
            addCriterion("s_duties_first <>", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstGreaterThan(String value) {
            addCriterion("s_duties_first >", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstGreaterThanOrEqualTo(String value) {
            addCriterion("s_duties_first >=", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstLessThan(String value) {
            addCriterion("s_duties_first <", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstLessThanOrEqualTo(String value) {
            addCriterion("s_duties_first <=", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstLike(String value) {
            addCriterion("s_duties_first like", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstNotLike(String value) {
            addCriterion("s_duties_first not like", value, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstIn(List<String> values) {
            addCriterion("s_duties_first in", values, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstNotIn(List<String> values) {
            addCriterion("s_duties_first not in", values, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstBetween(String value1, String value2) {
            addCriterion("s_duties_first between", value1, value2, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesFirstNotBetween(String value1, String value2) {
            addCriterion("s_duties_first not between", value1, value2, "sDutiesFirst");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondIsNull() {
            addCriterion("s_duties_second is null");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondIsNotNull() {
            addCriterion("s_duties_second is not null");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondEqualTo(String value) {
            addCriterion("s_duties_second =", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondNotEqualTo(String value) {
            addCriterion("s_duties_second <>", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondGreaterThan(String value) {
            addCriterion("s_duties_second >", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondGreaterThanOrEqualTo(String value) {
            addCriterion("s_duties_second >=", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondLessThan(String value) {
            addCriterion("s_duties_second <", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondLessThanOrEqualTo(String value) {
            addCriterion("s_duties_second <=", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondLike(String value) {
            addCriterion("s_duties_second like", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondNotLike(String value) {
            addCriterion("s_duties_second not like", value, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondIn(List<String> values) {
            addCriterion("s_duties_second in", values, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondNotIn(List<String> values) {
            addCriterion("s_duties_second not in", values, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondBetween(String value1, String value2) {
            addCriterion("s_duties_second between", value1, value2, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesSecondNotBetween(String value1, String value2) {
            addCriterion("s_duties_second not between", value1, value2, "sDutiesSecond");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdIsNull() {
            addCriterion("s_duties_third is null");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdIsNotNull() {
            addCriterion("s_duties_third is not null");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdEqualTo(String value) {
            addCriterion("s_duties_third =", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdNotEqualTo(String value) {
            addCriterion("s_duties_third <>", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdGreaterThan(String value) {
            addCriterion("s_duties_third >", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdGreaterThanOrEqualTo(String value) {
            addCriterion("s_duties_third >=", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdLessThan(String value) {
            addCriterion("s_duties_third <", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdLessThanOrEqualTo(String value) {
            addCriterion("s_duties_third <=", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdLike(String value) {
            addCriterion("s_duties_third like", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdNotLike(String value) {
            addCriterion("s_duties_third not like", value, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdIn(List<String> values) {
            addCriterion("s_duties_third in", values, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdNotIn(List<String> values) {
            addCriterion("s_duties_third not in", values, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdBetween(String value1, String value2) {
            addCriterion("s_duties_third between", value1, value2, "sDutiesThird");
            return (Criteria) this;
        }

        public Criteria andSDutiesThirdNotBetween(String value1, String value2) {
            addCriterion("s_duties_third not between", value1, value2, "sDutiesThird");
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