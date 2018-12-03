package pojo;

public class Stock extends Investment {
	private Double sharePrice;
	private Double beta;// risk measurement beta

	public Stock() {
	}

	public Stock(String code, String label, Double quarterlyDividend, Double baseRateOfReturn, Double sharePrice,
			Double beta) {
		super(code, label, quarterlyDividend, baseRateOfReturn);
		this.sharePrice = sharePrice;
		this.beta = beta;
	}


	
	public Double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(Double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public Double getBeta() {
		return beta;
	}

	public void setBeta(Double beta) {
		this.beta = beta;
	}

	@Override
	public String accountType() {
		return "S";
	}

	@Override
	public Double riskMeasure() {
		return Math.round(100 * beta) / 100d;
	}


}