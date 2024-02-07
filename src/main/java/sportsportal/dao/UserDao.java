package sportsportal.dao;

import java.sql.*;

import java.util.*;

import sportsportal.beans.*;

import sportsportal.dbutils.DBConnection;

public class UserDao 
{
	public int addFeedBack(FeedBackBean p)
	{
		int status = 0;
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		try
		{
			String insertQuery = "insert into feedback(name, email, feedbackText, rating, status, date) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1 , p.getName());
			ps.setString(2 , p.getEmail());
			ps.setString(3 , p.getFeedback());
			ps.setInt(4 , p.getRating());
			ps.setString(5 , p.getStatus());
			ps.setDate(6 , p.getDate());
			System.out.println(ps);
			status = ps.executeUpdate();
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return status;
	}
	
	public int addContactUs(ContactBean p)
	{
		int status = 0;
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		try
		{
			String insertQuery = "insert into contactus(name, email, phone, question, date) values(?,?,?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1 , p.getName());
			ps.setString(2 , p.getEmail());
			ps.setString(3 , p.getPhone());
			ps.setString(4 , p.getQuestion());
			ps.setDate(5 , p.getDate());
			System.out.println(ps);
			status = ps.executeUpdate();
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return status;
	}
	
	
	public ArrayList<Plan_Bean> viewPlans() //type safe collections -> generic (parameterized) (angular Brackets)
	                                        //this method is for fetching data from table and displaying in a jsp page . Return type is ArrayList
	{
		
		ArrayList<Plan_Bean>planList = new ArrayList<>(); //inside <> on LHS , Plan_Bean is written , this means it is an object of Plan_Bean class . planList is name/reference variable of this object
		
		
		Connection con = DBConnection.openConnection();
		
		String select_query = "select * from plans"; //
		PreparedStatement ps = null;
		ResultSet rs = null; // it is used to hold the reference of resultant dataset returned by select query
		
		try
		{
		    ps = con.prepareStatement(select_query);
			rs = ps.executeQuery(); // query is executed and address is given to rs . Ex : if 10 rows are stored in table , they are executed and the address of the 10 rows is given to 'rs' 
			
			while(rs.next()) //rs.next() puts cursor on the first row and checks for data availability . If data is there , True is returned and cursor is moved to next row and False otherwise
			{
				String nm = rs.getString("planName"); //reads the data from from given column name . inside brackets , actual column name from table is written , here column name can be case insensitive
				int ch = rs.getInt("planCharge");
				String ser = rs.getString("planServices");
				//all the above variables form one row and collectively they form one object
				
				Plan_Bean pb = new Plan_Bean(nm , ser , ch); //New object is created for above variables to be stored and any previous data is overwritten
				
				planList.add(pb); //the object created above is added to ArrayList so that on next iteration , the values of this object are not lost
			}
			//System.out.println(planList);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		return planList;
	}
	
	
	public ArrayList<EventBean> viewEvents()
	{
		ArrayList<EventBean> eventList = new ArrayList<>();
		
        Connection con = DBConnection.openConnection();
		
		String select_query = "select * from events order by date limit 6"; /*after this writing order by date will sort data according to date in ascending order by default and further writing desc after will sort it in descending order
		                                                                    and further more writing limit 6 will show only first 6 data according to ascending or descending order . NOTE : here date is the column name(write column name for doing so)*/
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			ps = con.prepareStatement(select_query);
			rs = ps.executeQuery(); 
			
			while(rs.next())
			{
				
				String nm = rs.getString("name"); 
				String ven = rs.getString("venue");
				String org = rs.getString("organizer");
				String des = rs.getString("description");
				String dt = rs.getString("date");
				
				
				EventBean event = new EventBean(nm , ven , des , org , dt);
				
				eventList.add(event); 
			}
			System.out.println(eventList);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		return eventList;
	}
}
