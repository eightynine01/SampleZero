package com.sample.board.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 11:09
 */
@Entity
public class BoardEntity {
    @Id @GeneratedValue
    private Long id;
    private String author;
    private String title;
    @Lob
    private String contents;
    @OneToOne
    private CategoryEntity categoryEntity;
    @OneToMany
    private List<ReplyEntity> replyEntity;

    public BoardEntity(BoardDto boardDto){
        this.author = boardDto.getAuthor();
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
        this.categoryEntity = boardDto.getCategoryEntity();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<ReplyEntity> getReplyEntity() {
        return replyEntity;
    }

    public void setReplyEntity(List<ReplyEntity> replyEntity) {
        this.replyEntity = replyEntity;
    }
}
