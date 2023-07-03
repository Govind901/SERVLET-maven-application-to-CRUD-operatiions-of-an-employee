package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.TablesPojo;

public class ContractData {
	String delContract="DELETE * FROM contract WHERE id=?";
	String searchid="SELECT * FROM contract WHERE id=?";
	String addContract ="INSERT INTO contract VALUES(?,?,?,?)";

	Connection conn=null;
	public TablesPojo contractDisplay(int id) throws SQLException, ClassNotFoundException {
		TablesPojo tp=new TablesPojo();
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement pstmt=conn.prepareStatement(searchid);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			tp.setId(rs.getInt("id"));
			tp.setEp(rs.getString("ep"));
			tp.setSalary(rs.getInt("salary"));
			tp.setDepartment(rs.getString("department"));
		}
		pstmt.close();
		return tp;
	}
	public String deleteContract(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement pstmt=conn.prepareStatement(searchid);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		pstmt.close();
		return "deleted";
	}
	public TablesPojo addContract(TablesPojo t) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement pstmt=conn.prepareStatement(addContract);
		pstmt.setInt(1, t.getId());
		pstmt.setString(2, t.getEp());
		pstmt.setInt(3, t.getSalary());
		pstmt.setString(4, t.getDepartment());
		pstmt.execute();
		pstmt.close();
		return t;
	}

}
