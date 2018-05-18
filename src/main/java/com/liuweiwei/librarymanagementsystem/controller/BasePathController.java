package com.liuweiwei.librarymanagementsystem.controller;

import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 根目录映射类
 */
@Controller
@RequestMapping("/")
public class BasePathController {
    @GetMapping("/userLogin")
    public String loginView(){
        return "login";
    }
    @GetMapping("/bookList")
    public ModelAndView list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "6") Integer pageSize) {
        model.addAttribute("title", "图书列表");
        try {
            PageInfo<Book> pageInfo = Constant.ServiceFacade.getBookService().list(pageNum,pageSize);
            //获得当前页
            model.addAttribute("pageNum", pageInfo.getPageNum());
            //获得一页显示的条数
            model.addAttribute("pageSize", pageInfo.getPageSize());
            //是否是第一页
            model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
            //获得总页数
            model.addAttribute("totalPages", pageInfo.getPages());
            //是否是最后一页
            model.addAttribute("isLastPage", pageInfo.isIsLastPage());
            model.addAttribute("books", pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("bookList", "bookModel", model);
    }

    @GetMapping("/bookView/{id}")
    public ModelAndView bookView(@PathVariable("id") int id, Model model){
        Book book = null;
        try {
            book = Constant.ServiceFacade.getBookService().select(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("book", book);

        return new ModelAndView("bookView", "bookModel", model);
    }

}
