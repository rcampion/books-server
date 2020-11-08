package com.rkc.zds.books.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer")
public class CustomerDTO {
	@Id
	@Column(name="id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Size(min = 0, max = 45)
	@Column(name = "Name", nullable = true, length = 20)
	private String name;


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



}
