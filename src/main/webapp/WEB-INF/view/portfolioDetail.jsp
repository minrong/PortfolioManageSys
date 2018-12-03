<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>detail coming </h1>

	<c:out value="${portfolioView.ownerFirstName}"></c:out>
	<c:out value="${portfolioView.ownerLastName}"></c:out>

	<input type="button" value="ADD Stock Investment" 
			onclick='window.location.href="/portfolioMember/addSMemberForm/?portfolioId=${portfolioView.portfolioId}"; return false'/>
	
	<input type="button" value="ADD Private Investment" 
			onclick='window.location.href="/portfolioMember/addPMemberForm/?portfolioId=${portfolioView.portfolioId}"; return false'/>
	
	<input type="button" value="ADD DepositAccount" 
			onclick='window.location.href="/portfolioMember/addDMemberForm/?portfolioId=${portfolioView.portfolioId}"; return false'/>
	
	<table>
		<tr>
			<th>Asset Code</th>
			<th>Account Type</th>
			<th>Account Value</th>
			<th>Number Of holds</th>
			<th>Update the holds</th>
			<th>delete</th>

			<c:forEach var="tempPortfolio" items="${portfolioMember}">

				<tr>
					<td><c:out value="${tempPortfolio.assetCode}"></c:out></td>
					<td><c:out value="${tempPortfolio.accountType}"></c:out></td>
					<td><c:out value="${tempPortfolio.value_}"></c:out></td>
					<td><c:out value="${tempPortfolio.parameter}"></c:out></td>
					<td><a href="/portfolioMember/updatePortfolioMember/?portfolioMemberId=${tempPortfolio.portfolioMemberId}">Update</a>
					<td><a href="/portfolioMember/deletePortfolioMember/${tempPortfolio.portfolioMemberId}">Delete</a>
					
				</tr>
			</c:forEach>
		</tr></table>


</body>

<script type="text/javascript">
	function diag(){
	    var num; 
	    num = prompt("enter a number to buy more holds：");
	    if(!isNaN(num)){
	       alert("you want to buy " + num + " more");
	       return num;
	    }else{
	       alert("pls enter a number");
	    }
	    
	}
 </script>
</html>