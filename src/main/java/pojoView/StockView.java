package pojoView;

public class StockView {
	private Integer assetId;
	private String assetCode;
	private String assetLabel;
	private Double quarterlyDividend;
	private Double baseRateOfReturn;
	private Double sharePrice;
	private Double beta;
	
	public StockView() {
		
	}
	
	public StockView(Integer assetId, String assetCode, String assetLabel, Double quarterlyDividend,
			Double baseRateOfReturn, Double sharePrice, Double beta) {
		super();
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.assetLabel = assetLabel;
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.sharePrice = sharePrice;
		this.beta = beta;
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
	
	
	
	
}
