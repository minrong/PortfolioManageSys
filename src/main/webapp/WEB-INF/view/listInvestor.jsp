<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Investor</title>
</head>
<body>

	<h1>Investor in the system</h1>

	<h2></h2>
	<input type="button" value="ADD Investor" 
			onclick='window.location.href="addInvestor"; return false'/>
	<table>

		<tr>
			<th>personCode</th>
			<th>country</th>
			
			<!-- loop over and print out customer -->
			<c:forEach var="tempInvestor" items="${iv}">
			
				<tr>
					<td>${tempInvestor.personCode}</td>
					<td>${tempInvestor.country}</td>
					<td><a href="updateInvestor/?personId=${tempInvestor.personId}">Update</a>
					<td><a href="deleteInvestor/${tempInvestor.personId}">Delete</a></td>
				</tr>
			
			</c:forEach>
		</tr>

	</table>

</body>
</html>