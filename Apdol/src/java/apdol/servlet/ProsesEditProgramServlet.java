/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.ProgramComparator;
import apdol.entity.Program;
import apdol.model.DaftarProgram;
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
public class ProsesEditProgramServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditProgramServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditProgramServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarProgram daftarProgram = new DaftarProgram();
            String jsp = "";           

            String kdprogram = request.getParameter("kode_program");
            String nmprogram = request.getParameter("nama_program");
            
            String idProgram = request.getParameter("id_edit_program");
            Long longIdProgram = Long.parseLong(idProgram);
            Program program = daftarProgram.findProgram(longIdProgram);

            if (kdprogram == "") {
                JOptionPane.showMessageDialog(null, "Kode Program tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } else if (nmprogram == "") {
                JOptionPane.showMessageDialog(null, "Nama Program tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } //validate length field
            else if (kdprogram.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Program harus 4 angka !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } //validate kdprogram are numbers and not minus
            else if (!this.valNumber(kdprogram)) {
                JOptionPane.showMessageDialog(null, "Kode Program harus angka dan tidak boleh minus !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } //validate zero value
            else if (kdprogram.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Program tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } //validate kdprogram on database
            else if (daftarProgram.isKodeExist(kdprogram) && !program.isKodeNoChange(kdprogram)) {
                JOptionPane.showMessageDialog(null, "Kode Program sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } //validate nmprogram on database
            else if (daftarProgram.isNamaExist(nmprogram) && !program.isNamaNoChange(nmprogram)) {
                JOptionPane.showMessageDialog(null, "Program sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("program_edit", program);
                jsp = "pages/edit_program.jsp";
            } else {
                program.setKdprogram(kdprogram);
                program.setNmprogram(nmprogram);
                daftarProgram.edit(program);
                List<Program> listProgram = daftarProgram.getProgram();
                listProgram = daftarProgram.getProgram();
                Collections.sort(listProgram, new ProgramComparator());
                request.setAttribute("list_program", listProgram);
                jsp = "pages/program.jsp";
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
