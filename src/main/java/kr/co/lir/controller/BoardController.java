package kr.co.lir.controller;

import kr.co.lir.domain.Board;
import kr.co.lir.repository.BoardRepository;
import kr.co.lir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepsitory;

    /* API */
    @GetMapping("/api/v1/board/list")
    public List<Board> getBoardList(){
        return boardService.boardList();
    }

    @PostMapping("/api/v1/board/insert")
    public String boardInsert(
            @RequestBody Board board
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

    /* JPA API */
    @PostMapping("/api/v2/board/insert")
    public String boardJpaInsert(
            @RequestBody Board board
    ){
        boardRepsitory.save(Board.builder()
                .title(board.getTitle())
                .author(board.getAuthor())
                .content(board.getContent())
                .build());
        return "board insert success";
    }

}
