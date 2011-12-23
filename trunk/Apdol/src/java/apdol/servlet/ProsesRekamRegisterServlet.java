/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.User;
import apdol.model.DaftarUser;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author wahid
 */
@WebServlet(name = "ProsesRekamRegisterServlet", urlPatterns = {"/proses_rekam_user"})
public class ProsesRekamRegisterServlet extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesRekamRegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesRekamRegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarUser daftarUser = new DaftarUser();
            User user = new User();
            String jsp = "index.jsp";

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nama = request.getParameter("nama");
            String jabatan = request.getParameter("jabatan");
            String roleuser = request.getParameter("roleuser");
            String kodesatker = request.getParameter("kodesatker");
            user.setUsername(username);
            user.setPassword(password);
            user.setNama(nama);
            user.setJabatan(jabatan);
            user.setRoleuser(roleuser);
            user.setKodeSatker(kodesatker);


            //validate blank field
            if (username == null) {
                JOptionPane.showMessageDialog(null, "Username tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } else if (password == null) {
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } else if (nama == null) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } else if (jabatan == null) {
                JOptionPane.showMessageDialog(null, "Jabatan tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } else if ("".equals(roleuser)) {
                JOptionPane.showMessageDialog(null, "Role User tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } else if ("".equals(kodesatker)) {
                JOptionPane.showMessageDialog(null, "Kode Satker tidak boleh kosong !");
                jsp = "pages/rekam_user.jsp";
            } //validate record on database
            else if (user.valKodeSatker()) {
                JOptionPane.showMessageDialog(null, "Kode Satker sudah ada dalam data base !");
                jsp = "pages/rekam_user.jsp";
            } else if (user.valUsername()) {
                JOptionPane.showMessageDialog(null, "Username sudah ada dalam data base !");
                jsp = "pages/rekam_user.jsp";
            } // validate lenght field
            else if (kodesatker.length() < 6) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus 6 angka !");
                jsp = "pages/rekam_user.jsp";
            }// validate kode satker are number
            else if (!this.valNumber(kodesatker)) {
                JOptionPane.showMessageDialog(null, "Kode Satker harus angka dan tidak boleh minus !");
                jsp = "pages/rekam_user.jsp";
            } else {
                daftarUser.rekamUser(user);
                List<User> listUser = daftarUser.getUser();
                request.setAttribute("list_user", listUser);
                jsp = "pages/register.jsp";
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

    private boolean valNumber(String kodesatker) {
        try {
            int i = Integer.parseInt(kodesatker);
            //validate minus input
            if (i >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
