package application;

import org.hibernate.SessionFactory;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = entityManager.getTransaction();

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
		User user = new User();
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
				entityManager.clear();

				try
				{
					transaction.begin();
					TypedQuery<User> userFromDB = entityManager.createNamedQuery("getUserByUsername",User.class);
					userFromDB.setParameter(1,username);
					user = userFromDB.getSingleResult();
					transaction.commit();
					if (application.passwordUtils.validatePassword(password,user.getPassword()))
					{
						destPage = "home.jsp";
						response.addCookie(cookieBuilder("username",user.getUsername()));
						response.addCookie(cookieBuilder("firstName",user.getFirstName()));
						response.addCookie(cookieBuilder("loggedIn","True"));
					}
					else
					{
						String errorLogin = "<span class='spnError'>Invalid Login: Please Try Again</span>";
						request.setAttribute("errorLogin", errorLogin);
						request.setAttribute("username",username);
					}
				}
				catch (Exception ex)
				{
					String errorLogin = "<span class='spnError'>Invalid Login: Please Try Again</span>";
					request.setAttribute("errorLogin", errorLogin);
					request.setAttribute("username",username);
				}
				finally
				{
					if(transaction.isActive())
					{
						transaction.rollback();
					}
				}

			}
			//The old way here was forwarding the request. This caused an issue because cookies are
			//being added to the response so they would only be available in subsequent requests.
			//Thus the behavior of having to login twice. This new option redirects the current request
			//so it is same session and resolves this.
			//RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			//dispatcher.forward(request,response);
			response.sendRedirect(destPage);
		}
		catch (Exception ex)
		{
			throw new ServletException(ex);
		}
	}

	public Cookie cookieBuilder(String cookieName, String value)
	{
		Cookie cookie = new Cookie(cookieName,value);
		cookie.setHttpOnly(true);
		return cookie;
	}

	public void destroy()
	{
	}

}
