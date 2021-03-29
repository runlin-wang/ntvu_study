package edu.ntvu.springmvcdemo2.dao.impl;

import edu.ntvu.springmvcdemo2.dao.IUserDAO;
import edu.ntvu.springmvcdemo2.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

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
        String sql = "insert into user (name, pwd, salt, real_name, telephone, email, gender, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {user.getUserName(), user.getPwd(), user.getSalt(), user.getRealName(), user.getTelephone(),
                            user.getEmail(), user.isGender(), user.getAge()};
        return jdbcTemplate.update(sql, params) > 0;
    }

    @Override
    public int delete(String no) {
//        String sql = "delete from user where no = ?";
//        Object[] params = {no};
//        return jdbcTemplate.update(sql, params);
        return 0;
    }

    @Override
    public int edit(User user) {
//        String sql = "update user set name = ?, gender = ?, age = ? where no = ?";
//        Object[] params = {user.getName(), user.isGender(), user.getAge(), user.getNo()};
//        return jdbcTemplate.update(sql, params);
        return 0;
    }

    @Override
    public List<User> selectByName(String name) {
        String sql = "select * from user where name like ?";
        Object[] params = {"%" + name + "%"};

        List<User> lst = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, params);

        while (rowSet.next()) {
//            User user = new User(rowSet.getString("no"),
//                    rowSet.getString("name"),
//                    rowSet.getBoolean("gender"),
//                    rowSet.getInt("age"));
//            lst.add(user);
        }

        return lst;
    }

    @Override
    public User selectByNo(String no) {
        String sql = "select * from user where no=?";
        Object[] params = {no};

        return null;
//        return jdbcTemplate.queryForList();
    }
}
