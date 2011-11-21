<%-- 
    Document   : lokasi
    Created on : Nov 11, 2011, 11:28:50 AM
    Author     : Hari RZ
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarLokasi"%>
<%@page import="apdol.entity.Lokasi"%>

<% List<Lokasi> listLokasi = (List<Lokasi>) request.getAttribute("listlokasi");%>
<% Lokasi lokasi;%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Daftar Lokasi</h3>
        <% Iterator<Lokasi> iterator = listLokasi.iterator();%>
        <form >
            <p style="margin: 10px;"><BR>
            <table width="671" border="1">
                <tr>
                    <td width="46"><p style="margin: 10px;">Cek<BR>
                        </p></td>
                    <td width="112"><span style="margin: 10px;">Kode Lokasi</span></td>
                    <td width="205"><p style="margin: 10px;">Nama Kota</p></td>
                    <td width="280"><span style="margin: 10px;">Nama Propinsi</span></td>
                </tr>
                <% while (iterator.hasNext()) {
                              lokasi = iterator.next();%>
                <tr>
                    <td width="46" height="45"><p style="margin: 10px;">
                            <input  type="checkbox"  name="ceklokasi" value="<%=lokasi.getId()%>">
                            <BR>
                        </p></td>
                    <td width="112"><span style="margin: 10px;"><%=lokasi.getKodeLokasi()%></span></td>
                    <td width="205"><p style="margin: 10px;"><%=lokasi.getNamaKota()%></p></td>
                    <td width="280"><span style="margin: 10px;"><%=lokasi.getNamaPropinsi()%></span></td>
                </tr>
                <%}%>
            </table>
            <span style="margin: 10px;">
            </span>
            <p style="margin: 10px;"><BR>
                <input type="submit" value="rekam" name="rekam" formaction="rekamlokasi" formmethod="post"/>
                <input type="submit" value="edit" name="edit" formaction="editlokasi" formmethod="post"/> 
                <input type="submit" value="hapus" name="hapus" formaction="proseshapuslokasi" formmethod="post"/>
        </form>

    </body>
</html>
