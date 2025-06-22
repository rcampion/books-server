package com.zdslogic.server.plugins.books.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ADDRESS")
@IdClass(CustomerAddressEntityKey.class)
public class CustomerAddressEntity {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="customer_id", unique = true, nullable = false)
	private Integer customerId;

	@Id
	@Column(name="address_id", unique = true, nullable = false)
	private Integer addressId;

	@Column(name="status_id", unique = true, nullable = false)
	private Integer statusId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}


}
