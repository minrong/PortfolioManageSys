<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add Stock</title>
</head>
<body>

	<h1>add Stock</h1>

		<form:form action="/assets/saveStock" modelAttribute="stock" method="POST">
			<form:input type = "hidden"  path="assetId" />
			<table>
				<tbody>

					<tr>
						<td><label>Base Rate Of Return:</label></td>
						<td><form:input path="baseRateOfReturn" /></td>
					</tr>
				
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
						<td><label>Price:</label></td>
						<td><form:input path="sharePrice" /></td>
					</tr>
					
					<tr>
						<td><label>Beta:</label></td>
						<td><form:input path="beta" /></td>
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