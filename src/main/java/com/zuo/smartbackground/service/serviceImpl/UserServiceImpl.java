package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.AdminMapper;
import com.zuo.smartbackground.dao.DoctorMapper;
import com.zuo.smartbackground.dao.PatientMapper;
import com.zuo.smartbackground.dao.UserMapper;
import com.zuo.smartbackground.model.*;
import com.zuo.smartbackground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public Admin getAdminByAccount(String account) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(account);
        List<Admin> lists = adminMapper.selectByExample(adminExample);
        if(lists!=null&&lists.size()>0)
        {
            return lists.get(0);
        }
        return null;
    }

    @Override
    public Doctor getDoctorByAccount(String account) {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andAccountEqualTo(account);
        List<Doctor> lists = doctorMapper.selectByExample(doctorExample);
        if(lists!=null&&lists.size()>0)
        {
            return lists.get(0);
        }
        return null;
    }

    @Override
    public Patient getPatientByAccount(String account) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAccountEqualTo(account);
        List<Patient> lists = patientMapper.selectByExample(patientExample);
        if(lists!=null&&lists.size()>0)
        {
            return lists.get(0);
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        if(user==null||user.getAccount()==null||
                user.getPassword()==null||user.getUserStatus()==null)
        {
            return 0;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount())
                .andUserStatusEqualTo(user.getUserStatus());
        System.out.println(user.getAccount());
        List<User> list = userMapper.selectByExample(userExample);
        System.out.println(list.size());
        if(list.size()>0){
            return 0;
        }
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertPatient(Patient patient) {
        if(patient==null||patient.getAccount()==null)
        {
            return 0;
        }
        return patientMapper.insertSelective(patient);
    }

    @Override
    public int insertDoctor(Doctor doctor) {
        if(doctor==null||doctor.getAccount()==null)
        {
            return 0;
        }
        return doctorMapper.insertSelective(doctor);
    }

    @Override
    public int insertAdmin(Admin admin) {
        if(admin==null||admin.getAccount()==null){
            return 0;
        }
        return adminMapper.insertSelective(admin);
    }

    @Override
    public List<User> selectUserByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<Doctor> selectDoctorByExample(DoctorExample doctorExample) {
        return doctorMapper.selectByExample(doctorExample);
    }

    @Override
    public List<Patient> selectPatientByExample(PatientExample patientExample) {
        return patientMapper.selectByExample(patientExample);
    }

    @Override
    public List<Admin> selectAdminByExample(AdminExample adminExample) {
        return adminMapper.selectByExample(adminExample);
    }

    @Override
    public int updateUser(User user) {
        if(user==null||user.getAccount()==null||user.getUserStatus()==null){
            return 0;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount())
                .andUserStatusEqualTo(user.getUserStatus());
        return userMapper.updateByExampleSelective(user,userExample);
    }

    @Override
    public int updateDoctor(Doctor doctor) {
        if(doctor==null||doctor.getAccount()==null)
        {
            return 0;
        }
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andAccountEqualTo(doctor.getAccount());
        return doctorMapper.updateByExampleSelective(doctor,doctorExample);
    }

    @Override
    public int updatePatient(Patient patient) {
        if(patient==null||patient.getAccount()==null)
        {
            return 0;
        }
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAccountEqualTo(patient.getAccount());
        return patientMapper.updateByExampleSelective(patient,patientExample);
    }

    @Override
    public int updateAdmin(Admin admin) {
        if(admin==null||admin.getAccount()==null)
        {
            return 0;
        }
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(admin.getAccount());
        return adminMapper.updateByExampleSelective(admin,adminExample);
    }

    @Override
    public int deleteUser(User user) {
        if(user==null||user.getUserStatus()==null||user.getAccount()==null)
        {
            return 0;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount())
                .andUserStatusEqualTo(user.getUserStatus());

        return userMapper.deleteByExample(userExample);
    }

    @Override
    public int deleteDoctor(String account) {
        if(account==null)
        {
            return 0;
        }
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andAccountEqualTo(account);

        return doctorMapper.deleteByExample(doctorExample);
    }

    @Override
    public int deletePatient(String account) {
        if(account==null)
        {
            return 0;
        }
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAccountEqualTo(account);
        return patientMapper.deleteByExample(patientExample);
    }

    @Override
    public int deleteAdmin(String account) {
        if(account==null)
        {
            return 0;
        }
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(account);

        return adminMapper.deleteByExample(adminExample);
    }
}
