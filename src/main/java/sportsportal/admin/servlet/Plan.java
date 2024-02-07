package sportsportal.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.Plan_Bean;
import sportsportal.dao.AdminDao;

/**
 * Servlet implementation class Plan
 */
@WebServlet("/Plan")
public class Plan extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plan() 
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
		String planName = request.getParameter("txtplan");  //fetch the value from control
		String charge = request.getParameter("txtcharge");
		String services= request.getParameter("txtservices");
		System.out.println("Plan Name is : "+planName+" and charge is : "+charge);
		System.out.println("Services are : "+services);
		
		
		//object creation of bean class
		Plan_Bean plan = new Plan_Bean(planName , services , Integer.parseInt(charge));
		AdminDao dao = new AdminDao();
		
		int status = dao.addPlan(plan);
		
		if(status > 0)
		{
			request.setAttribute("plan" , "Your Plan has been added");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/plan.jsp");
			dispatcher.forward(request , response);
		}
	}

}
