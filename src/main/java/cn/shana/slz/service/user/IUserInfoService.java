package cn.shana.slz.service.user;


import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.AppResponse;

public interface IUserInfoService<T> {
     T insertUserInfo(UserModel userEntity);
     T getUserInfoByPhone(String phone);
}
