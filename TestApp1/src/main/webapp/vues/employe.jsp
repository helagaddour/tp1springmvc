<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.Vector" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="cxt" value="${pageContext.request.contextPath}" />

    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Liste des projet</h1>
<h2>Département : ${departement.nom}  </h2>
<table border="1">
    <thead>
    <th>Id</th>
    <th>Nom</th>
    <th>Fonction</th>

    </thead>
<tbody>
    <c:forEach items="${list}" var="projet">
        <tr>
            <td> ${projet.id}</td>
            <td> ${projet.nom}</td>
            <td> ${projet.fonction}</td>

        </tr>
    </c:forEach>
</tbody>
</table>
<a href='${cxt}/ajoutEmploye'>Ajouter un employe</a>


</body>
</html>