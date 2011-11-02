/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.Users;
import apdol.model.DaftarUsers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Accio
 */
//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class HomeServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            DaftarUsers usr = new DaftarUsers();
            Users user = usr.getUsers(username, password);
            if(user!=null){
            //if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("Nama", user.getNama());
                session.setAttribute("roleuser", user.getRoleuser());
                //response.sendRedirect("home");
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                out.println("invalid");
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
