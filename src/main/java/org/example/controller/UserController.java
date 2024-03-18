package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.domain.UserDO;
import org.example.pojo.Result;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(
            @Pattern(regexp = "^\\S{5,16}$") String username,
            @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        UserDO u = userService.findByUsername(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(
            @Pattern(regexp = "^\\S{5,16}$") String username,
            @Pattern(regexp = "^\\S{5,16}$") String password) {
        UserDO loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        }

        if (Md5Util.getMd5String(password).equals(loginUser.getPassword())) {
            // login success
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", (Long) loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.getToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<Optional<UserDO>> userInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Optional<UserDO> user = userService.findById(Long.valueOf((int) map.get("id")));
        if (user.isEmpty()) {
            return Result.error("用户不存在");
        }
        return Result.success(user);
    }
}
