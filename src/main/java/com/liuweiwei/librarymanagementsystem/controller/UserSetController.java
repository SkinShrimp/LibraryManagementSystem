package com.liuweiwei.librarymanagementsystem.controller;

import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户设置管理
 */
@Controller
@RequestMapping("/userInfoManage")
public class UserSetController {
    @GetMapping("/userInfo")
    public String userSet(){
        return "/userInfoManage/userInfo";
    }

    @GetMapping("/initInfo")
    public ModelAndView userSetting(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        String username = userDetails.getUsername();
        User user = Constant.DaoFacade.getUserDao().findByLogin(username);
        model.addAttribute("user",user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    @GetMapping("/photoUpload")
    public String photoUpload(){
        return "/userInfoManage/photoUpload";
    }

    @GetMapping("/photoSet")
    public String photoSet(){
        return "/userInfoManage/photoSet";
    }
}
