<%-- 
    Document   : index.jsp
    Created on : 12/03/2017, 19:04:44
    Author     : Victor Moraes Ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login</h1>
        <br><hr>
        <form method="post" action="FrontControllerServlet?control=User&action=login">
            <p>
                <label for="email">Digite o email: </label>
                <input type="text" name="email" id="email"/>
            </p>
            <p>
                <label for="password">Digite a senha: </label>
                <input type="password" name="password" id="password"/>
            </p>
            <input type="submit" value="Entrar"/>
        </form>
        <a href="cadastro.jsp">Não possui registro? Cadastre-se aqui</a>
        <br> ${answer}
    </body>
</html>
