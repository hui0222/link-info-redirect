package kr.co.lir.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//넣어줘야됨..
    private Long id;

    private String title;
    private String content;
    private String author;

}


