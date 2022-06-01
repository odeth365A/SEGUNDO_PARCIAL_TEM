
package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAO_imp;
import com.emergentes.modelos.Seminario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeminarioControlador", urlPatterns = {"/SeminarioControlador"})
public class SeminarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action")!=null)? request.getParameter("action"): "view";
            
            int id;
            SeminarioDAO dao = new SeminarioDAO_imp();
            Seminario sem = new Seminario();
            
            
            switch(action)
            {
                case "add":
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("frm_Seminario.jsp").forward(request, response);       
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("frm_Seminario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("SeminarioControlador");
                    break;
                case "view":
                    //obtener la lista de registros.                    
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("Seminarios.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error Get"+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        Seminario sem = new Seminario();
        SeminarioDAO dao = new SeminarioDAO_imp();
        
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setFecha(convierteFecha(fecha));
        sem.setCupo(cupo);
        
        if(id == 0)
        {
            try {
                //nuevo registro
                dao.insert(sem);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }else{
            try {
                //edicion de registro
                dao.update(sem);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            } 
        }
        response.sendRedirect("SeminarioControlador");
    }
    
    public Date convierteFecha(String fecha)
    {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date fechaTMP;
      
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());    
        } catch (ParseException ex) {
            System.out.println("Error al convertir la fecha "+ex.getMessage());
        }        
        return fechaBD;
    }
}