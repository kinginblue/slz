package cn.shana.slz.controller;

import cn.shana.slz.response.AppResponse;
import cn.shana.slz.model.UserModel;
import cn.shana.slz.response.SerializedField;
import cn.shana.slz.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/add",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AppResponse<UserModel> insertUser(@RequestBody UserModel userEntity){
        return userService.insertUser(userEntity);
    }
    //todo
    /**
     * 根据手机号码获取用户信息
     *
     * @param mobile 手机号码
     * @return AppResponse<UserModel>
     */
    @GetMapping(value = "/getUserByPhone")
    @SerializedField(excludes = {"password"})
    public AppResponse<UserModel> getUserByPhone(@RequestParam String mobile){
        return userService.getUserByPhone(mobile);
    }
}
