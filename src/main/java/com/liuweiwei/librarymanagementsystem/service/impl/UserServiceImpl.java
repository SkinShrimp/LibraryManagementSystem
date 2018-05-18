package com.liuweiwei.librarymanagementsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.config.Constant;
import com.liuweiwei.librarymanagementsystem.entity.User;
import com.liuweiwei.librarymanagementsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void insert(User user) throws Exception {
        Constant.DaoFacade.getUserDao().save(user);
    }

    @Override
    public void delete(int id) throws Exception {
        Constant.DaoFacade.getUserDao().delete(id);
    }

    @Override
    public User select(int id) throws Exception {
        return Constant.DaoFacade.getUserDao().findById(id);
    }

    @Override
    public void update(User user) throws Exception {
        Constant.DaoFacade.getUserDao().update(user);
    }

    @Override
    public int save(User user) throws Exception {
        if (user == null) {
            return 0;
        }
        if (user.getId() > 0){
            update(user);
        } else {
            user.setDelete_flag("0");
            insert(user);
        }
        return user.getId();
    }
    @Override
    public PageInfo<User> list(Integer pageNum,Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<> (Constant.DaoFacade.getUserDao().loadAll());
    }


    @Override
    public List<User> list(String order, int page, int size) throws Exception {
        return null;
    }

    @Override
    public int count() throws Exception {
        return 0;
    }
}
