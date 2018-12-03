package pojoView;

public class PrivateInvestmentView {
	private Integer assetId;
	private String assetCode;
	private String assetLabel;
	private Double quarterlyDividend;
	private Double baseRateOfReturn;
	private Double omegaBase;
	private Double valueOfPrivateInvestment;
	
	public PrivateInvestmentView() {
		
	}
	
	public PrivateInvestmentView(Integer assetId, String assetCode, String assetLabel, Double quarterlyDividend,
			Double baseRateOfReturn, Double omegaBase, Double valueOfPrivateInvestment) {
		super();
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.assetLabel = assetLabel;
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.omegaBase = omegaBase;
		this.valueOfPrivateInvestment = valueOfPrivateInvestment;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetLabel() {
		return assetLabel;
	}

	public void setAssetLabel(String assetLabel) {
		this.assetLabel = assetLabel;
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

	public Double getOmegaBase() {
		return omegaBase;
	}

	public void setOmegaBase(Double omegaBase) {
		this.omegaBase = omegaBase;
	}

	public Double getValueOfPrivateInvestment() {
		return valueOfPrivateInvestment;
	}

	public void setValueOfPrivateInvestment(Double valueOfPrivateInvestment) {
		this.valueOfPrivateInvestment = valueOfPrivateInvestment;
	}
	
	
	
	
}
