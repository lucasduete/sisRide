package io.github.sisRide.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.github.sisRide.interfaces.Command;


@MultipartConfig
public class FrontController extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setCharacterEncoding("UTF-8");
        String ex = request.getParameter("action");
        
        try {
            Command com = (Command) Class.forName("Controladores." + ex + "Controller").newInstance();
            com.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex1) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (SQLException ex1) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex1);
        }*/

        String action = request.getParameter("action");
        response.setCharacterEncoding("UTF-8");

        try {

            Command command = (Command) Class.forName("io.github.sisRide.appcontroller." + action + "Controller").newInstance();
            command.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | IOException | ServletException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

}