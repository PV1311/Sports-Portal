package sportsportal.dbutils;
import java.sql.*;
import java.util.ResourceBundle;

public class DBConnection 
{
	private static Connection con; /*con variable of Connection database : stores the reference of the database
	                                 to which connection is made*/
	
	private static ResourceBundle rb; //to read data from .properties file
	
	public static Connection openConnection()
	{
		try
		{
			rb = ResourceBundle.getBundle("sportsportal/dbutils/dbinfo"); //inside () -> package name('/' in place of '.') and class name in end without.properties extension
			
			String url = rb.getString("db.url"); //getString gets the value stored in db.url in the properties file . Inside () -> variable name/key
			// System.out.println(url);
			String id = rb.getString("db.userid");
			String pass = rb.getString("db.userpass");
			
			
         Class.forName("com.mysql.cj.jdbc.Driver"); /*'Class' is a built in class with static method forName() , it creates
         object of a class , here object of Driver class is created which loads 
         the class in the memory*/
         
        // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsdb","root","Pranjal@35"); /**/
         
         con = DriverManager.getConnection(url , id , pass); /**/
			
			
		}
		
		
		catch(SQLException | ClassNotFoundException se)
		{
			System.out.println(se);
		}
		
		return con;
	}
	
	
	/*
	  public static void main(String[] args
      { 
          Connection c = DBConnection.openConnection(0;
          System.out.println(c);
      }
	 */
	
	public static void closeConnection()
	{
		try 
		{
		    if(con != null)
		    	con.close();
	    }
		catch (SQLException e)
		{
		    e.printStackTrace();
		}
	}
	
}
