package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;
import model.Cart;

/**
 * Servlet implementation class addToCardController
 */
public class addToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
//		try {
//			Connection conn = new DBContext().getConnection();
//			ArrayList<Cart> cartList = new ArrayList<Cart>();
//			int id = Integer.parseInt(request.getParameter("id"));
//			System.out.println(id + " ");
//			Cart nCart = new Cart();
//			nCart.setId(id);
//			nCart.setNumber(1);
//			
//			HttpSession session = request.getSession();
//			ArrayList<Cart> curCartList = (ArrayList<Cart>) session.getAttribute("cart-list");
//			
//			if(curCartList == null) {
//				cartList.add(nCart);
//				session.setAttribute("cart-list", cartList);
//				response.sendRedirect("home");
//			} else {
//				boolean exist = false;
//				for(Cart c:curCartList) {
//					if(c.getId() == id) {
//						exist = true;
//						int number = c.getNumber() + 1W;
//						c.setNumber(number);
//						session.setAttribute("cart-list", curCartList);
//						response.sendRedirect("home");
//					}
//				}
//				if(exist == false) {
//					curCartList.add(nCart);
//					session.setAttribute("cart-list", curCartList);
//					response.sendRedirect("home");
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Connection conn = new DBContext().getConnection();
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cartList = new ArrayList<Cart>();
			Cart nCart = new Cart();
			nCart.setId(id);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> curCartList = (ArrayList<Cart>) session.getAttribute("cart-list");
			System.out.println(nCart.getId() + " - id cart ");
			boolean exist = false;
			if(curCartList == null) {
				System.out.println(" Cur null ");
				cartList.add(nCart);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("home");
			} else {
				System.out.println(" Cur not null ");
				for(Cart c:curCartList) {
					if(c.getId() == id) {
						exist = true;
						int number = c.getNumber() + 1;
						c.setNumber(number);
						session.setAttribute("cart-list", curCartList);
						response.sendRedirect("home");
					}
			}
			if(exist == false) {
				curCartList.add(nCart);
				session.setAttribute("cart-list", curCartList);
				response.sendRedirect("home");
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(id + " - id cart ");
		//response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
