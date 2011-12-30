<%-- 
    Document   : edit_spm
    Created on : Dec 25, 2011, 10:52:26 PM
    Author     : wahid
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSPM"%>
<%@page import="apdol.entity.SPM"%>
<%@page import="apdol.model.DaftarRincianKegiatan"%>
<%@page import="apdol.entity.RincianKegiatan"%>

<% SPM spm = (SPM) request.getAttribute("spm_edit");%>
<% List<RincianKegiatan> listRincianKegiatan = (List<RincianKegiatan>) request.getAttribute("list_rincian_kegiatan");%>
<% RincianKegiatan rincianKegiatan;%>
<% DateFormat dfd = new SimpleDateFormat("dd");%>
<% DateFormat dfm = new SimpleDateFormat("MM");%>
<% DateFormat dfy = new SimpleDateFormat("yyyy");%>

<% RincianKegiatan rincianKegiatanSPM = (RincianKegiatan) request.getAttribute("rincianKegiatanSPM");%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>
    <%String kodeSatker = (String) session.getAttribute("kode_satker");%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Edit SPM</title>
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
                    <li><a href="spm">DIPA</a></li>
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
                    <li><a href="tayang_dipa">Tayang DIPA</a></li>
                </ul>
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="spm">Surat Perintah Membayar</a></li>
                </ul>
                <p><strong>Monitoring</strong></p>
                <ul class="nav">
                    <li><a href="realisasi">Realisasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="cetak_spm">Cetak SPM</a></li>	
                    <li><a href="submit">Submit ke KPPN</a></li>
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
                <center><p><h3> Edit SPM</h3></p>
                    <form name="form_edit_spm" action="proses_edit_spm" method="post" >
                        <table width="400px"/>  
                            <tr>
                                <td>Nomor SPM</td><td><input type="text" name="nomor_spm" style="width: 200px" value="<%=spm.getId()%>"></td>
                            </tr>
                            <tr>
                                <td width="200">Tanggal SPM</td>
                                <td><label for="tanggal"></label>
                                    <input name="tanggal" type="text" id="tanggal" style = "width:25px" size="2" maxlength="2" value="<%=dfd.format(spm.getTanggalSPM())%>"/>
                                /
                                <input name="bulan" type="text" id="bulan" style = "width:25px" size="2" maxlength="2" value="<%=dfm.format(spm.getTanggalSPM())%>"/>
                                /
                                <label for="tahun"></label>
                                <input type="text" name="tahun" id="tahun" style = "width:50px" size="4" maxlength="4" value="<%=dfy.format(spm.getTanggalSPM())%>"/></td>
                            </tr>
                            <tr>
                                <td>RincianKegiatan</td>
                                <td>
                                    <select name="rincian_kegiatan">
                                        <%Iterator<RincianKegiatan> iterator = listRincianKegiatan.iterator();%>
                                        <%while (iterator.hasNext()) {
                                                rincianKegiatan = iterator.next();
                                                
                                            if (kodeSatker.equalsIgnoreCase(rincianKegiatan.getSatker().getKodeSatker())) {
                                                if (spm.getRincianKegiatan() != null && spm.getRincianKegiatan().getId().equals(rincianKegiatan.getId())) {
                                                    out.println("<option value=" + rincianKegiatan.getId() + " selected=\"selected\">" + rincianKegiatan.getKegiatan().getNmgiat() + " . " + rincianKegiatan.getOutput().getNamaOutput() + " . " + rincianKegiatan.getMataAnggaran().getNamaMataAnggaran() + "</option>");
                                                } else {
                                                    out.println("<option value=" + rincianKegiatan.getId() + ">" + rincianKegiatan.getKegiatan().getNmgiat() + " . " + rincianKegiatan.getOutput().getNamaOutput() + " . " + rincianKegiatan.getMataAnggaran().getNamaMataAnggaran() + "</option>");
                                                }}
                                            }%>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <table width="400px"/>  
                            <tr>
                                <td>Jumlah Keluar</td><td><input type="text" name="jumlah_keluar" style="width: 200px" value="<%=spm.getJumlahKeluar()%>"</td>
                            </tr>
                        </table>
                        <table width="400px"/>  
                            <tr>
                                <td>Jumlah Potongan</td><td><input type="text" name="jumlah_potongan" style="width: 200px" value="<%=spm.getJumlahPotongan()%>"</td>
                            </tr>
                        </table>                       
                        <p><input type="hidden" name="id_edit_spm" value="<%=spm.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_spm.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>
