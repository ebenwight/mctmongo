<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome mct 620</title>
</head>
<body>
	<p>add a comment:</p>
	<form action="server" method="post">
		<input type="text" id="name" name="name" />
		<input type="text" id="comment" name="comment" />
		<button type="submit">submit</button>

	</form>

	<%
		boolean showComment = false;
		Object comment = request.getParameter("document");
		if (null != comment) {
	%>

	<%=comment%>

	<%
		}
	%>
</body>
</html>