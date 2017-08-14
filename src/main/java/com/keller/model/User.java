package com.keller.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uId;

    private String uName;

    private String uPasswd;

    private Integer rId;

    private String uRes;
    
    private Integer limit;
    private Integer start;

    public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPasswd() {
        return uPasswd;
    }

    public void setuPasswd(String uPasswd) {
        this.uPasswd = uPasswd == null ? null : uPasswd.trim();
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
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
        User other = (User) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuPasswd() == null ? other.getuPasswd() == null : this.getuPasswd().equals(other.getuPasswd()))
            && (this.getrId() == null ? other.getrId() == null : this.getrId().equals(other.getrId()))
            && (this.getuRes() == null ? other.getuRes() == null : this.getuRes().equals(other.getuRes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuPasswd() == null) ? 0 : getuPasswd().hashCode());
        result = prime * result + ((getrId() == null) ? 0 : getrId().hashCode());
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
        sb.append(", uName=").append(uName);
        sb.append(", uPasswd=").append(uPasswd);
        sb.append(", rId=").append(rId);
        sb.append(", uRes=").append(uRes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}