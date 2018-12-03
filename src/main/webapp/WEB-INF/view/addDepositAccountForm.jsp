<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>

<title>add DepositAccount</title>

</head>

<body>

	<h1>add DepositAccount</h1>

		<form:form action="/assets/saveDepositAccount" modelAttribute="depositAccount" method="POST">
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
						<td><label>Apr:</label></td>
						<td><form:input path="apr" /></td>
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