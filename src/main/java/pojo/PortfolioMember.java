package pojo;

public class PortfolioMember {
	private Integer portfolioMemberId;
	private Integer portfolioId;
	private Double assetParameter;
	private Integer assetId;

	public PortfolioMember() {

	}
	
	public PortfolioMember(Integer portfolio, Double assetParameter, Integer asset) {
		super();
		this.portfolioId = portfolio;
		this.assetParameter = assetParameter;
		this.assetId = asset;
	}

	
	public Integer getPortfolioMemberId() {
		return portfolioMemberId;
	}

	public void setPortfolioMemberId(Integer portfolioMemberId) {
		this.portfolioMemberId = portfolioMemberId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Double getAssetParameter() {
		return assetParameter;
	}
	public void setAssetParameter(Double assetParameter) {
		this.assetParameter = assetParameter;
	}

	
}
