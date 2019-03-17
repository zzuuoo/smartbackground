package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "createBook",method = RequestMethod.POST)
    public int createBook(Book book){
        return bookService.createBook(book);
    }

    @ResponseBody
    @RequestMapping(value = "cancleBook",method = RequestMethod.POST)
    public int cancleBook(Book book){
        return bookService.cancleBook(book);
    }

    @ResponseBody
    @RequestMapping(value = "updateBook",method = RequestMethod.POST)
    public int updateBook(Book book){
        return bookService.updateBook(book);
    }
}
