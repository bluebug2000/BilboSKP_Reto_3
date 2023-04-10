<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String seccion = request.getParameter("sec");
if (seccion == null) {
	seccion = "inicio";
}
seccion = "secciones/" + seccion + ".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/header_footerR.css">
<link rel="stylesheet" href="css/quienes_somosV2.css">
<link rel="stylesheet" href="normalize.css">

<title>BilboSKP</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/x-icon" href="img/favicon.png">
</head>
<body>
	<%--<%@include file="plantillas/nav.jsp"--%>
	<header>
	<ul>
	<a href="./perfil" > <li>Mi perfil</li></a>
	
	</ul>
	</header>
	<main>
		<%-- <jsp:include page="plantillas/mensaje.jsp"></jsp:include>--%>
		
		<jsp:include page="<%=seccion%>"></jsp:include>
	</main>
</body>
</html>