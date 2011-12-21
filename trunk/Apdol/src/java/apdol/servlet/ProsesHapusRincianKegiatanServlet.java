/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;


import apdol.comparator.RincianKegiatanComparator;
import apdol.entity.RincianKegiatan;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
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
 * @author Hari RZ
 */
@WebServlet(name = "ProsesHapusRincianKegiatanServlet", urlPatterns = {"/ProsesHapusRincianKegiatanServlet"})
public class ProsesHapusRincianKegiatanServlet extends HttpServlet {
    private Long idrincianKegiatan;

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesRekamLokasiServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesRekamLokasiServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
            Collections.sort(listRincianKegiatan, new RincianKegiatanComparator());
            String cekRincianKegiatan[] = request.getParameterValues("cek_rincian_regiatan");
            String jsp = "";

            if (cekRincianKegiatan == null) {
                JOptionPane.showMessageDialog(null, "Rincian Kegiatan tidak ada yang dipilih");
                request.setAttribute("list_rincian_regiatan", listRincianKegiatan);
                jsp = "pages/rincian_regiatan.jsp";
            } else {
                int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                        JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < cekRincianKegiatan.length; i++) {
                        long idRincianKegiatan = Long.parseLong(cekRincianKegiatan[i]);
                        RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(idrincianKegiatan);
                        daftarRincianKegiatan.destroy(idrincianKegiatan);
                    }
                }
                listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                Collections.sort(listRincianKegiatan, new RincianKegiatanComparator());
                request.setAttribute("list_rincian_regiatan", listRincianKegiatan);
                jsp = "pages/rincian_regiatan.jsp";
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusRincianKegiatanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesHapusRincianKegiatanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
