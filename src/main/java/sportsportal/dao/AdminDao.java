package sportsportal.dao;

import sportsportal.beans.*;

import sportsportal.dbutils.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class AdminDao 
{
	public int addPlan(Plan_Bean p)
	{
		/*
		 * System.out.println(p.getName());
		 * System.out.println(p.getCharges());
		 * System.out.println(p.getServices());
		 */
		
		int status = 0;
		
		Connection con = DBConnection.openConnection(); //connection established
		PreparedStatement ps = null; //it will communicate with the database tables
		
		try
		{
			String insertQuery = "insert into plans(planName, planCharge, planServices) values(?,?,?)"; /*this is a query ,
			                                                            whatever is written in database is a query.
			                                                        Inside plan() brackets , column names are written.
			                                                        Inside values() bracket , as many '?' are inserted as
			                                                        are the number of column names in plan() bracket .
			                                                        The '?' are known as placeholders */
			
			
			ps = con.prepareStatement(insertQuery); /*prepareStatement method compiles the query at database and the
			                                          reference is being assigned to 'ps'*/
			
			ps.setString(1 , p.getName()); //setting value -> (column number , value to be set)
			ps.setInt(2 , p.getCharges());
			ps.setString(3 , p.getServices());
			System.out.println(ps);
			status = ps.executeUpdate(); //executeUpdate() method is used to execute the query , It return 1 or 0 i.e. int
		}
		
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(ps != null)
					ps.close();
			}
			
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			DBConnection.closeConnection(); //method made in DBConncetion.java
                                       //if there are more than one 'ps' , then we have to explicitly write code for closing connection
		}
		
		
		return status;
	}
	
	
	
	
	public int addEvent(EventBean p)
	{
		
//		  System.out.println(p.getEventName());
//		  System.out.println(p.getVenue());
//		  System.out.println(p.getDescription());
//		  System.out.println(p.getOrganizer());
//		  System.out.println(p.getDate());
		 
		
		int status = 0;
		
		Connection con = DBConnection.openConnection(); //connection established
		PreparedStatement ps = null; //it will communicate with the database tables
		
		try
		{
			String insertQuery = "insert into events(name, venue, organizer, description, date) values(?,?,?,?,?)"; /*this is a
			                                                                query , whatever is written in database is a query.
			                                                                 Inside plan() brackets , column names are written.
			                                                              Inside values() bracket , as many '?' are inserted as
			                                                              are the number of column names in plan() bracket .
			                                                              The '?' are known as placeholders  */
			
			
			ps = con.prepareStatement(insertQuery); /*prepareStatement method compiles the query at database and the
			                                          reference is being assigned to 'ps'*/
		
			ps.setString(1 , p.getEventName()); //setting value -> (column number , value to be set)
			ps.setString(2 , p.getVenue());
			ps.setString(3 , p.getOrganizer());
			ps.setString(4 , p.getDescription());
			ps.setString(5 , p.getDate());

			System.out.println(ps);
			status = ps.executeUpdate(); //executeUpdate() method is used to execute the query
		}
		
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return status;
	}
	
	
	
	
	
	public ArrayList<ContactBean> viewContacts() //type safe collections -> generic (parameterized) (angular Brackets)
                                            //this method is for fetching data from table and displaying in a jsp page . Return type is ArrayList
    {
		ArrayList<ContactBean>contactList = new ArrayList<>(); //inside <> on LHS , ContactBean is written , this means it is an object of ContactBean class . planList is name/reference variable of this object


        Connection con = DBConnection.openConnection();

        String select_query = "select * from contactus"; //
        PreparedStatement ps = null;
        ResultSet rs = null; // it is used to hold the reference of resultant dataset returned by select query

        try
        {
            ps = con.prepareStatement(select_query);
            rs = ps.executeQuery(); // query is executed and address is given to rs . Ex : if 10 rows are stored in table , they are executed and the address of the 10 rows is given to 'rs' 

            while(rs.next()) //rs.next() puts cursor on the first row and checks for data availability . If data is there , True is returned and cursor is moved to next row and False otherwise
            {
            	//id, name, email, phone, question, date
                String nm = rs.getString("name"); //reads the data from from given column name . inside brackets , actual column name from table is written , here column name can be case insensitive
                String em = rs.getString("email");
                String ph = rs.getString("phone");
                String ques = rs.getString("question");
                
                java.util.Date d = new java.util.Date();
        		long dt = d.getTime();
        		java.sql.Date sqlDate = new java.sql.Date(dt);
                
                //all the above variables form one row and collectively they form one object

                ContactBean pb = new ContactBean(nm , em , ph , ques , sqlDate); //New object is created for above variables to be stored and any previous data is overwritten

                contactList.add(pb); //the object created above is added to ArrayList so that on next iteration , the values of this object are not lost
            }
            System.out.println(contactList);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        return contactList;
    }
	
	
	
	
	
	
	public ArrayList<FeedBackBean> viewFeedback() //type safe collections -> generic (parameterized) (angular Brackets)
                                                 //this method is for fetching data from table and displaying in a jsp page . Return type is ArrayList
    {
        ArrayList<FeedBackBean>feedbackList = new ArrayList<>(); //inside <> on LHS , FeedBackBean is written , this means it is an object of FeedBackBean class . planList is name/reference variable of this object


        Connection con = DBConnection.openConnection();

        String select_query = "select * from feedback"; //
        PreparedStatement ps = null;
        ResultSet rs = null; // it is used to hold the reference of resultant dataset returned by select query

        try
        {
            ps = con.prepareStatement(select_query);
            rs = ps.executeQuery(); // query is executed and address is given to rs . Ex : if 10 rows are stored in table , they are executed and the address of the 10 rows is given to 'rs' 

            while(rs.next()) //rs.next() puts cursor on the first row and checks for data availability . If data is there , True is returned and cursor is moved to next row and False otherwise
            {
            //id, name, email, feedbackText, rating, status, date
                String nm = rs.getString("name"); //reads the data from from given column name . inside brackets , actual column name from table is written , here column name can be case insensitive
                String em = rs.getString("email");
                String fb = rs.getString("feedbackText");
                int rt = rs.getInt("rating");
                String st = rs.getString("status");

                java.util.Date d = new java.util.Date();
                long dt = d.getTime();
                java.sql.Date sqlDate = new java.sql.Date(dt);

                //all the above variables form one row and collectively they form one object

                FeedBackBean pb = new FeedBackBean(rt , nm , em , fb , sqlDate); //New object is created for above variables to be stored and any previous data is overwritten
                pb.setId(rs.getInt("id")); //getting id and setting it , id will be required if we want to delete any feedback , as feedback will be delete according to id to know which feedback is deleted
                pb.setStatus(st);
                feedbackList.add(pb); //the object created above is added to ArrayList so that on next iteration , the values of this object are not lost
            }
            System.out.println(feedbackList);
            }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        return feedbackList;
    }

	
	
	
	
	
	public int deleteFeedback(String[] idArray) 
	{
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		// String deleteQuerry ="delete from feedback"; -> //this will delete all data from feedback table
		
		String deleteQuerry ="delete from feedback where id =?"; //this will delete data on the basis of id
		
		int flag = 1;
		
		try
		{
			ps = con.prepareStatement(deleteQuerry);
			
			/*
			   for(int i = 0 ; i < idArray.length ; i++)  -> this will be slow as every time one query will be executed at a time which will take a lot of time for heavy colume data
			   {
			       int id =Integer.parseInt(idArray[i]);
			       ps.setInt(1 , id);
			       ps.executeUpdate();
			   }
			*/
			
			
			
			//batch processing
			for(int i = 0 ; i < idArray.length ; i++)
			   {
			       int id =Integer.parseInt(idArray[i]);
			       ps.setInt(1 , id);
			       ps.addBatch(); //this is like a temporary Buffer area
			   }
			int[] arr = ps.executeBatch(); //executeBatch return an integer type array . this line will send the whole branch to RDBMS for execution
			
			
			for(int i = 0 ; i < arr.length ; i++)
			{                                        // -> this is checking if all elements to be deleted are deleted , if element required to be deleted is not deleted , negative number will be stored instead  of positive number
				if(arr[i] < 0)
				{
					flag = 0;
					break;
				}
				else
				{
					flag = 1;
				}
			}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
			
			try 
			{
				con.rollback();    //if all selected data is not deleted then the part of data that was deleted will be given back by con.rollback()
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return flag;
	}


	
	
	
	
    public ArrayList<MemberFeedbackBean> viewMemberFeedback() 
    {
        ArrayList<MemberFeedbackBean>feedbackList = new ArrayList<>();

        Connection con = DBConnection.openConnection();

        String select_query = "select * from member_feedback"; //
        PreparedStatement ps = null;
        ResultSet rs = null; 

        try
        {
            ps = con.prepareStatement(select_query);
            rs = ps.executeQuery();

            while(rs.next())
            {

                String mid = rs.getString("memberid"); 
                String feed = rs.getString("feedback");
                int rat = rs.getInt("rating");

                java.util.Date d = new java.util.Date();
                long dt = d.getTime();
                java.sql.Date sqlDate = new java.sql.Date(dt);

                MemberFeedbackBean pb = new MemberFeedbackBean(mid , rat , feed , sqlDate); 
                pb.setSno(rs.getInt("sno"));
                
                feedbackList.add(pb); 
            }
        
            System.out.println(feedbackList);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        return feedbackList;
    }
    
    
    
    
    
    public MemberFeedbackBean viewMemberFeedbackData(String Sno)
    {
    	Connection con = DBConnection.openConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	MemberFeedbackBean mfb = null;
    	
    	String selectQuery = "select * from member_feedback where sno=?";
    	
    	try
    	{
    		ps = con.prepareStatement(selectQuery);
    		
    		ps.setInt(1 , Integer.parseInt(Sno));
    		
    		rs = ps.executeQuery();
    		rs.next();
    		
    		mfb = new MemberFeedbackBean();
    		
    		mfb.setFeedback(rs.getString("feedback"));
    		mfb.setRating(rs.getInt("rating"));
    		
    	}
    	
    	catch(SQLException se)
    	{
    		se.printStackTrace();
    	}
    	
    	return mfb;
    }
    
   
    
    
    
    
    public int deleteMemberFeedback(String[] idArray) 
	{
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		// String deleteQuerry ="delete from feedback"; -> //this will delete all data from feedback table
		
		String deleteQuerry ="delete from member_feedback where sno =?"; //this will delete data on the basis of id
		
		int flag = 1;
		
		try
		{
			ps = con.prepareStatement(deleteQuerry);
			
			/*
			   for(int i = 0 ; i < idArray.length ; i++)  -> this will be slow as every time one query will be executed at a time which will take a lot of time for heavy colume data
			   {
			       int id =Integer.parseInt(idArray[i]);
			       ps.setInt(1 , id);
			       ps.executeUpdate();
			   }
			*/
			
			
			
			//batch processing
			for(int i = 0 ; i < idArray.length ; i++)
			   {
			       int sno =Integer.parseInt(idArray[i]);
			       ps.setInt(1 , sno);
			       ps.addBatch(); //this is like a temporary Buffer area
			   }
			int[] arr = ps.executeBatch(); //executeBatch return an integer type array . this line will send the whole branch to RDBMS for execution
			
			
			for(int i = 0 ; i < arr.length ; i++)
			{                                        // -> this is checking if all elements to be deleted are deleted , if element required to be deleted is not deleted , negative number will be stored instead  of positive number
				if(arr[i] < 0)
				{
					flag = 0;
					break;
				}
				else
				{
					flag = 1;
				}
			}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
			
			try 
			{
				con.rollback();    //if all selected data is not deleted then the part of data that was deleted will be given back by con.rollback()
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return flag;
	}

}
