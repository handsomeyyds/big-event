package org.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class UserDO {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @Pattern(regexp = "^\\s{1,10}$")
    private String nickname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createUser")
    @JsonIgnore
    private List<CategoryDO> categoryDOList;
    @Email
    private String email;
    private String userPic;
    @JsonIgnore
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:SS")
    private LocalDateTime updateTime;
}
