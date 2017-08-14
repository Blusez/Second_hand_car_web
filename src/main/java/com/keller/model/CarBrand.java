package com.keller.model;

import java.io.Serializable;

public class CarBrand implements Serializable {
    private Integer bId;

    private String bName;

    private Integer bCount;

    private String bImg;

    private String bSzm;

    private static final long serialVersionUID = 1L;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public Integer getbCount() {
        return bCount;
    }

    public void setbCount(Integer bCount) {
        this.bCount = bCount;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg == null ? null : bImg.trim();
    }

    public String getbSzm() {
        return bSzm;
    }

    public void setbSzm(String bSzm) {
        this.bSzm = bSzm == null ? null : bSzm.trim();
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
        CarBrand other = (CarBrand) that;
        return (this.getbId() == null ? other.getbId() == null : this.getbId().equals(other.getbId()))
            && (this.getbName() == null ? other.getbName() == null : this.getbName().equals(other.getbName()))
            && (this.getbCount() == null ? other.getbCount() == null : this.getbCount().equals(other.getbCount()))
            && (this.getbImg() == null ? other.getbImg() == null : this.getbImg().equals(other.getbImg()))
            && (this.getbSzm() == null ? other.getbSzm() == null : this.getbSzm().equals(other.getbSzm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getbId() == null) ? 0 : getbId().hashCode());
        result = prime * result + ((getbName() == null) ? 0 : getbName().hashCode());
        result = prime * result + ((getbCount() == null) ? 0 : getbCount().hashCode());
        result = prime * result + ((getbImg() == null) ? 0 : getbImg().hashCode());
        result = prime * result + ((getbSzm() == null) ? 0 : getbSzm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bId=").append(bId);
        sb.append(", bName=").append(bName);
        sb.append(", bCount=").append(bCount);
        sb.append(", bImg=").append(bImg);
        sb.append(", bSzm=").append(bSzm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}