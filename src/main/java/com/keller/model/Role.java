package com.keller.model;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer rId;

    private String rRolename;

    private String rDes;

    private String rRes;

    private static final long serialVersionUID = 1L;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrRolename() {
        return rRolename;
    }

    public void setrRolename(String rRolename) {
        this.rRolename = rRolename == null ? null : rRolename.trim();
    }

    public String getrDes() {
        return rDes;
    }

    public void setrDes(String rDes) {
        this.rDes = rDes == null ? null : rDes.trim();
    }

    public String getrRes() {
        return rRes;
    }

    public void setrRes(String rRes) {
        this.rRes = rRes == null ? null : rRes.trim();
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
        Role other = (Role) that;
        return (this.getrId() == null ? other.getrId() == null : this.getrId().equals(other.getrId()))
            && (this.getrRolename() == null ? other.getrRolename() == null : this.getrRolename().equals(other.getrRolename()))
            && (this.getrDes() == null ? other.getrDes() == null : this.getrDes().equals(other.getrDes()))
            && (this.getrRes() == null ? other.getrRes() == null : this.getrRes().equals(other.getrRes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getrId() == null) ? 0 : getrId().hashCode());
        result = prime * result + ((getrRolename() == null) ? 0 : getrRolename().hashCode());
        result = prime * result + ((getrDes() == null) ? 0 : getrDes().hashCode());
        result = prime * result + ((getrRes() == null) ? 0 : getrRes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", rRolename=").append(rRolename);
        sb.append(", rDes=").append(rDes);
        sb.append(", rRes=").append(rRes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}