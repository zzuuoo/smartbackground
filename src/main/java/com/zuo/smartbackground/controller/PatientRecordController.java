package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.PatientRecord;
import com.zuo.smartbackground.model.PatientRecordForDate;
import com.zuo.smartbackground.service.PatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
//        List<PatientRecordForDate> patientRecordForDates = new ArrayList<>();
//        PatientRecordForDate patientRecordForDate;
//        PatientRecord patientRecord;
//        for(int i=0;i<list.size();i++)
//        {
//            patientRecord = list.get(i);
//            System.out.println(patientRecord.getPatientId());
//            patientRecordForDate = new PatientRecordForDate();
//            patientRecordForDate.setAdmissionTime(patientRecord.getAdmissionTime().getTime());
//            patientRecordForDate.setChief(patientRecord.getChief());
//            patientRecordForDate.setDiagnosis(patientRecord.getDiagnosis());
//            patientRecordForDate.setDoctorId(patientRecord.getDoctorId());
//            patientRecordForDate.setFamilyHistory(patientRecord.getFamilyHistory());
//            patientRecordForDate.setNowHistory(patientRecord.getNowHistory());
//            patientRecordForDate.setPastHistory(patientRecord.getPastHistory());
//            patientRecordForDate.setPatientId(patientRecord.getPatientId());
//            patientRecordForDate.setPersonalHistory(patientRecord.getPersonalHistory());
//            patientRecordForDate.setPhysicalExamination(patientRecord.getPhysicalExamination());
//            patientRecordForDate.setTherapeuticExamination(patientRecord.getTherapeuticExamination());
//            patientRecordForDate.setPatientRecordId(patientRecord.getPatientRecordId());
//            patientRecordForDates.add(patientRecordForDate);
//        }

        return list;
    }
}
