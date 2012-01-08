/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.PejabatComparator;
import apdol.comparator.RincianKegiatanComparator;
import apdol.entity.Kegiatan;
import apdol.entity.MataAnggaran;
import apdol.entity.Output;
import apdol.entity.Pejabat;
import apdol.entity.RincianKegiatan;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarKegiatan;
import apdol.model.DaftarMataAnggaran;
import apdol.model.DaftarOutput;
import apdol.model.DaftarPejabat;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.DaftarSatuanKerja;
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
 * @author AlfieSaHid
 */
public class ProsesEditRincianKegiatanServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditPejabatServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditPejabatServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();

            String jsp = "";

            String kodeSatker = request.getParameter("satker");
            String kdgiat = request.getParameter("kegiatan");
            String kodeOutput = request.getParameter("output");
            String kodeMataAnggaran = request.getParameter("mata_anggaran");

            SatuanKerja satker = new SatuanKerja();
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.findSatuanKerjaByKode(kodeSatker);
            satker = listSatker.get(0);

            Output output = new Output();
            DaftarOutput daftarOutput = new DaftarOutput();
            List<Output> listOutput = daftarOutput.findOutputByKode(kodeOutput);
            output = listOutput.get(0);

            MataAnggaran mataAnggaran = new MataAnggaran();
            DaftarMataAnggaran daftarMataAnggaran = new DaftarMataAnggaran();
            List<MataAnggaran> listMataAnggaran = daftarMataAnggaran.findMataAnggaranByKode(kodeMataAnggaran);
            mataAnggaran = listMataAnggaran.get(0);

            Kegiatan kegiatan = new Kegiatan();
            DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
            List<Kegiatan> listKegiatan = daftarKegiatan.findKegiatanByKode(kdgiat);
            kegiatan = listKegiatan.get(0);

            String idRincianKegiatan = request.getParameter("id_edit_rincian_kegiatan");
            Long longIdRincianKegiatan = Long.parseLong(idRincianKegiatan);
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longIdRincianKegiatan);

            listKegiatan = daftarKegiatan.getKegiatan();
            listMataAnggaran = daftarMataAnggaran.getMataAnggaran();
            listOutput = daftarOutput.getOutput();
            listSatker = daftarSatker.getSatuanKerja();

            //validate blank field
            if (kodeSatker == "") {
                JOptionPane.showMessageDialog(null, "Satuan Kerja tidak boleh kosong !");
                request.setAttribute("list_satker", listSatker);
                request.setAttribute("list_kegiatan", listKegiatan);
                request.setAttribute("list_output", listOutput);
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                jsp = "pages/edit_rincian_kegiatan.jsp";
            } else if (kdgiat == "") {
                JOptionPane.showMessageDialog(null, "Kegiatan tidak boleh kosong !");
                request.setAttribute("list_satker", listSatker);
                request.setAttribute("list_kegiatan", listKegiatan);
                request.setAttribute("list_output", listOutput);
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                jsp = "pages/edit_rincian_kegiatan.jsp";
            } else if (kodeOutput == "") {
                JOptionPane.showMessageDialog(null, "Output tidak boleh kosong !");
                request.setAttribute("list_satker", listSatker);
                request.setAttribute("list_kegiatan", listKegiatan);
                request.setAttribute("list_output", listOutput);
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                jsp = "pages/edit_rincian_kegiatan.jsp";
            } else if (kodeMataAnggaran == "") {
                JOptionPane.showMessageDialog(null, "Mata Anggaran tidak boleh kosong !");
                request.setAttribute("list_satker", listSatker);
                request.setAttribute("list_kegiatan", listKegiatan);
                request.setAttribute("list_output", listOutput);
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                jsp = "pages/edit_rincian_kegiatan.jsp";
                //cek rincian kegiatan di database
            } else if (!rincianKegiatan.isRincianKegiatanNoChange(kegiatan, mataAnggaran, output, satker)
                    && daftarRincianKegiatan.isRincianKegiatanExist(kegiatan, mataAnggaran, output, satker)) {
                JOptionPane.showMessageDialog(null, "Rincian Kegiatan sudah ada di database !");
                request.setAttribute("list_satker", listSatker);
                request.setAttribute("list_kegiatan", listKegiatan);
                request.setAttribute("list_output", listOutput);
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                jsp = "pages/edit_rincian_kegiatan.jsp";
            } else {
                rincianKegiatan.setSatker(satker);
                rincianKegiatan.setKegiatan(kegiatan);
                rincianKegiatan.setOutput(output);
                rincianKegiatan.setMataAnggaran(mataAnggaran);
                daftarRincianKegiatan.edit(rincianKegiatan);
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                Collections.sort(listRincianKegiatan, new RincianKegiatanComparator());
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rincian_kegiatan.jsp";
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }
//validate number

    public boolean valNumber(String nip) {
        int j;
        try {
            for (int i = 0; i < nip.length(); i++) {
                String c = nip.substring(i, i + 1);
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
