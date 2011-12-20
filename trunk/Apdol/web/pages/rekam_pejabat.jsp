<%-- 
    Document   : rekam_pejabat
    Created on : Nov 27, 2011, 6:17:37 AM
    Author     : AlfieSaHid
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSatuanKerja"%>
<%@page import="apdol.entity.SatuanKerja"%>

<% List<SatuanKerja> listSatker = (List<SatuanKerja>) request.getAttribute("list_satker");%>
<% SatuanKerja satker;%>
<% Iterator<SatuanKerja> iterator = listSatker.iterator();%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Rekam Pejabat</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
        <style>
        .content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
        ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
        </style>
        <![endif]-->
        <script language="JavaScript">
            function showhidekppn(){
                // enable one
                document.getElementById("ketkppn").style.display = 'block';
                document.getElementById("ketkppn").disabled = false;
                // disable two
                document.getElementById("ketsatker").disabled = true;
                document.getElementById("ketsatker").style.display = 'none';
            }
            function showhidesatker(){
                // disable one
                document.getElementById("ketkppn").disabled = true;
                document.getElementById("ketkppn").style.display = 'none';	
                // enable two
                document.getElementById("ketsatker").style.display = 'block';
                document.getElementById("ketsatker").disabled = false;
            }
        </script>
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
                <center><p><h3> Rekam Pejabat</h3></p>
                    <form name="form_rekam_pejabat" action="proses_rekam_pejabat" method="post" >
                        <table width="450">                                                
                            <tr>
                                <td width="150">NIP</td><td><input name="nip" type="text" style="width: 180px" size="18" maxlength="18"></td>
                            </tr>                                                
                            <tr>
                                <td>Nama Pejabat</td><td><input type="text" name="nama" style="width: 300px"></td>
                            </tr>
                            <tr>                                                    
                                <td>Golongan</td>
                                <td>
                                    <select name="golongan">
                                        <option value="31">III/a Penata Muda</option>
                                        <option value="32">III/b Penata Muda Tk. I</option>
                                        <option value="33">III/c Penata</option>
                                        <option value="34">III/d Penata Tk. I</option>
                                        <option value="41">IV/a Pembina</option>
                                        <option value="42">IV/b Pembina Tk. I</option>
                                        <option value="43">IV/c Pembina Utama Muda</option>
                                        <option value="44">IV/d Pembina Utama Madya</option>
                                        <option value="45">IV/e Pembina Utama</option>
                                    </select>
                                </td>
                                <tr>
                                    <td>Jabatan</td><td><input type="text" name="jabatan" style="width: 300px"></td>
                                </tr>                            
                                <tr>
                                    <td>Pilih</td>
                                    <td>
                                        <input type="radio" onClick="javascript:showhidesatker();document.form_rekam_pejabat.satker.disabled=false;" name="pilih"/>Satker
                                        <input type="radio" onClick="javascript:showhidekppn();document.form_rekam_pejabat.satker.disabled=true;" name="pilih"/>KPPN
                                    </td>
                                </tr>
                                <tr>
                                    <td>Keterangan</td>
                                    <td>
                                        <select id="ketkppn" name="keterangan" style="display: none;">
                                            <option value="Kasi Pencairan Dana">Kasi Pencairan Dana</option>
                                            <option value="Kasi Bank/Giro Pos">Kasi Bank/Giro Pos</option>
                                        </select>
                                        <select id="ketsatker" name="keterangan">
                                            <option value="KPA">KPA</option>
                                            <option value="Penandatangan SPM">Penandatangan SPM</option>
                                        </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Satker</td>
                                    <td>
                                        <select name="satker"><% while (iterator.hasNext()) {
                                                    satker = iterator.next();%><option value="<%=satker.getKodeSatker()%>"><%=satker.getKodeSatker() + " " + satker.getNamaSatker()%> </option><%}%>
                                        </select>
                                    </td>
                                </tr>
                        </table>
                        <p></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_pejabat.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>

