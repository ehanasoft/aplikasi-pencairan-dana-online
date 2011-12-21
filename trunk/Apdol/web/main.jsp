<%-- 
    Document   : main
    Created on : Nov 3, 2011, 2:45:19 AM
    Author     : Accio
--%>

<%@page import="apdol.model.DaftarUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Apdol Testing 0.01</title>
<link href="styles/style.css" rel="stylesheet" type="text/css" />
</head>

<%-- add admin user for default user --%>
<% DaftarUser dUser = new DaftarUser ();%>
<% dUser.addAdmin();%>

<body>

<div id="login">
	<div id="content">
		<form method="post" action="maindo">
			<label class="login-info">Username</label>
			<input class="input" name="username" type="text" />
			<label class="login-info">Password</label>
			<input class="input" name="password" type="password" />
                        
				<div id="login-buttton">
					<input name="Submit" src="images/login-button.png" type="image" value="Giriş" /></div>
		</form>
	</div>
</div>
</body>
</html>
