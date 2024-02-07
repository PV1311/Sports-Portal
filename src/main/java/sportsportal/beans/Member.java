package sportsportal.beans;

import java.sql.*;

public class Member 
{
	private String memberId , password , name , email , phone , gender , city , planName , address ;
	private Date date;
	
	
	public Member() 
	{
	}


	public Member(String memberId, String password, String name, String email, String phone, String gender, String city,
			String planName, String address, Date date)
	{
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.planName = planName;
		this.address = address;
		this.date = date;
	}


	public Member(String memberId, String name, String email, String phone, String gender, String city, String planName,
			String address, Date date)
	{
		super();
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.planName = planName;
		this.address = address;
		this.date = date;
	}


	public Member(String memberId, String email, String phone, String city, String address)
	{
		this.memberId = memberId;      /*this constructor is created to pass the edited values when member edits profile*/
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.address = address;
	}


	public String getMemberId() 
	{
		return memberId;
	}


	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}


	public String getPassword()
	{
		return password;
	}


	public void setPassword(String password) 
	{
		this.password = password;
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


	public String getGender() 
	{
		return gender;
	}


	public void setGender(String gender) 
	{
		this.gender = gender;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getPlanName() 
	{
		return planName;
	}


	public void setPlanName(String planName)
	{
		this.planName = planName;
	}


	public String getAddress()
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
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
