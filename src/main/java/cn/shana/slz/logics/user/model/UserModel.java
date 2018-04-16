package cn.shana.slz.logics.user.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class UserModel implements Serializable {

    private int id;
    private String mobile;
    private String password;

    public UserModel() {
        super();
    }

    public UserModel(String mobile, String password) {
        super();
        this.mobile = mobile;
        this.password = password;
    }

}
