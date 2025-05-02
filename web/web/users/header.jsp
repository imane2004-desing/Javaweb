<%-- 
    Document   : header.jsp
    Created on : 27 avr. 2025, 13:59:53
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    header {
        background: #35424a;
        color: #ffffff;
        padding: 10px 0;
    }
    header .logo {
        float: left;
        font-size: 24px;
        margin-left: 20px;
    }
    nav ul {
        list-style: none;
        padding: 0;
    }
    nav ul li {
        display: inline;
        margin-right: 20px;
    }
    nav ul li a {
        color: #ffffff;
        text-decoration: none;
    }
</style>
<header>
    <div class="logo">Médiathèque</div>
    <nav>
        <ul>
            <li><a href="index.jsp">Accueil</a></li>
            <li><a href="media.jsp">Médias</a></li>
            <li><a href="emprunts.jsp">Emprunts</a></li>
            <li><a href="profile.jsp">Mon Profil</a></li>
            <li><a href="login.jsp">Connexion</a></li>
        </ul>
    </nav>
</header>