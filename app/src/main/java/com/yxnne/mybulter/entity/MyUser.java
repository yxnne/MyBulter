package com.yxnne.mybulter.entity;

import cn.bmob.v3.BmobUser;

/**
 * Class Full Name  : com.yxnne.mybulter.entity.MyUser
 * Author Name      : yxnne
 * Create Time      : 2017/2/16
 * Project Name     : MyBulter
 * Descriptions     : 用户的实体类。
 *
 * BmobUser作为基类，封装了
 *      BmobUser除了从BmobObject继承的属性外，还有几个特定的属性：
 *      username: 用户的用户名（必需）。
 *      password: 用户的密码（必需）。
 *      email: 用户的电子邮件地址（可选）。
 *      emailVerified:邮箱认证状态（可选）。
 *      mobilePhoneNumber：手机号码（可选）。
 *      mobilePhoneNumberVerified：手机号码的认证状态（可选）。
 *
 *  这里扩展age，sex，desc
 */
public class MyUser extends BmobUser{
    private int age;
    private boolean sex;
    private String desc;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
