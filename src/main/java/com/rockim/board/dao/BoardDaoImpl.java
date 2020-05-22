package com.rockim.board.dao;

import com.rockim.board.model.Board;
import com.rockim.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoardDaoImpl implements BoardDao{
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Board> listAll() throws Exception{
        String sql = "SELECT bno,title,content,writer,regDate,viewCnt FROM db_board.board";
        List<Board> boards = jdbcTemplate.query(sql,new BoardMapper());
        return boards;
    }

    class BoardMapper implements RowMapper<Board> {
        public Board mapRow(ResultSet rs, int arg1) throws SQLException {
            Board board = new Board();

            board.setBno(rs.getInt("bno"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getTimestamp("regDate"));
            board.setViewCnt(rs.getInt("viewCnt"));

            return board;
        }

    }
}
