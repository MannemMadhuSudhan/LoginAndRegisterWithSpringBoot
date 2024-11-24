<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - College Management System</title>
        <link rel="stylesheet" href="/css/style.css"> <!-- Link to the CSS file -->
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Register</a></li>
            </ul>
        </nav>
    </header>
    <main>
            <center>    <h2>Register</h2>      </center>   
        <form action="/register" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="branch">Select Branch:</label>
            <select name="branch" id="branch">
                <option value="arts">Arts</option>
                <option value="science">Science</option>
                <option value="engineering">Engineering</option>
            </select><br>

            <input type="submit" value="Register">
        </form>
        <p><%= request.getAttribute("success") != null ? request.getAttribute("success") : "" %></p>
    </main>
</body>
</html>
