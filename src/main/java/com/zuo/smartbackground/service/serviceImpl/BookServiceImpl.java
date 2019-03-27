package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.BookMapper;
import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.model.BookExample;
import com.zuo.smartbackground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public int createBook(Book book) {
        return bookMapper.insertSelective(book);
    }

    @Override
    public int cancleBook(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
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
