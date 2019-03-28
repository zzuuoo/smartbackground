package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.PatientRecord;
import com.zuo.smartbackground.service.PatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
