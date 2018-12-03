package pojoView;

public class InvestorView {
	private Integer personId;
	private String personCode;
	private String firstName;
	private String lastName;
	private String country;
	private String state;
	private String street;
	
	public InvestorView() {
		
	}

	public InvestorView(Integer personId, String personCode, String firstName, String lastName, String country,
			String state, String street) {
		super();
		this.personId = personId;
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.state = state;
		this.street = street;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
