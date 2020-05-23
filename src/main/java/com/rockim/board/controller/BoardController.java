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

    @RequestMapping(value="write",method = RequestMethod.GET)
    public String write(){
        return "write";
    }


    @RequestMapping(value="insert",method={RequestMethod.GET,RequestMethod.POST})
    public String insert(@ModelAttribute Board board) throws Exception{
        boardService.create(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "view",method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws  Exception{
        boardService.increaseViewcnt(bno, session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view");
        mav.addObject("dto",boardService.read(bno));
        return mav;
    }

    @RequestMapping(value="update",method = {RequestMethod.GET,RequestMethod.POST})
    public String update(@ModelAttribute Board board) throws Exception{
        boardService.update(board);
        return "redirect:board";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int bno) throws Exception{
        boardService.delete(bno);
        return "redirect:board";
    }
}
