package com.gl.HibernateAssgmnt5.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Project {
	@Id
	@Column(name = "Project_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String pname;
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Employee> employees;
	
	public Project() {}

	public Project(String pname, List<Employee> employees) {
		super();
		this.pname = pname;
		this.employees = employees;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [Id=" + Id + ", pname=" + pname + "]";
	};
	
	
	
}
