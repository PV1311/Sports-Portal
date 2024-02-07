package sportsportal.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.EventBean;
import sportsportal.dao.AdminDao;

/**
 * Servlet implementation class Event
 */
@WebServlet("/Event")
public class Event extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event() 
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
		String eventName = request.getParameter("eventname");  //fetch the value from control
		String venue = request.getParameter("venue");
		String date = request.getParameter("date");
		String organizerName = request.getParameter("txtname");
		String description = request.getParameter("txtdescription");
		System.out.println("Event Name is : "+eventName+" and venue is : "+venue);
		System.out.println("Date is : "+date+" and Organizer's Name is : "+organizerName);
		System.out.println("Description is : "+description);
		
		
		//object creation of bean class
		EventBean event = new EventBean(eventName , venue , description , organizerName , date);
		AdminDao dao = new AdminDao();
		
		int status = dao.addEvent(event);
		
		if(status > 0)
		{
			request.setAttribute("message" , "Event has been added");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/event.jsp");
		    dispatcher.forward(request , response);
		}
	}

}
