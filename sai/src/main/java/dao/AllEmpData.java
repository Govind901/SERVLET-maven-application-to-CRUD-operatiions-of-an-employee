package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.AllEmployyPojo;

public class AllEmpData {
	String jsonquery = "SELECT * FROM alldetails";
	String searchid="SELECT * FROM alldetails WHERE id=? ";
	Connection conn = null;
		
//		try {
			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	public AllEmployyPojo getEmployee(int id) throws SQLException, ClassNotFoundException {
		AllEmployyPojo Ae=new AllEmployyPojo();
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement pstmt=conn.prepareStatement(searchid);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			Ae.setId(rs.getInt("id"));
			Ae.setEp(rs.getString("ep"));
			Ae.setSalary(rs.getInt("salary"));
			Ae.setDepartment(rs.getString("department"));
			Ae.setType(rs.getString("type"));
		}
		pstmt.close();
		return Ae;
	}
	public List<Object> getall() throws ClassNotFoundException, SQLException{
		List<Object> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				PreparedStatement pstmt = conn.prepareStatement(jsonquery);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					AllEmployyPojo e = new AllEmployyPojo(rs.getInt("id"),rs.getInt("salary"),rs.getString("ep"),rs.getString("department"),rs.getString("type"));
					list.add(e);
				}
				pstmt.close();
		return list;
	}

}
