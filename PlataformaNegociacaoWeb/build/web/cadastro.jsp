<%-- 
    Document   : cadastro
    Created on : 12/03/2017, 20:07:53
    Author     : Victor Moraes Ribeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/validation.css">
    </head>
    <body>
        <h1>Cadastro</h1>
        <br><hr>
        <form method="post" action="FrontControllerServlet?control=User&action=register" onsubmit="return $(this).validateValuesUser()">
            <p>
                <label for="email">Digite o email: </label>
                <input type="text" name="email" id="email"/>
            </p>
            <p>
                <label for="password">Digite a senha: </label>
                <input type="password" name="password" id="password"/>
            </p>
            <p>
                <label for="password2">Digite a senha novamente: </label>
                <input type="password" name="password2" id="password2"/>
            </p>
            <p>
                <label for="name">Digite o nome: </label>
                <input type="text" name="name" id="name"/>
            </p>
            <p>
                <label for="lastname">Digite o sobrenome: </label>
                <input type="text" name="lastname" id="lastname"/>
            </p>
            <p>
                <label for="dtaNasc">Digite a data de nascimento: </label>
                <input type="text" name="dtaNasc" id="dtaNasc" placeholder="30/01/1980"/>
            </p>
            <p>
                <label for="cpf">Digite o cpf: </label>
                <input type="text" name="cpf" id="cpf"/>
            </p>
            <p>
                <label for="rg">Digite o rg: </label>
                <input type="text" name="rg" id="rg"/>
            </p>
            <p>
                <label for="phone">Digite o celular: </label>
                <input type="text" name="phone" id="phone" value=" "/>
            </p>
            <p>
                Selecione o estado: 
                <select id="estados" name="countryState">
                    <option value=""></option>
                </select>
            </p>
            <p>
                Selecione a cidade:  
                <select id="cidades" name="city">
                </select>
            </p>
            <p>
                <label for="cep">Digite o cep: </label>
                <input type="text" name="cep" id="cep"/>
            </p>
            <input type="submit" value="Registrar"/>
        </form>
        <br>${answer}
        
        <p class="red not-display" id="error-name">Nome incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-lastname">Sobrenome incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-email">Email incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-phone">Celular incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-pass-regex">
            A senha deve possuir um mínimo de 8 caracteres, sendo: 1 letra maiúscula, 1 letra minúscula, 1 número e 1 caractere especial.
        </p>
        <p class="red not-display" id="error-pass">Senhas não coincidem.</p>
        <p class="red not-display" id="error-cep">CEP incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-cpf">CPF incompleto ou com caracteres não permitidos.</p>
        <p class="red not-display" id="error-city">Escolha um estado e uma cidade.</p>
        <p class="red not-display" id="error-rg">RG incompleto.</p>
        <p class="red not-display" id="error-date">Data incompleta.</p>
        
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/estados_cidades.js"></script>
        <script src="js/jquery.maskedinput.min.js"></script>
        <script src="js/userFrontValidation.js"></script>
    </body>
</html>
