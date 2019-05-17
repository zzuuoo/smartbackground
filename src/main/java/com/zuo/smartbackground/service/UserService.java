package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.*;

import javax.print.Doc;
import java.util.List;

public interface UserService {
    Admin getAdminByAccount(String account);
    Doctor getDoctorByAccount(String account);
    Patient getPatientByAccount(String account);
    int insertUser(User user);
    int insertPatient(Patient patient);
    int insertDoctor(Doctor doctor);
    int insertAdmin(Admin admin);

    List<User> selectUserByExample(UserExample userExample);
    List<Doctor> selectDoctorByExample(DoctorExample doctorExample);
    List<Patient> selectPatientByExample(PatientExample patientExample);
    List<Admin> selectAdminByExample(AdminExample adminExample);

    List<User> getUserByAccountAndStatus(String account,int status);

    int updateUser(User user);
        int updateDoctor(Doctor doctor);
    int updatePatient(Patient patient);
    int updateAdmin(Admin admin);

    int deleteUser(User user);
    int deleteDoctor(String account);
    int deletePatient(String account);
    int deleteAdmin(String account);

    int addDoctor(User user, Doctor doctor);
    int editDoctor(Doctor doctor);
    int addPatient(User u,Patient p);
    int addAdmin(User user,Admin admin);






}
