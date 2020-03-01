package com.tutorial.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "employee")
public class EmployeeDocument {
	
	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "name", type = "string")
	private String name;

	@Indexed(name = "email", type = "string")
	private String email;

	@Indexed(name = "address", type = "string")
	private String address;

	@Indexed(name = "telephone", type = "string")
	private String telephone;
	
	public EmployeeDocument() {
	}

	public EmployeeDocument(String id, String name, String email, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}