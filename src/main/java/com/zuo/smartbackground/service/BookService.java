package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.model.BookDocSche;
import com.zuo.smartbackground.model.BookPatientSche;
import com.zuo.smartbackground.model.CBook;

import java.util.List;

public interface BookService {
    int createBook(CBook cbook);
    int cancleBook(Book book);
//    int updateBook(Book book);
    List<Book> getAllValidBook();
    List<Book> getValidBooKByScheduleId(int scheduleId);
    List<Book> getValidBookByPatientId(int patientId);

    List<Book> getAllBook();
    List<Book> getBooKByScheduleId(int scheduleId);
    List<Book> getBookByPatientId(int patientId);

    List<Book> getBookByAccount(String account);

    List<BookDocSche> showBook(String account);

    List<BookPatientSche> showBookForDoctor(Integer scheduleId);

}
