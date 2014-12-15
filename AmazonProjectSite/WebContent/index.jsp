<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Le Blanko</title>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>
	<div id="main_container">
		<div class="top_bar"></div>
		<div id="header">
			<div id="logo">
				<a href=""><img src="images/logo.png" alt="" border="0"
					width="237" height="140" /></a>
			</div>
			<div class="oferte_content">
				<div class="top_divider">
					<img src="images/header_divider.png" alt="" width="1" height="164" />
				</div>
				<div class="oferta"></div>
			</div>
			<div class="top_divider">
				<img src="images/header_divider.png" alt="" width="1" height="164" />
			</div>
		</div>
		<!-- end of oferte_content-->
		<div id="main_content">
			<div id="menu_tab">
				<div class="left_menu_corner"></div>
					<ul class="menu">
					<li><a href="index.jsp" class="nav1">Accueil</a></li>
					<li class="divider"></li>
					<li><a href="produit.jsp" class="nav2">Produits</a></li>
					<li class="divider"></li>
					<li><a href="creerProduit.jsp" class="nav3">Promotions</a></li>
					<li class="divider"></li>
					<li><a href="compte.jsp" class="nav4">Mon compte</a></li>
					<li class="divider"></li>
					<li><a href="connexion.jsp" class="nav4">Se connecter</a></li>
					<li class="divider"></li>
					<li><a href="NewFile.jsp" class="nav5">Panier</a></li>
					<li class="divider"></li>
					<li><a href="contact.html" class="nav6">contact</a></li>
					<li class="divider"></li>
					<li class="currencies">Convertir <select>
							<option>Dollar</option>
							<option>Euro</option>
					</select>
					</li>
				</ul>
				<div class="right_menu_corner"></div>
			</div>
		</div>
		<!-- end of menu tab -->
		<!-- end of center content -->
		<div class="right_content">
			<div class="shopping_cart">
				<div class="cart_title">Shopping cart</div>
				<div class="cart_details">
					0 items <br /> <span class="border_cart"></span> Total: <span
						class="price">0</span>
				</div>
				<div class="cart_icon">
					<a href="" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img
						src="images/shoppingcart.png" alt="" width="48" height="48"
						border="0" /></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>