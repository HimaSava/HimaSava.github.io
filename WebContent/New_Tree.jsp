<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page import="com.savargaonkar.MemberModel.MemberFamily" %>
    <%@page import="com.savargaonkar.MemberModel.Member" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="temp.css">
  <title>Family-Tree</title>
</head>
<body>

	<%@ include file="Nav_bar.jsp"%>
	
  <section class="flowchart">
    <c:if test="${not empty data}">
    <div class="master_parent">
    <div class="parent">
        <div class="label">
        	Father Name:<br>
          <c:if test="${not empty data.father}">
				<a href="HomeTree?id=<c:out value='${data.father.id}'/>">
					<c:out value="${data.father.name} "/>
				</a>
			</c:if>
			<c:if test="${empty data.father}">
				-
			</c:if>
        </div>
    </div>
    <div class="parent">
        <div class="label">
          Mother Name:<br>
          <c:if test="${not empty data.mother}">
				<a href="HomeTree?id=<c:out value='${data.mother.id}'/>">
					<c:out value="${data.mother.name} "/>
				</a>
			</c:if>
			<c:if test="${empty data.mother}">
				-
			</c:if>
        </div>
    </div>
  </div>
  <div class="person">
    <div class="node">
      <div class="main_person">
      <div class="label">
        <c:out value="${data.head.name} "/><br>
        asd<br>
        asd<br>
        asd<br>
        asd<br>
      </div>
      </div>
    </div>
    <div class="node">
        <div class="spouse">
      <div class="label">
        Spouse:
        <c:if test="${not empty data.spouse}">
				<a href="HomeTree?id=<c:out value='${data.spouse.id}'/>">
					<c:out value="${data.spouse.name} "/>
				</a>
		</c:if>
		<c:if test="${empty data.spouse}">
				Unmarried<br>
		</c:if>
      </div>
    </div>
    </div>
  </div>
    <div class="master_child">
    	<c:if test="${not empty data.children}">
				<c:forEach var ="child" items="${data.children}">
					<div class="children">
      					<div class="label">
					<a href="HomeTree?id=<c:out value='${child.id}'/>">
						<c:out value="${child.name}"/>
					</a>
					</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty data.children }">
				No children
			</c:if>
    <div class="children">
      <div class="label">
        Child 1
      </div>
    </div>
    
    </c:if>
	<c:if test="${empty data}">
			Data not found!!
	</c:if>
  </section>
</body>
</html>