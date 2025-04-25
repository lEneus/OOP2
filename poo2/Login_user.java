package prr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login_user {
	  public Login_user() throws ClassNotFoundException
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded");

	     	conn =	DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "root");
			 System.out.println("Connection is successful");

			
		}catch(SQLException e){ System.out.println("Impossible to load the driver");}
	finally {closeConnection(conn);}



	}
	  private  void closeConnection(Connection conn) {
			 if (conn != null) {
			  try {
			 conn.close();
			System.out.println("Disconnected from the database.");
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 }

	}
	  public boolean CheckUser(String name, String password,String idkey) {
		  boolean a=false;
		    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "root");
		         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE name = ? AND password = ? and idkey = ?")) {
		        stmt.setString(1, name);
		        stmt.setString(2, password);
	            stmt.setString(3, idkey);
		        ResultSet result = stmt.executeQuery();

		        if (result.next()) {
		     	JOptionPane.showMessageDialog(null, "Comfirmed LogIn");
		     	a=true;
		        } else {
		        	JOptionPane.showMessageDialog(null, "LogIn failed the user doesn't exist or Incorrect password");
		              
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return a;
		}
	}
