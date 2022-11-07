<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 03.11.2022
  Time: 11:34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:each in="${books}">
    <p>${it.author} ${it.title}</p>
</g:each>
</body>
</html>