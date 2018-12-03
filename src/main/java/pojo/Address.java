package pojo;



public class Address {
	
	private Integer addressId;
	

	private String street;
	

	private String state;
	

	private String country;
	
	
	private Integer personId;

	public Address() {

	}
	
	public Address(String street, String state, String country) {
		this.street = street;
		this.state = state;
		this.country = country;
	}
	
	

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getAddressId() {
		return addressId;
	}
	
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
