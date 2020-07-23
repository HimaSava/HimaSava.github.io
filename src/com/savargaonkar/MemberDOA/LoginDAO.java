package com.savargaonkar.MemberDOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/savargaonkar";
    private String jdbcUsername = "root";
    private String jdbcPassword = "HimaSava123";

    private static final String SELECT_USER_BY_ID = "select * from login where id =?";
	
    public LoginDAO() {
    	super();
    }
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    private boolean LoginCheck(int id,String password) {
        
    	// Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            // Step 4: Process the ResultSet object.
            while(rs.next()) {
            	String pass = rs.getString("password");
            	System.out.println("pass");
                if( password.equals(pass)) {
                	return true;
                }
            }
            
                       
            
        } catch (SQLException se) {
        	se.printStackTrace();
        }
        return false;
    }
    public boolean login(int id, String password) {
    	boolean c = LoginCheck(id,password);
    	return c;
    }
    
}
