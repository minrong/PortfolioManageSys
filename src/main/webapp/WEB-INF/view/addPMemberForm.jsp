<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Add Private Investment to Portfolio</h1>
		<form:form action="/portfolioMember/savePortfolioMember" modelAttribute="portfolioMember" method="POST">
			
			<table>
				<tbody>
				 	
				 	<form:input type = "hidden" path = "portfolioMemberId"/>
					<form:input type = "hidden" path = "portfolioId"/>
 					<tr>
						<td><label>Asset:</label></td>
						<td><form:select 
							path = "assetId" 
							items="${privateInvestmentView}" 
							itemLabel="assetCode" 
							itemValue="assetId"
						/></td>
					</tr>
					
					<tr>
						<td><label>Investment Percentage:</label></td>
						<td><form:input path = "assetParameter" /></td>
					</tr>
						
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"/></td>
					</tr>
				
				</tbody>
			</table>
		
		</form:form>



</body>
</html>