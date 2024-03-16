package preparedstatementApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Connection connection=DriverManager.
				getConnection("jdbc:mysql://localhost:3306/ineuron","root","root");
		
		Statement statement=connection.createStatement();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the UserName :: ");
		String uname=scanner.next();
		System.out.println("Enter the Password :: ");
		String password=scanner.next();
		
		uname="'"+uname+"'";
		password="'"+password+"'";
		String sqlSelectQuery = "select count(*) from students where 'user'="+uname+" and 'password'="+password+"";
		ResultSet resultset=statement.executeQuery(sqlSelectQuery);
		int count=0;
		if(resultset.next())
		{
			count=resultset.getInt(1);
		}
		if(count==1)
		{
			System.out.println("Valid Credentials");
		}
		else
		{
			System.out.println("Invalid Credetials");
		}
		
		scanner.close();
		connection.close();
	}

}
