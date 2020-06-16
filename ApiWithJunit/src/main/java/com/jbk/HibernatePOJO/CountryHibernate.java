package com.jbk.HibernatePOJO;
// Generated 23-May-2020 14:10:44 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "firstdemospringboot")
public class CountryHibernate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019259964450230620L;
	private Integer cid;
	private String cname;
	private Set<EmployeeHibernate> employees = new HashSet<>();

	public CountryHibernate() {
	}

	public CountryHibernate(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public CountryHibernate(String cname) {
		this.cname = cname;
	}

	public CountryHibernate(String cname, Set<EmployeeHibernate> employees) {
		this.cname = cname;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "cname", nullable = false, length = 45)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<EmployeeHibernate> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<EmployeeHibernate> employees) {
		this.employees = employees;
	}

		
}