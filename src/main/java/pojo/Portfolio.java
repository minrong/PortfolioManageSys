package pojo;



public class Portfolio {
	private Integer portfolioId;
	
//	@NotEmpty(message = "portfolioCode不能为空")
	private String portfolioCode;
	
	private Integer ownerId,beneficiaryId,managerId;
	
	public Portfolio() {

	}
	
	public Portfolio(String portfolioCode, Integer owner, Integer beneficiary, Integer manager) {
		this.portfolioCode = portfolioCode;
		this.ownerId = owner;
		this.beneficiaryId = beneficiary;
		this.managerId = manager;
	}
	


	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public String getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



}