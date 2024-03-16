package preparedstatementApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbcUtil.JdbcConnection;

public class SelectApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		
				Scanner scanner= new Scanner(System.in);
				
				System.out.println("Enter the SID: ");
				int s_id=scanner.nextInt();
				
				
				
				
						
					
				String sqlSelectQuery = "select s_id,s_name,c_id,assigns from students where s_id=?";


	
	try
	{
		connection=JdbcConnection.getJdbcConnection();
		
		if(connection!=null)
		
			System.out.println(connection);
			pstmt=connection.prepareStatement(sqlSelectQuery);
			if(pstmt!=null)
			{
				pstmt.setInt(1, s_id);
				resultset = pstmt.executeQuery();
			}
			if(resultset!=null)
			{
				
				if(resultset.next())
				{
					System.out.println("SID\tSNAME\tCID\tASSIGNS");
					System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getInt(4));
				}
				else
				{
					System.out.println("Record Not Available for the Given ID " +s_id);
				}
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
