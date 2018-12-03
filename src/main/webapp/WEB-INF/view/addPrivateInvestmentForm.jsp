<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>

<title>add Private Investment</title>

</head>

<body>

	<h1>add Private Investment</h1>

		<form:form action="/assets/savePrivateInvestment" modelAttribute="privateInvestment" method="POST">
			<form:input type = "hidden"  path="assetId" />
			<table>
				<tbody>
 					<tr>
						<td><label>Asset Code:</label></td>
						<td><form:input path="code" /></td>
					</tr>
				
					<tr>
						<td><label>Asset Label:</label></td>
						<td><form:input path="label" /></td>
					</tr> 

					<tr>
						<td><label>Quarterly Dividend:</label></td>
						<td><form:input path="quarterlyDividend" /></td>
					</tr>
					
					<tr>
						<td><label>Base Rate Of Return:</label></td>
						<td><form:input path="baseRateOfReturn" /></td>
					</tr>
					
					<tr>
						<td><label>Omega Base:</label></td>
						<td><form:input path="omegaBase" /></td>
					</tr>
					
					<tr>
						<td><label>Total Value:</label></td>
						<td><form:input path="totalValue" /></td>
					</tr>
					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"/></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
		
		 <a href="${pageContext.request.contextPath}/assets">Back to List</a>

</body>

</html>