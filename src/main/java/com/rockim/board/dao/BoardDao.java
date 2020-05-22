package com.rockim.board.dao;

import com.rockim.board.model.Board;

import java.util.List;

public interface BoardDao {
    public List<Board> listAll() throws Exception;
}
