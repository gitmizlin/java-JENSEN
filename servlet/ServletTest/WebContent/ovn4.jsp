<html>
<body>

<%@ include file="menu.html" %>

<%
	String pageStr = request.getParameter("page");
	
	if (pageStr.equals("") || pageStr == null) {
		out.println("Hej - vem d�r");
	} else {
		out.println("Hej - " + pageStr);
	}
%>


</body>
</html>