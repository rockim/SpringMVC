package com.rockim.board.service;

import com.rockim.board.dao.BoardDao;
import com.rockim.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardServiceImpl implements BoardService {
    @Autowired
    public BoardDao boardDao;

    public List<Board> listAll() throws Exception{
        return boardDao.listAll();
    }
}
