<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Nom=<%=request.getParameter("nom").toUpperCase()%>
	<br />
	<%=(String) request.getParameter("etat")%>
	<br />
	<%
		String[] lesSports = request.getParameterValues("sport");
		if (lesSports != null) {
			for (int i = 0; i < lesSports.length; i++) {
				out.println(" " + lesSports[i] + "<br/>");
			}
		}
	%>
</body>
</html>