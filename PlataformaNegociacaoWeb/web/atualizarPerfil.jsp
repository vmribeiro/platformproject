<%-- 
    Document   : perfil
    Created on : 13/03/2017, 12:50:55
    Author     : Victor Moraes Ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <h1>Alterar informações</h1>
        <br><hr>
        <form method="post" action="FrontControllerServlet?control=User&action=update&id=${user.idLogin}">
            <p>
                <label for="email">Digite o email: </label>
                <input type="text" name="email" id="email" value="${user.email}"/>
            </p>
            <p>
                <label for="name">Digite o nome: </label>
                <input type="text" name="name" id="name" value="${user.userProfile.nameUser}"/>
            </p>
            <p>
                <label for="lastname">Digite o sobrenome: </label>
                <input type="text" name="lastname" id="lastname" value="${user.userProfile.lastnameUser}"/>
            </p>
            <p>
                <label for="dtaNasc">Digite a data de nascimento: </label>
                <input type="text" name="dtaNasc" id="dtaNasc" placeholder="30/01/1980"  value="${user.userProfile.getFormattedDtaNasc()}"/>
            </p>
            <p>
                <label for="cpf">Digite o cpf: </label>
                <input type="text" name="cpf" id="cpf" value="${user.userProfile.cpf}"/>
            </p>
            <p>
                <label for="rg">Digite o rg: </label>
                <input type="text" name="rg" id="rg" value="${user.userProfile.rg}"/>
            </p>
            <p>
                <label for="phone">Digite o celular: </label>
                <input type="text" name="phone" id="phone" value="${user.userProfile.phone}"/>
            </p>
            <p>
                Selecione o estado: 
                <select id="estados" name="countryState">
                    <option value="${user.userProfile.countryState}" selected=""></option>
		</select>
            </p>
            <p>
                Selecione a cidade:  
                <select id="cidades" name="city">
                    <option value="${user.userProfile.city}" selected=""></option>
		</select>
            </p>
            <p>
                <label for="cep">Digite o cep: </label>
                <input type="text" name="cep" id="cep" value="${user.userProfile.cep}"/>
            </p>
            <p>
                <label for="password">Digite a senha: </label>
                <input type="password" name="password" id="password"/>
            </p>
            <p>
                <label for="password2">Digite a senha novamente: </label>
                <input type="password" name="password2" id="password2"/>
            </p>
            <input type="submit" value="Registrar"/>
        </form>            
        <br>${answer}
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/estados_cidades.js"></script>
    </body>
</html>
