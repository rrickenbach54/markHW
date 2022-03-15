package application;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet
{
	public register()
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
		String confirm_password = request.getParameter("confirm_password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		boolean match = false;
		boolean validUser = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		User user = new User();

		try
		{
			String destPage = "register.jsp";
			if(isNullOrEmpty(username))
			{
				request.setAttribute("username_err","Please enter a username");
			}
			else
			{
				try
				{
					transaction.begin();
					TypedQuery<User> userFromDB = entityManager.createNamedQuery("getUserByUsername",User.class);
					userFromDB.setParameter(1,username);
					user = userFromDB.getSingleResult();
					transaction.commit();
				}
				finally
				{
					if(transaction.isActive())
					{
						transaction.rollback();
					}
					entityManager.close();
					entityManagerFactory.close();
				}
				if (user != null)
				{
					request.setAttribute("username_err","Username already exists");
					request.setAttribute("username",username);
				}
				else
				{
					request.setAttribute("username",username);
					validUser = true;
				}
				//if(user.getUsername().length() > 0)
				//{
				//	request.setAttribute("username_err","Username already exists");
				//	request.setAttribute("username",username);
				//}
				//else
				//{
				//}
				//Will have to look at persistence still on if a check should be made for an existing user here or just before trying to create a user.
			}
			if(isNullOrEmpty(password))
			{
				request.setAttribute("password_err","Please enter a password");
			}
			if(isNullOrEmpty(confirm_password))
			{
				request.setAttribute("confirm_password_err","Please confirm password");
			}
			if(isNullOrEmpty(fname))
			{
				request.setAttribute("fname_err","Please enter a first name");
			}
			else
			{
				request.setAttribute("fname",fname);
			}
			if(isNullOrEmpty(lname))
			{
				request.setAttribute("lname_err","Please enter a last name");
			}
			else
			{
				request.setAttribute("lname",lname);
			}
			if(isNullOrEmpty(email))
			{
				request.setAttribute("email_err","Please enter an email");
			}
			else
			{
				request.setAttribute("email",email);
			}
			if(!password.isEmpty() && !confirm_password.isEmpty())
			{
				if(password.equals(confirm_password))
				{
					match = true;
				}
				else
				{
					request.setAttribute("password_err","Passwords did not match");
				}
			}
			if(!username.isEmpty() && !password.isEmpty() && !confirm_password.isEmpty() && !fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && match && validUser)
			{
				//If validation for a username not already existing (based on username) then create.
				//Create DB user here
				destPage = "index.jsp";
				try
				{
					transaction.begin();
					user.setUsername(username);
					user.setFirstName(fname);
					user.setLastName(lname);
					user.setEmail(email);
					user.setPassword(password);
					user.setCreateTime(new Timestamp(System.currentTimeMillis()));
					entityManager.persist(user);
					transaction.commit();
				}
				finally
				{
					if(transaction.isActive())
					{
						transaction.rollback();
					}
					entityManager.close();
					entityManagerFactory.close();
				}

			}
			else
			{
				String register_err = "<span class='spnError'>Please correct the below issues and try again</span>";
				request.setAttribute("register_err",register_err);
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
