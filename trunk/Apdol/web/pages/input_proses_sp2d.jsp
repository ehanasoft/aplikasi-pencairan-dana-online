<%-- 
    Document   : input_notifikasi_spm
    Created on : Jan 7, 2012, 2:54:20 PM
    Author     : Accio
--%>

<%@page import="apdol.entity.BankPos"%>
<%@page import="apdol.string.format.Rupiah"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSPM"%>
<%@page import="apdol.entity.SPM"%>
<%@page import="apdol.model.DaftarRincianKegiatan"%>
<%@page import="apdol.entity.RincianKegiatan"%>

<% SPM spm = (SPM) request.getAttribute("spm_proses");%>
<% DateFormat dfd = new SimpleDateFormat("dd");%>
<% DateFormat dfm = new SimpleDateFormat("MM");%>
<% DateFormat dfy = new SimpleDateFormat("yyyy");%>
<%Rupiah rp = new Rupiah();%>

<% List<BankPos> listBank = (List<BankPos>) request.getAttribute("list_bank");
    BankPos bankPos;
    Iterator<BankPos> iteratorBank = listBank.iterator();%>
    
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
                <center><p><h3>Input Notifikasi SPM</h3></p>
                    <form name="form_input_notifikasi_spm" action="proses" method="post" >
                        <table width="650">
                            <tr>
                                <td width="189">Nomor SPM</td>
                                <td width="11">:</td>
                                <td width="450"><%=spm.getNomorSpm()%></td>
                            </tr>
                            <tr>
                                <td>Tanggal SPM</td>
                                <td>:</td>
                                <td><%=dfd.format(spm.getTanggalSPM())%>/<%=dfm.format(spm.getTanggalSPM())%>/<%=dfy.format(spm.getTanggalSPM())%></td>
                            </tr>
                            <tr>
                                <td>Satuan Kerja</td>
                                <td>:</td>
                                <td><%=spm.getRincianKegiatan().getSatker().getKodeSatker() + " - " + spm.getRincianKegiatan().getSatker().getNamaSatker()%></td>
                            </tr>
                            <tr>
                                <td width="127">Rincian Kegiatan</td>
                                <td>:</td>
                                <td><%=spm.getRincianKegiatan().getKegiatan().getNmgiat() + "." + spm.getRincianKegiatan().getOutput().getNamaOutput() + "." + spm.getRincianKegiatan().getMataAnggaran().getNamaMataAnggaran()%></td>
                            </tr>
                            <tr>
                                <td>Jumlah Keluar</td>
                                <td>:</td>
                                <td>Rp <%=rp.formatRupiah(spm.getJumlahKeluar())%></td>
                            </tr>
                            <tr>
                                <td>Potongan</td>
                                <td>:</td>
                                <td>Rp <%=rp.formatRupiah(spm.getJumlahPotongan())%></td>
                            </tr>
                            <tr>
                                <td>Jumlah Bersih</td>
                                <td>:</td>
                                <td>Rp <%=rp.formatRupiah(spm.getJumlahBersih())%></td>
                            </tr>
                            <tr>
                                <td width="200">Tanggal SP2D</td>
                                <td>
                                    <select name="tanggal" > 
                                        <% for (int i = 0; i < 31; i++) {%>
                                        <option value="<%=i + 1%>" ><%=i + 1%></option> <%}%> 
                                    </select>
                                    /
                                    <select name="bulan">
                                        <% for (int i = 0; i < 12; i++) {%>
                                        <option value="<%=i + 1%>"><%=i + 1%></option>
                                        <%}%>
                                    </select>
                                    /
                                    <select name="tahun">
                                        <option value="2011">2011</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Bank Pos</td>
                                <td>
                                    <select name="bank_pos"><% while (iteratorBank.hasNext()) { 
                                            bankPos = iteratorBank.next();%>
                                        <option value="<%=bankPos.getId()%>"><%=bankPos.getKdbankpos() + "-"+bankPos.getNmbankpos()%></option><%}%>
                                    </select>
                                </td>
                            </tr> 
                        </table>
                        <p><input type="hidden" name="spm_id" value="<%=spm.getId()%>"/></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_input_notifikasi_spm.reset()"><img src="images/reset.png" alt="Reset"/></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>

