<%@page import="apdol.entity.MataAnggaran"%>
<%@page import="apdol.entity.Output"%>
<%@page import="apdol.entity.Kegiatan"%>
<%@page import="apdol.entity.RincianKegiatan"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSatuanKerja"%>
<%@page import="apdol.entity.SatuanKerja"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="apdol.model.DaftarLokasi"%>
<%@page import="apdol.entity.Lokasi"%>

<% RincianKegiatan rincianKegiatan = (RincianKegiatan) request.getAttribute("rincian_kegiatan_edit");%>

<% List<SatuanKerja> listSatker = (List<SatuanKerja>) request.getAttribute("list_satker");%>
<% SatuanKerja satker;%>

<% SatuanKerja satkerRincianKegiatan = (SatuanKerja) request.getAttribute("satkerRincianKegiatan");%>

<% List<Kegiatan> listKegiatan = (List<Kegiatan>) request.getAttribute("list_kegiatan");%>
<% Kegiatan kegiatan;%>

<% Kegiatan kegiatanRincianKegiatan = (Kegiatan) request.getAttribute("kegiatanRincianKegiatan");%>

<% List<Output> listOutput = (List<Output>) request.getAttribute("list_output");%>
<% Output output;%>

<% Output outputRincianKegiatan = (Output) request.getAttribute("outputRincianKegiatan");%>

<% List<MataAnggaran> listMataAnggaran = (List<MataAnggaran>) request.getAttribute("list_mata_anggaran");%>
<% MataAnggaran mataAnggaran;%>

<% MataAnggaran mataAnggaranRincianKegiatan = (MataAnggaran) request.getAttribute("mataAnggaranRincianKegiatan");%>


<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Edit Rincian Kegiatan</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
        <style>
        .content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
        ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
        </style>
        <![endif]-->
    </head>

    <body>
        <center><div class="header"><img src="images/sederhana.jpg" /></div></center>

        <div class="container">
            <div class="sidebar1">
                <% if (roleUser.equals("1")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="dipa">DIPA</a></li>
                </ul>
                <p><strong>Referensi</strong></p> 
                <ul class="nav">
                    <li><a href="satker">Satuan Kerja</a></li>
                    <li><a href="bank_pos">Bank Pos</a></li>
                    <li><a href="pejabat">Pejabat</a></li>
                    <li><a href="program">Program</a></li>
                    <li><a href="kegiatan">Kegiatan</a></li>
                    <li><a href="output">Output</a></li>
                    <li><a href="mata_anggaran">Mata Anggaran</a></li>
                    <li><a href="rincian_kegiatan">Rincian Kegiatan</a></li>
                    <li><a href="lokasi">Lokasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="user">Registrasi User</a></li>
                </ul>
                <% } else if (roleUser.equals("2")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="#">Tayang DIPA</a></li>
                </ul>
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Surat Perintah Membayar</a></li>
                </ul>
                <p><strong>Monitoring</strong></p>
                <ul class="nav">
                    <li><a href="#">Realisasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="#">Cetak SPM</a></li>	
                    <li><a href="#">Submit ke KPPN</a></li>
                </ul>
                <% } else if (roleUser.equals("3")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="#">Tayang DIPA</a></li>
                </ul>
                <p><strong>Penerimaan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Notifikasi SPM</a></li>
                    <li><a href="#">Tolak SPM</a></li>
                </ul>  
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Proses SP2D</a></li>
                    <li><a href="#">Batal SP2D</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="#">Cetak SP2D</a></li>	
                </ul>  
                <% }%>
                <p></p>
                <p></p>
                <p></p>


                <!-- end .sidebar1 --></div>
            <div class="logout"><a href="logout"><img src="images/logout.png"/></a>
                <!-- end .logout --></div>
            <div class="content">
                <center><p><% if (logedUser != null) {%><%="Anda Login sebagai: " + logedUser%><%}%></p></center>
                <center><p><h3> Edit Rincian Kegiatan</h3></p>
                    <form name="form_edit_rincian_kegiatan" action="proses_edit_rincian_kegiatan" method="post" >
                        <table width="400px">                                                           
                                <tr>
                                <td>Satker</td>
                                <td>
                                    <select name="satker">
                                        <%Iterator<SatuanKerja> iterator = listSatker.iterator();%>
                                        <%while (iterator.hasNext()) {
                                                satker = iterator.next();
                                                if (rincianKegiatan.getSatker().getId().equals(satker.getId())) {
                                                    out.println("<option value=" + satker.getKodeSatker() + " selected=\"selected\">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                                } else {
                                                    out.println("<option value=" + satker.getKodeSatker() + ">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                                }
                                            }%>
                                    </select>
                                </td>
                                </tr>
                                <tr>
                                <td>Kegiatan</td>
                                <td>
                                    <select name="kegiatan">
                                        <%Iterator<Kegiatan> iteratorKegiatan = listKegiatan.iterator();%>
                                        <%while (iteratorKegiatan.hasNext()) {
                                                kegiatan = iteratorKegiatan.next();
                                                if (rincianKegiatan.getKegiatan().getId().equals(kegiatan.getId())) {
                                                    out.println("<option value=" + kegiatan.getKdgiat() + " selected=\"selected\">" + kegiatan.getKdgiat() + " " + kegiatan.getNmgiat() + "</option>");
                                                } else {
                                                    out.println("<option value=" + kegiatan.getKdgiat() + ">" + kegiatan.getKdgiat() + " " + kegiatan.getNmgiat() + "</option>");
                                                }
                                            }%>
                                    </select>
                                </td>
                                </tr>
                                <tr>
                                <td>Output</td>
                                <td>
                                    <select name="output">
                                        <%Iterator<Output> iteratorOutput = listOutput.iterator();%>
                                        <%while (iteratorOutput.hasNext()) {
                                                output = iteratorOutput.next();
                                                if (rincianKegiatan.getOutput().getId().equals(output.getId())) {
                                                    out.println("<option value=" + output.getKodeOutput() + " selected=\"selected\">" + output.getKodeOutput() + " " + output.getNamaOutput() + "</option>");
                                                } else {
                                                    out.println("<option value=" + output.getKodeOutput() + ">" + output.getKodeOutput() + " " + output.getNamaOutput() + "</option>");
                                                }
                                            }%>
                                    </select>
                                </td>
                                </tr>
                                <tr>
                                <td>Mata Anggaran</td>
                                <td>
                                    <select name="mata_anggaran">
                                        <%Iterator<MataAnggaran> iteratorMataAnggaran = listMataAnggaran.iterator();%>
                                        <%while (iteratorMataAnggaran.hasNext()) {
                                                mataAnggaran = iteratorMataAnggaran.next();
                                                if (rincianKegiatan.getMataAnggaran().getId().equals(mataAnggaran.getId())) {
                                                    out.println("<option value=" + mataAnggaran.getKodeMataAnggaran() + " selected=\"selected\">" + mataAnggaran.getKodeMataAnggaran() + " " + mataAnggaran.getNamaMataAnggaran() + "</option>");
                                                } else {
                                                    out.println("<option value=" + mataAnggaran.getKodeMataAnggaran() + ">" + mataAnggaran.getKodeMataAnggaran() + " " + mataAnggaran.getNamaMataAnggaran() + "</option>");
                                                }
                                            }%>
                                    </select>
                                </td>
                                </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_rincian_kegiatan" value="<%=rincianKegiatan.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_rincian_kegiatan.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>