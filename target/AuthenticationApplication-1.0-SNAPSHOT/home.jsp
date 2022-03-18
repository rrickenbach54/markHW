<%--
  Want to pull from the DB here and you can add all the users information on login to show that information.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link href="sources/styles.css" rel="stylesheet">
</head>
<body>
<table>
<%
Cookie cookie = null;
Cookie[] cookies = null;
cookies = request.getCookies();
boolean loggedIn = false;

for(int i = 0; i < cookies.length; i++)
{
	cookie = cookies[i];
	if(cookie.getName().equals("user"))
    {
		loggedIn = true;
    }
}
if(!loggedIn)
{
	out.print("<jsp:forward page=\"index.jsp\"/>");
}
%>
</table>
</body>
</html>