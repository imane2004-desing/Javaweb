<%-- 
    Document   : index.jsp
    Created on : 27 avr. 2025, 14:00:36
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Système de Médiathèque</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
            line-height: 1.6;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            flex: 1; /* Permet au container de s'étendre et de pousser le footer vers le bas */
        }

        h1 {
            color: #35424a;
            text-align: center;
            margin-bottom: 20px;
        }

        main {
            padding: 20px;
        }

        p {
            font-size: 1.1em;
            color: #555;
        }

        /* Styles pour mettre en évidence les liens */
        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Styles pour le footer (si nécessaire) */
        footer {
            text-align: center;
            padding: 10px;
            background-color: #343a40;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <main>
            <h1>Bienvenue dans le Système de Médiathèque</h1>
            <p>Explorez notre vaste collection de médias. Découvrez des livres, des films, de la musique et bien plus encore.</p>
            <p>Consultez <a href="catalogue.jsp">notre catalogue</a> pour trouver ce que vous cherchez.</p>
            <p>Gérez vos <a href="emprunts.jsp">emprunts</a> en toute simplicité.</p>
        </main>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>