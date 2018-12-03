<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>
<html>
<head>
<meta charset="UTF-8">
<title>Add-Investor</title>

</head>
<body>

	<h1>add Investor</h1>



<form name="addInvestor" action="/people/saveInvestor" method="post">
	
	<spring:bind path="investor.personId" >
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>

	<spring:bind path="investor.code">
		<label>Person Code:</label>
   		<input type="text" onblur="validatePersonCode(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="investor.firstName">
		<label>First Name:</label>
   		<input type="text" onblur="validatePersonFirstName(this.value)" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="investor.lastName">
		<label>Last Name:</label>
   		<input type="text" onblur="validatePersonLastName(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="address.addressId">
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.personId">
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.street">
		<label>Street:</label>
   		<input type="text" onblur="validateAddressStreet(this.value)" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.country">
		<label>Country:</label>
   		<input type="text" onblur="validateAddressCountry(this.value)" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.state">
		<label>State:</label>
   		<input type="text" onblur="validateAddressState(this.value)" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<input type="submit" value="Save"/>
</form>
		 <a href="${pageContext.request.contextPath}/people/investor">Back to List</a>



</body>

<script type="text/javascript" src= "<%=basePath %>js/InvestorValidation.js"></script>

</html>