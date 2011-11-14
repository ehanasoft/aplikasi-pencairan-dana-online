<%-- 
    Document   : ubah
    Created on : Nov 15, 2011, 5:44:43 AM
    Author     : wahid
--%>
<%@page import="apdol.model.DaftarUser"%>
<%@page import="apdol.entity.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form action="edit" method="post" name="rekam">
    <input name="id" value="${users.id}"/>
<table width="200" border="1">
  <tr>
    <td>Username</td>
    <td><input name="username" value="${users.username}" type="text" maxlength="50" /></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><input name="password" value="${users.password}" type="password" maxlength="50" /></td>
  </tr>
  <tr>
    <td>Nama</td>
    <td><input name="nama" value="${users.nama}" type="text" /></td>
  </tr>
  <tr>
    <td>Jabatan</td>
    <td><input name="jabatan" value="${users.jabatan}" type="text" maxlength="50" /></td>
  </tr>
  <tr>
    <td>Kode Satker</td>
    <td><input name="kodesatker" value="${users.kodesatker}" type="text" maxlength="50" /></td>
  </tr>
</table>
    <label>${error}</label>
    <input name="Rekam" type="submit" value="Submit" />
</form>
    </body>
</html>
