package com.keller.model;

import java.io.Serializable;

public class UserInfor implements Serializable {
    private Integer uId;

    private String uAddress;

    private String uRealName;

    private String uPhone;

    private String uEmail;

    private String uSex;

    private String uRes;

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }

    public String getuRealName() {
        return uRealName;
    }

    public void setuRealName(String uRealName) {
        this.uRealName = uRealName == null ? null : uRealName.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public String getuRes() {
        return uRes;
    }

    public void setuRes(String uRes) {
        this.uRes = uRes == null ? null : uRes.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserInfor other = (UserInfor) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuAddress() == null ? other.getuAddress() == null : this.getuAddress().equals(other.getuAddress()))
            && (this.getuRealName() == null ? other.getuRealName() == null : this.getuRealName().equals(other.getuRealName()))
            && (this.getuPhone() == null ? other.getuPhone() == null : this.getuPhone().equals(other.getuPhone()))
            && (this.getuEmail() == null ? other.getuEmail() == null : this.getuEmail().equals(other.getuEmail()))
            && (this.getuSex() == null ? other.getuSex() == null : this.getuSex().equals(other.getuSex()))
            && (this.getuRes() == null ? other.getuRes() == null : this.getuRes().equals(other.getuRes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuAddress() == null) ? 0 : getuAddress().hashCode());
        result = prime * result + ((getuRealName() == null) ? 0 : getuRealName().hashCode());
        result = prime * result + ((getuPhone() == null) ? 0 : getuPhone().hashCode());
        result = prime * result + ((getuEmail() == null) ? 0 : getuEmail().hashCode());
        result = prime * result + ((getuSex() == null) ? 0 : getuSex().hashCode());
        result = prime * result + ((getuRes() == null) ? 0 : getuRes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uAddress=").append(uAddress);
        sb.append(", uRealName=").append(uRealName);
        sb.append(", uPhone=").append(uPhone);
        sb.append(", uEmail=").append(uEmail);
        sb.append(", uSex=").append(uSex);
        sb.append(", uRes=").append(uRes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}