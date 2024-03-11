package org.example.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String coverImg;
    private String state;
    private Integer categoryId;
    private Integer createUser;
    private String content;
    private LocalDateTime crateTime;
    private LocalDateTime updateTime;
}
