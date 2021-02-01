package kr.co.lir.service;

import kr.co.lir.domain.Board;
import kr.co.lir.service.impl.BoardServiceImpl;

import java.util.List;

public interface BoardService {

    List<Board> boardList();
    void boardInsert(Board board);
    void boardDelete(Integer id);
    Board boardDetail(Integer id);
}
