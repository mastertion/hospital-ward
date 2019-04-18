package com.example.hospitalward.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarePlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarePlanExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCareIdIsNull() {
            addCriterion("care_id is null");
            return (Criteria) this;
        }

        public Criteria andCareIdIsNotNull() {
            addCriterion("care_id is not null");
            return (Criteria) this;
        }

        public Criteria andCareIdEqualTo(Long value) {
            addCriterion("care_id =", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotEqualTo(Long value) {
            addCriterion("care_id <>", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThan(Long value) {
            addCriterion("care_id >", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("care_id >=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThan(Long value) {
            addCriterion("care_id <", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThanOrEqualTo(Long value) {
            addCriterion("care_id <=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdIn(List<Long> values) {
            addCriterion("care_id in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotIn(List<Long> values) {
            addCriterion("care_id not in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdBetween(Long value1, Long value2) {
            addCriterion("care_id between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotBetween(Long value1, Long value2) {
            addCriterion("care_id not between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Long value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Long value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Long value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Long value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Long value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Long> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Long> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Long value1, Long value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Long value1, Long value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdIsNull() {
            addCriterion("medicinal_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdIsNotNull() {
            addCriterion("medicinal_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdEqualTo(Long value) {
            addCriterion("medicinal_id =", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdNotEqualTo(Long value) {
            addCriterion("medicinal_id <>", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdGreaterThan(Long value) {
            addCriterion("medicinal_id >", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("medicinal_id >=", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdLessThan(Long value) {
            addCriterion("medicinal_id <", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdLessThanOrEqualTo(Long value) {
            addCriterion("medicinal_id <=", value, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdIn(List<Long> values) {
            addCriterion("medicinal_id in", values, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdNotIn(List<Long> values) {
            addCriterion("medicinal_id not in", values, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdBetween(Long value1, Long value2) {
            addCriterion("medicinal_id between", value1, value2, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalIdNotBetween(Long value1, Long value2) {
            addCriterion("medicinal_id not between", value1, value2, "medicinalId");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumIsNull() {
            addCriterion("medicinal_num is null");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumIsNotNull() {
            addCriterion("medicinal_num is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumEqualTo(Integer value) {
            addCriterion("medicinal_num =", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumNotEqualTo(Integer value) {
            addCriterion("medicinal_num <>", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumGreaterThan(Integer value) {
            addCriterion("medicinal_num >", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicinal_num >=", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumLessThan(Integer value) {
            addCriterion("medicinal_num <", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumLessThanOrEqualTo(Integer value) {
            addCriterion("medicinal_num <=", value, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumIn(List<Integer> values) {
            addCriterion("medicinal_num in", values, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumNotIn(List<Integer> values) {
            addCriterion("medicinal_num not in", values, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumBetween(Integer value1, Integer value2) {
            addCriterion("medicinal_num between", value1, value2, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andMedicinalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("medicinal_num not between", value1, value2, "medicinalNum");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNull() {
            addCriterion("is_complete is null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNotNull() {
            addCriterion("is_complete is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteEqualTo(Boolean value) {
            addCriterion("is_complete =", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotEqualTo(Boolean value) {
            addCriterion("is_complete <>", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThan(Boolean value) {
            addCriterion("is_complete >", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complete >=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThan(Boolean value) {
            addCriterion("is_complete <", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complete <=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIn(List<Boolean> values) {
            addCriterion("is_complete in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotIn(List<Boolean> values) {
            addCriterion("is_complete not in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete not between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andCarePlanIsNull() {
            addCriterion("care_plan is null");
            return (Criteria) this;
        }

        public Criteria andCarePlanIsNotNull() {
            addCriterion("care_plan is not null");
            return (Criteria) this;
        }

        public Criteria andCarePlanEqualTo(String value) {
            addCriterion("care_plan =", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanNotEqualTo(String value) {
            addCriterion("care_plan <>", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanGreaterThan(String value) {
            addCriterion("care_plan >", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanGreaterThanOrEqualTo(String value) {
            addCriterion("care_plan >=", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanLessThan(String value) {
            addCriterion("care_plan <", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanLessThanOrEqualTo(String value) {
            addCriterion("care_plan <=", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanLike(String value) {
            addCriterion("care_plan like", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanNotLike(String value) {
            addCriterion("care_plan not like", value, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanIn(List<String> values) {
            addCriterion("care_plan in", values, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanNotIn(List<String> values) {
            addCriterion("care_plan not in", values, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanBetween(String value1, String value2) {
            addCriterion("care_plan between", value1, value2, "carePlan");
            return (Criteria) this;
        }

        public Criteria andCarePlanNotBetween(String value1, String value2) {
            addCriterion("care_plan not between", value1, value2, "carePlan");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIsNull() {
            addCriterion("create_staff is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIsNotNull() {
            addCriterion("create_staff is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffEqualTo(Long value) {
            addCriterion("create_staff =", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNotEqualTo(Long value) {
            addCriterion("create_staff <>", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffGreaterThan(Long value) {
            addCriterion("create_staff >", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffGreaterThanOrEqualTo(Long value) {
            addCriterion("create_staff >=", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffLessThan(Long value) {
            addCriterion("create_staff <", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffLessThanOrEqualTo(Long value) {
            addCriterion("create_staff <=", value, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIn(List<Long> values) {
            addCriterion("create_staff in", values, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNotIn(List<Long> values) {
            addCriterion("create_staff not in", values, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffBetween(Long value1, Long value2) {
            addCriterion("create_staff between", value1, value2, "createStaff");
            return (Criteria) this;
        }

        public Criteria andCreateStaffNotBetween(Long value1, Long value2) {
            addCriterion("create_staff not between", value1, value2, "createStaff");
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