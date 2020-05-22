package com.rockim.board.service;

import com.rockim.board.model.Board;
import java.util.List;

public interface BoardService {
    public List<Board> listAll() throws Exception;
}
