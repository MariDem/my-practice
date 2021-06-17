<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>login</title>
</head>
<body >
<jsp:useBean id="DataService" class="by.marina.service.DataService" scope="request"/>
    <%
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userName != null) {
            if (password != null) {
                DataService.loginProcess(userName, password);
            }
        }
    %>

</body>
</html>
