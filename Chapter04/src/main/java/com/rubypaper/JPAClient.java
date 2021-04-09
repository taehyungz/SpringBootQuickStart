package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAClient {
    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
        EntityManager em = emf.createEntityManager();
        // Transaction 생성
//        EntityTransaction tx = em.getTransaction();
        try {
            // 글 상세 조회
            Board searchBoard = em.find(Board.class, 10L);
            System.out.println("---> " + searchBoard.toString());
//            // Transaction 시작
//            tx.begin();
//
//            Board board = new Board();
//            board.setTitle("JPA 제목");
//            board.setWriter("관리자");
//            board.setContent("JPA 글 등록 잘 되네요.");
//            board.setCreateDate(new Date());
//            board.setCnt(0L);
//
//            //글 등록
//            em.persist(board);
//
//            // Transaction commit
//            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
//            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
