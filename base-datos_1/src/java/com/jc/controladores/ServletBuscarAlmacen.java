
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


public class ServletBuscarAlmacen extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //EN ESTE CASO NO HAY PARAMETROS ENVIADOS POR EL CLIENTE
        //SIMPLEMENTE GENERAMOS OBJETOS NECESARIOS
        
        ArrayList<Almacen>datos=new ArrayList<Almacen>();
        DAOAlmacen dao=new DAOAlmacen();
        
        //LLENAMOS EL ARRAYLIST
        datos=dao.buscarTodos();
        
        //HACEMOS EL MAPEO JSON
        ObjectMapper maper=new ObjectMapper();
        //SACAMOS EL CLIENTE
        out.print(maper.writeValueAsString(datos));
        
    
    }
}