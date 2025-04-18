<%-- Document : login.jsp Created on : 17 avr. 2025, 00:51:44 Author : hp --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> <!DOCTYPE html>

<html> <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1.0"> <title>Connexion</title> <style> * { margin: 0; padding: 0; box-sizing: border-box; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        body {
            background: linear-gradient(to bottom right, #6d28d9, #5b21b6, #4338ca);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }
        
        .login-container {
            background-color: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(12px);
            -webkit-backdrop-filter: blur(12px);
            border-radius: 16px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 100%;
            max-width: 420px;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }
        
        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .icon-container {
            display: inline-block;
            padding: 12px;
            background: linear-gradient(to bottom right, #8b5cf6, #6366f1);
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            margin-bottom: 16px;
        }
        
        .icon {
            width: 32px;
            height: 32px;
            fill: white;
        }
        
        .login-header h1 {
            font-size: 28px;
            font-weight: 700;
            color: white;
            margin-bottom: 10px;
        }
        
        .login-header p {
            color: rgba(224, 231, 255, 0.8);
            font-size: 14px;
        }
        
        form {
            width: 100%;
            margin-top: 24px;
        }
        
        table {
            width: 100%;
        }
        
        td {
            padding: 8px 0;
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: rgba(224, 231, 255, 0.9);
            font-size: 14px;
        }
        
        .input-container {
            position: relative;
            margin-bottom: 20px;
        }
        
        .input-icon {
            position: absolute;
            left: 12px;
            top: 50%;
            transform: translateY(-50%);
            width: 20px;
            height: 20px;
            fill: rgba(224, 231, 255, 0.7);
        }
        
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 12px 12px 12px 40px;
            background-color: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(224, 231, 255, 0.2);
            border-radius: 8px;
            font-size: 16px;
            color: white;
            transition: all 0.3s;
        }
        
        input[type="email"]::placeholder,
        input[type="password"]::placeholder {
            color: rgba(224, 231, 255, 0.5);
        }
        
        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: rgba(224, 231, 255, 0.5);
            box-shadow: 0 0 0 3px rgba(99, 102, 241, 0.3);
            outline: none;
        }
        
        input[type="submit"] {
            background: linear-gradient(to right, #6366f1, #8b5cf6);
            color: white;
            border: none;
            border-radius: 8px;
            padding: 14px 20px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
            width: 100%;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        
        input[type="submit"]:hover {
            background: linear-gradient(to right, #4f46e5, #7c3aed);
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.25);
        }
        
        .register-link {
            text-align: center;
            margin-top: 24px;
            font-size: 14px;
            color: rgba(224, 231, 255, 0.8);
        }
        
        .register-link a {
            color: rgba(224, 231, 255, 1);
            text-decoration: none;
            font-weight: 600;
            transition: color 0.3s;
        }
        
        .register-link a:hover {
            color: white;
            text-decoration: underline;
        }
        
        @media (max-width: 480px) {
            .login-container {
                padding: 30px 20px;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-header">
            <div class="icon-container">
                <svg class="icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
                    <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
                </svg>
            </div>
            <h1>Connexion</h1>
            <p>Veuillez vous connecter pour accéder à votre compte</p>
        </div>
        
        <form method="POST" action="LoginController">
            <table>
                <tr>
                    <td>
                        <label for="email">Email</label>
                        <div class="input-container">
                            <svg class="input-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"></path>
                                <polyline points="22,6 12,13 2,6"></polyline>
                            </svg>
                            <input type="email" id="email" name="email" placeholder="Entrez votre email" required/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="mdp">Mot de passe</label>
                        <div class="input-container">
                            <svg class="input-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <rect x="3" y="11" width="18" height="11" rx="2" ry="2"></rect>
                                <path d="M7 11V7a5 5 0 0 1 10 0v4"></path>
                            </svg>
                            <input type="password" id="mdp" name="motDePasse" placeholder="Entrez votre mot de passe" required/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Se connecter"/>
                    </td>
                </tr>
            </table>
        </form>
        
        <div class="register-link">
            Vous n'avez pas de compte ? <a href="register.jsp">S'inscrire</a>
        </div>
    </div>
</body>
</html>
