package com.kangkang.store.entity;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

/**
 * ClassName:User
 * Package:com.kangkang.store.entity
 * Description:
 *
 * @date:2022/3/24 9:25
 * @author:kangkang
 */
public class User extends BaseEntity implements Serializable {

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;     //0表示女，1表示男
    private String avatar;
    private Integer isDelete;  //0表示未删除，1表示已删除

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(isDelete, user.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uid, username, password, salt, phone, email, gender, avatar, isDelete);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar=" + avatar +
                ", isDelete=" + isDelete +
                '}';
    }
}
