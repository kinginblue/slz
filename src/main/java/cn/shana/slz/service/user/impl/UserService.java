package cn.shana.slz.service.user.impl;

import cn.shana.slz.mapper.UserInfoMapper;
import cn.shana.slz.mapper.UserMapper;
import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.AppResponse;
import cn.shana.slz.response.error.ErrorEnum;
import cn.shana.slz.response.error.ResponseUtils;
import cn.shana.slz.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService implements IUserService {

    private final UserMapper userMapper;
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserService(UserMapper userMapper, UserInfoMapper userInfoMapper) {
        this.userMapper = userMapper;
        this.userInfoMapper = userInfoMapper;
    }

    @Transactional
    @Override
    public AppResponse insertUser(UserModel userEntity) {
        UserModel user = userMapper.getUserByPhone(userEntity.getMobile());
        if (user == null) {
            try {
                userMapper.insert(userEntity);
                UserModel newUser = userMapper.getUserByPhone(userEntity.getMobile());
                userInfoMapper.insert(newUser.getId());
            } catch (TransactionException e) {
                //                事务回滚？
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                e.printStackTrace();
                return ResponseUtils.error(-1, "出现事务异常");
            }
        } else {
            return ResponseUtils.error(ErrorEnum.USER_IS_EXITED);
        }
        return ResponseUtils.success();
    }

    @Override
    public AppResponse getUserByPhone(String phone) {
        UserModel user = userMapper.getUserByPhone(phone);
        if (user == null) {
            return ResponseUtils.error(ErrorEnum.USER_NOT_FIND);
        }
        return ResponseUtils.success(user);
    }
}
