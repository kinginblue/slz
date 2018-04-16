package cn.shana.slz.logics.user.model;

import lombok.Data;

@Data
public class UserInfoModel {

    private int id;

    private String userName;

    private String nickName;

    private int sex;

    private int age;

    private long birthday;

    private long createTime;

    private long updateTime;
}
