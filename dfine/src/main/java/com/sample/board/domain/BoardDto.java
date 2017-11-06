package com.sample.board.domain;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by TaeHwan
 * 2017. 11. 6. AM 10:43
 */
public class BoardDto extends ResourceSupport {
    private final String author;
    private final String title;
    private final String contents;
    private final CategoryEntity categoryEntity;

    public BoardDto(String author, String title, String contents, CategoryEntity categoryEntity) {
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.categoryEntity = categoryEntity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

}
