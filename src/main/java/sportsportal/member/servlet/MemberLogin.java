package sportsportal.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() 
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
		String id = request.getParameter("txtid");
		String pass = request.getParameter("txtpass");
		String value = request.getParameter("chkcookie");
		
		MemberDao dao = new MemberDao();
		
		Member member = dao.login(id , pass);
		
/*for cookie creation ->*/ String userinfo = id+"#"+pass; //here for the moment hash is a delimiter a we are considering these are two separate values
	
		if(member != null) //if(member != null) , it means entered id and password was correct
		{
			if(value != null)
			{
				Cookie c = new Cookie("userdetails" , userinfo); //inside "" in brackets is name of cookie
				c.setMaxAge(60*60*2); //setting age of cookie -> in seconds
				response.addCookie(c); //this method will send cookie on client machine
			}
			System.out.println(member.getName());
			HttpSession hs = request.getSession(); //it will create new session
			hs.setAttribute("memberSessionKey" , id); //binding id of member in Session
			hs.setAttribute("mem_details" , member); //complete object is passed in session to show details of member
			
			response.sendRedirect("/SportsPortal/member/member_home.jsp");
		}
		
		else
		{
			request.setAttribute("msg" , "Invalid Credentials . Please try again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/userlogin.jsp");
			dispatcher.forward(request, response);
		}
		
		//System.out.println(id +" "+pass);
	}

}
