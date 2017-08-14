package com.keller.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private Integer fid;

    private String faccount;

    private Date flogintime;

    private Date flogouttime;

    private String fregionid;

    private String fleaguename;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFaccount() {
        return faccount;
    }

    public void setFaccount(String faccount) {
        this.faccount = faccount == null ? null : faccount.trim();
    }

    public Date getFlogintime() {
        return flogintime;
    }

    public void setFlogintime(Date flogintime) {
        this.flogintime = flogintime;
    }

    public Date getFlogouttime() {
        return flogouttime;
    }

    public void setFlogouttime(Date flogouttime) {
        this.flogouttime = flogouttime;
    }

    public String getFregionid() {
        return fregionid;
    }

    public void setFregionid(String fregionid) {
        this.fregionid = fregionid == null ? null : fregionid.trim();
    }

    public String getFleaguename() {
        return fleaguename;
    }

    public void setFleaguename(String fleaguename) {
        this.fleaguename = fleaguename == null ? null : fleaguename.trim();
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
        LoginLog other = (LoginLog) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getFaccount() == null ? other.getFaccount() == null : this.getFaccount().equals(other.getFaccount()))
            && (this.getFlogintime() == null ? other.getFlogintime() == null : this.getFlogintime().equals(other.getFlogintime()))
            && (this.getFlogouttime() == null ? other.getFlogouttime() == null : this.getFlogouttime().equals(other.getFlogouttime()))
            && (this.getFregionid() == null ? other.getFregionid() == null : this.getFregionid().equals(other.getFregionid()))
            && (this.getFleaguename() == null ? other.getFleaguename() == null : this.getFleaguename().equals(other.getFleaguename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getFaccount() == null) ? 0 : getFaccount().hashCode());
        result = prime * result + ((getFlogintime() == null) ? 0 : getFlogintime().hashCode());
        result = prime * result + ((getFlogouttime() == null) ? 0 : getFlogouttime().hashCode());
        result = prime * result + ((getFregionid() == null) ? 0 : getFregionid().hashCode());
        result = prime * result + ((getFleaguename() == null) ? 0 : getFleaguename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", faccount=").append(faccount);
        sb.append(", flogintime=").append(flogintime);
        sb.append(", flogouttime=").append(flogouttime);
        sb.append(", fregionid=").append(fregionid);
        sb.append(", fleaguename=").append(fleaguename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}