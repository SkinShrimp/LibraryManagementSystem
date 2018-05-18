package com.liuweiwei.librarymanagementsystem.config;

import com.liuweiwei.librarymanagementsystem.service.BookService;
import com.liuweiwei.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ServiceFacade")
public class ServiceFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
