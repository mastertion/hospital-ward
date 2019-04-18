package com.example.hospitalward.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HealthExample() {
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

        public Criteria andCandoIsNull() {
            addCriterion("cando is null");
            return (Criteria) this;
        }

        public Criteria andCandoIsNotNull() {
            addCriterion("cando is not null");
            return (Criteria) this;
        }

        public Criteria andCandoEqualTo(String value) {
            addCriterion("cando =", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoNotEqualTo(String value) {
            addCriterion("cando <>", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoGreaterThan(String value) {
            addCriterion("cando >", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoGreaterThanOrEqualTo(String value) {
            addCriterion("cando >=", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoLessThan(String value) {
            addCriterion("cando <", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoLessThanOrEqualTo(String value) {
            addCriterion("cando <=", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoLike(String value) {
            addCriterion("cando like", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoNotLike(String value) {
            addCriterion("cando not like", value, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoIn(List<String> values) {
            addCriterion("cando in", values, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoNotIn(List<String> values) {
            addCriterion("cando not in", values, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoBetween(String value1, String value2) {
            addCriterion("cando between", value1, value2, "cando");
            return (Criteria) this;
        }

        public Criteria andCandoNotBetween(String value1, String value2) {
            addCriterion("cando not between", value1, value2, "cando");
            return (Criteria) this;
        }

        public Criteria andMentalIsNull() {
            addCriterion("mental is null");
            return (Criteria) this;
        }

        public Criteria andMentalIsNotNull() {
            addCriterion("mental is not null");
            return (Criteria) this;
        }

        public Criteria andMentalEqualTo(String value) {
            addCriterion("mental =", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalNotEqualTo(String value) {
            addCriterion("mental <>", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalGreaterThan(String value) {
            addCriterion("mental >", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalGreaterThanOrEqualTo(String value) {
            addCriterion("mental >=", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalLessThan(String value) {
            addCriterion("mental <", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalLessThanOrEqualTo(String value) {
            addCriterion("mental <=", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalLike(String value) {
            addCriterion("mental like", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalNotLike(String value) {
            addCriterion("mental not like", value, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalIn(List<String> values) {
            addCriterion("mental in", values, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalNotIn(List<String> values) {
            addCriterion("mental not in", values, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalBetween(String value1, String value2) {
            addCriterion("mental between", value1, value2, "mental");
            return (Criteria) this;
        }

        public Criteria andMentalNotBetween(String value1, String value2) {
            addCriterion("mental not between", value1, value2, "mental");
            return (Criteria) this;
        }

        public Criteria andPulseIsNull() {
            addCriterion("pulse is null");
            return (Criteria) this;
        }

        public Criteria andPulseIsNotNull() {
            addCriterion("pulse is not null");
            return (Criteria) this;
        }

        public Criteria andPulseEqualTo(String value) {
            addCriterion("pulse =", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotEqualTo(String value) {
            addCriterion("pulse <>", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseGreaterThan(String value) {
            addCriterion("pulse >", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseGreaterThanOrEqualTo(String value) {
            addCriterion("pulse >=", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLessThan(String value) {
            addCriterion("pulse <", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLessThanOrEqualTo(String value) {
            addCriterion("pulse <=", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLike(String value) {
            addCriterion("pulse like", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotLike(String value) {
            addCriterion("pulse not like", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseIn(List<String> values) {
            addCriterion("pulse in", values, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotIn(List<String> values) {
            addCriterion("pulse not in", values, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseBetween(String value1, String value2) {
            addCriterion("pulse between", value1, value2, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotBetween(String value1, String value2) {
            addCriterion("pulse not between", value1, value2, "pulse");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNull() {
            addCriterion("blood_pressure is null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIsNotNull() {
            addCriterion("blood_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andBloodPressureEqualTo(String value) {
            addCriterion("blood_pressure =", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotEqualTo(String value) {
            addCriterion("blood_pressure <>", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThan(String value) {
            addCriterion("blood_pressure >", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureGreaterThanOrEqualTo(String value) {
            addCriterion("blood_pressure >=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThan(String value) {
            addCriterion("blood_pressure <", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLessThanOrEqualTo(String value) {
            addCriterion("blood_pressure <=", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureLike(String value) {
            addCriterion("blood_pressure like", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotLike(String value) {
            addCriterion("blood_pressure not like", value, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureIn(List<String> values) {
            addCriterion("blood_pressure in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotIn(List<String> values) {
            addCriterion("blood_pressure not in", values, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureBetween(String value1, String value2) {
            addCriterion("blood_pressure between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andBloodPressureNotBetween(String value1, String value2) {
            addCriterion("blood_pressure not between", value1, value2, "bloodPressure");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesIsNull() {
            addCriterion("allergic_medicines is null");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesIsNotNull() {
            addCriterion("allergic_medicines is not null");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesEqualTo(String value) {
            addCriterion("allergic_medicines =", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesNotEqualTo(String value) {
            addCriterion("allergic_medicines <>", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesGreaterThan(String value) {
            addCriterion("allergic_medicines >", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesGreaterThanOrEqualTo(String value) {
            addCriterion("allergic_medicines >=", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesLessThan(String value) {
            addCriterion("allergic_medicines <", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesLessThanOrEqualTo(String value) {
            addCriterion("allergic_medicines <=", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesLike(String value) {
            addCriterion("allergic_medicines like", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesNotLike(String value) {
            addCriterion("allergic_medicines not like", value, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesIn(List<String> values) {
            addCriterion("allergic_medicines in", values, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesNotIn(List<String> values) {
            addCriterion("allergic_medicines not in", values, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesBetween(String value1, String value2) {
            addCriterion("allergic_medicines between", value1, value2, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andAllergicMedicinesNotBetween(String value1, String value2) {
            addCriterion("allergic_medicines not between", value1, value2, "allergicMedicines");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNull() {
            addCriterion("disease is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNotNull() {
            addCriterion("disease is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseEqualTo(String value) {
            addCriterion("disease =", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotEqualTo(String value) {
            addCriterion("disease <>", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThan(String value) {
            addCriterion("disease >", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("disease >=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThan(String value) {
            addCriterion("disease <", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThanOrEqualTo(String value) {
            addCriterion("disease <=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLike(String value) {
            addCriterion("disease like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotLike(String value) {
            addCriterion("disease not like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseIn(List<String> values) {
            addCriterion("disease in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotIn(List<String> values) {
            addCriterion("disease not in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseBetween(String value1, String value2) {
            addCriterion("disease between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotBetween(String value1, String value2) {
            addCriterion("disease not between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andFoodIsNull() {
            addCriterion("food is null");
            return (Criteria) this;
        }

        public Criteria andFoodIsNotNull() {
            addCriterion("food is not null");
            return (Criteria) this;
        }

        public Criteria andFoodEqualTo(String value) {
            addCriterion("food =", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotEqualTo(String value) {
            addCriterion("food <>", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThan(String value) {
            addCriterion("food >", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThanOrEqualTo(String value) {
            addCriterion("food >=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThan(String value) {
            addCriterion("food <", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThanOrEqualTo(String value) {
            addCriterion("food <=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLike(String value) {
            addCriterion("food like", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotLike(String value) {
            addCriterion("food not like", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodIn(List<String> values) {
            addCriterion("food in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotIn(List<String> values) {
            addCriterion("food not in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodBetween(String value1, String value2) {
            addCriterion("food between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotBetween(String value1, String value2) {
            addCriterion("food not between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andCharactIsNull() {
            addCriterion("charact is null");
            return (Criteria) this;
        }

        public Criteria andCharactIsNotNull() {
            addCriterion("charact is not null");
            return (Criteria) this;
        }

        public Criteria andCharactEqualTo(String value) {
            addCriterion("charact =", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotEqualTo(String value) {
            addCriterion("charact <>", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThan(String value) {
            addCriterion("charact >", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThanOrEqualTo(String value) {
            addCriterion("charact >=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThan(String value) {
            addCriterion("charact <", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThanOrEqualTo(String value) {
            addCriterion("charact <=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLike(String value) {
            addCriterion("charact like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotLike(String value) {
            addCriterion("charact not like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactIn(List<String> values) {
            addCriterion("charact in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotIn(List<String> values) {
            addCriterion("charact not in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactBetween(String value1, String value2) {
            addCriterion("charact between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotBetween(String value1, String value2) {
            addCriterion("charact not between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("hobby is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("hobby is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("hobby =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("hobby <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("hobby >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("hobby >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("hobby <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("hobby <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("hobby like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("hobby not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("hobby in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("hobby not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("hobby between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("hobby not between", value1, value2, "hobby");
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