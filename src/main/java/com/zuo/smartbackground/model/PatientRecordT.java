package com.zuo.smartbackground.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PatientRecordT {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.patient_record_id
     *
     * @mbggenerated
     */
    private Long patientRecordId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.patient_id
     *
     * @mbggenerated
     */
    private Integer patientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.doctor_id
     *
     * @mbggenerated
     */
    private Integer doctorId;

    private Integer scheduleId;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.admission_time
     *
     * @mbggenerated
     */
    private long admissionTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.chief
     *
     * @mbggenerated
     */
    private String chief;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.now_history
     *
     * @mbggenerated
     */
    private String nowHistory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.past_history
     *
     * @mbggenerated
     */
    private String pastHistory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.personal_history
     *
     * @mbggenerated
     */
    private String personalHistory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.family_history
     *
     * @mbggenerated
     */
    private String familyHistory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.physical_examination
     *
     * @mbggenerated
     */
    private String physicalExamination;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.therapeutic_examination
     *
     * @mbggenerated
     */
    private String therapeuticExamination;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column patient_record.diagnosis
     *
     * @mbggenerated
     */
    private String diagnosis;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.patient_record_id
     *
     * @return the value of patient_record.patient_record_id
     *
     * @mbggenerated
     */
    public Long getPatientRecordId() {
        return patientRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.patient_record_id
     *
     * @param patientRecordId the value for patient_record.patient_record_id
     *
     * @mbggenerated
     */
    public void setPatientRecordId(Long patientRecordId) {
        this.patientRecordId = patientRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.patient_id
     *
     * @return the value of patient_record.patient_id
     *
     * @mbggenerated
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.patient_id
     *
     * @param patientId the value for patient_record.patient_id
     *
     * @mbggenerated
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.doctor_id
     *
     * @return the value of patient_record.doctor_id
     *
     * @mbggenerated
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.doctor_id
     *
     * @param doctorId the value for patient_record.doctor_id
     *
     * @mbggenerated
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.admission_time
     *
     * @return the value of patient_record.admission_time
     *
     * @mbggenerated
     */
    public long getAdmissionTime() {
        return admissionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.admission_time
     *
     * @param admissionTime the value for patient_record.admission_time
     *
     * @mbggenerated
     */
    public void setAdmissionTime(long admissionTime) {
        this.admissionTime = admissionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.chief
     *
     * @return the value of patient_record.chief
     *
     * @mbggenerated
     */
    public String getChief() {
        return chief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.chief
     *
     * @param chief the value for patient_record.chief
     *
     * @mbggenerated
     */
    public void setChief(String chief) {
        this.chief = chief == null ? null : chief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.now_history
     *
     * @return the value of patient_record.now_history
     *
     * @mbggenerated
     */
    public String getNowHistory() {
        return nowHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.now_history
     *
     * @param nowHistory the value for patient_record.now_history
     *
     * @mbggenerated
     */
    public void setNowHistory(String nowHistory) {
        this.nowHistory = nowHistory == null ? null : nowHistory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.past_history
     *
     * @return the value of patient_record.past_history
     *
     * @mbggenerated
     */
    public String getPastHistory() {
        return pastHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.past_history
     *
     * @param pastHistory the value for patient_record.past_history
     *
     * @mbggenerated
     */
    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory == null ? null : pastHistory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.personal_history
     *
     * @return the value of patient_record.personal_history
     *
     * @mbggenerated
     */
    public String getPersonalHistory() {
        return personalHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.personal_history
     *
     * @param personalHistory the value for patient_record.personal_history
     *
     * @mbggenerated
     */
    public void setPersonalHistory(String personalHistory) {
        this.personalHistory = personalHistory == null ? null : personalHistory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.family_history
     *
     * @return the value of patient_record.family_history
     *
     * @mbggenerated
     */
    public String getFamilyHistory() {
        return familyHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.family_history
     *
     * @param familyHistory the value for patient_record.family_history
     *
     * @mbggenerated
     */
    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory == null ? null : familyHistory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.physical_examination
     *
     * @return the value of patient_record.physical_examination
     *
     * @mbggenerated
     */
    public String getPhysicalExamination() {
        return physicalExamination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.physical_examination
     *
     * @param physicalExamination the value for patient_record.physical_examination
     *
     * @mbggenerated
     */
    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination == null ? null : physicalExamination.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.therapeutic_examination
     *
     * @return the value of patient_record.therapeutic_examination
     *
     * @mbggenerated
     */
    public String getTherapeuticExamination() {
        return therapeuticExamination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.therapeutic_examination
     *
     * @param therapeuticExamination the value for patient_record.therapeutic_examination
     *
     * @mbggenerated
     */
    public void setTherapeuticExamination(String therapeuticExamination) {
        this.therapeuticExamination = therapeuticExamination == null ? null : therapeuticExamination.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column patient_record.diagnosis
     *
     * @return the value of patient_record.diagnosis
     *
     * @mbggenerated
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column patient_record.diagnosis
     *
     * @param diagnosis the value for patient_record.diagnosis
     *
     * @mbggenerated
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }
}