package preparedstatementApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import jdbcUtil.JdbcConnection;

public class InsertApp {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		
				Scanner scanner= new Scanner(System.in);
				
				System.out.println("Enter the SID: ");
				int s_id=scanner.nextInt();
				
				
				System.out.println("Enter the SNAME: ");
				String s_name=scanner.next();
				
				System.out.println("Enter the COURSEID: ");
				int c_id=scanner.nextInt();
				
				System.out.println("Enter the ASSIGNID: ");
				int a_id=scanner.nextInt();
				
						
					
				String sqlInsertQuery = "INSERT INTO students (s_id,s_name,c_id,assigns) VALUES (?, ?, ?, ?)";


	
	try
	{
		connection=JdbcConnection.getJdbcConnection();
		
		if(connection!=null)
		
			System.out.println(connection);
			pstmt=connection.prepareStatement(sqlInsertQuery);
			if(pstmt!=null)
			{
				pstmt.setInt(1, s_id);
	            pstmt.setString(2, s_name);
	            pstmt.setInt(3, c_id);
	            pstmt.setInt(4, a_id);
	            
	            int rowAffected=pstmt.executeUpdate();
	            System.out.println("No od Rows Affected is:   " +rowAffected);

			}
		
	}
	
	
				catch(SQLException se)
				{
					se.printStackTrace();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				finally
				{
					JdbcConnection.closeConnection(null, pstmt, connection);
			
					if(scanner!=null)
					{
						scanner.close();
					}
					
				}
				
				
			

	}

}
