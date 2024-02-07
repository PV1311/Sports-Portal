package sportsportal.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.FeedBackBean;
import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;
import sportsportal.dao.UserDao;

/**
 * Servlet implementation class MemberRegistration
 */
@WebServlet("/MemberRegistration")
public class MemberRegistration extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegistration()
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
		String id = request.getParameter("txtid");  //fetch the value from control
		String pass = request.getParameter("txtpass");
		String nm = request.getParameter("txtname");
		String gn = request.getParameter("inlineRadioOptions");
		String em = request.getParameter("txtmail");
		String ph = request.getParameter("txtphone");
		String ct = request.getParameter("cmbcity");
		String pn = request.getParameter("txtplan");
		String add = request.getParameter("txtaddress");
		System.out.println("\nid is : "+id);
		System.out.println("Password is : "+pass);
		System.out.println("Name is : "+nm);
		System.out.println("Gender is : "+gn);
		System.out.println("Email is : "+em);
		System.out.println("Phone Number is : "+ph);
		System.out.println("City is : "+ct);
		System.out.println("Plan Name is : "+pn);
		System.out.println("Address is : "+add);
		
        java.util.Date d = new java.util.Date();
		long dt = d.getTime();
		java.sql.Date sqlDate = new java.sql.Date(dt);
		System.out.println("SQL Date is : "+sqlDate);
		System.out.println();
		
		Member mb = new Member(id , pass , nm , em , ph , gn , ct , pn , add , sqlDate);
		
		MemberDao dao = new MemberDao();
		
		int status = dao.registration(mb);
		
		if(status > 0)
		{
			request.setAttribute("msg" , "Thank You For Registering , Please Log in to continue");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/userlogin.jsp");
			dispatcher.forward(request , response);
			response.sendRedirect("/SportsPortal/member/userlogin.jsp");
		}
		
	}

}
