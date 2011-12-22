/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.DipaComparator;
import apdol.entity.Dipa;
import apdol.entity.RincianKegiatan;
import apdol.model.DaftarDipa;
import apdol.model.DaftarRincianKegiatan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author wahid
 */
public class ProsesEditDipaServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditDipaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditDipaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarDipa daftarDipa = new DaftarDipa();

            String jsp = "";

            String nomorDipa = request.getParameter("nomor_dipa");
            String pagu = request.getParameter("pagu");
            String realisasi = request.getParameter("realisasi");
            String sisaDana = request.getParameter("sisa_dana");
            String rincianKegiatanId = request.getParameter("rincian_kegiatan");
            Long longId = Long.parseLong(rincianKegiatanId);

            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longId);

            String idDipa = request.getParameter("id_edit_dipa");
            Long longIdDipa = Long.parseLong(idDipa);
            Dipa dipa = daftarDipa.findDipa(longIdDipa);


            //validate blank field
            if ("".equals(nomorDipa)) {
                JOptionPane.showMessageDialog(null, "Nomor Dipa tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", dipa.getRincianKegiatan());
                jsp = "pages/edit_dipa.jsp";
            } else if ("".equals(pagu)) {
                JOptionPane.showMessageDialog(null, "Pagu tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", dipa.getRincianKegiatan());
                jsp = "pages/edit_dipa.jsp";
            } else if ("".equals(realisasi)) {
                JOptionPane.showMessageDialog(null, "Realisasi tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", dipa.getRincianKegiatan());
                jsp = "pages/edit_dipa.jsp";
            } else if ("".equals(sisaDana)) {
                JOptionPane.showMessageDialog(null, "Sisa Dana tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", dipa.getRincianKegiatan());
                jsp = "pages/edit_dipa.jsp";
            } else if ("".equals(rincianKegiatanId)) {
                JOptionPane.showMessageDialog(null, "Rincian Kegiatan tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", dipa.getRincianKegiatan());
                jsp = "pages/edit_dipa.jsp";
            } else {
                dipa.setNomorDipa(nomorDipa);
                dipa.setPagu(pagu);
                dipa.setRealisasi(realisasi);
                dipa.setSisaDana(sisaDana);
                dipa.setRincianKegiatan(rincianKegiatan);
                daftarDipa.edit(dipa);
                jsp = "pages/dipa.jsp";
                List<Dipa> listDipa = daftarDipa.getDipa();
                Collections.sort(listDipa, new DipaComparator());
                request.setAttribute("list_dipa", listDipa);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    //validate number
    public boolean valNumber(String nomorDipa) {
        int j;
        try {
            for (int i = 0; i < nomorDipa.length(); i++) {
                String c = nomorDipa.substring(i, i + 1);
                j = Integer.parseInt(c);
            }
            return true;
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
