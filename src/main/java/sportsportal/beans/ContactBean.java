package sportsportal.beans;
import java.sql.Date;

public class ContactBean 
{
	private int id; //not included in parameterized constructor
	private String name , email , phone , question;
	private Date date;
	
	
	public ContactBean()
	{
	}


	public ContactBean(String name, String email, String phone, String question, Date date) 
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.date = date;
	}


	public int getId() 
	{
		return id;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getPhone()
	{
		return phone;
	}


	public void setPhone(String phone)
	{
		this.phone = phone;
	}


	public String getQuestion()
	{
		return question;
	}


	public void setQuestion(String question) 
	{
		this.question = question;
	}


	public Date getDate()
	{
		return date;
	}


	public void setDate(Date date)
	{
		this.date = date;
	}	
	
	
}
