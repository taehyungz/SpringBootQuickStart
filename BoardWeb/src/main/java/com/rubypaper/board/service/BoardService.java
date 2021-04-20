package com.rubypaper.board.service;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Search;
import org.springframework.data.domain.Page;

public interface BoardService {

    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);

    Board getBoard(Board board);

    Page<Board> getBoardList(Search search);
}
