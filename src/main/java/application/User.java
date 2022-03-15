package application;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQuery(name = "maxID",query = "SELECT e FROM User e WHERE e.userId = MAX(User.userId)")
public class User
{

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Timestamp createTime;
	private Timestamp lastLogin;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Integer userId;
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Basic
	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Basic
	@Column(name = "first_name")
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "last_name")
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "email")
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Basic
	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Basic
	@Column(name = "create_time")
	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "last_login")
	public Timestamp getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		User user = (User) o;

		if (userId != null ? !userId.equals(user.userId) : user.userId != null)
		{
			return false;
		}
		if (username != null ? !username.equals(user.username) : user.username != null)
		{
			return false;
		}
		if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null)
		{
			return false;
		}
		if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null)
		{
			return false;
		}
		if (email != null ? !email.equals(user.email) : user.email != null)
		{
			return false;
		}
		if (password != null ? !password.equals(user.password) : user.password != null)
		{
			return false;
		}
		if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null)
		{
			return false;
		}
		if (lastLogin != null ? !lastLogin.equals(user.lastLogin) : user.lastLogin != null)
		{
			return false;
		}

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
		return result;
	}
}
