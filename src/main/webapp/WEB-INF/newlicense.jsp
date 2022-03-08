<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 7/03/22
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>New License</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-3">
                <div class="row">
                    <div class="col-8">
                        <h1 class="text-primary mb-3">New License</h1>
                    </div>
                </div>
                <form:form class="rounded border border-5 border-primary" action="/licenses/new" method="post" modelAttribute="license">
                    <div class="row justify-content-center">
                        <div class="col-9">
                            <form:label for="person" path="person" class="form-label mt-3">Person:</form:label>
                            <form:select class="form-select" path="person">
                                <c:forEach var="onePerson" items="${persons}">
                                    <!--- Cada opción VALUE es el id de la persona --->
                                    <form:option value="${onePerson.id}" path="person">
                                        <!--- Esto es lo que se muestra al usuario como opción --->
                                        <c:out value="${onePerson.firstName}" />
                                        <c:out value="${onePerson.lastName}" />
                                    </form:option>
                                </c:forEach>
                            </form:select>
                            <form:label for="state" path="state" class="form-label mt-3">State:</form:label>
                            <form:errors path="state" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="state" path="state" aria-label="License's state" />
                            <form:label for="expirationDate" path="expirationDate" class="form-label">Exp Date:</form:label>
                            <form:errors path="expirationDate" cssClass="text-danger" />
                            <form:input type="date" class="form-control mb-3" id="expirationDate" path="expirationDate" aria-label="License's Exp Date"/>
                            <div class="d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary mb-3">Create</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
