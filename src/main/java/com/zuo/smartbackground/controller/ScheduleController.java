package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.Schedule;
import com.zuo.smartbackground.model.ScheduleT;
import com.zuo.smartbackground.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping(value = "/getValiScheduleByDoctorId",method = RequestMethod.GET)
    public List<Schedule> getValiScheduleByDoctorId(int doctorId){
        return scheduleService.getValiScheduleByDoctorId(doctorId);
    }


    @RequestMapping(value = "/getScheduleByDoctorId",method = RequestMethod.GET)
    public List<Schedule> getScheduleByDoctorId(int doctorId){
        return scheduleService.getScheduleByDoctorID(doctorId);
    }

    @RequestMapping(value = "/getScheduleBySectionId",method = RequestMethod.GET)
    public List<Schedule> getScheduleBySectionId(int sectionId){
        List<Schedule> schedules = scheduleService.getScheduleBySessionID(sectionId);
        return schedules;
    }


    @RequestMapping(value = "/getAllSchedlue",method = RequestMethod.GET)
    public List<Schedule> getAllSchedlue(){
        return scheduleService.getAllSchedule();
    }

//    @RequestMapping(value = "/bookSchedlue",method = RequestMethod.GET)
//    public int bookSchedule(int scheduleId){
//        return scheduleService.bookSchedule(scheduleId);
//    }

//    @RequestMapping(value = "/unBookSchedule",method = RequestMethod.GET)
//    public int unBookSchedule(int scheduleId){
//        return scheduleService.unBookSchedule(scheduleId);
//    }

    @RequestMapping(value = "/arrangeSchedule",method = RequestMethod.POST)
    public int arrangeSchedule(ScheduleT schedule){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(new Date(schedule.getWorkTimeStart())));
        Schedule s = new Schedule();
        s.setWorkTimeStart(new Date(schedule.getWorkTimeStart()));
        s.setW(schedule.getW());
        s.setDoctorId(schedule.getDoctorId());
        s.setRemainder(schedule.getRemainder());
        s.setIsCancle(schedule.getIsCancle());
//        int x = -1;
//        if (s.getW()==0){
//            s.setW(1);
//            x=x+scheduleService.arrangeSchedule(s);
//            s.setW(2);
//            x=x+scheduleService.arrangeSchedule(s);
//        }
        return scheduleService.arrangeSchedule(s);
//        return 1;
    }

    @RequestMapping(value = "/arrangeScheduleList",method = RequestMethod.POST)
    public int arrangeScheduleList(List<Schedule> schedules){
        return scheduleService.arrangeScheduleList(schedules);
    }

    @RequestMapping(value = "/getAllFromNowSchedule",method = RequestMethod.GET)
    public List<Schedule> getAllFromNowSchedule(){
        return scheduleService.getAllFromNowSchedule();
    }

    @RequestMapping(value = "/deleteSchedule",method = RequestMethod.GET)
    public int deleteSchedule(int scheduleId){
//        Schedule schedule = new Schedule();
//        schedule.setScheduleId(scheduleId);
//        schedule.setIsCancle(true);
//        return scheduleService.updateSchedule(schedule);
        return scheduleService.deleteSchedule(scheduleId);
    }
    @RequestMapping(value ="/getScheduleByDoctorAccount",method = RequestMethod.GET)
    public List<Schedule> getScheduleByDoctorAccount(String account){
        return scheduleService.getScheduleByDoctorAccount(account);
    }

}
