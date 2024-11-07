<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>

<%@include file="header.jsp" %>

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="login.jsp">login</a>
<br>
<a href="investimentos.jsp">investimentos</a>
<br>


<script src="resources/js/bootstrap.bundle.js"></script>

</body>
</html>