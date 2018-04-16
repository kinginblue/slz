package cn.shana.slz.service.user.impl;

import cn.shana.slz.mapper.UserInfoMapper;
import cn.shana.slz.model.UserInfoModel;
import cn.shana.slz.model.UserModel;
import cn.shana.slz.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements IUserInfoService<UserInfoModel> {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoModel insertUserInfo(UserModel userEntity) {
        return null;
    }

    @Override
    public UserInfoModel getUserInfoByPhone(String phone) {
        return null;
    }
}
