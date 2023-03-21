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
public class Employee {
	@Id
	@Column(name = "Emp_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String email;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Project> projects;

	public Employee() {
	}

	public Employee(String name, String email, List<Project> projects) {
		super();
		this.name = name;
		this.email = email;
		this.projects = projects;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	};

}
