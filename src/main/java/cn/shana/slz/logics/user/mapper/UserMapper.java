package cn.shana.slz.logics.user.mapper;

import cn.shana.slz.boot.mapper.BaseMapper;
import cn.shana.slz.logics.user.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserModel> {

    UserModel getUser(String mobile);

    UserModel getUserByPhone(String mobile);
}