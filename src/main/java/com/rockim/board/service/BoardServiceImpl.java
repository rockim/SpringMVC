package com.rockim.board.service;

import com.rockim.board.dao.BoardDao;
import com.rockim.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    @Autowired
    public BoardDao boardDao;

    public List<Board> listAll() throws Exception{
        return boardDao.listAll();
    }

    public void create(Board board) throws Exception{
        String title = board.getTitle();
        String content = board.getContent();
        String writer = board.getWriter();


        title = title.replace("<", "%lt;");
        title = title.replace(">","&gt;");
        writer = writer.replace("<", "%lt;");
        writer = writer.replace(">","&gt;");
        title = title.replace(" ","&nbsp;&nbsp;");
        writer = writer.replace(" ","&nbsp;&nbsp;");
        content = content.replace("\n","<br>");
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        System.out.println(
                "title: "+title+" writer: "+writer+" content : "+content
        );
        boardDao.create(board);
    }

    public Board read(int bno) throws Exception{
        return boardDao.read(bno);
    }

    public void update(Board board) throws Exception{
        boardDao.update(board);
    }

    public void delete(int bno) throws Exception{
        boardDao.delete(bno);
    }

    public void increaseViewcnt(int bno, HttpSession session) throws  Exception{
        long update_time = 0;
        if(session.getAttribute("update_time_"+bno) != null){
            update_time = (long)session.getAttribute("update_time_"+bno);
        }
        long current_time = System.currentTimeMillis();
        if(current_time - update_time > 5 * 1000){
            boardDao.increaseViewcnt(bno);
            session.setAttribute("update_time_"+bno,current_time);
        }
    }
}
