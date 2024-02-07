package sportsportal.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.MemberFeedbackBean;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberFeedback
 */
@WebServlet("/MemberFeedback")
public class MemberFeedback extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFeedback()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs = request.getSession(false);
		String id = (String)hs.getAttribute("memberSessionKey");
		String rat = request.getParameter("rating");
		String feed = request.getParameter("txtfeedback");
		
		java.util.Date d = new java.util.Date();
		long dt = d.getTime();
		java.sql.Date sqlDate = new java.sql.Date(dt);
		
		MemberFeedbackBean mfb = new MemberFeedbackBean(id , Integer.parseInt(rat) , feed , sqlDate);
		
		MemberDao dao = new MemberDao();
		int status = dao.addMemberFeedBack(mfb);
		
		if(status > 0)
		{
			request.setAttribute("information" , "Thank You For Your Feedback");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/member_feedback.jsp");
			dispatcher.forward(request , response);
		}
	}

}
