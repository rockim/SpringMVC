package com.rockim.board.service;

import com.rockim.board.model.Board;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BoardService {
    public List<Board> listAll() throws Exception;

    public void create(Board board) throws Exception;

    public Board read(int bno) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(int bno) throws Exception;

    public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
