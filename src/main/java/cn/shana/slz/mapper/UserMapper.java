package cn.shana.slz.mapper;

import cn.shana.slz.mapper.base.BaseMapper;
import cn.shana.slz.model.UserModel;

import java.util.List;

public interface UserMapper extends BaseMapper<UserModel>{

        UserModel getUser(String mobile);

        UserModel getUserByPhone(String mobile);
}