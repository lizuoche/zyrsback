package com.cn.zyrs.domain;

import java.math.BigDecimal;

public class Craft {
    private String craftid;

    private String craftname;

    private String style;

    private Integer isvalid;

    private Integer deleflag;

    private BigDecimal price;

    private String companyid;

    private String deptid;

    private Integer timeneed;

    public String getCraftid() {
        return craftid;
    }

    public void setCraftid(String craftid) {
        this.craftid = craftid == null ? null : craftid.trim();
    }

    public String getCraftname() {
        return craftname;
    }

    public void setCraftname(String craftname) {
        this.craftname = craftname == null ? null : craftname.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getDeleflag() {
        return deleflag;
    }

    public void setDeleflag(Integer deleflag) {
        this.deleflag = deleflag;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public Integer getTimeneed() {
        return timeneed;
    }

    public void setTimeneed(Integer timeneed) {
        this.timeneed = timeneed;
    }
}