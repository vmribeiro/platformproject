$(document).ready(function () {

    $("#cep").mask("99.999-999");
    $("#rg").mask("99.999.999-9");
    $("#cpf").mask("999.999.999-99");
    $('#phone').mask("(99)9999?9-9999");
    $("#dtaNasc").mask("99/99/9999");

    //Validação com regex
    $.fn.validateRegex = function (type, value) {
        var regex;
        switch (type) {
            case "phone":
                //Celular ou telefone
                regex = /^(?:(?:\+|00)?(55)\s?)?(?:\(?([1-9][0-9])\)?\s?)?(?:((?:9\d|[2-9])\d{3})\-?(\d{4}))$/;
                break;

            case "email":
                regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                break;

            case "name":
                regex = /^([ \u00c0-\u01ffa-zA-Z'\-])+$/;
                break;

            case "password":
                //Minimum 8 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character.
                regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
                break;
               
            case "cpf":
                regex = /^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$/;
                break;
                
            case "date":
                // 00/00/0000
                regex = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/;
                break;
                
            case "cep":
                regex = /^[0-9]{2}.[0-9]{3}-[0-9]{3}$/;
                break;
            
        }

        return value.match(regex);
    };

    $.fn.validateValuesUser = function () {

        var error = true;

        if (!$(this).validateRegex("name", $("#name").val())) {
            $("#error-name").removeClass("not-display");
            error = false;
        } else {
            $("#error-name").addClass("not-display");
        }

        if (!$(this).validateRegex("name", $("#lastname").val())) {
            $("#error-lastname").removeClass("not-display");
            error = false;
        } else {
            $("#error-lastname").addClass("not-display");
        }

        if (!$(this).validateRegex("email", $("#email").val())) {
            $("#error-email").removeClass("not-display");
            error = false;
        } else {
            $("#error-email").addClass("not-display");
        }

        if (!$(this).validateRegex("phone", $("#phone").val())) {
            $("#error-phone").removeClass("not-display");
            error = false;
        } else {
            $("#error-phone").addClass("not-display");
        }
        
        if (!$(this).validateRegex("cpf", $("#cpf").val())) {
            $("#error-cpf").removeClass("not-display");
            error = false;
        } else {
            $("#error-cpf").addClass("not-display");
        }
        
        if (!$(this).validateRegex("cep", $("#cep").val())) {
            $("#error-cep").removeClass("not-display");
            error = false;
        } else {
            $("#error-cep").addClass("not-display");
        }
        
        if (!$(this).validateRegex("date", $("#dtaNasc").val())) {
            $("#error-date").removeClass("not-display");
            error = false;
        } else {
            $("#error-date").addClass("not-display");
        }

        if (!$(this).validateRegex("password", $("#password").val()) || !$(this).validateRegex("password", $("#password2").val())){
            $("#error-pass-regex").removeClass("not-display");
            error = false;
        }else{
            $("#error-pass-regex").addClass("not-display");
        }
        
        if ($("#rg").val() == 0.0) {
            $("#error-rg").removeClass("not-display");
            error = false;
        } else {
            $("#error-rg").addClass("not-display");
        }
        
         if ($("#estados").val() == undefined) {
            $("#error-state").removeClass("not-display");
            error = false;
        } else {
            $("#error-state").addClass("not-display");
        }
        
        if ($("#cidades").val() == undefined) {
            $("#error-city").removeClass("not-display");
            error = false;
        } else {
            $("#error-city").addClass("not-display");
        }

        return error;
    };

    $("#salvar").click(function () {
        $(this).validateValuesUser();
    });
});