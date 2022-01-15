<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="cxt" value="${pageContext.request.contextPath}" />

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>Ajouter un Employe</h1>
<form:form  action="${cxt}/saveEmploye" modelAttribute="employe" >
    <table>
        <tr>
            <td>Nom et prénom</td>
            <td><form:input type="text" path="nom" /></td>
        </tr>
        <tr>
            <td>Fonction:</td>
            <td><form:select path="fonction" >
                    <form:option value="ingenieur" label="ingenieur" />
                    <form:option value="Manager" label="Manager" />

                </form:select>
        </tr>
        <tr>

            <td>Departement:</td>
            <td>
                <form:select path="departement.id" items="${departement}"
                             itemValue="id" itemLabel="nom" />


            </td>
        </tr>



        <tr>

            <td>Projet:</td>
            <td>
                <form:select path="projet.id" items="${projet}"
                             itemValue="id" itemLabel="id" />


            </td>
        </tr>

        <td colspan="2">
            <input class="btn btn-warning" type="submit" value="enregistrer" />
        </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>