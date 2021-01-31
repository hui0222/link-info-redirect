package kr.co.lir.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class TestMainController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception {
        String test = "test";

        mvc.perform(get("/main/test"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));
    }

}
