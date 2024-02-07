package sportsportal.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.dao.AdminDao;

/**
 * Servlet implementation class DeleteFeedBack
 */
@WebServlet("/DeleteFeedBack")
public class DeleteFeedBack extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFeedBack()
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
		String[] idArray = request.getParameterValues("chkdelete"); //getting all values at once , so that all selected feedbacks are deleted at once
		
		for(String id : idArray)
		{
			System.out.println("Feedback id is : "+id);
		}
		
		AdminDao dao = new AdminDao();
		int status = dao.deleteFeedback(idArray);
		
		if(status > 0)
		{
			response.sendRedirect("/SportsPortal/admin/view_feedback.jsp");
		}
	}

}
