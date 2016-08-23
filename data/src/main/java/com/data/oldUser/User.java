package com.data.oldUser;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document
@Data
public class User {
    @Id
    private String _id;
    @Email

    private String email;

    private String phone;
    private String openId;
    private String unionId;

    private String androidCid;//android推送ID

    private String iOSCid;//iOS推送ID

    private String nickname;

    private String wxName;
    private String password;
    private String salt;
    private UserType type;
    private UserStatus status = UserStatus.NORMAL;

    private String faceUrl;

    private String address;

    private Date createTime;

    private List<String> mineDevices;

    private List<String> subscribeDevices;

    private String defaultDevice;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdentify() {
        switch (type) {
            case PHONE:
                return phone;
            case EMAIL:
                return email;
            default:
                return _id.toString();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getMineDevices() {
        return mineDevices;
    }

    public void setMineDevices(List<String> mineDevices) {
        this.mineDevices = mineDevices;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getDefaultDevice() {
        return defaultDevice;
    }

    public void setDefaultDevice(String defaultDevice) {
        this.defaultDevice = defaultDevice;
    }

    public List<String> getSubscribeDevices() {
        return subscribeDevices;
    }

    public void setSubscribeDevices(List<String> subscribeDevices) {
        this.subscribeDevices = subscribeDevices;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getAndroidCid() {
        return androidCid;
    }

    public void setAndroidCid(String androidCid) {
        this.androidCid = androidCid;
    }

    public String getiOSCid() {
        return iOSCid;
    }

    public void setiOSCid(String iOSCid) {
        this.iOSCid = iOSCid;
    }
}
