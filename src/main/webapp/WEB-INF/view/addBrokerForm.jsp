<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<title>add Broker</title>
</head>

<body>

	<h1>add broker</h1>

<form name=“addBroker” action="/people/saveBroker" method="post">
	
	<spring:bind path="broker.personId" >
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.personId" >
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	<spring:bind path="address.addressId" >
   		<input type="hidden" name="${status.expression}" value="${status.value}"><br/>
	</spring:bind>
	
	
	<spring:bind path="broker.code">
		<label>Person Code:</label>
   		<input type="text" onblur="validatePersonCode(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="broker.firstName">
		<label>First Name:</label>
   		<input type="text" onblur="validateFirstName(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="broker.lastName">
		<label>Last Name:</label>
   		<input type="text" onblur="validateLastName(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="broker.type">
		<label>Broker Type:</label>
 		  <input type="radio" name= "type" value="E" <c:if test = "${broker.type=='E'}">checked="checked"</c:if> /> Expert <br />
  		  <input type="radio" name= "type" value="J" <c:if test = "${broker.type=='J'}">checked="checked"</c:if> /> Junior <br />
	</spring:bind>
	
	<spring:bind path="broker.secIdentifier">
		<label>Broker Second Identifier:</label>
   		<input type="text" onblur="validateSecIdentifier(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="address.street">
		<label>Street:</label>
   		<input type="text" onblur="validateStreet(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="address.country">
		<label>Country:</label>
   		<input type="text" onblur="validateCountry(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<spring:bind path="address.state">
		<label>State:</label>
   		<input type="text" onblur="validateState(this.value)" name="${status.expression}" value="${status.value}"><br />
	</spring:bind>
	
	<input type="submit" value="Save"/>
</form>
		 <a href="${pageContext.request.contextPath}/people/broker">Back to List</a>


</body>



<script type="text/javascript" src= "<%=basePath %>js/BrokerValidation.js"></script>
</html>