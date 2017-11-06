package com.sample.board.domain;

import javax.persistence.*;

/**
 * Created by TaeHwan
 * 2017. 11. 6. AM 10:02
 */
@Entity
public class ReplyEntity {
    @Id @GeneratedValue
    private Long id;
    private String author;
    @Lob
    private String contents;
    @ManyToOne
    private BoardEntity boardEntity;

    public ReplyEntity(String author, String contents, BoardEntity boardEntity) {
        this.author = author;
        this.contents = contents;
        this.boardEntity = boardEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }
}
