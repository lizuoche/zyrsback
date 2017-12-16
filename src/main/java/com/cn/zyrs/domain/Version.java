package com.cn.zyrs.domain;

import java.util.Date;

public class Version {
    private Date releasedat;

    private String version;

    private String explain;

    public Date getReleasedat() {
        return releasedat;
    }

    public void setReleasedat(Date releasedat) {
        this.releasedat = releasedat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }
}