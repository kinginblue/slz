package cn.shana.slz.logics.user.service;

import cn.shana.slz.logics.user.model.UserModel;
import cn.shana.slz.boot.response.AppResponse;

public interface IUserService {

    AppResponse insertUser(UserModel userEntity);

    AppResponse getUserByPhone(String phone);
}
