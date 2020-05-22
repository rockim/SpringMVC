package com.rockim.board.controller;

import com.rockim.board.model.Board;
import com.rockim.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/board")
    public ModelAndView listAll() throws Exception{
        List<Board> list = boardService.listAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board");
        mav.addObject("list",list);

        return mav;
    }

}
