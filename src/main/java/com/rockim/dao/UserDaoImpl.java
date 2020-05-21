package com.rockim.dao;

import com.rockim.model.Login;
import com.rockim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int register(User user){
        String sql = "insert into users(username,password,firstname,lastname,email,address,phone) values(?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[] {user.getUsername(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
    }
    public User validateUser(Login login) {
        String sql = "SELECT * FROM users WHERE username='" + login.getUsername() + "'";

        List<User> users = jdbcTemplate.query(sql,new UserMapper());
        if (users.size()>0){
            if(users.get(0).getPassword().equals(login.getPassword())){
                return users.get(0);
            }

        }else{
            return null;
        }
        return null;
    }

    class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int arg1) throws SQLException {
            User user = new User();

            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getInt("phone"));

            return user;
        }

    }




}
