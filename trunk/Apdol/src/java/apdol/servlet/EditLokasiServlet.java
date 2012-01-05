/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.LokasiComparator;
import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Accio
 */
public class EditLokasiServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            DaftarLokasi daftarLokasi = new DaftarLokasi();
            List<Lokasi> listLokasi = daftarLokasi.getLokasi();
            Collections.sort(listLokasi, new LokasiComparator());
            request.setAttribute("list_lokasi", listLokasi);
            String jsp = "";
            String cekLokasi = request.getParameter("edit_lokasi");

            Long idLokasi = Long.parseLong(cekLokasi);
            Lokasi lokasi = daftarLokasi.findLokasi(idLokasi);
            request.setAttribute("lokasi_edit", lokasi);
            jsp = "/pages/edit_lokasi.jsp";


            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>
     * POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        /*DaftarUser usr = new DaftarUser();
        User users = new User();
        if (usr.check(users.getUsername(), users.getPassword()) == false) {
        System.out.println("Login Fail");
        } else {
        session.setAttribute("username", users.getNama());
        session.setAttribute("users", users);
        session.setAttribute("role", users.getRoleuser());
        response.sendRedirect("home");
        }*/
        //boolean check = usr.check(username, password);
        //users = usr.getUsers(username, password);

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
