package pojoView;

public class DepositAccountView {
	private Integer assetId;
	private String assetCode;
	private String assetLabel;
	private Double apr;
	
	public DepositAccountView() {
		
	}
	
	
	public DepositAccountView(Integer assetId, String assetCode, String assetLabel, Double apr) {
		super();
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.assetLabel = assetLabel;
		this.apr = apr;
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


	public Double getApr() {
		return apr;
	}


	public void setApr(Double apr) {
		this.apr = apr;
	}
	
	
	
}
