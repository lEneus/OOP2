package GUI;


import java.sql.*;

public class DBsignup {

	public DBsignup() throws SQLException{
		Connection conn = null;
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("Driver loaded");
         	conn =	DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "djalel2020");
				 System.out.println("Connection is successful");
		 } catch (ClassNotFoundException e) {
		 System.out.println("Impossible to load the driver");
		 e.printStackTrace();
		 } finally {
		closeConnection(conn);
	 }
	
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
	public void addUser(String username, String password) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "djalel2020");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

            stmt.setString(1, username);
            stmt.setString(2, password);      
           

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("User insertion failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}