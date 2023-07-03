package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import pojo.TablesPojo;

/**
 * Servlet implementation class Contract
 */
public class Contract extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dao.ContractData ContractData=new dao.ContractData();
	Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contract() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		if(id1>0) {
		try {
			ContractData.contractDisplay(id1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			out.print("invalid id");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		if(id1>0) {
		try {
			ContractData.deleteContract(id1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			out.print("invalid id");
		}
	}
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException, ClassNotFoundException, SQLException {
		TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
		PrintWriter out=response.getWriter();
		TablesPojo tp=ContractData.addContract(json);
		String con = gson.toJson(tp);
		response.setContentType("application/json");
		out.print("added");
		}
//	ContractEmployee ce = dao.adddata(jsonToObject);
//	String contractemployeestring = gson.toJson(ce);
//	PrintWriter out = response.getWriter();
//	response.setContentType("application/json");
//	response.setCharacterEncoding("UTF-8");
//	out.print(contractemployeestring);
//	out.flush();

}
