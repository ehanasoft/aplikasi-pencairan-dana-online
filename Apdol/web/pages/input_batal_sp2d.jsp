<%-- 
    Document   : input_batal_sp2d
    Created on : Jan 8, 2012, 11:12:22 PM
    Author     : AlfieSaHid
--%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="apdol.model.DaftarSP2D"%>
<%@page import="apdol.entity.SP2D"%>

<% SP2D sp2d = (SP2D) request.getAttribute("sp2d_batal");%>
<% DateFormat dfd = new SimpleDateFormat("dd");%>
<% DateFormat dfm = new SimpleDateFormat("MM");%>
<% DateFormat dfy = new SimpleDateFormat("yyyy");%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Input Batal SP2D</title>
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
                <center><p><h3>Input Batal SP2D</h3></p>
                    <form name="form_input_batal_sp2d" action="proses_batal_sp2d" method="post" >
                        <table width="650">
                            <tr>
                                <td width="189">Nomor SP2D</td>
                                <td width="11">:</td>
                                <td width="450"><%=sp2d.getNomorSP2D()%></td>
                            </tr>
                            <tr>
                                <td>Tanggal SP2D</td>
                                <td>:</td>
                                <td><%=dfd.format(sp2d.getTanggalSP2D())%>/<%=dfm.format(sp2d.getTanggalSP2D())%>/<%=dfy.format(sp2d.getTanggalSP2D())%></td>
                            </tr>
                            <tr>
                                <td>Tanggal Batal SP2D</td>
                                <td>:</td>
                                <td><input type="text" name="tanggal_batal_sp2d" style="width: 70px" /></td>
                            </tr>
                            <tr>
                                <td>Nomor Batal SP2D</td>
                                <td>:</td>
                                <td><input type="text" name="nomor_tolak_sp2d" style="width: 70px" /></td>
                            </tr>
                            <tr>
                                <td>Alasan Batal</td>
                                <td>:</td>
                                <td><textarea name="alasan" cols="45" rows="2"></textarea></td>
                            </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_sp2d" value="<%=sp2d.getId()%>"/></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_input_batal_sp2d.reset()"><img src="images/reset.png" alt="Reset"/></a><input name="proses_batal_sp2d" src="images/proses.png" type="image" value="<%=sp2d.getId()%>" formmethod="post" formaction="proses_batal_sp2d"/> </td>
                            </tr>
                        </table>
                    </form>
                </center> 
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>
