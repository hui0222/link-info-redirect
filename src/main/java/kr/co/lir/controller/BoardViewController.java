package kr.co.lir.controller;

import kr.co.lir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardViewController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/form")
    public String boardForm() {
        return "board/form";
    }

    @GetMapping("/board/list")
    public String boardList(
            Model model
    ) {
        model.addAttribute("boardList", boardService.boardList());
        return "board/list";
    }

    @GetMapping("/board/detail/{id}")
    public String boardDetail(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("board", boardService.boardDetail(id));
        return "board/detail";
    }
}
