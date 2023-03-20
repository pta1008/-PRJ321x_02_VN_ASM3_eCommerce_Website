package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class Main {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String args[]) {
		try {
			Connection conn = new DBContext().getConnection();
			ListProductDAO accDAO = new ListProductDAO();
			accDAO.login(conn, "duydt@fpt.com.vn", "12356");
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
