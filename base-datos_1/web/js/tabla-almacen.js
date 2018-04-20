/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$.ajax('buscar-almacen',{
    type:'get',
    dataType:'json',
    success: function(datos){
        for(var i=0;i<datos.length;i++){
           $("#tablita").append('<tr><td>'+datos[i].numero_almacen+'</td>"+<td>'+datos[i].ubicacion_almacen+'</td></tr>')
}
    }
})


$("#buscar_por_id").click(function () {

    //Activamos ajax
    $.ajax('buscar-id', {
        type: 'get',
        dataType:'json',
        data: {
            numero_almacen: $("#id_almacen").val(),
        
        },
        success: function(datos){
        for(var i=0;i<datos.length;i++){
           $("#tablita-porid").html('<tr><td>'+datos[i].numero_almacen+'</td>"+<td>'+datos[i].ubicacion_almacen+'</td></tr>')
}
    }
    })
})