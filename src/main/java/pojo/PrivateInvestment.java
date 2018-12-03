package pojo;


public class PrivateInvestment extends Investment {
	private Double omegaBase;
	private Double totalValue;
	
	public PrivateInvestment() {

	}
	
	public PrivateInvestment(String code, String label, Double quarterlyDividend, Double baseRateOfReturn,
			Double omegaBase, Double totalValue) {
		super(code, label, quarterlyDividend, baseRateOfReturn);
		this.omegaBase = omegaBase;
		this.totalValue = totalValue;
	}
	
	
	public Double getOmegaBase() {
		return omegaBase;
	}
	public void setOmegaBase(Double omegaBase) {
		this.omegaBase = omegaBase;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public Double riskMeasure(){
		return Math.round(100*(omegaBase+Math.pow(Math.E, -100000/totalValue)))/100d;
	}

	@Override
	public String accountType(){
		return "P";
	}


}