
//alert("primer aplicacion con ajax");

console.log("Para depurar en Google Chrome");

//EL PRINCIPIO DE AJAX

//Programamos el evento del botón

$("#ingresar").click(function(){
    //$("#respuesta").html("Haz oprimido el botón!!!")
    //$("#ingresar").hide();
    
    //PRIMERO INVOCAMOS AJAX
    $.ajax('autenticate-tonto',{
        type:'post',
        data:{
            usuario:$("#usuario").val(),
            password:$("#password").val()
        },
        success:function(gato){
            $("#respuesta").html(gato);
            
            //LOGICA AUTENTICAR Y MOSTRAR 
          $("#bienvenido").show();
          $("#ventana-autenticar").hide();
            
        }
    })
})


$("#ingresar").click(function(){
    //$("#respuesta").html("Haz oprimido el botón!!!")
    //$("#ingresar").hide();
    
    //PRIMERO INVOCAMOS AJAX
    $.ajax('autenticate-tonto',{
        type:'post',
        data:{
            usuario:$("#usuario").val(),
            password:$("#password").val()
        },
        success:function(gatoo){
            $("#respuesta").html(gatoo);
            
            //LOGICA AUTENTICAR Y MOSTRAR 
           $("#bienvenidoo").show();
         $("#ventana-autenticar").hide();
            
            
        }
    })
})














$("#respuesta").click(function(){
    //$("#ingresar").show();
})
    



