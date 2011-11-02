<%-- 
    Document   : home
    Created on : Nov 2, 2011, 11:09:56 PM
    Author     : Accio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String logedUser = (String)session.getAttribute("username");%>
<%Integer roleUser = (Integer) session.getAttribute("roleuser");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Apdol Testing Main Page</title>
    </head>
    <body>
        <h1><% if(logedUser!=null){ %><%="Anda Login sebagai: "+logedUser%><%}%></h1>
    </body>
</html>
