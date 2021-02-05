package kr.co.lir.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor // 기본생성자 추가 Board(){}
@Data
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//넣어줘야됨..
    private Long id;

    private String title;
    private String content;
    private String author;

    @Builder
    public Board(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

}


