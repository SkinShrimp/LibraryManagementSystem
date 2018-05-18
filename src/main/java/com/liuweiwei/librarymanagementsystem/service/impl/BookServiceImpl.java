package com.liuweiwei.librarymanagementsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.Book;
import com.liuweiwei.librarymanagementsystem.entity.BookList;
import com.liuweiwei.librarymanagementsystem.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Override
    public void insert(Book book) throws Exception {
        Constant.DaoFacade.getBookDao().save(book);
    }

    @Override
    public void delete(int id) throws Exception {
        Constant.DaoFacade.getBookDao().delete(id);
    }

    @Override
    public Book select(int id) throws Exception {
        return Constant.DaoFacade.getBookDao().findById(id);
    }

    @Override
    public void update(Book book) throws Exception {
        Constant.DaoFacade.getBookDao().update(book);
    }

    @Override
    public int save(Book book) throws Exception {
        if (book == null) {
            return 0;
        }
        if (book.getId() > 0){
            update(book);
        } else {
            book.setDelete_flag("0");
            insert(book);
        }
        return book.getId();
    }
    @Override
    public PageInfo<Book> list(Integer pageNum,Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<Book> (Constant.DaoFacade.getBookDao().loadAll());
    }

/*    public PageInfo<BookList> listIndex(Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List Book = Constant.DaoFacade.getBookDao().loadAll();
        if(Book != null && Book.size()>0){
            int zheng = Book.size() / 4;
            int yu = Book.size() % 4;
            for(int i = 0; i < zheng; i++){

            }
        }
        return new PageInfo<Book> ();
    }*/

    @Override
    public List<Book> list(String order, int page, int size) throws Exception {
        return null;
    }

    @Override
    public int count() throws Exception {
        return 0;
    }
}
