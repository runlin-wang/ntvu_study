package edu.ntvu.springmvcdemo2.dao;


import edu.ntvu.springmvcdemo2.entity.User;

import java.util.List;

/**
 * @author alin
 * @Package edu.ntvu.web.dao
 * @date 2021/3/15 20:28
 * @description user 数据表操作接口
 */
public interface IUserDAO {
    boolean add(User user);

    int delete(String no);

    int edit(User user);

    List<User> selectByName(String name);

    User selectByNo(String no);
}
