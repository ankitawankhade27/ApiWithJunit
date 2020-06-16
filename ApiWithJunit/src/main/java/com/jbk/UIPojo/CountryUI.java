package com.jbk.UIPojo;

public class CountryUI {
	private int cid;
	private String cname;

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public CountryUI() {
		super();
	}

	public CountryUI(String cname) {
		super();
		this.cname = cname;
	}

	public CountryUI(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "CountryUI [cid=" + cid + ", cname=" + cname + "]";
	}

	

}
