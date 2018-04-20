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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author T-102
 */
public class ServletBuscarIdAlmacen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        Integer id=Integer.parseInt(request.getParameter("numero_almacen"));
        
         ArrayList<Almacen>datos=new ArrayList<Almacen>();
        DAOAlmacen dao=new DAOAlmacen();
        
        //LLENAMOS EL ARRAYLIST
        datos=dao.buscarPorId(id);
        
        //HACEMOS EL MAPEO JSON
        ObjectMapper maper=new ObjectMapper();
        //SACAMOS EL CLIENTE
        out.print(maper.writeValueAsString(datos));
    
    }}