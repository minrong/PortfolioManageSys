package pojoView;

public class PortfolioView {
	private Integer portfolioId;
	private String portfolioCode;
	private String ownerFirstName;
	private String ownerLastName;
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	private String managerFirstName;
	private String managerLastName;
	private Double value;
	private Double aggregatedRisk;
	private Double annualReturn;
	private Double fee;
	private Double commission;
	
	public PortfolioView() {
		
	}
	
	public PortfolioView(Integer portfolioId, String portfolioCode, String ownerFirstName, String ownerLastName,
			String beneficiaryFirstName, String beneficiaryLastName, String managerFirstName, String managerLastName,
			Double value, Double aggregatedRisk, Double annualReturn, Double fee, Double commission) {
		super();
		this.portfolioId = portfolioId;
		this.portfolioCode = portfolioCode;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.beneficiaryFirstName = beneficiaryFirstName;
		this.beneficiaryLastName = beneficiaryLastName;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.value = value;
		this.aggregatedRisk = aggregatedRisk;
		this.annualReturn = annualReturn;
		this.fee = fee;
		this.commission = commission;
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

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}

	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}

	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}

	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getAggregatedRisk() {
		return aggregatedRisk;
	}

	public void setAggregatedRisk(Double aggregatedRisk) {
		this.aggregatedRisk = aggregatedRisk;
	}

	public Double getAnnualReturn() {
		return annualReturn;
	}

	public void setAnnualReturn(Double annualReturn) {
		this.annualReturn = annualReturn;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}
	
	
	
	
}
