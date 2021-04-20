package com.rubypaper.board.controller;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Search;
import com.rubypaper.board.service.BoardService;
import com.rubypaper.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
        //로그인 성공한 사용자 정보를 이용하기 위해서는 로그인 성공한 회원객체를 가지고 있는 SecurityUser객체를 매개변수로 받는다
        //이 때, SecurityUser타입의 변수 앞에 AuthenticationPrincipal 어노테이션을 추가해야
        //인증정보를 가지고 있는 SecurityUser객체가 할당된다.
        board.setMember(principal.getMember());
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

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Search search) {
        if(search.getSearchCondition() == null) search.setSearchCondition("TITLE");
        if(search.getSearchKeyword() == null) search.setSearchKeyword("");
        Page<Board> boardList = boardService.getBoardList(search);
        model.addAttribute("boardList", boardList);
        return "board/getBoardList";
    }
}
