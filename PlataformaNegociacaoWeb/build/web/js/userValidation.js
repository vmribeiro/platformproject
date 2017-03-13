$(document).ready(function () {
	
	$('#phone').mask("(99)9999-9999?9");
	
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
        }

        return value.match(regex);
    };

    $.fn.validateValuesClient = function () {
    	
        var error = true;
        
        if (!$(this).validateRegex("name", $("#name").val())){
            $("#error-nome").removeClass("not-display");
            error = false;
        }else{
            $("#error-nome").addClass("not-display");
        }
        
        if (!$(this).validateRegex("email", $("#email").val())){
            $("#error-email").removeClass("not-display");
            error = false;
        }else{
            $("#error-email").addClass("not-display");
        }
        
        if (!$(this).validateRegex("phone", $("#phone").val())){
            $("#error-telefone").removeClass("not-display");
            error = false;
        }else{
            $("#error-telefone").addClass("not-display");
        }
         
        var error = true;
        if ($("#adress").val() == ""){
            $("#error-endereco").removeClass("not-display");
            error = false;
        }else{
            $("#error-endereco").addClass("not-display");
        }
        
        var error = true;
        if (!$("input[type='radio'][name='gender']").is(':checked')) {
            $("#error-sexo").removeClass("not-display");
            error = false;
        } else {
            $("#error-sexo").addClass("not-display");
        }
        
        return error;
    }

    $("#salvar").click(function () {
        $(this).validateValuesClient();
    });
});