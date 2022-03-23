<%@ page import="java.net.HttpCookie" %>
<%@ page import="java.net.http.HttpResponse" %>
<%@ page import="java.net.http.HttpRequest" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
<%
    String[] displayCookies = {"username","firstName"};
	List<String> list = new ArrayList<String>();
    Cookie cookie;
    Cookie[] cookies;
	boolean isValidLogin = false;
	cookies = request.getCookies();
	StringBuilder output = new StringBuilder();

	output.append("<h2>Welcome to the system user here is your information:</h2>");

	for(int i = 0; i<displayCookies.length;i++)
    {
		list.add(displayCookies[i]);
    }

	if(cookies != null)
    {
		//out.print("I see cookies exist with " + cookies.length + " in length<br>");
        output.append("<table>");
        for (int i = 0; i < cookies.length; i++)
        {
            cookie = cookies[i];
            //out.print("Cookie " + cookie.getName() + "<br>Value: " + cookie.getValue() + "<br>");
            if ((cookie.getName().equals("loggedIn")) &&  (cookie.getValue().equals("True")))
            {
				//out.print("Found loggedIn cookie<br>");
				isValidLogin = true;
            }
            else
            {
				//out.print("adding to output<br>");
                if(list.contains(cookie.getName()))
                {
                    output.append("<tr><td>").append(cookie.getName()).append("</td><td>").append(
                            cookie.getValue()).append("</td></tr>");
                }
            }
        }
		output.append("</table>");
        output.append("End of table html code here");
    }

    if(isValidLogin)
    {
        //out.print("Valid login should output the output variable<br>");
        out.print(output.toString());
    }
    else
    {
        response.sendRedirect("index.jsp");
        //out.print("I didn't find login cookie should redirect here");
    }

%>
</body>
</html>