package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import context.DBContext;
import dao.ListProductDAO;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("jsp/home.jsp").forward(request,
					response);
		} else if (action.equals("login")) {
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("error", "");
			
			request.getRequestDispatcher("jsp/login.jsp").forward(request,
					response);
		} else if (action.equals("register")) {
			request.getRequestDispatcher("jsp/register.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String usermail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		try {
			Connection conn = new DBContext().getConnection();
			ListProductDAO loginDAO = new ListProductDAO();
			Account account = loginDAO.login(conn, usermail, password);
			if(account == null) {
				conn.close();
				request.setAttribute("error", "Username or password is incorrect");
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			} else {
				conn.close();
				
				HttpSession session = request.getSession();
				session.setAttribute("acc", account);
				response.sendRedirect("home");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
