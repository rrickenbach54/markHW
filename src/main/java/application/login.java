package application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet
{
	public login()
	{
		super();
	}

	private static boolean isNullOrEmpty(String s)
	{
		return s == null || s.length() ==0;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try
		{
			String destPage = "index.jsp";
			if (isNullOrEmpty(username))
			{
				String errorUser = "<span class='spnError'>Please enter valid username</span>";
				request.setAttribute("errorUser", errorUser);
			}
			else
			{
				request.setAttribute("username",username);
			}
			if (isNullOrEmpty(password))
			{
				String errorPass = "<span class='spnError'>Please enter valid Password</span>";
				request.setAttribute("errorPass", errorPass);
			}
			if (!username.isEmpty() && !password.isEmpty())
			{

				if ((username.equals("Test")) && (password.equals("Test")))
				{
					//response.sendRedirect(request.getContextPath() + "/home.jsp");
					destPage = "home.jsp";
				}
				else
				{
					String errorLogin = "<span class='spnError'>Invalid Login: Please Try Again</span>";
					request.setAttribute("errorLogin", errorLogin);
					request.setAttribute("username",username);
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request,response);
		}
		catch (Exception ex)
		{
			throw new ServletException(ex);
		}
	}

	public void destroy()
	{
	}

}
