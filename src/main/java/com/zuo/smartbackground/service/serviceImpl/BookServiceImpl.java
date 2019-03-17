package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.BookMapper;
import com.zuo.smartbackground.model.Book;
import com.zuo.smartbackground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
