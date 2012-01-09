<%-- 
    Document   : batal_sp2d
    Created on : Dec 12, 2011, 3:09:36 AM
    Author     : AlfieSaHid
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="apdol.entity.SP2D"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSP2D"%>

<% List<SP2D> listSP2D = (List<SP2D>) request.getAttribute("list_sp2d");%>
<% SP2D sp2d;%>
<% DateFormat df = new SimpleDateFormat("dd/MM/yyyy");%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Batal SP2D</title>
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
                    <li><a href="tayang_dipa">Tayang DIPA</a></li>
                </ul>
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="spm">Surat Perintah Membayar</a></li>
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
                    <li><a href="tayang_dipa">Tayang DIPA</a></li>
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
                <center><p><h3>Batal SP2D</h3></p>
                    <% Iterator<SP2D> iterator = listSP2D.iterator();%>
                    <form >
                        <table id="rounded-corner">
                            <thead>
                                <tr>
                                    <th width="70" align="center" valign="middle" class="rounded-company" scope="col">Tanggal SP2D</th>
                                    <th width="60" align="center" valign="middle" class="rounded-q1" scope="col">Nomor SP2D</th>
                                    <th width="50" align="center" valign="middle" class="rounded-q3" scope="col">Bank Pos</th>
                                    <th width="50" align="center" valign="middle" class="rounded-q3" scope="col">Kode Satker</th>
                                    <th width="29" align="center" valign="middle" class="rounded-q4" scope="col">Batal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% while (iterator.hasNext()) {
                                        sp2d = iterator.next();
                                        if (sp2d.getStatusSp2d().equals("terproses")) {%>
                                <tr>
                                    <td><%=df.format(sp2d.getTanggalSP2D())%></td>
                                    <td><%=sp2d.getNomorSP2D()%></td>
                                    <td><%=sp2d.getBankpos().getNmbankpos()%></td>
                                    <td><%=sp2d.getSpm().getRincianKegiatan().getSatker().getKodeSatker()%></td>
                                    <td><input name="input_batal_sp2d" src="images/proses.png" type="image" value="<%=sp2d.getId()%>" formmethod="post" formaction="input_batal_sp2d" /> </td>
                                </tr>
                                <%}}%>      
                            </tbody>
                        </table>
                    </form>
                </center>
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>