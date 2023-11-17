package com.zdslogic.server.books.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrderEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name = "order_date")
	private Timestamp orderDate;

	@Column(name="customer_id")
	private Integer customerId;	

	@Column(name="shipping_method_id")
	private Integer shippingMethodId;

	@Column(name="dest_address_id")
	private Integer destAddressId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(Integer shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public Integer getDestAddressId() {
		return destAddressId;
	}

	public void setDestAddressId(Integer destAddressId) {
		this.destAddressId = destAddressId;
	}


}
