package pojo;

public abstract class Investment extends Asset {
	private Double quarterlyDividend;
	private Double baseRateOfReturn;

	public Investment() {
		

	}

	public Investment(String code, String label, Double quarterlyDividend, Double baseRateOfReturn) {
		super(code, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;

	}

	public Double getQuarterlyDividend() {
		return quarterlyDividend;
	}

	public void setQuarterlyDividend(Double quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}

	public Double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}

	public void setBaseRateOfReturn(Double baseRateOfReturn) {
		this.baseRateOfReturn = baseRateOfReturn;
	}

	public abstract Double riskMeasure();

	public abstract String accountType();

}