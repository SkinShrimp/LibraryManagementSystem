package com.liuweiwei.librarymanagementsystem.dao;



import com.liuweiwei.librarymanagementsystem.common.dao.GenericDao;
import com.liuweiwei.librarymanagementsystem.entity.QueryUser;
import com.liuweiwei.librarymanagementsystem.entity.User;

import java.util.List;

/**
 * 用户管理类
 **/
public interface UserDao extends GenericDao<User, QueryUser> {

    /**
     * 通过id删除用户
     * @param id
     */
    public void delete(int id);
    /**
     * 功能描述：根据账号来获取用户信息
     * @param userName
     * @return
     */
    User findByLogin(String userName);

    /**
     * 通过用户id来查询用户
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 查询用户列表
     * @return
     */
    @Override
    public List<User> loadAll();

}