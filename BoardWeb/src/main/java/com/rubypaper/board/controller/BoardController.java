package com.rubypaper.board.controller;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {
        Page<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "board/getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "board/getBoard";
    }

    //글 등록 링크 클릭시, 글 등록 화면으로 전환
    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "board/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }
}
