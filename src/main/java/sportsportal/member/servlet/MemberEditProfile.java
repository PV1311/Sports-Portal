package sportsportal.member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberEditProfile
 */
@WebServlet("/MemberEditProfile")
public class MemberEditProfile extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEditProfile() 
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
		String emailId = request.getParameter("email");
		String phoneNumber = request.getParameter("phone");
		String cityName = request.getParameter("city");
		String address = request.getParameter("address");
		
		HttpSession hs = request.getSession(false);
		String id = (String)hs.getAttribute("memberSessionKey"); //getting id of current session member
		
		Member m = new Member(id , emailId , phoneNumber , cityName , address);
		
		MemberDao dao = new MemberDao();
		Member member = dao.editProfile(m);
		
		if(member != null)
		{
			hs.setAttribute("mem_details" , member);
			response.sendRedirect("/SportsPortal/member/member_editprofile.jsp");
		}
	}

}
