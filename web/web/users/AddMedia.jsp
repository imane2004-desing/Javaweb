<%-- 
    Document   : AddMedia.jsp
    Created on : 1 mai 2025, 11:17:43
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un média</title>
    <style>
        /* (Styles CSS similaires à media.jsp) */
    </style>
</head>
<body>
    <div class="container">
        <h1>Ajouter un média</h1>
        <form action="AddMediaServlet" method="post">
            <div>
                <label for="titre">Titre:</label>
                <input type="text" id="titre" name="titre" required>
            </div>
            <div>
                <label for="auteur">Auteur:</label>
                <input type="text" id="auteur" name="auteur" required>
            </div>
            <!-- Ajoutez d'autres champs pour les informations du média -->
            <button type="submit">Ajouter</button>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>