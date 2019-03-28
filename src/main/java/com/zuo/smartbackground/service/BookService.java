package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Book;

import java.util.List;

public interface BookService {
    int createBook(Book book);
    int cancleBook(Book book);
//    int updateBook(Book book);
    List<Book> getAllValidBook();
    List<Book> getValidBooKByScheduleId(int scheduleId);
    List<Book> getValidBookByPatientId(int patientId);

    List<Book> getAllBook();
    List<Book> getBooKByScheduleId(int scheduleId);
    List<Book> getBookByPatientId(int patientId);

}
