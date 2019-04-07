package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.BookMapper;
import com.zuo.smartbackground.dao.DoctorMapper;
import com.zuo.smartbackground.dao.PatientMapper;
import com.zuo.smartbackground.dao.ScheduleMapper;
import com.zuo.smartbackground.model.*;
import com.zuo.smartbackground.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private PatientMapper patientMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int createBook(CBook cbook) {
        int res = 0;
        res = scheduleMapper.updateRemainder(cbook.getScheduleId());

        if(res==1)
        {
            Book book = new Book();
            book.setIsCancle(false);
            book.setIsAvaliablity(true);
            book.setBookTime(new Date());
            book.setScheduleId(cbook.getScheduleId());
            PatientExample patientExample = new PatientExample();
            patientExample.createCriteria().andAccountEqualTo(cbook.getAccount());
            List<Patient> patients = patientMapper.selectByExample(patientExample);
            if(patients==null||patients.size()<1){
                return 0;
            }
            book.setPatientId(patients.get(0).getPatientId());
            return bookMapper.insertSelective(book);
        }else{
            logger.warn("更新schedule的挂号数失败");
            return 0;
        }

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int cancleBook(Book book) {
        int res = 0;
        res = scheduleMapper.updateUnRemainder(book.getScheduleId());

        if(res==1)
        {
            return bookMapper.updateByPrimaryKeySelective(book);
        }else{
            logger.warn("更新schedule的挂号数失败");
            return 0;
        }

    }



    @Override
    public List<Book> getAllValidBook() {
        BookExample bookExample =new BookExample();
        bookExample.createCriteria().andBookTimeGreaterThan(new Date())
                .andIsAvaliablityEqualTo(true)
                .andIsCancleEqualTo(false);
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getValidBooKByScheduleId(int scheduleId) {
        BookExample bookExample =new BookExample();
        bookExample.createCriteria().andBookTimeGreaterThan(new Date())
                .andIsAvaliablityEqualTo(true)
                .andIsCancleEqualTo(false)
                .andScheduleIdEqualTo(scheduleId);
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getValidBookByPatientId(int patientId) {
        BookExample bookExample =new BookExample();
        bookExample.createCriteria().andBookTimeGreaterThan(new Date())
                .andIsAvaliablityEqualTo(true)
                .andIsCancleEqualTo(false)
                .andPatientIdEqualTo(patientId);
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getAllBook() {
        return bookMapper.selectByExample(null);
    }

    @Override
    public List<Book> getBooKByScheduleId(int scheduleId) {
        BookExample bookExample =new BookExample();
        bookExample.createCriteria()
                .andScheduleIdEqualTo(scheduleId);
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getBookByPatientId(int patientId) {
        BookExample bookExample =new BookExample();
        bookExample.createCriteria()
                .andPatientIdEqualTo(patientId);
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getBookByAccount(String account) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAccountEqualTo(account);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if(patients==null||patients.size()<1){
            return null;
        }
        return  getBookByPatientId(patients.get(0).getPatientId());
    }

    @Override
    public List<BookDocSche> showBook(String account) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAccountEqualTo(account);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if(patients==null||patients.size()<1){
            return null;
        }
        BookExample bookExample =new BookExample();
        bookExample.createCriteria()
                .andPatientIdEqualTo(patients.get(0).getPatientId())
        .andIsAvaliablityEqualTo(true)
        .andIsCancleEqualTo(false);
        List<Book> books = bookMapper.selectByExample(bookExample);
        List<BookDocSche> bookDocSches = new ArrayList<>();
        if(books==null||books.size()<1){
            return null;
        }
        for(Book book:books){
                ScheduleExample scheduleExample = new ScheduleExample();
                scheduleExample.createCriteria().andScheduleIdEqualTo(book.getScheduleId());
                List<Schedule> s = scheduleMapper.selectByExample(scheduleExample);
                if(s!=null&&s.size()>0){
                    Schedule s1 = s.get(0);
                    DoctorExample doctorExample = new DoctorExample();
                    doctorExample.createCriteria().andDoctorIdEqualTo(s.get(0).getDoctorId());
                    List<Doctor> d = doctorMapper.selectByExample(doctorExample);
                    if(d!=null&&d.size()>0){
                        BookDocSche docSche = new BookDocSche();
                        docSche.setBook(book);
                        docSche.setDoctor(d.get(0));
                        docSche.setSchedule(s.get(0));
                        bookDocSches.add(docSche);
                    }

            }
        }
        return bookDocSches;
    }
}
