<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Portfolio</title>
</head>
<body>

	<h1>Portfolio in the system</h1>
	<input type="button" value="ADD Portfolio" 
			onclick='window.location.href="portfolio/addPortfolioForm"; return false'/>
	
	<table>

		<tr>
			<th>Code</th>
			<th>Owner</th>

			
			
			<!-- loop over and print out customer -->
			<c:forEach var="tempPortfolio" items="${portfolio}">
				<c:url var="detailLink" value="/portfolio/portfolioDetail">
					<c:param name="portfolioId" value="${tempPortfolio.portfolioId}" />
				</c:url>
				
				<tr>
					<td>${tempPortfolio.portfolioCode}</td>
					<td>${tempPortfolio.ownerFirstName}</td>
					<td><a href="${detailLink}">Detail</a></td>
					<td><a href="portfolio/updatePortfolio/?portfolioId=${tempPortfolio.portfolioId}">Update</a>
					<td><a href="portfolio/deletePortfolio/${tempPortfolio.portfolioId}">Delete</a>
					
				</tr>
			
			</c:forEach>
		</tr>

	</table>


</body>
</html>