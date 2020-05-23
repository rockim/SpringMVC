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
    public void create(Board board) throws Exception{
        String sql = "INSERT INTO db_board.board(bno,title,content,writer) VALUES((SELECT NVL(MAX(bno)+1, 1)FROM db_board.board),'"+board.getTitle()+"','"+board.getContent()+"','"+board.getWriter()+"'";
        jdbcTemplate.update(sql);
    }
    public void update(Board board) throws Exception{
        String sql = "UPDATE db_board.board SET title = '"+board.getTitle()+"', content = '"+board.getContent()+"', writer = '"+board.getWriter()+"' WHERE bno = '"+board.getBno()+"'";
        jdbcTemplate.update(sql);
    }

    public void delete(int bno) throws Exception{
        String sql = "DELETE FROM db_board.board WHERE bno = '"+bno+"'";
        jdbcTemplate.update(sql);
    }
    public Board read(int bno) throws Exception{
        String sql = "SELECT * FROM db_board.board WHERE bno = '"+bno+"'";
        List<Board> boards =  jdbcTemplate.query(sql,new BoardMapper());
        return boards.get(0);
    }
    public void increaseViewcnt(int bno) throws Exception{
        String sql = "UPDATE db_board.board SET viewCnt = viewCnt + 1 WHERE bno = '"+bno+"'";
        jdbcTemplate.update(sql);
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
