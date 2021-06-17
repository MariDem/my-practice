<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.marina.service.DataService" %>
<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    boolean result = new DataService().loginProcess(userName,password);
%>
<%if (result) {%>
<c:redirect url="../table/table-page.jsp"/>
<%} else {%>
<c:redirect url="log.jsp" context="Try again"/>
<%}%>
</body>
</html>
