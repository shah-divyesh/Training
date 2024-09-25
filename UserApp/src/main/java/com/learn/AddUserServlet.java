package com.learn;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private Connection connection;
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	String connectionURL = config.getServletContext().getInitParameter("connectionURL");
    	String userName = config.getServletContext().getInitParameter("userName");
    	String pwd = config.getServletContext().getInitParameter("password");
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, userName, pwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String city = request.getParameter("city");
		try{
			
			PreparedStatement statement = connection.prepareStatement("insert into person values(?,?,?,?,?)");
			
			statement.setInt(1, id);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, emailId);
			statement.setString(5, city);
			
			int execute = statement.executeUpdate();
			
			if(execute > 0) {
				response.getWriter().append(firstName + " person is added into database");
			}else {
				response.getWriter().append("Error in adding person into database");
			}
			response.getWriter().close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
