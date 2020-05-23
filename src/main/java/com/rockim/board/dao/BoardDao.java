package com.rockim.board.dao;

import com.rockim.board.model.Board;

import java.util.List;

public interface BoardDao {
    public List<Board> listAll() throws Exception;

    public void create(Board board) throws Exception;

    public void update(Board board) throws Exception;

    public void delete(int bno) throws Exception;

    public Board read(int bno) throws Exception;

    public void increaseViewcnt(int bno) throws Exception;
}
