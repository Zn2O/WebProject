<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Le Blanko</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<%@page import="com.client.Utilisateur" %>
<body>

  <%
		// si l'utilisateur tape l'adresse de la page content.jsp sans s'être logué auparavant, on affiche...
		if(request.getSession().getAttribute("utilisateur") == null)
		{
			out.print("Vous n'êtes pas connecté. Cliquez <a href=\"index.jsp\">ici</a> pour vous authentifier");
			
		} 
		else
		{
			// S'il s'est loggué, on affiche...
			Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("utilisateur");
			out.print(String.format("Bonjour visiteur ! Tu es connecté en tant que : %s", currentUser.getLogin()));
			out.print("<br />");
			out.print(String.format("Ton mot de passe est : %s", currentUser.getPassword()));
			out.print("<p><a href=\"LogoutServlet\">Déconnexion</a></p>");
		}
	%>
</body>
</html>