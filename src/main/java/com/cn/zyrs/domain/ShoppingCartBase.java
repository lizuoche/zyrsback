package com.cn.zyrs.domain;

public class ShoppingCartBase {
    private String id;

    private String designid;
    
    private String deptid;

    private String designname;
    
    private String type;
    
    private String typename;
    
    private String assetbundlename;
    
    private String suitbutton;
    
    private String suitbom;

    private String insidebom;

    private String shirtbom;

    private String tiebom;
    
    private String kouyanbom;
   
    private String joindate;

    private String createdate;

    private String updatedate;

    private String picture;
   
    private String jsonurl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    
    public String getDesignid() {
		return designid;
	}

	public void setDesignid(String designid) {
		this.designid = designid;
	}

	public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getDesignname() {
        return designname;
    }

    public void setDesignname(String designname) {
        this.designname = designname == null ? null : designname.trim();
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getAssetbundlename() {
		return assetbundlename;
	}

	public void setAssetbundlename(String assetbundlename) {
		this.assetbundlename = assetbundlename;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

	public String getJsonurl() {
		return jsonurl;
	}

	public void setJsonurl(String jsonurl) {
		this.jsonurl = jsonurl;
	}

	public String getSuitbom() {
		return suitbom;
	}

	public void setSuitbom(String suitbom) {
		this.suitbom = suitbom;
	}

	public String getInsidebom() {
		return insidebom;
	}

	public void setInsidebom(String insidebom) {
		this.insidebom = insidebom;
	}

	public String getShirtbom() {
		return shirtbom;
	}

	public void setShirtbom(String shirtbom) {
		this.shirtbom = shirtbom;
	}

	public String getTiebom() {
		return tiebom;
	}

	public void setTiebom(String tiebom) {
		this.tiebom = tiebom;
	}

	public String getKouyanbom() {
		return kouyanbom;
	}

	public void setKouyanbom(String kouyanbom) {
		this.kouyanbom = kouyanbom;
	}

	public String getSuitbutton() {
		return suitbutton;
	}

	public void setSuitbutton(String suitbutton) {
		this.suitbutton = suitbutton;
	}
	
	

}