package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.BookMapper;
import com.zuo.smartbackground.dao.ScheduleMapper;
import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.model.BookExample;
import com.zuo.smartbackground.model.Schedule;
import com.zuo.smartbackground.model.ScheduleExample;
import com.zuo.smartbackground.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int createBook(Book book) {
        int res = 0;
        res = scheduleMapper.updateRemainder(book.getScheduleId());

        if(res==1)
        {
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
}
