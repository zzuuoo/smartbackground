package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Schedule;

import java.util.List;

public interface ScheduleService {
    int arrangeSchedule(Schedule schedule);
    int arrangeScheduleList(List<Schedule> schedules);
    int cancleSchedule(Schedule schedule);
    int cancleScheduleList(List<Schedule> schedules);
    int bookSchedule(int scheduleID);
    int unBookSchedule(int scheduleID);
    List<Schedule> getScheduleByDoctorID(int doctorID);
    List<Schedule> getAllSchedule();
    List<Schedule> getAllFromNowSchedule();

    List<Schedule> getValiScheduleByDoctorId(int doctorID);

}
