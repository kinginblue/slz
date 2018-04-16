package cn.shana.slz.logics.user.data.response;

import cn.shana.slz.logics.user.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户的 View Object
 */
@Data
@AllArgsConstructor
public class UserVo implements Serializable {

    private int id;

    private String mobile;

    // 加了 @JsonIgnore 的域不会被框架序列化，或者 VO 本身就不定义 password 域
    @JsonIgnore
    private String password;

    public UserVo(UserModel userModel) {
        this.id = userModel.getId();
        this.mobile = userModel.getMobile();
        this.password = userModel.getPassword();
    }

}
