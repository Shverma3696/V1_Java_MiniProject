package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Statement stmt;
	private ResultSet rs;
	private Connection conn;
	private boolean loggedIn;

	public Database(String username, String password) throws ClassNotFoundException {
		this.stmt = null;
		this.rs = null;
		this.loggedIn = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydailydiary_db", username, password);
			System.out.println("Connected successfully");
			this.loggedIn = true;
		} 
		catch (SQLException e) {
//          e.printStackTrace();
			System.out.println("Incorrect username and/or password");
		}
	}
	
//	public void insertIntoUserInfo() throws SQLException {
//		this.stmt = this.conn.createStatement();
//		this.rs = this.stmt.executeQuery("SELECT * FROM students;");
//		while (rs.next()) {
//			System.out.println(rs.getString("student_id") + ":" + rs.getString("first_name"));
//		}
//	}
//	
//	public void selectAllStudents() throws SQLException {
//		this.stmt = this.conn.createStatement();
//		this.rs = this.stmt.executeQuery("SELECT * FROM students;");
//		while (rs.next()) {
//			System.out.println(rs.getString("student_id") + ":" + rs.getString("first_name"));
//		}
//	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

}
