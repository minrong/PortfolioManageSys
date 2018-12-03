package pojo;






public class Broker extends Person {
	
	private String type;
	
	private String secIdentifier;
	
	private final boolean isBroker = true;

	public Broker() {

	}
	
	public Broker(String code, String firstName, String lastName, String type, String secIdentifier) {
		super(code, firstName, lastName);
		this.type = type;
		this.secIdentifier = secIdentifier;
	}


	public Boolean getIsBroker() {
		return isBroker;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSecIdentifier() {
		return secIdentifier;
	}

	public void setSecIdentifier(String secIdentifier) {
		this.secIdentifier = secIdentifier;
	}
	

}
