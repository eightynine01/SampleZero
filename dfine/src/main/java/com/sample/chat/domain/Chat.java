package com.sample.chat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 5:55
 */
@Entity
public class Chat {
    @Id @GeneratedValue
    private Long id;
    private String author;
    private String title;
    @Lob
    private String contents;
}
