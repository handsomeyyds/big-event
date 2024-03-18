package org.example.service.impl;

import org.example.domain.UserDO;
import org.example.pojo.user.UserInfoDTO;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDO findByUsername(String username) {
        UserDO u = userRepository.findByUsername(username);
        return u;
    }

    @Override
    public UserDO register(String username, String password) {
        // 加密
        String md5String = Md5Util.getMd5String(password);
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(md5String);
        logger.info("crate user {}", userDO.toString());
        return userRepository.save(userDO);
    }

    @Override
    public Optional<UserDO> findById(Long id) {
        Optional<UserDO> user = userRepository.findById(id);
        return user;
    }

//
//    @Override
//    public void update(User user) {
//        user.setUpdateTime(LocalDateTime.now());
//        userMapper.update(user);
//    }
//
//    @Override
//    public void updateAvatar(String avatarUrl) {
//        Map<String, Object> map = ThreadLocalUtil.get();
//        Integer id = (Integer) map.get("id");
//        userRepository.updateAvatar(avatarUrl, id);
//    }
}
