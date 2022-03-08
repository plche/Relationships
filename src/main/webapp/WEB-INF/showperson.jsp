<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 7/03/22
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Person Details</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-6">
                <h1>Person Details:</h1>
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th>Name</th>
                            <th>License Number</th>
                            <th>State</th>
                            <th>Exp Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></td>
                            <td><c:out value="${person.license.number}"/></td>
                            <td><c:out value="${person.license.state}"/></td>
                            <td><c:out value="${person.license.expirationDate}"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
