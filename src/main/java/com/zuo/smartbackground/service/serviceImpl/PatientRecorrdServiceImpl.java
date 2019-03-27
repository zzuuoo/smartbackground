package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.PatientMapper;
import com.zuo.smartbackground.dao.PatientRecordMapper;
import com.zuo.smartbackground.model.Doctor;
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

    @Override
    public List<PatientRecord> getPatientRecordByDoctorAccount(String account) {
        Doctor doctor = userService.getDoctorByAccount(account);
        if(doctor==null||doctor.getDoctorId()==null)
        {
            return null;
        }
        PatientRecordExample patientRecordExample = new PatientRecordExample();
        patientRecordExample.createCriteria().andDoctorIdEqualTo(doctor.getDoctorId());
        return patientRecordMapper.selectByExample(patientRecordExample);
    }

    @Override
    public int createPatientRecord(PatientRecord patientRecord) {
        return patientRecordMapper.insertSelective(patientRecord);
    }

    @Override
    public int deletePatientRecord(long patientRecordId) {
        return patientRecordMapper.deleteByPrimaryKey(patientRecordId);
    }

    @Override
    public int updatePatientRecord(PatientRecord patientRecord) {
        return patientRecordMapper.updateByPrimaryKeySelective(patientRecord);
    }
}
