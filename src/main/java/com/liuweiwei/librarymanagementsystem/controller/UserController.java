package com.liuweiwei.librarymanagementsystem.controller;

import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/*
 * 类描述：用户维护controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
        model.addAttribute("title", "用户列表");
        try {
            PageInfo<User> pageInfo = Constant.ServiceFacade.getUserService().list(pageNum,pageSize);
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
            model.addAttribute("users", pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("user/list", "userModel", model);
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
        User user = null;
        try {
            user = Constant.ServiceFacade.getUserService().select(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user",user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("user/view", "userModel", model);
    }

    /**
     * 获取创建表单
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("user/form", "userModel", model);
    }


    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ModelAndView createUser(@ModelAttribute(value = "user") User user,Model model) {
        int useId = user.getId();
        try {
            Constant.ServiceFacade.getUserService().save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(useId > 0) {
            model.addAttribute("title", "修改用户");
            return new ModelAndView("user/form", "userModel", model);
        }
        model.addAttribute("title", "新增用户");
        return new ModelAndView("index", "userModel", model);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id, Model model) {
        try {
            Constant.ServiceFacade.getUserService().delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "删除用户");
        return new ModelAndView("redirect:/user/list");
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/modify/{id}")
    public ModelAndView modifyForm(@PathVariable(value = "id") int id,Model model) {
        try {
            User user = Constant.ServiceFacade.getUserService().select(id);
            if(user != null){
                user.changeToDate();
            }
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form","userModel",model);
    }
}
