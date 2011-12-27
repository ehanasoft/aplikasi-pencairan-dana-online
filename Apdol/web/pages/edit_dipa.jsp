<%-- 
    Document   : edit_dipa
    Created on : Dec 23, 2011, 12:04:31 AM
    Author     : wahid
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarDipa"%>
<%@page import="apdol.entity.Dipa"%>
<%@page import="apdol.model.DaftarRincianKegiatan"%>
<%@page import="apdol.entity.RincianKegiatan"%>

<% Dipa dipa = (Dipa) request.getAttribute("dipa_edit");%>
<% List<RincianKegiatan> listRincianKegiatan = (List<RincianKegiatan>) request.getAttribute("list_rincian_kegiatan");%>
<% RincianKegiatan rincianKegiatan;%>

<% RincianKegiatan rincianKegiatanDipa = (RincianKegiatan) request.getAttribute("rincianKegiatanDipa");%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Edit Dipa</title>
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
                    <li><a href="rincianKegiatan">Satuan Kerja</a></li>
                    <li><a href="bank_pos">Bank Pos</a></li>
                    <li><a href="dipa">Dipa</a></li>
                    <li><a href="program">Program</a></li>
                    <li><a href="kegiatan">Kegiatan</a></li>
                    <li><a href="output">Output</a></li>
                    <li><a href="mata_anggaran">Mata Anggaran</a></li>
                    <li><a href="rincian_kegiatan">Rincian Kegiatan</a></li>
                    <li><a href="lokasi">Lokasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="register">Registrasi User</a></li>
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
                <center><p><h3> Edit Dipa</h3></p>
                    <form name="form_edit_dipa" action="proses_edit_dipa" method="post" >
                        <table width="400px"/>  
                            <tr>
                                <td>Nomor Dipa</td><td><input type="text" name="nomor_dipa" style="width: 200px" value="<%=dipa.getNomorDipa()%>"></td>
                            </tr>
                            <tr>
                                <td>RincianKegiatan</td>
                                <td>
                                    <select name="rincian_kegiatan">
                                        <%Iterator<RincianKegiatan> iterator = listRincianKegiatan.iterator();%>
                                        <%while (iterator.hasNext()) {
                                                rincianKegiatan = iterator.next();
                                                if (dipa.getRincianKegiatan() != null && dipa.getRincianKegiatan().getId().equals(rincianKegiatan.getId())) {
                                                    out.println("<option value=" + rincianKegiatan.getId() + " selected=\"selected\">" + rincianKegiatan.getKegiatan().getNmgiat() + " . " + rincianKegiatan.getOutput().getNamaOutput() + " . " + rincianKegiatan.getMataAnggaran().getNamaMataAnggaran() + "</option>");
                                                } else {
                                                    out.println("<option value=" + rincianKegiatan.getId() + ">" + rincianKegiatan.getKegiatan().getNmgiat() + " . " + rincianKegiatan.getOutput().getNamaOutput() + " . " + rincianKegiatan.getMataAnggaran().getNamaMataAnggaran() + "</option>");
                                                }
                                            }%>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <table width="400px"/>  
                            <tr>
                                <td>Pagu</td><td><input type="text" name="pagu" style="width: 200px" value="<%=dipa.getPagu()%>"</td>
                            </tr>
                        </table>
                        <table width="400px"/>  
                            <tr>
                                <td>Realisasi</td><td><input type="text" name="realisasi" style="width: 200px" value="<%=dipa.getRealisasi()%>"</td>
                            </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_dipa" value="<%=dipa.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_dipa.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>
