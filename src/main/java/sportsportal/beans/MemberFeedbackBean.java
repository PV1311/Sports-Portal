package sportsportal.beans;

import java.sql.Date;

public class MemberFeedbackBean 
{
	private int rating , sno;
	

	private String feedback , id;
	private Date date;
	
	
	
	public MemberFeedbackBean() 
	{
	}

	

	public MemberFeedbackBean(String id, int rating, String feedback, Date date)
	{
		this.id = id;
		this.rating = rating;
		this.feedback = feedback;
		this.date = date;
	}


	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating)
	{
		this.rating = rating;
	}

	public String getFeedback()
	{
		return feedback;
	}


	public void setFeedback(String feedback) 
	{
		this.feedback = feedback;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}	
	
	public int getSno() 
	{
		return sno;
	}

	public void setSno(int sno) 
	{
		this.sno = sno;
	}
	
}
