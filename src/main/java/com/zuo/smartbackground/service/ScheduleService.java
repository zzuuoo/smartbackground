package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.model.MakeSchedule;
import com.zuo.smartbackground.model.Schedule;

import java.util.List;

public interface ScheduleService {
    int arrangeSchedule(Schedule schedule);
    int arrangeScheduleList(List<Schedule> schedules);
    int cancleSchedule(Schedule schedule);
    int cancleScheduleList(List<Schedule> schedules);
//    int bookSchedule(int scheduleID);
//    int unBookSchedule(int scheduleID);
    int makeSche(MakeSchedule makeSchedule);
    List<Schedule> getScheduleByDoctorID(int doctorID);
    List<Schedule> getScheduleBySessionID(int sectionID);
    List<Schedule> getAllSchedule();
    List<Schedule> getAllFromNowSchedule();

    List<Schedule> getValiScheduleByDoctorId(int doctorID);

    int deleteSchedule(int scheduleId);
    int updateSchedule(Schedule schedule);

    List<Schedule> getScheduleByBookList(List<Book> books);

    List<Schedule> getScheduleByDoctorAccount(String account);

}
