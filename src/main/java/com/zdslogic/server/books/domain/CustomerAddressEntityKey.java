package com.zdslogic.server.books.domain;

import java.io.Serializable;

public class CustomerAddressEntityKey implements Serializable {
	
	private Integer customerId;

	private Integer addressId;

    // default constructor

    public CustomerAddressEntityKey(Integer id1, Integer id2) {
        this.customerId = id1;
        this.addressId = id2;
    }

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

}

