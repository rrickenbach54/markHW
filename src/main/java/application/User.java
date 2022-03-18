package application;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "user")
@NamedQuery(name = "getUserByUsername", query = "SELECT person FROM User person WHERE person.username = ?1")
public class User
{
	private Integer userId;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String createTime;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
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
		return result;
	}

}
