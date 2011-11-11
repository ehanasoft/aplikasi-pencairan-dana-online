/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.User;
import apdol.model.DaftarUser;
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
//@WebServlet(name = "HomeServlet", urlPatterns = {"/main"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");

        DaftarUser usr = new DaftarUser();
        User user = new User();
        HttpSession session = request.getSession();
        boolean resultCheck = usr.check(username, password);
        user = usr.getUser(username, password);
                
        if(username.equals("") || password.equals("")){
            request.setAttribute("error", "Username/Password tidak boleh kosong!");
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        } else {
            if(resultCheck){
                session.setAttribute("username", username);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                request.setAttribute("error2", "Username/Password tidak terdaftar");
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            }
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
