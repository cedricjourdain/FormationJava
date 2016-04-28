<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reponse</title>
</head>
<body>
		<!--    reponse.jsp  -->
		<% 
			int essai=Integer.parseInt(request.getParameter("essais"));
			int n1   =Integer.parseInt(request.getParameter("n1"));
			int n2   =Integer.parseInt(request.getParameter("n2"));
			boolean correct = essai==n1*n2;
		%>
		<h1><%= correct ? "bravo" : "desole " %>
		<% request.getParameter("nom"); %>
		<br/>
		score <%= correct ? "10" : "0" %></h1>
</body>
</html>