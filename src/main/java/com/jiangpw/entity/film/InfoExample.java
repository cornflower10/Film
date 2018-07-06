package com.jiangpw.entity.film;

import java.util.ArrayList;
import java.util.List;

public class InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoExample() {
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

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andDouban_idIsNull() {
            addCriterion("douban_id is null");
            return (Criteria) this;
        }

        public Criteria andDouban_idIsNotNull() {
            addCriterion("douban_id is not null");
            return (Criteria) this;
        }

        public Criteria andDouban_idEqualTo(Integer value) {
            addCriterion("douban_id =", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idNotEqualTo(Integer value) {
            addCriterion("douban_id <>", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idGreaterThan(Integer value) {
            addCriterion("douban_id >", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("douban_id >=", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idLessThan(Integer value) {
            addCriterion("douban_id <", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idLessThanOrEqualTo(Integer value) {
            addCriterion("douban_id <=", value, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idIn(List<Integer> values) {
            addCriterion("douban_id in", values, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idNotIn(List<Integer> values) {
            addCriterion("douban_id not in", values, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idBetween(Integer value1, Integer value2) {
            addCriterion("douban_id between", value1, value2, "douban_id");
            return (Criteria) this;
        }

        public Criteria andDouban_idNotBetween(Integer value1, Integer value2) {
            addCriterion("douban_id not between", value1, value2, "douban_id");
            return (Criteria) this;
        }

        public Criteria andCover_xIsNull() {
            addCriterion("cover_x is null");
            return (Criteria) this;
        }

        public Criteria andCover_xIsNotNull() {
            addCriterion("cover_x is not null");
            return (Criteria) this;
        }

        public Criteria andCover_xEqualTo(String value) {
            addCriterion("cover_x =", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xNotEqualTo(String value) {
            addCriterion("cover_x <>", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xGreaterThan(String value) {
            addCriterion("cover_x >", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xGreaterThanOrEqualTo(String value) {
            addCriterion("cover_x >=", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xLessThan(String value) {
            addCriterion("cover_x <", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xLessThanOrEqualTo(String value) {
            addCriterion("cover_x <=", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xLike(String value) {
            addCriterion("cover_x like", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xNotLike(String value) {
            addCriterion("cover_x not like", value, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xIn(List<String> values) {
            addCriterion("cover_x in", values, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xNotIn(List<String> values) {
            addCriterion("cover_x not in", values, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xBetween(String value1, String value2) {
            addCriterion("cover_x between", value1, value2, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_xNotBetween(String value1, String value2) {
            addCriterion("cover_x not between", value1, value2, "cover_x");
            return (Criteria) this;
        }

        public Criteria andCover_yIsNull() {
            addCriterion("cover_y is null");
            return (Criteria) this;
        }

        public Criteria andCover_yIsNotNull() {
            addCriterion("cover_y is not null");
            return (Criteria) this;
        }

        public Criteria andCover_yEqualTo(String value) {
            addCriterion("cover_y =", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yNotEqualTo(String value) {
            addCriterion("cover_y <>", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yGreaterThan(String value) {
            addCriterion("cover_y >", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yGreaterThanOrEqualTo(String value) {
            addCriterion("cover_y >=", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yLessThan(String value) {
            addCriterion("cover_y <", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yLessThanOrEqualTo(String value) {
            addCriterion("cover_y <=", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yLike(String value) {
            addCriterion("cover_y like", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yNotLike(String value) {
            addCriterion("cover_y not like", value, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yIn(List<String> values) {
            addCriterion("cover_y in", values, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yNotIn(List<String> values) {
            addCriterion("cover_y not in", values, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yBetween(String value1, String value2) {
            addCriterion("cover_y between", value1, value2, "cover_y");
            return (Criteria) this;
        }

        public Criteria andCover_yNotBetween(String value1, String value2) {
            addCriterion("cover_y not between", value1, value2, "cover_y");
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