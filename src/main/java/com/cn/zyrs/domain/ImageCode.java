package com.cn.zyrs.domain;

public class ImageCode {
    private String id;

    private String imagename;

    private String imagecode;

    private String unitycode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename == null ? null : imagename.trim();
    }

    public String getImagecode() {
        return imagecode;
    }

    public void setImagecode(String imagecode) {
        this.imagecode = imagecode == null ? null : imagecode.trim();
    }

    public String getUnitycode() {
        return unitycode;
    }

    public void setUnitycode(String unitycode) {
        this.unitycode = unitycode == null ? null : unitycode.trim();
    }
}