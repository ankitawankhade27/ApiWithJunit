package com.jbk.UIPojo;

public class EmployeeUI {
	private int id;
	private String name;
	private String phoneno;
	private String department;
	private String status;
	private String createddtm;
	private String createdby;
	private String updateddtm;
	private String updatedby;
	private int cid;
	private String cname;
	public EmployeeUI() {
		super();
	}
	public EmployeeUI(String name, String phoneno, String department, String status, String createddtm,
			String createdby, String updateddtm, String updatedby, int cid, String cname) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.department = department;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.cid = cid;
		this.cname = cname;
	}
	
	
	public EmployeeUI(int id, String name, String phoneno, String department, String status, String createddtm,
			String createdby, String updateddtm, String updatedby, int cid, String cname) {
		super();
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.department = department;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.cid = cid;
		this.cname = cname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateddtm() {
		return createddtm;
	}
	public void setCreateddtm(String createddtm) {
		this.createddtm = createddtm;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdateddtm() {
		return updateddtm;
	}
	public void setUpdateddtm(String updateddtm) {
		this.updateddtm = updateddtm;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "EmployeeUI [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", department=" + department
				+ ", status=" + status + ", createddtm=" + createddtm + ", createdby=" + createdby + ", updateddtm="
				+ updateddtm + ", updatedby=" + updatedby + ", cid=" + cid + ", cname=" + cname + "]";
	}
	
}
