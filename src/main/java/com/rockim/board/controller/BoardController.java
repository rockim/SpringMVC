package com.rockim.board.controller;

import com.rockim.board.model.Board;
import com.rockim.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value="/write",method = RequestMethod.GET)
    public ModelAndView showWrite(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("write");
        mav.addObject("board", new Board());
        return mav;
    }


    @RequestMapping(value="writeProcess",method={RequestMethod.POST})
    public String addBoard(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("board") Board board) throws Exception{
        boardService.create(board);
        return "redirect:board";
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response,@RequestParam int bno, HttpSession session) throws  Exception{
        boardService.increaseViewcnt(bno, session);
        ModelAndView mav = new ModelAndView("view");
        mav.addObject("board", new Board());
        mav.addObject("dto",boardService.read(bno));
        return mav;
    }

    @RequestMapping(value="viewProcess",method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("board") Board board, @RequestParam int  bno,@RequestParam("update") String action) throws Exception{
        if(action.equals("update")) {
            boardService.update(board);
        }
        else{
            boardService.delete(bno);
        }
        return "redirect:board";
    }
}
