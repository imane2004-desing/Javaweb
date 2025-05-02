<%-- 
    Document   : profile.jsp
    Created on : 27 avr. 2025, 14:01:11
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon Profil</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.1em;
            color: #555;
            margin-bottom: 15px;
        }

        strong {
            font-weight: bold;
            color: #333;
        }

        a {
            display: inline-block;
            padding: 12px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Mon Profil</h1>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
                out.println("<div class='error-message'>" + errorMessage + "</div>");
            }
        %>
        <p><strong>Nom:</strong> ${user.nom}</p>
        <p><strong>Email:</strong> ${user.email}</p>
        <a href="EditProfileServlet">Modifier Profil</a>
        <a href="ChangePasswordServlet">Changer le mot de passe</a>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>