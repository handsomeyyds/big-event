package org.example.service;

import org.example.domain.UserDO;
import org.example.pojo.user.UserInfoDTO;

import java.util.Optional;

public interface UserService {
    // 根据用户名查询用户
    UserDO findByUsername(String username);

    //    // 注册
    UserDO register(String username, String password);

    Optional<UserDO> findById(Long id);
}