package sportsportal.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.FeedBackBean;
import sportsportal.dao.UserDao;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("txtname");  //fetch the value from control
		String email = request.getParameter("txtemail");
		String rating = request.getParameter("rating");
		String feedback = request.getParameter("txtfeedback");
		String checkBox = request.getParameter("chkagree");
		System.out.println("Name is : "+name);
		System.out.println("Email is : "+email);
		System.out.println("rating is : "+rating); 
		System.out.println("Feedback is : "+feedback);
		System.out.println("User agrees(agrees) or not(null) : "+checkBox);
		
		
		java.util.Date d = new java.util.Date(); //taking system date
		
		long dt = d.getTime(); /*method of Date Class -> converts today's date into long value.
		                         long value is taken because the object created below requires long
		                         type to be passed in the constructor*/
		
		java.sql.Date sqlDate = new java.sql.Date(dt); /*creating object of Date Class of sql package
		                                      and on passing 'dt' , system date is converted to
		                                      sql format*/
		
		System.out.println("SQL Date is : "+sqlDate);
		
		FeedBackBean fb = new FeedBackBean(Integer.parseInt(rating) , name , email , feedback , sqlDate);
		fb.setStatus(checkBox);
		
		UserDao dao = new UserDao();
		
		int status = dao.addFeedBack(fb);
		
		if(status > 0)
		{
			request.setAttribute("information" , "Thank You For Your Feedback");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/feedback.jsp");
			dispatcher.forward(request , response);
		}
	
	}

}
