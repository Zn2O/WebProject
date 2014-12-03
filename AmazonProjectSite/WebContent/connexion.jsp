<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="iecss.css" />
<script type="text/javascript" src="js/index.js"></script>

<title>Le Blanko</title>
</head>
<body>
	<a href="index.jsp" class="button" id="toggle-login">Accueil</a>

	<div id="login">
		<div id="triangle"></div>
		<h1>Log in</h1>
		<form action="LoginServlet" method="post">
			<input type="text" placeholder="Login" id="Login" name="login" /> <input
				type="password" placeholder="Password" id="password" name="password" />
			<input type="submit" value="Log in" />
		</form>
	</div>

	<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

	<script src="js/index.js"></script>

</body>
</html>