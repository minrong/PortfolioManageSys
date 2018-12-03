package pojoView;

public class PortfolioMemberView {
	private Integer portfolioMemberId;
	private Integer portfolioId;
	private Integer assetId;
	private String accountType;
	private String assetCode;
	private String assetLabel;
	private Double value_;
	private Double annualReturn;
	private Double returnRate;
	private Double parameter;
	
	public PortfolioMemberView() {
		
	}
	
	public PortfolioMemberView(Integer portfolioMemberId, Integer portfolioId, Integer assetId, String accountType, String assetCode, String assetLabel,
			Double value_, Double annualReturn, Double returnRate,Double parameter) {
		super();
		this.portfolioMemberId = portfolioMemberId;
		this.portfolioId = portfolioId;
		this.assetId = assetId;
		this.accountType = accountType;
		this.assetCode = assetCode;
		this.assetLabel = assetLabel;
		this.value_ = value_;
		this.annualReturn = annualReturn;
		this.returnRate = returnRate;
		this.parameter = parameter;
	}

	public Double getParameter() {
		return parameter;
	}

	public void setParameter(Double parameter) {
		this.parameter = parameter;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public Double getValue_() {
		return value_;
	}

	public void setValue_(Double value_) {
		this.value_ = value_;
	}

	public Double getAnnualReturn() {
		return annualReturn;
	}

	public void setAnnualReturn(Double annualReturn) {
		this.annualReturn = annualReturn;
	}

	public Double getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(Double returnRate) {
		this.returnRate = returnRate;
	}
	
	
	
	
}
