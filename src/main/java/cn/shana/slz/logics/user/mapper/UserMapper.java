package cn.shana.slz.logics.user.mapper;

import cn.shana.slz.logics.user.mapper.base.BaseMapper;
import cn.shana.slz.logics.user.model.UserModel;

public interface UserMapper extends BaseMapper<UserModel>{

        UserModel getUser(String mobile);

        UserModel getUserByPhone(String mobile);
}