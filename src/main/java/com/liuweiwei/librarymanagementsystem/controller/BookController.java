package com.liuweiwei.librarymanagementsystem.controller;

import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/*
 * 类描述：用户维护controller
 */
@Controller
@RequestMapping("/book")
public class BookController {
    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
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
        return new ModelAndView("book/list", "bookModel", model);
    }

    /**
     * 通过用户id查询用户
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") int id, Model model) {
        Book book = null;
        try {
            book = Constant.ServiceFacade.getBookService().select(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("book",book);
        model.addAttribute("title", "查看图书");
        return new ModelAndView("book/view", "bookModel", model);
    }

    /**
     * 获取创建表单
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("title", "新增图书");
        return new ModelAndView("book/form", "bookModel", model);
    }


    /**
     * @param book
     * @param model
     * @return
     */
    @PostMapping("/add")
    public ModelAndView createBook(@ModelAttribute(value = "book") Book book,Model model) {
        int bookId = book.getId();
        try {
            Constant.ServiceFacade.getBookService().save(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bookId > 0){
            model.addAttribute("title", "修改用户");
            return new ModelAndView("/book/list","bookModel",model);
        }
        model.addAttribute("title", "新增用户");
        return new ModelAndView("book/form","bookModel",model);


    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id, Model model) {
        try {
            Constant.ServiceFacade.getBookService().delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "删除图书");
        return new ModelAndView("redirect:book/list");
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/modify/{id}")
    public ModelAndView modifyForm(@PathVariable(value = "id") int id,Model model) {
        try {
            Book book = Constant.ServiceFacade.getBookService().select(id);
            model.addAttribute("book",book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "修改书籍信息");
        return new ModelAndView("book/form","bookModel",model);
    }
}
