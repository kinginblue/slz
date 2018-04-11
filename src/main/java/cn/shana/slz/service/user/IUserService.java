package cn.shana.slz.service.user;


import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.AppResponse;

public interface IUserService {
     AppResponse<UserModel> insertUser(UserModel userEntity);
     AppResponse<UserModel> getUserByPhone(String phone);
}
