package com.keller.model;

import java.io.Serializable;

public class CarPicture implements Serializable {
    private Integer pId;

    private Integer cId;

    private String image1;

    private String image2;

    private String image3;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2 == null ? null : image2.trim();
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3 == null ? null : image3.trim();
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
        CarPicture other = (CarPicture) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getImage1() == null ? other.getImage1() == null : this.getImage1().equals(other.getImage1()))
            && (this.getImage2() == null ? other.getImage2() == null : this.getImage2().equals(other.getImage2()))
            && (this.getImage3() == null ? other.getImage3() == null : this.getImage3().equals(other.getImage3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getImage1() == null) ? 0 : getImage1().hashCode());
        result = prime * result + ((getImage2() == null) ? 0 : getImage2().hashCode());
        result = prime * result + ((getImage3() == null) ? 0 : getImage3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", cId=").append(cId);
        sb.append(", image1=").append(image1);
        sb.append(", image2=").append(image2);
        sb.append(", image3=").append(image3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}