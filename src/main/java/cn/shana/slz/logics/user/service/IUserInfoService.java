package cn.shana.slz.logics.user.service;


import cn.shana.slz.logics.user.model.UserModel;

public interface IUserInfoService<T> {

    T insertUserInfo(UserModel userEntity);

    T getUserInfoByPhone(String phone);
}
