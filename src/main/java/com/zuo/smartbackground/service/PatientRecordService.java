package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.PatientRecord;

import java.util.List;

public interface PatientRecordService {
    List<PatientRecord> getPatientRecordByPatientAccount(String account);
}
