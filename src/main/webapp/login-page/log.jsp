<%@ page import="by.marina.service.DataService" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../css/start.css">
</head>
<body background="https://i.ytimg.com/vi/e6SKtbYPS_8/maxresdefault.jpg">
    <form method = "POST" action="logPage.jsp">
        <br>
        <center><input type="text" name="userName" value="" placeholder="Enter Username" required></center>
        <br>
        <center><input type="text" name="password" value="" placeholder="Enter Password" required></center>
        <br>
        <center><input type="submit" value="Sumbit"></center>
    </form>
</body>
</html>