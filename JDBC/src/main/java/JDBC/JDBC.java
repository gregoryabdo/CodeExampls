package JDBC;

import java.sql.*;

public class JDBC {
	/*
	 * Sample of how to use postgresql from java using a ssl connection.
	 * Examples: http://www.tutorialspoint.com/postgresql/postgresql_java.htm
	 * Driver Download: http://jdbc.postgresql.org/download.html
	 */
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			// Connect to database. 
			 /*String url = "jdbc:postgresql://dev-box:5432/postgres?"
					+ "ssl=true&"
					+ "sslfactory=org.postgresql.ssl.NonValidatingFactory"; //*/
			
			String url = "jdbc:postgresql://dev-box:5432/postgres?ssl=true";
			 //url = "jdbc:postgresql://dev-box:5432/admin?user=postgres&password=postgres";
			String user = "postgres";
			String password = "postgres";

			Class dbDriver = Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			//con = DriverManager.getConnection(url);
			System.out.println("Opened database connection successfully");
			
			con.setAutoCommit(false);
			
			// Creat a table in the database.
			try{
				Statement stmt = con.createStatement();
				String sql = "CREATE TABLE COMPANY "
						+ "(ID INT PRIMARY KEY     NOT NULL,"
						+ " NAME           TEXT    NOT NULL, "
						+ " AGE            INT     NOT NULL, "
						+ " ADDRESS        CHAR(50), " 
						+ " SALARY         REAL)";
				stmt.executeUpdate(sql);
				System.out.println("Created table successfully");
			} catch (Exception ex) {
				System.out.println("Error Creating Table");
				ex.printStackTrace();
			}
			finally{
				con.commit();
			}

			// Insert into table in the database.
			Statement stmt = con.createStatement();
			String sql = "";
				
			try{
				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
				stmt.executeUpdate(sql);
	
				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
				stmt.executeUpdate(sql);
	
				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
				stmt.executeUpdate(sql);
	
				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
	
				stmt.executeUpdate(sql);
				stmt.close();
			System.out.println("Commited data successfully");
			} catch (Exception ex) {
				System.out.println("Error Inserting");
				ex.printStackTrace();
			}
			finally{
				con.commit();
			}

			// Read from the table in the database.
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();
			}
			rs.close();
			System.out.println("Read data successfully");
			
		} catch (Exception ex) {
			System.out.println("Problem Reading");
			ex.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Closed database connection successfully");
				} catch (Exception e) {
				}
			}
		}
	}
}