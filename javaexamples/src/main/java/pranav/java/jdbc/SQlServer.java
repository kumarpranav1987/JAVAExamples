package pranav.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQlServer {
	public static void main(String[] args) throws ClassNotFoundException {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Test";
		 try {
			Connection c = DriverManager.getConnection(url, "sa", "*********");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM [Test].[dbo].[User]");
			while(rs.next()) {
				System.out.println(rs.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
