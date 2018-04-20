
//Manejamos el clickeo del botón cuyo id es "guardar_almacen"

$("#guardar_almacen").click(function () {

    //Activamos ajax
    $.ajax('guardar-almacen', {
        type: 'post',
        dataType:'json',
        data: {
            numero_almacen: $("#numero_almacen").val(),
            ubicacion_almacen: $("#ubicacion_almacen").val()
        },
        success: function (datos) {
            $("#resultado_guardar").html(datos.mensaje);
        }
    })
})
$.ajax('buscar-almacen',{
    type:'get',
    dataType:'json',
    success: function(datos){
        for(var i=0;i<datos.length;i++){
           $("#tablita").append('<tr><td>'+datos[i].numero_almacen+'</td>"+<td>'+datos[i].ubicacion_almacen+'</td></tr>')
}
    }
})

$("#buscar-id").click(function () {

    //Activamos ajax
    $.ajax('buscar-id', {
        type: 'get',
        dataType:'json',
        data: {
            numero_almacen: $("#numero_almacen").val(),
            ubicacion_almacen: $("#ubicacion_almacen").val()
        },
        success: function (datos) {
            $("#resultado_guardar").html(datos.mensaje);
        }
    })
})
