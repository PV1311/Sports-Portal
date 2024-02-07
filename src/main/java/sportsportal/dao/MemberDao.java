package sportsportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sportsportal.beans.Member;
import sportsportal.beans.MemberFeedbackBean;
import sportsportal.dbutils.DBConnection;

public class MemberDao
{
	public int registration(Member p)
	{
		int status = 0;
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		try
		{
			String insertQuery = "insert into member(memberid, password, name, email, phone, gender, city, planname, addess, date) values(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1 , p.getMemberId());
			ps.setString(2 , p.getPassword());
			ps.setString(3 , p.getName());
			ps.setString(4 , p.getEmail());
			ps.setString(5 , p.getPhone());
			ps.setString(6 , p.getGender());
			ps.setString(7 , p.getCity());
			ps.setString(8 , p.getPlanName());
			ps.setString(9 , p.getAddress());
			ps.setDate(10 , p.getDate());
			System.out.println(ps);
			status = ps.executeUpdate();
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return status;
	}
	
	
	

	public Member login(String id, String pass)
	{
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		
		String strsql = "select * from member where memberid=? and password=?";
		
		try
		{
			ps = con.prepareStatement(strsql);
			ps.setString(1 , id);
			ps.setString(2 , pass);
			System.out.println(ps); //this is for testing only
			rs = ps.executeQuery(); //this will return only one object because id is unique
			
			if(rs.next() == true)
			{
				//memberid, password, name, email, phone, gender, city, planname, address, date
				m = new Member();
				String name= rs.getString("name");     //getting values from database
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String planName = rs.getString("planname");
				String address = rs.getString("address");
				m.setName(name);
				m.setEmail(email);          //setting values in bean class
				m.setPhone(phone);
				m.setCity(city);
				m.setPlanName(planName);
				m.setAddress(address);
			}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		return m; //to show member details object is returned containing all set properties
	}


	

	public Member editProfile(Member m)
	{		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		String updateQuery = "update member set email=? , phone=? , city=? , address=? where memberid=?"; /*update table name column names to be updated and column name on the basis of which data is updated . It should by unique for every row
		                                                                                              column name order can be in any order in update Query but it should be in order according to the table in insert query*/
		int status = 0;
		Member m1 = null;
		String id = "";
		
		try
		{
			ps = con.prepareStatement(updateQuery);
			ps.setString(1 , m.getEmail());
			ps.setString(2 , m.getPhone());
			ps.setString(3 , m.getCity());
			ps.setString(4 , m.getAddress());
			ps.setString(5 , m.getMemberId());
			
			System.out.println(ps);
			
			status = ps.executeUpdate();
			
			if(status > 0)
			{
				String strsql = "select * from member where memberid=?";
				PreparedStatement ps1 = null;
				ResultSet rs = null;
				
				ps1= con.prepareStatement(strsql);
				ps1.setString(1, m.getMemberId());
				rs = ps1.executeQuery();
				rs.next();
				id = rs.getString("memberid");
				String name= rs.getString("name");     
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String planName = rs.getString("planname");
				String address = rs.getString("address");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				
				m1 = new Member(id , password , name , email , phone , gender , city , planName , address , null);
			}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		viewProfile(id);
		
		return m1;
	}
	
	
	
	
	
	public Member viewProfile(String id)
	{
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String strsql = "select * from member where memberid=?";
		Member m1 = null;
		
		try
		{
			ps = con.prepareStatement(strsql);
			ps.setString(1 , id);
			rs = ps.executeQuery();
			rs.next();
			String memid = rs.getString("memberid");
			String name= rs.getString("name");     
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String city = rs.getString("city");
			String planName = rs.getString("planname");
			String address = rs.getString("address");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			
			m1 = new Member(memid , password , name , email , phone , gender , city , planName , address , null);
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		return m1;		
	}


	
	

	public int addMemberFeedBack(MemberFeedbackBean mfb) 
	{
        int status = 0;
		
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		
		try
		{
			String insertQuery = "insert into member_feedback(memberid, feedback, rating, date) values(?,?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1 , mfb.getId());
			ps.setString(2 , mfb.getFeedback());
			ps.setInt(3 , mfb.getRating());
			ps.setDate(4 , mfb.getDate());
			
			System.out.println(ps);
			status = ps.executeUpdate();
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		return status;
	}

}
