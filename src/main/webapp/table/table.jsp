<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.marina.service.DataService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InfPage</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    new DataService().addEntity(name,address);
%>
<%if (address.isEmpty() && name.isEmpty() && address.length() > 45 && name.length() > 45){%>

<%}%>
</body>
</html>
