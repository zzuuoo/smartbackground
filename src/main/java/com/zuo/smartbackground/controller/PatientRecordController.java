package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.PatientRecord;
import com.zuo.smartbackground.model.PatientRecordT;
import com.zuo.smartbackground.service.PatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/medicalRecord")
public class PatientRecordController {
    @Autowired
    private PatientRecordService patientRecordService;


    @RequestMapping(value = "getPatientRecordByAccount",method = RequestMethod.GET)
    public List<PatientRecord> getPatientRecordByAccount(String account)
    {
        List<PatientRecord> list = patientRecordService.getPatientRecordByPatientAccount(account);

        return list;
    }
    @RequestMapping(value = "insertPatientRecord",method = RequestMethod.POST)
    public int insertPatientRecord(PatientRecordT patientRecordT){
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setAdmissionTime(new Date(patientRecordT.getAdmissionTime()));
        patientRecord.setChief(patientRecordT.getChief());
        patientRecord.setDiagnosis(patientRecordT.getDiagnosis());
        patientRecord.setDoctorId(patientRecordT.getDoctorId());
        patientRecord.setPatientId(patientRecordT.getPatientId());
        patientRecord.setNowHistory(patientRecordT.getNowHistory());
        patientRecord.setPhysicalExamination(patientRecordT.getPhysicalExamination());
        patientRecord.setTherapeuticExamination(patientRecordT.getTherapeuticExamination());
        
        return patientRecordService.createPatientRecord(patientRecord);
    }
}
