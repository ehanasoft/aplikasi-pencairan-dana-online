/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.User;
import apdol.model.DaftarUser;
import apdol.model.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ProsesEditUserServlet", urlPatterns = {"/proses_edit_user"})
public class ProsesEditUserServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DaftarUser daftarUser = new DaftarUser();
            String jsp = "";
            // List<User> listuser = daftarUser.getUser();

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nama = request.getParameter("nama");
            String jabatan = request.getParameter("jabatan");
            String roleuser = request.getParameter("roleuser");
            String kodesatker = request.getParameter("kodesatker");

            String idUser = request.getParameter("id_edit_user");
            Long longIdUser = Long.parseLong(idUser);
            User user = daftarUser.findUser(longIdUser);

            if (username == "") {
                JOptionPane.showMessageDialog(null, "Username tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            } else if (password == "") {
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            } else if (nama == "") {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            }else if (jabatan == "") {
                JOptionPane.showMessageDialog(null, "Jabatan tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            }else if (roleuser == "") {
                JOptionPane.showMessageDialog(null, "Role User tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            }else if (kodesatker == "") {
                JOptionPane.showMessageDialog(null, "Kode Satker tidak boleh kosong !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            }
           //validate username on database
            else if (daftarUser.isUsernameExist(username) && !user.isUsernameNoChange(username)) {
                JOptionPane.showMessageDialog(null, "Username sudah ada dalam data base !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            } //validate password on database
            else if (daftarUser.isPasswordExist(password) && !user.isPasswordNoChange(password)) {
                JOptionPane.showMessageDialog(null, "Password sudah ada dalam data base !");
                request.setAttribute("user_edit", user);
                jsp = "pages/edit_user.jsp";
            } else {
                user.setUsername(username);
                user.setPassword(password);
                user.setNama(nama);
                user.setJabatan(jabatan);
                user.setRoleuser(roleuser);
                user.setKodeSatker(kodesatker);
                daftarUser.edit(user);
                List<User> listUser = daftarUser.getUser();
                listUser = daftarUser.getUser();
                request.setAttribute("list_user", listUser);
                jsp = "pages/register.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    public boolean valNumber(String kode) {
        try {
            int i = Integer.parseInt(kode);
            //validate minus input
            if (i >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
