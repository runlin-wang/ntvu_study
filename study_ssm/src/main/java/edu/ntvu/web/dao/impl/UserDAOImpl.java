package edu.ntvu.web.dao.impl;

import edu.ntvu.web.dao.IUserDAO;
import edu.ntvu.web.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author alin
 * @Package edu.ntvu.web.dao.impl
 * @date 2021/3/15 20:48
 * @description 操作用户数据库类
 */
public class UserDAOImpl implements IUserDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(User user) {
        String sql = "insert into user (no, name, gender, age) VALUES(?, ?, ?, ?)";
        
        return false;
    }

    @Override
    public int delete(String no) {
        String sql = "delete from user where no = ?";
        Object[] params = {no};
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int edit(User user) {
        return 0;
    }

    @Override
    public User select(String no) {
        String sql = "select * from user where no=?";
        Object[] params = {no};
//        return jdbcTemplate.(sql);
        return null;
    }
}
