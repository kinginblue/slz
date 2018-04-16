package cn.shana.slz.service.user;


import cn.shana.slz.model.UserModel;

public interface IUserInfoService<T> {

    T insertUserInfo(UserModel userEntity);

    T getUserInfoByPhone(String phone);
}
