package com.rubypaper.controller;

import com.rubypaper.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController //리턴되는 문자열을 그대로 브라우저에 출력함
public class BoardController {

    public BoardController() {
        System.out.println("===> BoardController 생성");
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello : " + name;
    }

    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목...");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다..............");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        for(int i=1; i<=10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("제목"+ i);
            board.setWriter("테스터");
            board.setContent(i+"번 테스트 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }
}
