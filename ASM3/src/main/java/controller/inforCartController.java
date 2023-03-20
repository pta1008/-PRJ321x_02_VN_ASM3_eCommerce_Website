package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;
import dao.ListProductDAO;
import model.Cart;

/**
 * Servlet implementation class inforCartController
 */
@WebServlet("/inforcart")
public class inforCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inforCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cart-list");
		
		
		
		
		try {
			Connection conn = new DBContext().getConnection();
			ListProductDAO cartDAO = new ListProductDAO();
			List<Cart> cartProduct  = cartDAO.getCartProducts(conn, cartlist);
			float total = cartDAO.totalPrice(conn, cartlist);
			request.setAttribute("cartlist", cartProduct);
			request.setAttribute("total", total);
			request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
