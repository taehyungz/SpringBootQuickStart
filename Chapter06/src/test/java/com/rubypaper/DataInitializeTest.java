package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInitializeTest {
    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testDataInsert() {
        Member member1 = new Member();
        member1.setId("member1");
        member1.setName("둘리");
        member1.setPassword("member111");
        member1.setRole("ROLE_USER");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setName("도우너");
        member2.setPassword("member222");
        member2.setRole("ROLE_ADMIN");
        memberRepo.save(member2);

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setWriter("둘리");
            board.setTitle("둘리가 등록한 게시글" + i);
            board.setContent("둘리가 등록한 게시글 내용 " + i);
            boardRepo.save(board);
        }

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setWriter("도우너");
            board.setTitle("도우너가 등록한 게시글" + i);
            board.setContent("도우너가 등록한 게시글 내용 " + i);
            boardRepo.save(board);
        }
    }
}
