package cn.shana.slz.logics.user.model;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class UserModel implements Serializable{
    
    private int id;
    private String mobile;
    private String password;

    public UserModel() {
        super();
    }

    public UserModel(String mobile, String password) {
        super();
        this.mobile = mobile;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("userName:%s password:%s",mobile,password) ;
    }
}
