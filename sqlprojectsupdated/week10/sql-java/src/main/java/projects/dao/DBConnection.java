package projects.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	import projects.exception.DBException;

	public class DBConnection {
		
		private static final String SCHEMA = "projects";
		private static final String USER = "root";
		private static final String PASSWORD = "Greg0814";
		private static final String HOST = "localhost";
		private static final int PORT = 3306;
		
		
		
		public static Connection getConnection() {
			String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false",
					HOST, PORT, SCHEMA, USER, PASSWORD);
			
			
			System.out.println("Connecting with url = " + url);
			
			try {
				Connection conn = DriverManager.getConnection(url);
				System.out.println("Connection Successful!");
				return conn;
			} catch (SQLException e) {
				System.out.println("Error getting connection.");
				throw new DBException(e);
			}
			
			
			
		}
		
		
		

		}
		 
		
