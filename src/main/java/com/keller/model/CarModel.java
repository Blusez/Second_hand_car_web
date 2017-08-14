package com.keller.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
public class CarModel implements Serializable {
    private Integer mId;

    private String mName;

    private String mCount;

    private static final long serialVersionUID = 1L;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmCount() {
        return mCount;
    }

    public void setmCount(String mCount) {
        this.mCount = mCount == null ? null : mCount.trim();
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
        CarModel other = (CarModel) that;
        return (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()))
            && (this.getmName() == null ? other.getmName() == null : this.getmName().equals(other.getmName()))
            && (this.getmCount() == null ? other.getmCount() == null : this.getmCount().equals(other.getmCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        result = prime * result + ((getmName() == null) ? 0 : getmName().hashCode());
        result = prime * result + ((getmCount() == null) ? 0 : getmCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", mName=").append(mName);
        sb.append(", mCount=").append(mCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}