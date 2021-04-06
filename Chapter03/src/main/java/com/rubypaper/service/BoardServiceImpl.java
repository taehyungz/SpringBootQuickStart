package com.rubypaper.service;

import com.rubypaper.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    public String hello(String name) {
        return "Hello : " + name;
    }

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