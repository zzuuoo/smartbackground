package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Book;

public interface BookService {
    int createBook(Book book);
    int cancleBook(Book book);
    int updateBook(Book book);
}
