/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.controladores;

import com.jc.model.Almacen;
import com.jc.model.DAOAlmacen;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author T-102
 */
public class ServletGuardarAlmacen extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) // ****CAMBIAR A DO******
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
        String numero_almacen = request.getParameter("numero_almacen");
        String ubicacion_almacen = request.getParameter("ubicacion_almacen");
        
        //*****INVOCAMOS EL MODELO **********
        Almacen almacen=new Almacen();
        almacen.setNumero_almacen(Integer.parseInt(numero_almacen));
        almacen.setUbicacion_almacen(ubicacion_almacen);
        
        //Generamos el DAO
        DAOAlmacen daoa=new DAOAlmacen();
        daoa.guardar(almacen);
        
        //Enviamos la respuesta como JSON
        ObjectMapper maper=new ObjectMapper();
        
        //Generamos un objeto de respuesta,JAVA
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Almacén guardado con éxito");
        
        //Preparamos la salida
        PrintWriter salida=response.getWriter();
        
        //Convertimos a JSON y enviamos
        salida.print(maper.writeValueAsString(estatus));
        
        
        
        
    }
}    
    