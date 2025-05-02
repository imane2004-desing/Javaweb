<%-- 
    Document   : media.jsp
    Created on : 27 avr. 2025, 14:01:30
    Author     : hp
--%>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Médias</title>
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
            width: 90%;
            max-width: 1200px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .action-links {
            display: flex;
            justify-content: space-around;
        }

        .action-links a {
            padding: 8px 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .action-links a:hover {
            background-color: #218838;
        }

        .add-media-button {
            display: block;
            margin: 20px auto;
            padding: 12px 20px;
            background-color: #17a2b8;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
            transition: background-color 0.3s ease;
            width: fit-content;
        }

        .add-media-button:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Liste des Médias</h1>

        <a href="AddMedia.jsp" class="add-media-button">Ajouter un média</a>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${mediaList}" var="media">
                    <tr>
                        <td>${media.id}</td>
                        <td>${media.titre}</td>
                        <td>${media.auteur}</td>
                        <td class="action-links">
                            <a href="EditMediaServlet?id=${media.id}">Modifier</a>
                            <a href="DeleteMediaServlet?id=${media.id}">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>