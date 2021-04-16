package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    // query method
    // naming: find + 엔티티 이름 + By + 변수 이름 -> 엔티티에서 해당 변수값만 조회한다
    List<Board> findByTitle(String searchKeyword);
    List<Board> findByContentContaining(String searchKeyword);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}
