package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.PatientRecord;

import java.util.List;

public interface PatientRecordService {
    List<PatientRecord> getPatientRecordByPatientAccount(String account);
    List<PatientRecord> getPatientRecordByDoctorAccount(String account);

    int createPatientRecord(PatientRecord patientRecord);
    int deletePatientRecord(long patientRecordId);
    int updatePatientRecord(PatientRecord patientRecord);

    PatientRecord getPatientRecordBySellf(PatientRecord patientRecord);

}
