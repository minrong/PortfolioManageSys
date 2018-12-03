package pojo;




public class Person {
	
	private Integer personId;
	
	private String code;
	
	private String firstName;
	
	private String lastName;

	public Person(){

	}
	
	public Person(String code, String firstName, String lastName){
		this.code=code;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Integer getPersonId() {
		return personId;
	}
	
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	public String getCode(){
		return code;
	}
	
	
	public void setCode(String code){
		this.code=code;
	}
	
	
}




