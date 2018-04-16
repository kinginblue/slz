package cn.shana.slz.logics.user.service;

import cn.shana.slz.logics.user.model.UserModel;

public interface IUserService {

    UserModel insertUser(UserModel userEntity);

    UserModel getUserByPhone(String phone);
}
