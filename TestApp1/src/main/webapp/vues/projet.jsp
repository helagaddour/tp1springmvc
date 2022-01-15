<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.Vector" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Insert title here</title>
    <c:set var="cxt" value="${pageContext.request.contextPath}" />

</head>
<body>
<h1>Liste des Projets</h1>
<h2>Département : ${departement.nom}  </h2>
<table border="1">
    <thead>
    <th> Id</th>
    <th> Titre</th>
    <th> etat</th>
    <th> </th>

    </thead>
    <tbody>
    <c:forEach items="${list}" var="projet">
        <tr>
            <td> ${projet.id}</td>
            <td> ${projet.titre}</td>
            <td> ${projet.etat}</td>
            <td><a href='${cxt}/employes/proj/${projet.id}'>Liste des employees</a></td>


        </tr>
    </c:forEach>
    </tbody>
</table>
<a href='${cxt}/ajoutProjet'>Ajouter un projet</a>

</body>
</html>