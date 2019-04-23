package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.*;
import com.zuo.smartbackground.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "getAdminByAccount",method = RequestMethod.GET)
    public Admin getAdminByAccount(String account)
    {
        logger.info("getAdminByAccount,account:"+account);
        return userService.getAdminByAccount(account);
    }

    @RequestMapping(value = "getDoctorByAccount",method = RequestMethod.GET)
    public Doctor getDoctorByAccount(String account)
    {
        logger.info("getDoctorByAccount,account:"+account);
        return userService.getDoctorByAccount(account);
    }

    @RequestMapping(value = "getPatientByAccount",method = RequestMethod.GET)
    public Patient getPatientByAccount(String account)
    {
        logger.info("getPatientByAccount,account:"+account);
        return userService.getPatientByAccount(account);
    }

//    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
//    public int insertUser(User user)
//    {
//        return userService.insertUser(user);
//    }


//    @RequestMapping(value = "insertDoctor",method = RequestMethod.POST)
//    public int insertDoctor(Doctor doctor)
//    {
//        return userService.insertDoctor(doctor);
//    }

//    @RequestMapping(value = "insertPatient",method = RequestMethod.POST)
//    public int insertPatient(Patient patient)
//    {
//
//        return userService.insertPatient(patient);
//    }


//    @RequestMapping(value = "insertAdmin",method = RequestMethod.POST)
//    public int insertAdmin(Admin admin)
//    {
//        return userService.insertAdmin(admin);
//    }

    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public int deleteUser(User user)
    {
        logger.info("deleteUser,UserAccount and status:",user.getAccount(),user.getUserStatus());
        return userService.deleteUser(user);
    }


    @RequestMapping(value = "deletePatient",method = RequestMethod.POST)
    public int deletePatient(String account)
    {
        return userService.deletePatient(account);
    }


    @RequestMapping(value = "deleteDoctor",method = RequestMethod.GET)
    public int deleteDoctor(String account)
    {
        return userService.deleteDoctor(account);
    }

    @RequestMapping(value = "deleteAdmin",method = RequestMethod.POST)
    public int deleteAdmin(String account)
    {
        return userService.deleteAdmin(account);
    }


    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public int updateUser(User user)
    {
        return userService.updateUser(user);
    }


    @RequestMapping(value = "updatePatient",method = RequestMethod.POST)
    public int updatePatient(Patient patient)
    {
        return userService.updatePatient(patient);
    }

        @RequestMapping(value = "updateDoctor",method = RequestMethod.POST)
    public int updateDoctor(Doctor doctor)
    {
        return userService.updateDoctor(doctor);
    }

    @RequestMapping(value = "updateAdmin",method = RequestMethod.POST)
    public int updateAdmin(Admin admin)
    {
        return userService.updateAdmin(admin);
    }


    @RequestMapping(value = "getAllDoctor",method = RequestMethod.GET)
    public List<Doctor> getAllDoctor()
    {
        return userService.selectDoctorByExample(null);
    }


    @RequestMapping(value = "getAllPatient",method = RequestMethod.GET)
    public List<Patient> getAllPatient()
    {
        return userService.selectPatientByExample(null);
    }


    @RequestMapping(value = "getAllAdmin",method = RequestMethod.GET)
    public List<Admin> getAllAdmin()
    {
        return userService.selectAdminByExample(null);
    }

    @RequestMapping(value = "getDoctorBySection",method = RequestMethod.GET)
    public List<Doctor> getDoctorBySection(Integer sectionId)
    {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andSectionIdEqualTo(sectionId);
        List<Doctor> doctors = userService.selectDoctorByExample(doctorExample);
        if(doctors!=null&&doctors.size()>0){
            System.out.println(doctors.get(0).getHonour());
        }
        return doctors;
    }

    @RequestMapping(value = "get_user_by_account_and_status",method = RequestMethod.GET)
    public List<User> get_user_by_account_and_status(String account,Integer status)
    {
        return userService.getUserByAccountAndStatus(account,status);
    }

    @RequestMapping(value = "addDoctor",method = RequestMethod.POST)
    public int addDoctor(DUser dUser){
        System.out.println(dUser.toString());
        User user = new User();
        user.setUserStatus(2);
        user.setAccount(dUser.getPhone());
        user.setPassword(dUser.getPassword());
        Doctor doctor = new Doctor();
        doctor.setAccount(user.getAccount());
        doctor.setHonour(dUser.getHonour());
        doctor.setPhone(user.getAccount());
        doctor.setSectionId(dUser.getSectionId());
        doctor.setName(dUser.getName());
        doctor.setIdNumber(dUser.getIdNumber());
        doctor.setSex(dUser.getSex());
        return userService.addDoctor(user,doctor);
    }

    @RequestMapping(value = "editDoctor",method = RequestMethod.POST)
    public int editDoctor(DUser dUser){
        System.out.println(dUser.toString());
        User user = new User();
        user.setUserStatus(2);
        user.setAccount(dUser.getAccount());
        if (dUser.getPassword()!=null&&dUser.getPassword()!=""){
            logger.info("更新医生密码：",dUser.getPassword(),dUser.getAccount());
            user.setPassword(dUser.getPassword());
            if (userService.updateUser(user)==1){
                logger.info("更新医生密码成功");
            }else{
                logger.info("更新医生密码失败");
            }
        }
        Doctor doctor = new Doctor();
        doctor.setDoctorId(dUser.getDoctorId());
        doctor.setAccount(dUser.getAccount());
        doctor.setHonour(dUser.getHonour());
        doctor.setPhone(dUser.getPhone());
        doctor.setSectionId(dUser.getSectionId());
        doctor.setName(dUser.getName());
        doctor.setIdNumber(dUser.getIdNumber());
        doctor.setSex(dUser.getSex());
        return userService.editDoctor(doctor);
    }



}
