
package com.emergentes.controlador;
import com.emergentes.dao.ParticipanteDAO;
import com.emergentes.dao.ParticipanteDAO_imp;
import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAO_imp;
import com.emergentes.modelos.Participante;
import com.emergentes.modelos.Seminario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ParticipanteControlador"})
public class ParticipanteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action")!=null)? request.getParameter("action"): "view";
            
            int id;
            SeminarioDAO daoSeminario= new SeminarioDAO_imp();
            ParticipanteDAO dao = new ParticipanteDAO_imp();

            List<Seminario> lista_seminarios = null;
            Participante part = new Participante();
            
            
            switch(action)
            {
                case "add":
                    lista_seminarios = daoSeminario.getAll();
                    request.setAttribute("lista_seminarios", lista_seminarios);
                    request.setAttribute("participante", part);
                    request.getRequestDispatcher("frm_participante.jsp").forward(request, response);       
                    break;
                case "edit":
                    lista_seminarios = daoSeminario.getAll();
                    request.setAttribute("lista_seminarios", lista_seminarios);
                    id = Integer.parseInt(request.getParameter("id"));
                    part = dao.getById(id);
                    request.setAttribute("participante", part);
                    request.getRequestDispatcher("frm_participante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ParticipanteControlador");
                    break;
                case "view":
                    //obtener la lista de registros.   
                    lista_seminarios = daoSeminario.getAll();
                    request.setAttribute("lista_seminarios", lista_seminarios);
                    List<Participante> lista = dao.getAll();
                    request.setAttribute("participantes", lista);
                    request.getRequestDispatcher("Participantes.jsp").forward(request, response);
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
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        
        Participante part = new Participante();
        ParticipanteDAO dao = new ParticipanteDAO_imp();
        
        part.setId(id);
        part.setNombres(nombres);
        part.setApellidos(apellidos);
        part.setId_seminario(id_seminario);
        part.setConfirmado(confirmado);
        
        if(id == 0)
        {
            try {
                //nuevo registro
                dao.insert(part);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }else{
            try {
                //edicion de registro
                dao.update(part);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            } 
        }
        response.sendRedirect("ParticipanteControlador");
    }
}