package kr.co.lir.service;

import kr.co.lir.domain.Board;
import kr.co.lir.service.impl.BoardServiceImpl;

import java.util.List;

public interface BoardService {

    List<Board> boardList();
    void boardInsert(Board board);
    void boardDelete(Long id);
    Board boardDetail(Long id);
}
