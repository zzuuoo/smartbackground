package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.Schedule;
import com.zuo.smartbackground.model.ScheduleT;
import com.zuo.smartbackground.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @ResponseBody
    @RequestMapping(value = "/getValiScheduleByDoctorId",method = RequestMethod.GET)
    public List<Schedule> getValiScheduleByDoctorId(int doctorId){
        return scheduleService.getValiScheduleByDoctorId(doctorId);
    }

    @ResponseBody
    @RequestMapping(value = "/getScheduleByDoctorId",method = RequestMethod.GET)
    public List<Schedule> getScheduleByDoctorId(int doctorId){
        return scheduleService.getScheduleByDoctorID(doctorId);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllSchedlue",method = RequestMethod.GET)
    public List<Schedule> getAllSchedlue(){
        return scheduleService.getAllSchedule();
    }
    @ResponseBody
    @RequestMapping(value = "/bookSchedlue",method = RequestMethod.GET)
    public int bookSchedule(int scheduleId){
        return scheduleService.bookSchedule(scheduleId);
    }
    @ResponseBody
    @RequestMapping(value = "/unBookSchedule",method = RequestMethod.GET)
    public int unBookSchedule(int scheduleId){
        return scheduleService.unBookSchedule(scheduleId);
    }
    @ResponseBody
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
        return scheduleService.arrangeSchedule(s);
//        return 1;
    }
    @ResponseBody
    @RequestMapping(value = "/arrangeScheduleList",method = RequestMethod.POST)
    public int arrangeScheduleList(List<Schedule> schedules){
        return scheduleService.arrangeScheduleList(schedules);
    }
    @ResponseBody
    @RequestMapping(value = "/getAllFromNowSchedule",method = RequestMethod.GET)
    public List<Schedule> getAllFromNowSchedule(){
        return scheduleService.getAllFromNowSchedule();
    }


}
