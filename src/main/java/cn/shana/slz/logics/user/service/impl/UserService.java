package cn.shana.slz.logics.user.service.impl;

import cn.shana.slz.boot.response.ErrorEnum;
import cn.shana.slz.boot.util.BSUtil;
import cn.shana.slz.logics.user.mapper.UserInfoMapper;
import cn.shana.slz.logics.user.mapper.UserMapper;
import cn.shana.slz.logics.user.model.UserModel;
import cn.shana.slz.logics.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional
    @Override
    public UserModel insertUser(UserModel userEntity) {

        // 校验要求：用户不存在
        UserModel user = userMapper.getUserByPhone(userEntity.getMobile());
        BSUtil.isNull(user, ErrorEnum.USER_IS_EXITED, ErrorEnum.USER_IS_EXITED.getMsg());

        // 创建用户
        userMapper.insert(userEntity);
        UserModel newUser = userMapper.getUserByPhone(userEntity.getMobile());
        userInfoMapper.insert(newUser.getId());

        // 返回刚刚创建的用户
        return newUser;
    }

    @Override
    public UserModel getUserByPhone(String phone) {

        // 校验要求：用户需存在
        UserModel user = userMapper.getUserByPhone(phone);
        BSUtil.notNull(user, ErrorEnum.USER_NOT_FIND, ErrorEnum.USER_NOT_FIND.getMsg());

        // 返回用户
        return user;
    }
}
