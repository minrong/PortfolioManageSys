package pojo;

public class DepositAccount extends Asset {
	private Double apr;// annual percentage rate

	
	public DepositAccount() {

	}

	public DepositAccount(String code, String label, Double apr) {
		super(code, label);
		this.apr = apr;
	}

	public Double getApr() {
		return apr;
	}

	public void setApr(Double apr) {
		this.apr = apr;
	}

	@Override
	public String accountType() {
		return "D";
	}

	@Override
	public Double riskMeasure() {
		return 0.0;
	}

}
