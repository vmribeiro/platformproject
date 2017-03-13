<%-- 
    Document   : index
    Created on : 12/03/2017, 18:39:15
    Author     : Victor Moraes Ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Welcome ${user.userProfile.nameUser} ${user.userProfile.lastnameUser} ${user.userProfile.getFormattedDtaNasc()}</h1>
        <a href="FrontControllerServlet?control=User&action=forwardToUpdatePage&id=${user.idLogin}">Editar Perfil</a>
        ${link}
        ${answer}
    </body>
</html>

