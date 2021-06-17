<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>BLACKLIST</title>
    <link rel="stylesheet" type="text/css" href="../css/tablestyle.css">
</head>
<body>
<jsp:useBean id="DataService" class="by.marina.service.DataService" scope="request"/>

<c:if test="${fn:length(DataService.allEntitiesForResponse) > 0}">
    <table class="styled-table" >
        <thead>
        <tr>
            <td>
                ID
            </td>
            <td>
                Name
            </td>
            <td>
                Address
            </td>>
        </tr>
        </thead>
        <c:forEach var="customer" items="${DataService.allEntitiesForResponse}">
            <tr>
                <td>
                        ${customer.id}
                </td>
                <td>
                        ${customer.name}
                </td>
                <td>
                        ${customer.address}
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${fn:length(DataService.allEntitiesForResponse) == 0}">
    <c:redirect url="../index.jsp"/>
</c:if>
<form method = "POST" action="table.jsp">
    <br>
    <center><input type="text" name="name" value="" placeholder="Name" required></center>
    <br>
    <center><input type="text" name="address" value="" placeholder="Address" required></center>
    <br>
    <center><input type="submit" value="Sumbit"></center>
</form>
<form method="post">
    <center><input type="submit" value="Log Out"></center>
</form>
</body>
</html>