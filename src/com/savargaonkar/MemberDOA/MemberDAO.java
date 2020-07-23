package com.savargaonkar.MemberDOA;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.savargaonkar.MemberModel.*;

public class MemberDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/savargaonkar";
    private String jdbcUsername = "root";
    private String jdbcPassword = "HimaSava123";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO family" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from family where id =?";
    
    private static final String SELECT_USER_BY_FATHER_ID = "select * from family where father_id =?";
    private static final String SELECT_USER_BY_MOTHER_ID = "select * from family where mother_id =?";
    private static final String SELECT_USER = "select * from family where ? =?";
       
    private static final String SELECT_ALL_USERS = "select * from family";
    private static final String DELETE_USERS_SQL = "delete from family where id = ?;";
    private static final String UPDATE_USERS_SQL = "update family set name = ?,email= ?, country =? where id = ?;";

    public MemberDAO(){
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
    
    public Member selectUser(int id) {
        Member user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ret_id = rs.getInt("id");
            	int spouse_id = rs.getInt("spouse_id");
            	String name = rs.getString("name");
                String gender = rs.getString("gender");
                int father_id = rs.getInt("father_id");
            	int mother_id = rs.getInt("mother_id");
                user = new Member(ret_id,spouse_id,father_id,mother_id, name, gender);
            }
        } catch (SQLException se) {
        	se.printStackTrace();
        }
        return user;
    }
    
    public List<Member> selectMother(int id) {
        List<Member> user = new ArrayList< Member >();
        Member temp = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_MOTHER_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            
            
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	
                int ret_id = rs.getInt("id");
                int spouse_id = rs.getInt("spouse_id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int father_id = rs.getInt("father_id");
            	int mother_id = rs.getInt("mother_id");
            	
                temp = new Member(ret_id,spouse_id,father_id,mother_id, name, gender);
                
                user.add(temp);
            }
        } catch (SQLException se) {
        	se.printStackTrace();
        }
        return user;
    }
    
    public List<Member> selectFather(int id) {
        List<Member> user = new ArrayList< Member >();
        Member temp = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_FATHER_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            
          
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	
                int ret_id = rs.getInt("id");
                int spouse_id = rs.getInt("spouse_id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int father_id = rs.getInt("father_id");
            	int mother_id = rs.getInt("mother_id");
            	
                temp = new Member(ret_id,spouse_id,father_id,mother_id, name, gender);
                
                user.add(temp);
            }
        } catch (SQLException se) {
        	se.printStackTrace();
        }
        return user;
    }

	public MemberFamily GetUser (int id) {
		MemberFamily fam = new MemberFamily();
		Member h = new Member();
		h = selectUser(id);
		fam.head = h;
		fam.spouse = selectUser(h.spouse_id);
		fam.father = selectUser(h.father_id);
		fam.mother = selectUser(h.mother_id);
		if(fam.head.gender.equals("M")) {
			fam.children = selectFather(id);
		}
		else {
			fam.children = selectMother(id);
		}
		fam.number_children = fam.children.size();
		return fam;
	}
}
