package com.rubypaper.controller;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionAttributes("member")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null) {
            return "redirect:login";
        }
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Hello 타임리프.^^");
    }

    @ModelAttribute("member")
    public Member setMember() {

        return new Member();
    }
}
