package kr.co.lir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardViewController {

    @GetMapping("/board/form")
    public String boardForm() {
        return "board/form";
    }

    @GetMapping("/board/list")
    public String boardList() {
        return "board/list";
    }
}
