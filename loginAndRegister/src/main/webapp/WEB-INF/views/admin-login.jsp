<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <main>
        <h1>Admin Login</h1>
        <form action="/admin/login" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" required>
            <label for="password">Password:</label>
            <input type="password" name="password" required>
            <button type="submit">Login</button>
        </form>
        <c:if test="${error != null}">
            <p style="color:red;">${error}</p>
        </c:if>
    </main>
</body>
</html>
