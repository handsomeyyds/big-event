package org.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="articles")
public class ArticleDO {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String coverImg;
    private String state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @NotEmpty
    private CategoryDO categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @NotEmpty
    private UserDO createUser;
    private String content;
    private LocalDateTime crateTime;
    private LocalDateTime updateTime;
}