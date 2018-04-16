package cn.shana.slz.service.user;

import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.AppResponse;

public interface IUserService {

    AppResponse insertUser(UserModel userEntity);

    AppResponse getUserByPhone(String phone);
}
