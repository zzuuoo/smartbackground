package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.PatientMapper;
import com.zuo.smartbackground.dao.PatientRecordMapper;
import com.zuo.smartbackground.model.Patient;
import com.zuo.smartbackground.model.PatientRecord;
import com.zuo.smartbackground.model.PatientRecordExample;
import com.zuo.smartbackground.service.PatientRecordService;
import com.zuo.smartbackground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientRecorrdServiceImpl implements PatientRecordService {

    @Autowired
    private PatientRecordMapper patientRecordMapper;

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private UserService userService;
    @Override
    public List<PatientRecord> getPatientRecordByPatientAccount(String account) {
        Patient patient = userService.getPatientByAccount(account);
        if(patient==null||patient.getPatientId()==null)
        {
            return null;
        }
        PatientRecordExample patientRecordExample = new PatientRecordExample();
        patientRecordExample.createCriteria().andPatientIdEqualTo(patient.getPatientId());
        return patientRecordMapper.selectByExample(patientRecordExample);
    }
}
