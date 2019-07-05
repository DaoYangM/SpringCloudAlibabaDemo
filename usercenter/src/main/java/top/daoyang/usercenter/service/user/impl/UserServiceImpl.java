package top.daoyang.usercenter.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.daoyang.usercenter.dao.user.UserMapper;
import top.daoyang.usercenter.domain.user.User;
import top.daoyang.usercenter.service.user.UserService;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
