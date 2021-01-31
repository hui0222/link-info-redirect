package kr.co.lir.controller;

import kr.co.lir.domain.Board;
import kr.co.lir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/list")
    public List<Board> getBoardList(){

        List<Board> boardList = boardService.boardList();

        return boardList;
    }

    @GetMapping("/board/insert")
    public String getBoardList(
            Board board
    ){

        boardService.boardInsert(board);

        return "board insert success";
    }
}