package org.example.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String user_pic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}