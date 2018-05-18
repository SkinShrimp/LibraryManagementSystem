package com.liuweiwei.librarymanagementsystem.service;


import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.entity.Book;

import java.util.List;

public interface BookService {

    void insert(Book book) throws Exception;

    void delete(int id) throws Exception;

    Book select(int id) throws Exception;

    void update(Book book) throws Exception;

    int save(Book book) throws Exception;

    PageInfo<Book> list(Integer pageNum, Integer pageSize) throws Exception;

    List<Book> list(String order, int page, int size) throws Exception;

    int count() throws Exception;
}
