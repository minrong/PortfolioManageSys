package pojo;

public class Investor extends Person {
	
	private final boolean isBroker = false;
	
	public Investor() {

	}
	
	public Investor(String code,String firstName, String lastName) {
		super(code, firstName, lastName);
	}


	public Boolean getIsBroker() {
		return isBroker;
	}

	
	
}
