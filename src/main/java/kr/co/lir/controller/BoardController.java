package kr.co.lir.controller;

import kr.co.lir.domain.Board;
import kr.co.lir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;


    /* API */
    @GetMapping("/api/v1/board/list")
    public List<Board> getBoardList(){

        List<Board> boardList = boardService.boardList();

        return boardList;
    }

    @GetMapping("/api/v1/board/insert")
    public String boardInsert(
            Board board
    ){
        boardService.boardInsert(board);
        return "board insert success";
    }

    @GetMapping("/api/v1/board/detail/{id}")
    public Board getBoardDetail(
            @PathVariable Long id
    ){
        return boardService.boardDetail(id);
    }

    @GetMapping("/api/v1/board/delete/{id}")
    public String boardDelete(
            @PathVariable Long id
    ){
        boardService.boardDelete(id);
        return "board Delete success";
    }


}
