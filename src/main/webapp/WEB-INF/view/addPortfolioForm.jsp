<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Portfolio</title>
</head>
<body>

	<h1>add Portfolio</h1>

		<form:form action="/portfolio/savePortfolio" modelAttribute="portfolio" method="POST">
			<form:input type = "hidden" path="portfolioId" />
			<td><form:errors path="portfolioId" /></td>
			<table>
				<tbody>
				 	
 					<tr>
						<td><label>Portfolio Code:</label></td>
						<td><form:input path="portfolioCode" /></td>
						<td><form:errors path="portfolioCode" /></td>
					</tr>
				
					<tr>
						<td><label>Owner</label></td>
						<td><form:select path="ownerId">
							<c:forEach items="${investorviews}" var="list">
								
                            	<option value="${list.personId}" 
									<c:if test = "${portfolio.ownerId == list.personId}">
										selected = 'selected'
									</c:if>
								>${list.personId}.${list.personCode}: ${list.firstName} ${list.lastName}</option>
                        	</c:forEach>
							
						</form:select></td>
						<td><form:errors path="ownerId" /></td>
					</tr> 

					<tr>
						<td><label>Beneficiary</label></td>
						<td><form:select path="beneficiaryId">
							<option value = "" />
							<c:forEach items="${investorviews}" var="list">
                            	<option value="${list.personId}"
									<c:if test = "${portfolio.beneficiaryId == list.personId}">
										selected = 'selected'
									</c:if>
								>${list.personId}.${list.personCode}: ${list.firstName} ${list.lastName}</option>
                        	</c:forEach>
						</form:select></td>
						<td><form:errors path="beneficiaryId" /></td>
					</tr>
					
					<tr>
						<td><label>Manager</label></td>
						<td><form:select path="managerId">
							<c:forEach items="${brokerviews}" var="list">
								
                            	<option value="${list.personId}"
									<c:if test = "${portfolio.managerId == list.personId}">
										selected = 'selected'
									</c:if>
								>${list.personId}.${list.personCode}: ${list.firstName} ${list.lastName}</option>
                        	</c:forEach>
						</form:select></td>
						<td><form:errors path="managerId" /></td>
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