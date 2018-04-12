package cn.shana.slz.service.user.impl;

import cn.shana.slz.mapper.UserInfoMapper;
import cn.shana.slz.mapper.UserMapper;
import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.AppResponse;
import cn.shana.slz.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserMapper userMapper;
    private final UserInfoMapper userInfoMapper;
    @Autowired
    public UserService(UserMapper userMapper,UserInfoMapper userInfoMapper) {
        this.userMapper = userMapper;
        this.userInfoMapper=userInfoMapper;
    }

    @Override
    public AppResponse<UserModel> insertUser(UserModel userEntity) {
        UserModel user = userMapper.getUserByPhone(userEntity.getMobile());
        AppResponse<UserModel> appResponse = new AppResponse<>();
        appResponse.setCode(0);
        if (user == null) {
            userMapper.insert(userEntity);
            UserModel newUser = userMapper.getUserByPhone(userEntity.getMobile());
            userInfoMapper.insert(newUser.getId());
        } else {
            appResponse.setCode(-1);
            appResponse.setMessage("该用户已经存在，请登录");
            return appResponse;
        }
        appResponse.setMessage("该用户已经成功创建");
        return appResponse;
    }

    @Override
    public AppResponse<UserModel> getUserByPhone(String phone) {
        AppResponse<UserModel> appResponse;
        UserModel user = userMapper.getUserByPhone(phone);
        if(user!=null){
            appResponse=new AppResponse<>(0,"success",user);
        }else{
            appResponse=new AppResponse<>(-1,"该用户不存在",null);
        }
        return appResponse;
    }
}
