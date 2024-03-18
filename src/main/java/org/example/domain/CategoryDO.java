package org.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="categories")
public class CategoryDO {
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String Alias;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @NotEmpty
    private UserDO createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
