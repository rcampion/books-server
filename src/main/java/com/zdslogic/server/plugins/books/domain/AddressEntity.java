package com.zdslogic.server.plugins.books.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="address_id ", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId ;

	@Column(name="street_number", nullable = true, length = 120)
	private String streetNumber;
	
	@Column(name="street_name", nullable = true, length = 120)
	private String streetName;

	@Column(name="city", nullable = true, length = 120)
	private String city;
	
	@Column(name="country_id", nullable = true)
	private Integer countryId ;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

}
