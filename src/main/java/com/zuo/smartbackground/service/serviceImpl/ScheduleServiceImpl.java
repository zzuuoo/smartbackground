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
        return 0;
    }

    @Override
    public int cancleScheduleList(List<Schedule> schedules) {
        return 0;
    }

    //当事务提交了才释放该行级锁
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public int bookSchedule(int scheduleID) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andScheduleIdEqualTo(scheduleID);
        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleID);
        int res = 0;
        if(schedule!=null&&schedule.getRemainder()>0)
        {
            Schedule s = new Schedule();
            s.setRemainder(schedule.getRemainder()-1);
            res =  scheduleMapper.updateByExampleSelective(s,scheduleExample);
        }
        if(res==1)
        {
//            Book book = new Book();
//            book.setScheduleId(scheduleID);
//            book.setBookTime(new Date());
//            book.setIsAvaliablity(true);
//            book.setIsCancle(false);
////            book.setPatientId();
//            bookMapper.insertSelective(book);
        }

        return res;

    }
    //当事务提交了才释放该行级锁
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public int unBookSchedule(int scheduleID) {
        ScheduleExample scheduleExample = new ScheduleExample();
        scheduleExample.createCriteria().andScheduleIdEqualTo(scheduleID);
        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleID);
        if(schedule!=null)
        {
            Schedule s = new Schedule();
            s.setRemainder(schedule.getRemainder()+1);
            return scheduleMapper.updateByExampleSelective(s,scheduleExample);
        }else{
            return 0;
        }
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
