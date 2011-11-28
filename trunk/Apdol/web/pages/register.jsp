<%-- 
    Document   : register
    Created on : Nov 24, 2011, 10:54:17 AM
    Author     : wahid
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarUser"%>
<%@page import="apdol.entity.User"%>

<% List<User> listUser = (List<User>) request.getAttribute("listuser");%>
<% User user;%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Daftar User</h3>
        <% Iterator<User> iterator = listUser.iterator();%>
        <form >
            <p style="margin: 10px;"><BR>
            <table width="1002" border="1">
                <tr>
                    <td width="112"><span style="margin: 10px;">Username</span></td>
                    <td width="205"><p style="margin: 10px;">Password</p></td>
                    <td width="240"><span style="margin: 10px;">Nama</span></td>
                    <td width="112"><p style="margin: 10px;">Kode Satker</p></td>
                    <td width="175"><span style="margin: 10px;">Jabatan</span></td>
                    <td width="112"><p style="margin: 10px;">Role User</p></td>
                    <td width="46"><p style="margin: 10px;">Cek<BR></p></td>
                </tr>
                <% while (iterator.hasNext()) {
                              user = iterator.next();%>
                <tr>                 
                    <td width="112"><span style="margin: 10px;"><%=user.getUsername()%></span></td>
                    <td width="205"><p style="margin: 10px;"><%=user.getPassword()%></p></td>
                    <td width="240"><span style="margin: 10px;"><%=user.getNama()%></span></td>
                    <td width="112"><p style="margin: 10px;"><%=user.getKodeSatker()%></p></td>
                    <td width="175"><span style="margin: 10px;"><%=user.getJabatan()%></span></td>
                    <td width="112"><p style="margin: 10px;"><%=user.getRoleuser()%></p></td>
                    <td width="46" height="45"><p style="margin: 10px;">
                            <input  type="checkbox"  name="cekuser" value="<%=user.getId()%>">
                            <BR>
                        </p></td>
                </tr>
                <%}%>
            </table>
            <span style="margin: 10px;">
            </span>
            <p style="margin: 10px;"><BR>
                <input type="submit" value="rekam" name="rekam" formaction="rekam_user" formmethod="post"/>
                <input type="submit" value="edit" name="edit" formaction="edit_user" formmethod="post"/> 
                <input type="submit" value="hapus" name="hapus" formaction="proses_hapus_user" formmethod="post"/>
        </form>

    </body>
</html>
