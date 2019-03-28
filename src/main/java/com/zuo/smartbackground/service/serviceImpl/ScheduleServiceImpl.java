package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.BookMapper;
import com.zuo.smartbackground.dao.DoctorMapper;
import com.zuo.smartbackground.dao.ScheduleMapper;
import com.zuo.smartbackground.model.MakeSchedule;
import com.zuo.smartbackground.model.Schedule;
import com.zuo.smartbackground.model.ScheduleExample;
import com.zuo.smartbackground.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public int arrangeSchedule(Schedule schedule) {
        return scheduleMapper.insertSelective(schedule);
    }

    @Override
    public int arrangeScheduleList(List<Schedule> schedules) {
        int i = 0;
        for(Schedule s:schedules)
        {
            i = scheduleMapper.insertSelective(s);
        }
        return i;
    }

    @Override
    public int cancleSchedule(Schedule schedule) {
        return scheduleMapper.updateByPrimaryKeySelective(schedule);
    }

    @Override
    public int cancleScheduleList(List<Schedule> schedules)
    {
        int i = 0;
        for(Schedule s:schedules)
        {
            i = scheduleMapper.updateByPrimaryKeySelective(s);
        }
        return i;
    }



    @Override
    public int makeSche(MakeSchedule makeSchedule) {
        Schedule schedule = new Schedule();
        schedule.setRemainder(makeSchedule.getRemainder());
        schedule.setDoctorId(makeSchedule.getDoctorId());
        schedule.setWorkTimeStart(makeSchedule.getDate());
        return 0;
    }

    @Override
    public List<Schedule> getScheduleByDoctorID(int doctorID) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andDoctorIdEqualTo(doctorID);
        return scheduleMapper.selectByExample(scheduleExample);
    }

    @Override
    public List<Schedule> getScheduleBySessionID(int sectionID) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andDoctorIdIn(doctorMapper.selectBySectionId(sectionID))
                .andWorkTimeStartGreaterThan(new Date(new Date().getTime()));
        return scheduleMapper.selectByExample(scheduleExample);
    }

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleMapper.selectByExample(null);
    }

    @Override
    public List<Schedule> getAllFromNowSchedule() {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andWorkTimeStartGreaterThanOrEqualTo(new Date());
        return scheduleMapper.selectByExample(scheduleExample);
    }

    @Override
    public List<Schedule> getValiScheduleByDoctorId(int doctorID) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria()
                .andWorkTimeStartGreaterThanOrEqualTo(new Date(new Date().getTime()+3600*2))
                .andDoctorIdEqualTo(doctorID);
        return scheduleMapper.selectByExample(scheduleExample);
    }
}
