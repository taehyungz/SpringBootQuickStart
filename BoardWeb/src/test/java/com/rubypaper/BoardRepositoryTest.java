package com.rubypaper;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Member;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testInsert() {
        Member member1 = new Member();
        member1.setId("member");
        member1.setPassword("member123");
        member1.setName("둘리");
        member1.setRole(Role.ROLE_MEMBER);
        member1.setEnabled(true);
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setId("admin");
        member2.setPassword("admin123");
        member2.setName("도우너");
        member2.setRole(Role.ROLE_ADMIN);
        member2.setEnabled(true);
        memberRepo.save(member2);

        for (int i = 1; i <= 13; i++) {
            Board board = new Board();
            board.setMember(member1);
            board.setTitle(member1.getName() + "가 등록한 게시글 " + i);
            board.setContent(member1.getName() + "가 등록한 내용 " + i);
            boardRepo.save(board);
        }
        for (int i = 1; i <= 13; i++) {
            Board board = new Board();
            board.setMember(member2);
            board.setTitle(member2.getName() + "가 등록한 게시글 " + i);
            board.setContent(member2.getName() + "가 등록한 내용 " + i);
            boardRepo.save(board);
        }
    }

    @Test
    public void testGetBoard() {
        Board board = boardRepo.findById(1L).get();

        System.out.println("[ " + board.getSeq() + "번 게시 글 상세 정보 ]");
        System.out.println("제목\t : " + board.getTitle());
        System.out.println("작성자\t : " + board.getMember().getName());
        System.out.println("내용 \t : " + board.getContent());
        System.out.println("등록일 \t : " + board.getCreateDate());
        System.out.println("조회수 \t : " + board.getCnt());
    }

    @Test
    public void testGetBoardList() {
        Member member = memberRepo.findById("member").get();

        System.out.println("[ " + member.getName() + "가 등록한 게시글 ]");
        for(Board board : member.getBoardList()) {
            System.out.println("---> " + board.toString());
        }
    }
}
