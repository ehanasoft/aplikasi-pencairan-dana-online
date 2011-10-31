<%-- 
    Document   : login
    Created on : Nov 1, 2011, 4:01:18 AM
    Author     : Accio
--%>
<%@page import="apdol.entity.Users"%>
<%@page import="apdol.model.DaftarUsers"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <center><h1>APDOL ALPHA</h1></center>
<body>
<center><form method="post" action="Login">
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
        <td></td>
        <td><input type="submit" value="login"></td>
    </tr>
    </table>
    </form></center>
</body>
</html>
