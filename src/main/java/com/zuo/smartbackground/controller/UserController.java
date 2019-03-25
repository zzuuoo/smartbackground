package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.*;
import com.zuo.smartbackground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "getAdminByAccount",method = RequestMethod.GET)
    public Admin getAdminByAccount(String account)
    {
        return userService.getAdminByAccount(account);
    }
    @ResponseBody
    @RequestMapping(value = "getDoctorByAccount",method = RequestMethod.GET)
    public Doctor getDoctorByAccount(String account)
    {
        return userService.getDoctorByAccount(account);
    }
    @ResponseBody
    @RequestMapping(value = "getPatientByAccount",method = RequestMethod.GET)
    public Patient getPatientByAccount(String account)
    {
        return userService.getPatientByAccount(account);
    }
    @ResponseBody
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public int insertUser(User user)
    {
        return userService.insertUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "insertDoctor",method = RequestMethod.POST)
    public int insertDoctor(Doctor doctor)
    {
        return userService.insertDoctor(doctor);
    }
    @ResponseBody
    @RequestMapping(value = "insertPatient",method = RequestMethod.POST)
    public int insertPatient(Patient patient)
    {

        return userService.insertPatient(patient);
    }

    @ResponseBody
    @RequestMapping(value = "insertAdmin",method = RequestMethod.POST)
    public int insertAdmin(Admin admin)
    {
        return userService.insertAdmin(admin);
    }
    @ResponseBody
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public int deleteUser(User user)
    {
        return userService.deleteUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "deletePatient",method = RequestMethod.POST)
    public int deletePatient(String account)
    {
        return userService.deletePatient(account);
    }

    @ResponseBody
    @RequestMapping(value = "deleteDoctor",method = RequestMethod.GET)
    public int deleteDoctor(String account)
    {
        return userService.deleteDoctor(account);
    }
    @ResponseBody
    @RequestMapping(value = "deleteAdmin",method = RequestMethod.POST)
    public int deleteAdmin(String account)
    {
        return userService.deleteAdmin(account);
    }

    @ResponseBody
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public int updateUser(User user)
    {
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "updatePatient",method = RequestMethod.POST)
    public int updatePatient(Patient patient)
    {
        return userService.updatePatient(patient);
    }
    @ResponseBody
    @RequestMapping(value = "updateDoctor",method = RequestMethod.POST)
    public int updateDoctor(Doctor doctor)
    {
        return userService.updateDoctor(doctor);
    }
    @ResponseBody
    @RequestMapping(value = "updateAdmin",method = RequestMethod.POST)
    public int updateAdmin(Admin admin)
    {
        return userService.updateAdmin(admin);
    }

    @ResponseBody
    @RequestMapping(value = "getAllDoctor",method = RequestMethod.GET)
    public List<Doctor> getAllDoctor()
    {
        return userService.selectDoctorByExample(null);
    }

    @ResponseBody
    @RequestMapping(value = "getAllPatient",method = RequestMethod.GET)
    public List<Patient> getAllPatient()
    {
        return userService.selectPatientByExample(null);
    }

    @ResponseBody
    @RequestMapping(value = "getAllAdmin",method = RequestMethod.GET)
    public List<Admin> getAllAdmin()
    {
        return userService.selectAdminByExample(null);
    }
    @ResponseBody
    @RequestMapping(value = "getDoctorBySection",method = RequestMethod.GET)
    public List<Doctor> getDoctorBySection(Integer sectionId)
    {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andSectionIdEqualTo(sectionId);
        List<Doctor> doctors = userService.selectDoctorByExample(doctorExample);
        System.out.println(doctors.get(0).getHonour());
        return doctors;
    }
    @ResponseBody
    @RequestMapping(value = "get_user_by_account_and_status",method = RequestMethod.GET)
    public List<User> get_user_by_account_and_status(String account,Integer status)
    {
        return userService.getUserByAccountAndStatus(account,status);
    }


}
