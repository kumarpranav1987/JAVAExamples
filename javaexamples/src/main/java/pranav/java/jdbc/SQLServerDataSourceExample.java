package pranav.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SQLServerDataSourceExample {
	public static void main(String[] args) throws SQLException {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setURL("jdbc:sqlserver://localhost:1433;DatabaseName=Test");
		ds.setUser("sa");
		ds.setPassword("***********");
		Connection c = ds.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM [Test].[dbo].[User]");
		while(rs.next()) {
			System.out.println(rs.getString("Name"));
		}
	}
}
