<%-- 
    Document   : rekamUser
    Created on : Nov 1, 2011, 11:00:51 AM
    Author     : Hari RZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
<center><form method="post" action="prosesrekam">
    <table border=0>
    <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
    </tr>
    <tr>
        <td>Nama</td>
        <td><input type="name" name="name"></td>
    </tr>
    <tr>
        <td>Jabatan</td>
        <td><input type="jabatan" name="jabatan"></td>
    </tr>
    <tr>
        <td>Role User</td>
        <td><input type="roleUser" name="roleUser"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="login"></td>
    </tr>
    </table>
    </form></center>
    </body>
</html>
