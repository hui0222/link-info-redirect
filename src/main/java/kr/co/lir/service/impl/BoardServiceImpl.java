package kr.co.lir.service.impl;

import kr.co.lir.domain.Board;
import kr.co.lir.repository.BoardRepository;
import kr.co.lir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> boardList(){
        return boardRepository.findAll();
    }

    @Override
    public void boardInsert(Board board){
        boardRepository.save(board);
    }

    @Override
    public void boardDelete(Long boardId){
        boardRepository.deleteById(boardId);
    }

    @Override
    public Board boardDetail(Long bordId){
        return boardRepository.findByid(bordId);
    }
}
