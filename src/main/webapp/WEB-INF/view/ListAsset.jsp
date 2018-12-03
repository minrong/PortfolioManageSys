<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>

<title>list Asset</title>

</head>

<body>

	<h1>Assets in the system</h1>

	<h2>Stocks</h2>
	<input type="button" value="ADD Stock" 
			onclick='window.location.href="assets/addStockForm"; return false'/>
	<table>

		<tr>
			<th>Code</th>
			<th>Label</th>
			<th>Price</th>
			<th>Quarterly Dividend</th>
			<th>Base Rate Of Return</th>
			<th>Beta</th>
			
			<!-- loop over and print out customer -->
			<c:forEach var="tempstock" items="${sv}">
			
				<tr>
					<td>${tempstock.assetCode}</td>
					<td>${tempstock.assetLabel}</td>
					<td>${tempstock.sharePrice}</td>
					<td>${tempstock.quarterlyDividend}</td>
					<td>${tempstock.baseRateOfReturn}</td>
					<td>${tempstock.beta}</td>
					<td><a href="assets/updateStock/?assetId=${tempstock.assetId}">Update</a>
					<td><a href="assets/deleteAsset/${tempstock.assetId}">Delete</a></td>
				</tr>
			
			</c:forEach>
		</tr>

	</table>
	
	<h2>Deposit Account</h2>
	<input type="button" value="ADD Deposit Account" 
			onclick='window.location.href="assets/addDepositAccountForm"; return false'/>
	<table>

		<tr>
			<th>Code</th>
			<th>Label</th>
			<th>Apr</th>

			
			<!-- loop over and print out customer -->
			<c:forEach var="tempdeps" items="${dav}">
			
				<tr>
					<td>${tempdeps.assetCode}</td>
					<td>${tempdeps.assetLabel}</td>
					<td>${tempdeps.apr}</td>
					<td><a href="assets/updateDepositAccount/?assetId=${tempdeps.assetId}">Update</a>
					<td><a href="assets/deleteAsset/${tempdeps.assetId}">Delete</a></td>
				</tr>
			
			</c:forEach>
		</tr>

	</table>
	
	
	<h2>Private Investment</h2>
	<input type="button" value="ADD Private Investment" 
			onclick='window.location.href="assets/addPrivateInvestmentForm"; return false'/>
	<table>

		<tr>
			<th>Code</th>
			<th>Label</th>
			<th>Total Value</th>
			<th>Omega</th>
			<th>Quarterly Dividend</th>
			<th>Base Rate Of Return</th>


			
			<!-- loop over and print out customer -->
			<c:forEach var="temppriv" items="${piv}">
			
				<tr>
					<td>${temppriv.assetCode}</td>
					<td>${temppriv.assetLabel}</td>
					<td>${temppriv.valueOfPrivateInvestment}</td>
					<td>${temppriv.omegaBase}</td>
					<td>${temppriv.quarterlyDividend}</td>
					<td>${temppriv.baseRateOfReturn}</td>
					<td><a href="assets/updatePrivateInvestment/?assetId=${temppriv.assetId}">Update</a>
					<td><a href="assets/deleteAsset/${temppriv.assetId}">Delete</a></td>
				</tr>
			
			</c:forEach>
		</tr>

	</table>



</body>

</html>