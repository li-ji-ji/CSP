package cn.lhj.csp.adminmenu.po;

import java.util.ArrayList;
import java.util.List;

public class CspAdminMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    //加入 offset 起始位置  和 limit 查询页数  用来分页
    protected int offset;
    
    protected int limit;
    
    public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public CspAdminMenuExample() {
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

        public Criteria andIsHiddenIsNull() {
            addCriterion("is_hidden is null");
            return (Criteria) this;
        }

        public Criteria andIsHiddenIsNotNull() {
            addCriterion("is_hidden is not null");
            return (Criteria) this;
        }

        public Criteria andIsHiddenEqualTo(Integer value) {
            addCriterion("is_hidden =", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenNotEqualTo(Integer value) {
            addCriterion("is_hidden <>", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenGreaterThan(Integer value) {
            addCriterion("is_hidden >", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hidden >=", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenLessThan(Integer value) {
            addCriterion("is_hidden <", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenLessThanOrEqualTo(Integer value) {
            addCriterion("is_hidden <=", value, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenIn(List<Integer> values) {
            addCriterion("is_hidden in", values, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenNotIn(List<Integer> values) {
            addCriterion("is_hidden not in", values, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenBetween(Integer value1, Integer value2) {
            addCriterion("is_hidden between", value1, value2, "isHidden");
            return (Criteria) this;
        }

        public Criteria andIsHiddenNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hidden not between", value1, value2, "isHidden");
            return (Criteria) this;
        }

        public Criteria andMainurlIsNull() {
            addCriterion("mainurl is null");
            return (Criteria) this;
        }

        public Criteria andMainurlIsNotNull() {
            addCriterion("mainurl is not null");
            return (Criteria) this;
        }

        public Criteria andMainurlEqualTo(String value) {
            addCriterion("mainurl =", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotEqualTo(String value) {
            addCriterion("mainurl <>", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlGreaterThan(String value) {
            addCriterion("mainurl >", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlGreaterThanOrEqualTo(String value) {
            addCriterion("mainurl >=", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLessThan(String value) {
            addCriterion("mainurl <", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLessThanOrEqualTo(String value) {
            addCriterion("mainurl <=", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLike(String value) {
            addCriterion("mainurl like", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotLike(String value) {
            addCriterion("mainurl not like", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlIn(List<String> values) {
            addCriterion("mainurl in", values, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotIn(List<String> values) {
            addCriterion("mainurl not in", values, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlBetween(String value1, String value2) {
            addCriterion("mainurl between", value1, value2, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotBetween(String value1, String value2) {
            addCriterion("mainurl not between", value1, value2, "mainurl");
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