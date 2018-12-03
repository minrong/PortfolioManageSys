<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Broker</title>
</head>
<body>


	<h1>Broker in the system</h1>

	<h2></h2>
	<input type="button" value="ADD Broker" 
			onclick='window.location.href="addBroker"; return false'/>
	<table>

		<tr>
			<th>personCode</th>
			<th>country</th>
			
			<!-- loop over and print out customer -->
			<c:forEach var="tempBroker" items="${bv}">
				<tr>
					<td>${tempBroker.personCode}</td>
					<td>${tempBroker.country}</td>
					<td><a href="updateBroker/?personId=${tempBroker.personId}">Update</a>
					<td><a href="deleteBroker/${tempBroker.personId}">Delete</a></td>
				</tr>
			
			</c:forEach>
		</tr>

	</table>
	


</body>
</html>