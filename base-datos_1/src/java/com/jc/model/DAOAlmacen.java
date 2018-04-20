/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;

import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

public class DAOAlmacen {
    
    public void guardar(Almacen almacen){
    
        try{
      Connection con=Conexion.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_almacen(?,?)}");
 
        callate.setInt(1,almacen.getNumero_almacen());
        callate.setString(2,almacen.getUbicacion_almacen());
      
        callate.execute();
  
        System.out.println("Almacen Guardado con éxito");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizar(Almacen almacen){
    
    }
    
    public ArrayList<Almacen> buscarPorId(Integer id){
    
        ArrayList<Almacen> datos =new ArrayList<Almacen>();
        
        try {
            Connection con = Conexion.conectarse();
            CallableStatement callate = con.prepareCall("{call buscarporid(?,?)}");
            callate.setInt(1,id);
            callate.registerOutParameter(2, OracleTypes.CURSOR);
            callate.executeUpdate();
            ResultSet res = (ResultSet) callate.getObject(2);

            while (res.next()) {
                Integer numero = res.getInt(1);
                String ubicacion = res.getString(2);
                //EN CADA ITERACIÓN INTEGRAMOS AL ARRAYLIST CADA FILA
                Almacen alma=new Almacen();
                alma.setNumero_almacen(numero);
                alma.setUbicacion_almacen(ubicacion);
                datos.add(alma);
                System.out.println("Numero " + numero + " Ubicacion " + ubicacion);

            }

        } catch (Exception e) {

        }
       return datos;
    }
    
    public ArrayList<Almacen> buscarTodos(){
    
        //GENERAMOS UN ARRAYLIST PARA INTEGRAR EN EL LA BÚSQUEDA
        //O EL SELECT DEL CURSOR
        ArrayList<Almacen> datos =new ArrayList<Almacen>();
        
        try {
            Connection con = Conexion.conectarse();
            CallableStatement callate = con.prepareCall("{call obtener_almacen(?)}");
            callate.registerOutParameter(1, OracleTypes.CURSOR);
            callate.executeUpdate();
            ResultSet res = (ResultSet) callate.getObject(1);

            while (res.next()) {
                Integer numero = res.getInt(1);
                String ubicacion = res.getString(2);
                //EN CADA ITERACIÓN INTEGRAMOS AL ARRAYLIST CADA FILA
                Almacen alma=new Almacen();
                alma.setNumero_almacen(numero);
                alma.setUbicacion_almacen(ubicacion);
                datos.add(alma);
                System.out.println("Numero " + numero + " Ubicacion " + ubicacion);

            }

        } catch (Exception e) {

        }
        
        return datos;
    }
    
    public void borrar(Integer id){
    
    }
}
