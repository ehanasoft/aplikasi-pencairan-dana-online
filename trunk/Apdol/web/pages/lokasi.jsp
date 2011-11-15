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
            <% while (iterator.hasNext()) {
                    lokasi = iterator.next();%>
            
                    <form >
                        <p style="margin: 10px;">
                <b style="color: blue;"> <%=lokasi.getNamaKota()%>  Dan <%=lokasi.getNamaPropinsi()%> Dan <%=lokasi.getId()%></b>
                <input type="hidden" name="idlokasi" value="<%=lokasi.getId()%>">
            
                    
                   <input type="submit" value="edit" name="edit" formaction="editlokasi" formmethod="post"/>
                   <input type="submit" value="hapus" name="hapus" formaction="hapuslokasi" formmethod="post"/>
                    </form>
            <%}%>
            <p style="margin: 15px;color : yellow;"><a href="rekamlokasi">Rekam Lokasi    </a></p>
        
    </body>
</html>
