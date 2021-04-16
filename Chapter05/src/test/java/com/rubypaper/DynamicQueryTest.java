package com.rubypaper;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.DynamicBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery() {
        String searchCondition = "TITLE";
        String searchKeyword = "테스트 제목 10";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qboard = QBoard.board;

        if(searchCondition.equals("TITLE")) {
            builder.and(qboard.title.like("%" + searchKeyword + "%"));
        } else if(searchCondition.equals("CONTENT")) {
            builder.and(qboard.content.like("%" + searchKeyword + "%"));
        }

        Pageable paging = PageRequest.of(0,5);

        Page<Board> boardList = boardRepo.findAll(builder, paging);

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }
}
