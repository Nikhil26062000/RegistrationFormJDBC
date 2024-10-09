import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao {

	private String dburl = "jdbc:mysql://localhost:3306/nikdb";
	private String dbUname = "root";
	private String dbPassword =  "mysql@kiit@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	
	
	public void loaddriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl,dbUname,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public String insert(Member member) {
		loaddriver(dbDriver);
		Connection con = getConnection();
		String result = "Data is entered";
		String sql = "insert into Registeration values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
		
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getPhone());
		ps.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result= "Data not entered";
			return result; 
		}
		
		return result;
		
	}

	
}
