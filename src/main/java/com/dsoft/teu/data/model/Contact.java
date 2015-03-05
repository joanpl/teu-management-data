package com.dsoft.teu.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name= "Contact")
public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ADDRESS")
	private String address;	
	
	
	//TODO later on define countryCodes and Countries if necessary
	@Column(name = "COUNTRY", nullable = false, length = 2 )
	private String country;
	
	//TODO validation
	@Column(name = "POSTCODE")
	private String postCode;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	
	@Column(name = "EMAIL", nullable = false)
	private String email; //must be unique?
	
//	@Column(name = "PHONENUMBERS", nullable = false)
//	private List<String> phoneNumbers;

	
	@PrePersist
	public void prePersist() {
	    if(country == null) //We set default value in case if the value is not set yet.
	        country = "pt";
	    country = country.toLowerCase();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<String> getPhoneNumbers() {
//		return phoneNumbers;
//	}
//
//	public void setPhoneNumbers(List<String> phoneNumbers) {
//		this.phoneNumbers = phoneNumbers;
//	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        
        String fullAddress = email ;//+ phoneNumbers.toString();
        result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Contact))
            return false;
        Contact other = (Contact) obj;
        if (id > -1 && id != other.id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!(email.equals(other.email) && !address.equals(other.address)))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Contact [id=" + id + ", email=" + email + ", city="
                + city + ", address=" + address  + "]";
    }

}
