<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page import="com.savargaonkar.MemberModel.MemberFamily" %>
    <%@page import="com.savargaonkar.MemberModel.Member" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<style>
.container {
	position: absolute;
	top: 10%;
	left: 20%;
}
</style>

<meta charset="ISO-8859-1">
<title>Family Tree</title>
<style>
	
</style>
</head>
<body>

	<%@ include file="Nav_bar.jsp"%>

	<div class="container">
		<h2>Family Tree</h2>	
		<c:if test="${not empty data}">		
			
			Name: <c:out value="${data.head.name} "/><br><br>
		
			Spouse Name: 	
			<c:if test="${not empty data.spouse}">
				<a href="HomeTree?id=<c:out value='${data.spouse.id}'/>">
					<c:out value="${data.spouse.name} "/>
				</a><br>
			</c:if>
			<c:if test="${empty data.spouse}">
				Unmarried<br>
			</c:if><br><br>
		
			Father name:
			<c:if test="${not empty data.father}">
				<a href="HomeTree?id=<c:out value='${data.father.id}'/>">
					<c:out value="${data.father.name} "/>
				</a><br>
			</c:if>
			<c:if test="${empty data.father}">
				-<br>
			</c:if>
		
			Mother name:
			<c:if test="${not empty data.mother}">
				<a href="HomeTree?id=<c:out value='${data.mother.id}'/>">
					<c:out value="${data.mother.name} "/>
				</a><br>
			</c:if>
			<c:if test="${empty data.mother}">
				-<br>
			</c:if><br><br>
				
			Children: 	
			<c:if test="${not empty data.children}">
				Number of Children: <c:out value="${data.number_children}"/><br>
				<c:forEach var ="child" items="${data.children}">
					<a href="HomeTree?id=<c:out value='${child.id}'/>">
						<c:out value="${child.name}"/>
					</a><br>
				</c:forEach>
			</c:if>
			<c:if test="${empty data.children }">
				No children
			</c:if>
		</c:if>	
		<c:if test="${empty data}">
			Data not found!!
		</c:if>
		
	  	<br><br>
	  	<a href=index.jsp>Home</a>
	  	<a href=Login.jsp>Logout</a>
	</div>
</html>
