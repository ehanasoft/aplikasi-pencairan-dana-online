<%-- 
    Document   : edit_satker
    Created on : Dec 8, 2011, 2:38:34 AM
    Author     : Accio
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSatuanKerja"%>
<%@page import="apdol.entity.SatuanKerja"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="apdol.model.DaftarLokasi"%>
<%@page import="apdol.entity.Lokasi"%>
<% SatuanKerja satker = (SatuanKerja) request.getAttribute("satker_edit");%>
<% List<Lokasi> listLokasi = (List<Lokasi>) request.getAttribute("list_lokasi");%>
<% Lokasi lokasi;%>

<% Lokasi lokasiSatker = (Lokasi) request.getAttribute("lokasiSatker");%>


<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Edit Satuan Kerja</title>
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
                <p><% if (logedUser != null) {%><%="Anda Login sebagai: " + logedUser + " " + roleUser%><%}%></p>
                <center><p><h3> Edit Satuan Kerja</h3></p>
                    <form name="form_edit_satker" action="proses_edit_satker" method="post" >
                        <table width="400px">                                
                            <tr>
                                <td width="175px">Kode Satuan Kerja</td><td><input name="kode_satker" type="text" style="width: 75px" size="6" maxlength="6" value="<%=satker.getKodeSatker()%>"></td>
                            </tr>
                            <tr>
                                <td>Nama Satuan Kerja</td><td><input type="text" name="nama_satker" style="width: 200px" value="<%=satker.getNamaSatker()%>"></td>
                            </tr>
                                <td width="175px">Kode Kementerian</td><td><input name="kode_dept" type="text" style="width: 40px" size="3" maxlength="3" value="<%=satker.getKodeDept()%>"></td>
                            </tr>
                            <tr>
                                <td>Nama Kementerian</td><td><input type="text" name="nama_dept" style="width: 200px" value="<%=satker.getNamaDept()%>"></td>
                            </tr>
                                <td width="175px">Kode Unit</td><td><input name="kode_unit" type="text" style="width: 40px" size="3" maxlength="3" value="<%=satker.getKodeUnit()%>"></td>
                            </tr>
                            <tr>
                                <td>Nama Unit</td><td><input type="text" name="nama_unit" style="width: 200px" value="<%=satker.getNamaUnit()%>"></td>
                                </tr>
                                <td>Lokasi</td><td><select name="lokasi">
                                        <% Iterator<Lokasi> iterator = listLokasi.iterator();%>
                                        
                                        <% while (iterator.hasNext()) { lokasi = iterator.next();
                                            if(satker.getLokasi().getId().equals(lokasi.getId())){
                                                out.println("<option value=" + lokasi.getKodeLokasi() + " selected=\"selected\">" + lokasi.getNamaKota() + "</option>");
                                            }   else {
                                                   out.println("<option value=" + lokasi.getKodeLokasi() + ">" + lokasi.getNamaKota() + "</option>");
                                                }
                                        }%></select>
                                </td>
                                </tr>
                                </table>
                        <p><input type="hidden" name="id_edit_satker" value="<%=satker.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_satker.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>