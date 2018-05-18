package com.liuweiwei.librarymanagementsystem.dao;



import com.liuweiwei.librarymanagementsystem.entity.Book;

import java.util.List;

/**
 * 用户管理类
 **/
public interface BookDao{
    public void save(Book book);
    /**
     * 通过id删除书
     * @param id
     */
    public void delete(int id);

    /**
     *
     * @param name
     * @return
     */
    Book findByName(String name);

    /**
     * 通过用户id来查询用户
     * @param id
     * @return
     */
    Book findById(int id);
    void update(Book book);
    public List<Book> loadAll();

}