<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarRincianKegiatan"%>
<%@page import="apdol.entity.RincianKegiatan"%>
<%@page import="javax.swing.JOptionPane"%>

<% List<RincianKegiatan> listRincianKegiatan = (List<RincianKegiatan>) request.getAttribute("list_rincian_kegiatan");%>
<% RincianKegiatan rincianKegiatan;%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Rincian Kegiatan</title>
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
                    <li><a href="monitoring_spm">Monitoring SPM</a></li>
                    <li><a href="realisasi">Realisasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="cetak_spm">Cetak SPM</a></li>	
                    <li><a href="submit_spm">Submit ke KPPN</a></li>
                </ul>
                <% } else if (roleUser.equals("3")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="#">Tayang DIPA</a></li>
                </ul>
                <p><strong>Penerimaan</strong></p> 
                <ul class="nav">
                    <li><a href="notifikasi_spm">Notifikasi SPM</a></li>
                    <li><a href="tolak_spm">Tolak SPM</a></li>
                </ul>  
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="proses_sp2d">Proses SP2D</a></li>
                    <li><a href="batal_sp2d">Batal SP2D</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="cetak_sp2d">Cetak SP2D</a></li>	
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
                <center><p ><h3>Rincian Kegiatan</h3></p>
                    <% Iterator<RincianKegiatan> iterator = listRincianKegiatan.iterator();%>
                    <form >
                        <table id="rounded-corner">
                            <thead>
                                <tr>  
                                    <th scope="col" class="rounded-company">Satuan Kerja</th>
                                    <th scope="col" class="rounded-q2">Kegiatan</th>
                                    <th scope="col" class="rounded-q3">Output</th>
                                    <th scope="col" class="rounded-q3">Mata Anggaran</th>                                   
                                    <th scope="col" class="rounded-q4">Cek</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% while (iterator.hasNext()) {
                            rincianKegiatan = iterator.next();%>
                                <tr>
                                    <td><%=rincianKegiatan.getSatker().getKodeSatker()%></td>
                                    <td><%=rincianKegiatan.getKegiatan().getNmgiat()%></td>
                                    <td><%=rincianKegiatan.getOutput().getNamaOutput()%></td>
                                    <td><%=rincianKegiatan.getMataAnggaran().getKodeMataAnggaran()%></td>
                                    <td><input  type="checkbox"  name="cek_rincian_kegiatan" value="<%=rincianKegiatan.getId()%>"></input></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        <span style="margin: 10px;">
                        </span>
                        <p style="margin: 10px;"><BR>
                                <input name="Submit" src="images/rekam.png" type="image" value="rekam" formmethod="post" formaction="rekam_rincian_kegiatan" />
                                <input name="Submit" src="images/ubah.png" type="image" value="edit" formmethod="post" formaction="edit_rincian_kegiatan" />
                                <input name="Submit" src="images/hapus.png" type="image" value="hapus" formmethod="post" formaction="proses_hapus_rincian_kegiatan" />
                  </form></center>
                                <!-- end .content --></div>
                                <!-- end .container --></div>
                                </body>
                                </html>
