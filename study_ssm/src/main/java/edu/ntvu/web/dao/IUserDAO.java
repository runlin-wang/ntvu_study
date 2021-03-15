package edu.ntvu.web.dao;

import edu.ntvu.web.entity.User;

import java.util.List;

/**
 * @author alin
 * @Package edu.ntvu.web.dao
 * @date 2021/3/15 20:28
 * @description todo
 */
public interface IUserDAO {
    public boolean add(User user);

    public int delete(String no);

    public int edit(User user);

    public User select(String no);
}
