package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;
import dao.ListProductDAO;
import model.Cart;
import model.Category;
import model.Product;

/**
 * Servlet implementation class homeController
 */
//@WebServlet("")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Connection conn = new DBContext().getConnection();
			ListProductDAO productDAO = new ListProductDAO();
			List<Product> listOfProduct = productDAO.getAllProduct(conn);
			List<Category> listOfCategory = productDAO.getAllCategory(conn);
			
			
			request.setAttribute("products", listOfProduct);
			request.setAttribute("categories", listOfCategory);
			
			
			HttpSession session = request.getSession();
			
			ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cart-list");
			List<Cart> cartProduct  = productDAO.getCartProducts(conn, cartlist);
			request.setAttribute("cartlist", cartProduct);
		
			request.setAttribute("message", "Welcome to my website!");
			request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
			
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
