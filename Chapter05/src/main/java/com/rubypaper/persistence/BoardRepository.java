package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    // query method
    // naming: find + 엔티티 이름 + By + 변수 이름 -> 엔티티에서 해당 변수값만 조회한다
    List<Board> findByTitle(String searchKeyword);
    List<Board> findByContentContaining(String searchKeyword);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query("SELECT b FROM Board b" +
            " WHERE b.title like %:searchKeyword% " +
            "ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);

    @Query("SELECT b.seq, b.title, b.writer, b.createDate " +
            "FROM Board b " +
            "WHERE b.title like %:searchKeyword% " +
            "ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query(value="select seq, title, writer, create_date "
            + "from board where title like '%'||?1||'%' "
            + "order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest3(String searchKeyword);

    @Query("SELECT b FROM Board b ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest4(Pageable paging);
}
