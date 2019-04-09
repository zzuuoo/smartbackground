package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.model.BookDocSche;
import com.zuo.smartbackground.model.BookPatientSche;
import com.zuo.smartbackground.model.CBook;
import com.zuo.smartbackground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;


    @RequestMapping(value = "createBook",method = RequestMethod.POST)
    public int createBook(CBook cbook){

        return bookService.createBook(cbook);
    }


    @RequestMapping(value = "cancleBook",method = RequestMethod.POST)
    public int cancleBook(Book book){
        return bookService.cancleBook(book);
    }



    @RequestMapping(value = "getAllValidBook",method = RequestMethod.GET)
    public List<Book> getAllValidBook(){
        return bookService.getAllValidBook();
    }

    @RequestMapping(value = "getAllBook",method = RequestMethod.GET)
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @RequestMapping(value = "getValidBooKByScheduleId",method = RequestMethod.GET)
    public List<Book> getValidBooKByScheduleId(Integer scheduleId){
        return bookService.getValidBooKByScheduleId(scheduleId);
    }

    @RequestMapping(value = "getValidBookByPatientId",method = RequestMethod.GET)
    public List<Book> getValidBookByPatientId(Integer patientId){
        return bookService.getValidBookByPatientId(patientId);
    }

    @RequestMapping(value = "getBooKByScheduleId",method = RequestMethod.GET)
    public List<Book> getBooKByScheduleId(Integer scheduleId){
        return bookService.getBooKByScheduleId(scheduleId);
    }

    @RequestMapping(value = "getBookByPatientId",method = RequestMethod.GET)
    public List<Book> getBookByPatientId(Integer patientId){
        return bookService.getBookByPatientId(patientId);
    }
    @RequestMapping(value = "getBookByAccount",method = RequestMethod.GET)
    public List<Book> getBookByAccount(String account){
        return bookService.getBookByAccount(account);
    }

    @RequestMapping(value = "showBookByAccount",method = RequestMethod.GET)
    public List<BookDocSche> showBookByAccount(String account){
        return bookService.showBook(account);
    }

    @RequestMapping(value = "showBookforDoctor",method = RequestMethod.GET)
    public List<BookPatientSche> showBookforDoctor(Integer scheduleId){
        return bookService.showBookForDoctor(scheduleId);
    }


}
