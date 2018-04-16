package cn.shana.slz.logics.user.controller;

import cn.shana.slz.boot.response.AppResponse;
import cn.shana.slz.logics.user.model.UserModel;
import cn.shana.slz.logics.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     * @param userEntity 用户数据
     * @return AppResponse<UserModel>
     */
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AppResponse<UserModel> insertUser(@RequestBody UserModel userEntity) {
        return userService.insertUser(userEntity);
    }

    /**
     * 根据手机号码获取用户信息
     * @param mobile 手机号码
     * @return AppResponse<UserModel>
     */
    @GetMapping(value = "/getUserByPhone")
    public AppResponse<UserModel> getUserByPhone(@RequestParam String mobile) {
        return userService.getUserByPhone(mobile);
    }
}
