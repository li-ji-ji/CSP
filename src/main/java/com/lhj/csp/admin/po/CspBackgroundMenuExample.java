package com.lhj.csp.admin.po;

import java.util.ArrayList;
import java.util.List;

public class CspBackgroundMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspBackgroundMenuExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andMainUrlIsNull() {
            addCriterion("main_url is null");
            return (Criteria) this;
        }

        public Criteria andMainUrlIsNotNull() {
            addCriterion("main_url is not null");
            return (Criteria) this;
        }

        public Criteria andMainUrlEqualTo(String value) {
            addCriterion("main_url =", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlNotEqualTo(String value) {
            addCriterion("main_url <>", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlGreaterThan(String value) {
            addCriterion("main_url >", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlGreaterThanOrEqualTo(String value) {
            addCriterion("main_url >=", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlLessThan(String value) {
            addCriterion("main_url <", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlLessThanOrEqualTo(String value) {
            addCriterion("main_url <=", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlLike(String value) {
            addCriterion("main_url like", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlNotLike(String value) {
            addCriterion("main_url not like", value, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlIn(List<String> values) {
            addCriterion("main_url in", values, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlNotIn(List<String> values) {
            addCriterion("main_url not in", values, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlBetween(String value1, String value2) {
            addCriterion("main_url between", value1, value2, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andMainUrlNotBetween(String value1, String value2) {
            addCriterion("main_url not between", value1, value2, "mainUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlIsNull() {
            addCriterion("insert_url is null");
            return (Criteria) this;
        }

        public Criteria andInsertUrlIsNotNull() {
            addCriterion("insert_url is not null");
            return (Criteria) this;
        }

        public Criteria andInsertUrlEqualTo(String value) {
            addCriterion("insert_url =", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlNotEqualTo(String value) {
            addCriterion("insert_url <>", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlGreaterThan(String value) {
            addCriterion("insert_url >", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlGreaterThanOrEqualTo(String value) {
            addCriterion("insert_url >=", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlLessThan(String value) {
            addCriterion("insert_url <", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlLessThanOrEqualTo(String value) {
            addCriterion("insert_url <=", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlLike(String value) {
            addCriterion("insert_url like", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlNotLike(String value) {
            addCriterion("insert_url not like", value, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlIn(List<String> values) {
            addCriterion("insert_url in", values, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlNotIn(List<String> values) {
            addCriterion("insert_url not in", values, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlBetween(String value1, String value2) {
            addCriterion("insert_url between", value1, value2, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andInsertUrlNotBetween(String value1, String value2) {
            addCriterion("insert_url not between", value1, value2, "insertUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlIsNull() {
            addCriterion("delete_url is null");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlIsNotNull() {
            addCriterion("delete_url is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlEqualTo(String value) {
            addCriterion("delete_url =", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlNotEqualTo(String value) {
            addCriterion("delete_url <>", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlGreaterThan(String value) {
            addCriterion("delete_url >", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("delete_url >=", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlLessThan(String value) {
            addCriterion("delete_url <", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlLessThanOrEqualTo(String value) {
            addCriterion("delete_url <=", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlLike(String value) {
            addCriterion("delete_url like", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlNotLike(String value) {
            addCriterion("delete_url not like", value, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlIn(List<String> values) {
            addCriterion("delete_url in", values, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlNotIn(List<String> values) {
            addCriterion("delete_url not in", values, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlBetween(String value1, String value2) {
            addCriterion("delete_url between", value1, value2, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andDeleteUrlNotBetween(String value1, String value2) {
            addCriterion("delete_url not between", value1, value2, "deleteUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIsNull() {
            addCriterion("update_url is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIsNotNull() {
            addCriterion("update_url is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlEqualTo(String value) {
            addCriterion("update_url =", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotEqualTo(String value) {
            addCriterion("update_url <>", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlGreaterThan(String value) {
            addCriterion("update_url >", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("update_url >=", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLessThan(String value) {
            addCriterion("update_url <", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLessThanOrEqualTo(String value) {
            addCriterion("update_url <=", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlLike(String value) {
            addCriterion("update_url like", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotLike(String value) {
            addCriterion("update_url not like", value, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlIn(List<String> values) {
            addCriterion("update_url in", values, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotIn(List<String> values) {
            addCriterion("update_url not in", values, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlBetween(String value1, String value2) {
            addCriterion("update_url between", value1, value2, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andUpdateUrlNotBetween(String value1, String value2) {
            addCriterion("update_url not between", value1, value2, "updateUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlIsNull() {
            addCriterion("select_url is null");
            return (Criteria) this;
        }

        public Criteria andSelectUrlIsNotNull() {
            addCriterion("select_url is not null");
            return (Criteria) this;
        }

        public Criteria andSelectUrlEqualTo(String value) {
            addCriterion("select_url =", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlNotEqualTo(String value) {
            addCriterion("select_url <>", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlGreaterThan(String value) {
            addCriterion("select_url >", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("select_url >=", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlLessThan(String value) {
            addCriterion("select_url <", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlLessThanOrEqualTo(String value) {
            addCriterion("select_url <=", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlLike(String value) {
            addCriterion("select_url like", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlNotLike(String value) {
            addCriterion("select_url not like", value, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlIn(List<String> values) {
            addCriterion("select_url in", values, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlNotIn(List<String> values) {
            addCriterion("select_url not in", values, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlBetween(String value1, String value2) {
            addCriterion("select_url between", value1, value2, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andSelectUrlNotBetween(String value1, String value2) {
            addCriterion("select_url not between", value1, value2, "selectUrl");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconOpenIsNull() {
            addCriterion("icon_open is null");
            return (Criteria) this;
        }

        public Criteria andIconOpenIsNotNull() {
            addCriterion("icon_open is not null");
            return (Criteria) this;
        }

        public Criteria andIconOpenEqualTo(String value) {
            addCriterion("icon_open =", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenNotEqualTo(String value) {
            addCriterion("icon_open <>", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenGreaterThan(String value) {
            addCriterion("icon_open >", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenGreaterThanOrEqualTo(String value) {
            addCriterion("icon_open >=", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenLessThan(String value) {
            addCriterion("icon_open <", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenLessThanOrEqualTo(String value) {
            addCriterion("icon_open <=", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenLike(String value) {
            addCriterion("icon_open like", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenNotLike(String value) {
            addCriterion("icon_open not like", value, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenIn(List<String> values) {
            addCriterion("icon_open in", values, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenNotIn(List<String> values) {
            addCriterion("icon_open not in", values, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenBetween(String value1, String value2) {
            addCriterion("icon_open between", value1, value2, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconOpenNotBetween(String value1, String value2) {
            addCriterion("icon_open not between", value1, value2, "iconOpen");
            return (Criteria) this;
        }

        public Criteria andIconCloseIsNull() {
            addCriterion("icon_close is null");
            return (Criteria) this;
        }

        public Criteria andIconCloseIsNotNull() {
            addCriterion("icon_close is not null");
            return (Criteria) this;
        }

        public Criteria andIconCloseEqualTo(String value) {
            addCriterion("icon_close =", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseNotEqualTo(String value) {
            addCriterion("icon_close <>", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseGreaterThan(String value) {
            addCriterion("icon_close >", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseGreaterThanOrEqualTo(String value) {
            addCriterion("icon_close >=", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseLessThan(String value) {
            addCriterion("icon_close <", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseLessThanOrEqualTo(String value) {
            addCriterion("icon_close <=", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseLike(String value) {
            addCriterion("icon_close like", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseNotLike(String value) {
            addCriterion("icon_close not like", value, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseIn(List<String> values) {
            addCriterion("icon_close in", values, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseNotIn(List<String> values) {
            addCriterion("icon_close not in", values, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseBetween(String value1, String value2) {
            addCriterion("icon_close between", value1, value2, "iconClose");
            return (Criteria) this;
        }

        public Criteria andIconCloseNotBetween(String value1, String value2) {
            addCriterion("icon_close not between", value1, value2, "iconClose");
            return (Criteria) this;
        }

        public Criteria andFongCssIsNull() {
            addCriterion("fong_css is null");
            return (Criteria) this;
        }

        public Criteria andFongCssIsNotNull() {
            addCriterion("fong_css is not null");
            return (Criteria) this;
        }

        public Criteria andFongCssEqualTo(String value) {
            addCriterion("fong_css =", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssNotEqualTo(String value) {
            addCriterion("fong_css <>", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssGreaterThan(String value) {
            addCriterion("fong_css >", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssGreaterThanOrEqualTo(String value) {
            addCriterion("fong_css >=", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssLessThan(String value) {
            addCriterion("fong_css <", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssLessThanOrEqualTo(String value) {
            addCriterion("fong_css <=", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssLike(String value) {
            addCriterion("fong_css like", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssNotLike(String value) {
            addCriterion("fong_css not like", value, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssIn(List<String> values) {
            addCriterion("fong_css in", values, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssNotIn(List<String> values) {
            addCriterion("fong_css not in", values, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssBetween(String value1, String value2) {
            addCriterion("fong_css between", value1, value2, "fongCss");
            return (Criteria) this;
        }

        public Criteria andFongCssNotBetween(String value1, String value2) {
            addCriterion("fong_css not between", value1, value2, "fongCss");
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