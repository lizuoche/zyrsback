package com.cn.zyrs.domain;

public class SuitParts {
    private String id;

    private String style;

    private String type;
    
    private String name;

    private String workshopname;

    private String remark;

    private String modelname;

    private String image;

    private String image1;

    private String image2;

    private String image3;
    
//    private String issell;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWorkshopname() {
        return workshopname;
    }

    public void setWorkshopname(String workshopname) {
        this.workshopname = workshopname == null ? null : workshopname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getimage1() {
        return image1;
    }

    public void setimage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public String getimage2() {
        return image2;
    }

    public void setimage2(String image2) {
        this.image2 = image2 == null ? null : image2.trim();
    }

    public String getimage3() {
        return image3;
    }

    public void setimage3(String image3) {
        this.image3 = image3 == null ? null : image3.trim();
    }

//	public String getIssell() {
//		return issell;
//	}
//
//	public void setIssell(String issell) {
//		this.issell = issell;
//	}
    
}