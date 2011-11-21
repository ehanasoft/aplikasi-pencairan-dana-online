/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
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
 * @author Accio
 */
@WebServlet(name = "EditLokasiServlet", urlPatterns = {"/EditLokasiServlet"})
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

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            String cekLokasi[] = request.getParameterValues("ceklokasi");

            if (cekLokasi == null) {
                JOptionPane.showMessageDialog(null, "Lokasi tidak ada yang dipilih");
            } else if (cekLokasi.length > 1) {
                JOptionPane.showMessageDialog(null, "Centang lebih dari satu, pilih salah satu lokasi saja");
            } else {
                Long idLokasi = Long.parseLong(cekLokasi[0]);
                Lokasi lokasi = daftarLokasi.findLokasi(idLokasi);
                request.setAttribute("lokasiedit", lokasi);

                String jsp = "/pages/editLokasi.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
                requestDispatcher.forward(request, response);
            }
            
            List<Lokasi> listLokasi = daftarLokasi.getLokasi();
            request.setAttribute("listlokasi", listLokasi);
            
            String jsp = "pages/lokasi.jsp";
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
