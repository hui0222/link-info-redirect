package kr.co.lir.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    private Long id;

    private String title;

    private String content;

    private String author;

}
