package pojo;



public abstract class Asset {
	private Integer assetId;
	

	private String code;
	

	private String label;
	
	public Asset() {
	}
	
	public Asset(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public abstract Double riskMeasure();
	public abstract String accountType();
	
	public Integer getAssetId() {
		return assetId;
	}
	
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}