<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 08.11.2022
  Time: 1:10
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>

<body>
<form method="post">
    <label>Login:
        <input type="text" name="login"><br/>
    </label>

    <label>Password:
        <input type="password" name="password"><br/>
    </label>

    <button type="submit">Login</button>
</form>
<a href="/registration">
    <button>Registration</button>
</a>
</body>
</html>