/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import apdol.entity.User;
import apdol.model.DaftarUser;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarSatuanKerja;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

/**
 *
 * @author Accio
 */
public class ProsesRekamUserServlet extends HttpServlet {

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
            User user = new User();
            DaftarUser daftarUser = new DaftarUser();

            String jsp = "";

            String nama = request.getParameter("nama");
            String jabatan = request.getParameter("jabatan");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String roleuser = request.getParameter("roleuser");
            String kodesatker = request.getParameter("satker");

            SatuanKerja satker = new SatuanKerja();
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.findSatuanKerjaByKode(kodesatker);
            if (listSatker.isEmpty()) {
                satker = null;
            } else {
                satker = listSatker.get(0);

            }

            if ("".equals(nama)) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong !");
                List<SatuanKerja> listNamaSatker = daftarSatker.getSatuanKerja();
                request.setAttribute("list_satker", listNamaSatker);
                jsp = "pages/rekam_user.jsp";
            } else if ("".equals(jabatan)) {
                JOptionPane.showMessageDialog(null, "Jabatan tidak boleh kosong !");
                List<SatuanKerja> listNamaSatker = daftarSatker.getSatuanKerja();
                request.setAttribute("list_satker", listNamaSatker);
                jsp = "pages/rekam_user.jsp";
            } else if ("".equals(username)) {
                JOptionPane.showMessageDialog(null, "Username tidak boleh kosong !");
                List<SatuanKerja> listNamaSatker = daftarSatker.getSatuanKerja();
                request.setAttribute("list_satker", listNamaSatker);
                jsp = "pages/rekam_user.jsp";
            } else if ("".equals(password)) {
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong !");
                List<SatuanKerja> listNamaSatker = daftarSatker.getSatuanKerja();
                request.setAttribute("list_satker", listNamaSatker);
                jsp = "pages/rekam_user.jsp";
            } else {
                user.setNama(nama);
                user.setJabatan(jabatan);
                user.setUsername(username);
                user.setPassword(password);
                user.setRoleuser(roleuser);
                user.setSatker(satker);
                daftarUser.rekamUser(user);
                List<User> listUser = daftarUser.getUser();
                request.setAttribute("list_user", listUser);
                jsp = "pages/user.jsp";
            }
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
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
