package cn.shana.slz.logics.user.controller;

import cn.shana.slz.boot.orika.Orika;
import cn.shana.slz.boot.response.AppResponse;
import cn.shana.slz.boot.response.ResponseUtils;
import cn.shana.slz.logics.user.data.response.UserVo;
import cn.shana.slz.logics.user.model.UserModel;
import cn.shana.slz.logics.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 创建用户
     * @param userEntity 用户数据
     * @return AppResponse<UserModel>
     */
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AppResponse<UserModel> insertUser(@RequestBody UserModel userEntity) {

        // 执行创建
        UserModel userModel = userService.insertUser(userEntity);

        // 响应结果
        return ResponseUtils.success(new UserVo(userModel));// 使用构造方法狗造成VO
    }

    /**
     * 根据手机号码获取用户信息
     * @param mobile 手机号码
     * @return AppResponse<UserModel>
     */
    @GetMapping(value = "/getUserByPhone")
    public AppResponse<UserModel> getUserByPhone(@RequestParam String mobile) {

        // 执行查找
        UserModel userModel = userService.getUserByPhone(mobile);

        // 响应结果
        return ResponseUtils.success(Orika.map(userModel, UserVo.class));// 借助 Orika 类库转化成VO
    }
}
