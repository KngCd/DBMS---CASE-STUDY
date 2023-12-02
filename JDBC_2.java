package Finals_prof;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_2 {
	
	public void update() throws SQLException, IOException, ClassNotFoundException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nThe next process is update, do you want to proceed?  ");
		String opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
			System.out.println("\n\t\tUpdate the ACTIVE STATUS of MJeep No. 4 to INACTIVE");
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ticketing_system";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		//1. UPDATE
		PreparedStatement ps = conn.prepareStatement("UPDATE mjeep_table SET is_active = 0 WHERE mjeep_no = 4;");
		Statement stmt = conn.createStatement();
		ps.executeUpdate();
		
		
		String bus_no, is_active, driver_id, cond_id;
		
		String sql = "SELECT * from mjeep_table";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\nThe new records are :");
		System.out.println("        " + "Mjeep No." + "     Active Status" + "     Driver ID" + "     Cond ID");
		while (rs.next())
		{
			bus_no = rs.getString(1);
			is_active = rs.getString(2);
			driver_id = rs.getString(3);
			cond_id = rs.getString(4);
			System.out.println("Row: " + rs.getRow()+" -  "+ bus_no + "               " + is_active + "              " + 
			driver_id + "            " + cond_id); 
			System.out.println();
		} //end while
		
		
		//2. UPDATE
		System.out.println("\n\t\tUpdate the MJEEP NO. of the Passenger whose MJEEP NO. is 4");
	
		PreparedStatement ps1 = conn.prepareStatement("UPDATE passenger_table SET mjeep_no = 5 WHERE mjeep_no = 4;");
		Statement stmt1 = conn.createStatement();
		ps1.executeUpdate();
		
		String pass_id, name, spoint, dest, promo, fare, date, bus_no1;
		
		String sql1 = "SELECT * from passenger_table";
		ResultSet rs1 = stmt1.executeQuery(sql1);
		System.out.println("\nThe new records are :");
		System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
				+ "           Promo" + "           Fare" +
				"         Date" + "          MJeep No.");
		while (rs1.next())
		{
			pass_id = rs1.getString(1);
			name = rs1.getString(2);
			spoint = rs1.getString(3);
			dest = rs1.getString(4);
			promo = rs1.getString(5);
			fare = rs1.getString(6);
			date = rs1.getString(7);
			bus_no1 = rs1.getString(8);
			
			System.out.println("Row: " + rs1.getRow()+" -  "+ pass_id + "         " + name + "            " + 
			spoint + "          " + dest + "            " + promo + "      " + fare + "     " + date + "     " + bus_no1); 
			System.out.println();
		} //end while
		conn.close();
		
		}
		else {
			System.out.println("\n\tOkay, Sorry for the inconvenience!");
		}
		
	}
	
	
	public void select() throws SQLException, IOException, ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nThe next process is retrieving information, do you want to proceed?  ");
		String opt = sc.nextLine();
		//1. SELECT ORDER BY
		if (opt.startsWith("y")) {
			System.out.println("\n\t\t\tRetrieve the Passengers based on the FARE (HIGHEST-LOWEST)");
			
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "ticketing_system";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "";
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
		
			Statement stmt = conn.createStatement();
	
			String pass_id, name, spoint, dest, promo, fare, date, bus_no;
			
			String sql = "SELECT *FROM passenger_table ORDER BY fare DESC";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("\nThe records are :");
			System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
			+ "           Promo" + "           Fare" +
			"         Date" + "          MJeep No.");
			while (rs.next())
			{
				pass_id = rs.getString(1);
				name = rs.getString(2);
				spoint = rs.getString(3);
				dest = rs.getString(4);
				promo = rs.getString(5);
				fare = rs.getString(6);
				date = rs.getString(7);
				bus_no = rs.getString(8);
				
				System.out.println("Row: " + rs.getRow()+" -  "+ pass_id + "         " + name + "            " + 
				spoint + "          " + dest + "            " + promo + "      " + fare + "     " + date + "     " + bus_no); 
				System.out.println();
			} //end while
			
			Statement stmt1 = conn.createStatement();
			
			String pass_id1, name1, spoint1, dest1, promo1, fare1, date1, bus_no1;
			
			//2. SELECT ORDER BY
			System.out.println("\n\t\t\tRetrieve the Passengers based on the MJEEP NO.");
			
			String sql1 = "SELECT *FROM passenger_table ORDER BY mjeep_no";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			System.out.println("\nThe records are :");
			System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
			+ "           Promo" + "           Fare" +
			"         Date" + "          MJeep No.");
			while (rs1.next())
			{
				pass_id1 = rs1.getString(1);
				name1 = rs1.getString(2);
				spoint1 = rs1.getString(3);
				dest1 = rs1.getString(4);
				promo1 = rs1.getString(5);
				fare1 = rs1.getString(6);
				date1 = rs1.getString(7);
				bus_no1 = rs1.getString(8);
				
				System.out.println("Row: " + rs1.getRow()+" -  "+ pass_id1 + "         " + name1 + "            " + 
				spoint1 + "          " + dest1 + "            " + promo1 + "      " + fare1 + "     " + date1 + "     " + bus_no1); 
				System.out.println();
			} //end while
			
			Statement stmt2 = conn.createStatement();
			
			String mjeep_no, driver_name;
			
			//1. SELECT JOIN
			System.out.println("\n\t\t\tRetrieve the DRIVER based on their respectives MJEEP");
			
			String sql2 = "SELECT mjeep_no, driver_name FROM mjeep_table m JOIN driver_table d ON m.driver_id = d.driver_id;";
			ResultSet rs2 = stmt2.executeQuery(sql2);
			System.out.println("\nThe records are :");
			System.out.println("      " + "   MJeep No." + "     Driver Name"); 
			while (rs2.next())
			{
				mjeep_no = rs2.getString(1);
				driver_name = rs2.getString(2);
				
				System.out.println("Row: " + rs2.getRow()+" -    "+ mjeep_no + "          " + driver_name);
				System.out.println();
			} //end while
			
			Statement stmt3 = conn.createStatement();
			
			String mjeep_no1, cond_name;
			
			//2. SELECT JOIN
			System.out.println("\n\t\t\tRetrieve the CONDUCTOR based on their respectives MJEEP");
			
			String sql3 = "SELECT mjeep_no, cond_name FROM mjeep_table m JOIN conductor_table d ON m.cond_id = d.cond_id;";
			ResultSet rs3 = stmt3.executeQuery(sql3);
			System.out.println("\nThe records are :");
			System.out.println("      " + "   MJeep No." + "     Conductor Name"); 
			while (rs3.next())
			{
				mjeep_no1 = rs3.getString(1);
				cond_name = rs3.getString(2);
				
				System.out.println("Row: " + rs3.getRow()+" -    "+ mjeep_no1 + "          " + cond_name);
				System.out.println();
			} //end while
			
			
			conn.close();
			}
			
		else {
			System.out.println("\n\tOkay, Sorry for the inconvenience!");
		}
		
	}
	
	public void another_select() throws SQLException, IOException, ClassNotFoundException{
		    //1. SELECT WHERE
			System.out.println("\n\t\t\tRetrieve the MJEEP who is/are already INACTIVE");
			
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "ticketing_system";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "";
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
		
			Statement stmt = conn.createStatement();
			
			String bus_no, is_active, driver_id, cond_id;
			
			String sql = "SELECT * from mjeep_table WHERE is_active = 0";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("\nThe records are :");
			System.out.println("        " + "MJeep No." + "     Active Status" + "     Driver ID" + "     Cond ID");
			while (rs.next())
			{
				bus_no = rs.getString(1);
				is_active = rs.getString(2);
				driver_id = rs.getString(3);
				cond_id = rs.getString(4);
				System.out.println("Row: " + rs.getRow()+" -  "+ bus_no + "               " + is_active + "              " + 
				driver_id + "            " + cond_id); 
				System.out.println();
			} //end while
			
			//2. SELECT WHERE
			System.out.println("\n\n\t\t\tRetrieve the FARE of the passengers LESS THAN OR EQUAL TO 50 SORT BY LOWEST TO HIGHEST");
			
			Statement stmt1 = conn.createStatement();
			
			String pass_id, name, spoint, dest, promo, fare, date, bus_no1;
			
			String sql1 = "SELECT * FROM passenger_table WHERE fare <= 50 ORDER BY fare ASC;";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			System.out.println("\nThe records are :");
			System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
			+ "           Promo" + "           Fare" +
			"         Date" + "          MJeep No.");
			while (rs1.next())
			{
				pass_id = rs1.getString(1);
				name = rs1.getString(2);
				spoint = rs1.getString(3);
				dest = rs1.getString(4);
				promo = rs1.getString(5);
				fare = rs1.getString(6);
				date = rs1.getString(7);
				bus_no1 = rs1.getString(8);
				
				System.out.println("Row: " + rs1.getRow()+" -  "+ pass_id + "         " + name + "            " + 
				spoint + "          " + dest + "            " + promo + "      " + fare + "     " + date + "     " + bus_no1); 
				System.out.println();
			} //end while
			
			//3. SELECT WHERE
			System.out.println("\n\n\t\t\tRetrieve the PASSENGERS who is/are STARTING POINT is SM LIPA");
			
			Statement stmt2 = conn.createStatement();
			
			String pass_id1, name1, spoint1, dest1, promo1, fare1, date1, bus_no2;
			
			String sql2 = "SELECT * FROM passenger_table WHERE spoint LIKE 'SM Lipa';";
			ResultSet rs2 = stmt2.executeQuery(sql2);
			System.out.println("\nThe records are :");
			System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
			+ "           Promo" + "           Fare" +
			"         Date" + "          MJeep No.");
			while (rs2.next())
			{
				pass_id1 = rs2.getString(1);
				name1 = rs2.getString(2);
				spoint1 = rs2.getString(3);
				dest1 = rs2.getString(4);
				promo1 = rs2.getString(5);
				fare1 = rs2.getString(6);
				date1 = rs2.getString(7);
				bus_no2 = rs2.getString(8);
				
				System.out.println("Row: " + rs2.getRow()+" -  "+ pass_id1 + "         " + name1 + "            " + 
				spoint1 + "          " + dest1 + "            " + promo1 + "      " + fare1 + "     " + date1 + "     " + bus_no2); 
				System.out.println();
			} //end while
			
			Statement stmt4 = conn.createStatement();
			
			String pass_id3, name3, driver_name;
			
			//1. SELECT JOIN JOIN
			System.out.println("\n\t\t\tRetrieve the DRIVER of the Passengers");
			
			String sql4 = "SELECT pass_id, name, driver_name FROM passenger_table p JOIN mjeep_table m ON p.mjeep_no = m.mjeep_no JOIN driver_table d ON m.driver_id = d.driver_id;";
			ResultSet rs4 = stmt4.executeQuery(sql4);
			System.out.println("\nThe records are :");
			System.out.println("      " + "      Pass ID" + "         Name" +  "        Driver Name"); 
			while (rs4.next())
			{
				pass_id3 = rs4.getString(1);
				name3 = rs4.getString(2);
				driver_name = rs4.getString(3);
				
				System.out.println("Row: " + rs4.getRow()+" -    "+ pass_id3 + "       " + name3 + "        " + driver_name);
				System.out.println();
			} //end while
			
			Statement stmt3 = conn.createStatement();
			
			String pass_id2, name2, cond_name;
			
			//2. SELECT JOIN JOIN
			System.out.println("\n\t\t\tRetrieve the CONDUCTOR of the Passengers");
			
			String sql3 = "SELECT pass_id, name, cond_name FROM passenger_table p JOIN mjeep_table m ON p.mjeep_no = m.mjeep_no JOIN conductor_table c ON m.cond_id = c.cond_id;";
			ResultSet rs3 = stmt3.executeQuery(sql3);
			System.out.println("\nThe records are :");
			System.out.println("      " + "      Pass ID" + "         Name" +  "        Conductor Name"); 
			while (rs3.next())
			{
				pass_id2 = rs3.getString(1);
				name2 = rs3.getString(2);
				cond_name = rs3.getString(3);
				
				System.out.println("Row: " + rs3.getRow()+" -    "+ pass_id2 + "       " + name2 + "        " + cond_name);
				System.out.println();
			} //end while
			
			
			conn.close();
}
	
	
	public void del() throws SQLException, IOException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nThe next process is delete, do you want to proceed?  ");
		String opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
			System.out.println("\n\t\tDelete the DRIVER whose Driver ID is 9 (Because we don't have an additional unit so we're just goind to add them if there's new units of MJeep)");
			
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ticketing_system";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		//1. DELETE
		PreparedStatement ps = conn.prepareStatement("DELETE FROM driver_table WHERE driver_id = 9;");
		Statement stmt = conn.createStatement();
		ps.executeUpdate();
		
		
		String driver_id, driver_name;
		
		String sql = "SELECT * from driver_table";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\nThe new records are :");
		System.out.println("      " + "   Driver ID" + "     Driver Name");
		while (rs.next())
		{
			driver_id = rs.getString(1);
			driver_name = rs.getString(2);
			System.out.println("Row: " + rs.getRow()+" -    "+ driver_id + "             " + driver_name);
			System.out.println();
		} //end while
		
		//2. DELETE
		System.out.println("\n\t\tDelete the CONDUCTOR whose Cond ID is 9 (Because we don't have an additional unit so we're just going to add them if there's new units of MJeep)");
		PreparedStatement ps1 = conn.prepareStatement("DELETE FROM conductor_table WHERE cond_id = 9;");
		Statement stmt1 = conn.createStatement();
		ps1.executeUpdate();
		
		String cond_id, cond_name;
		
		String sql1 = "SELECT * from conductor_table";
		ResultSet rs1 = stmt1.executeQuery(sql1);
		System.out.println("\nThe new records are :");
		System.out.println("      " + "   Cond ID" + "     Cond Name");
		while (rs1.next())
		{
		cond_id = rs1.getString(1);
		cond_name = rs1.getString(2); 
		System.out.println("Row: " + rs1.getRow()+" -    "+ cond_id + "             " + cond_name);
		System.out.println();
		} //end while
		
			
		conn.close();
		}
		else {
			System.out.println("\n\tOkay, Sorry for the inconvenience!");
		}
		
		
		
	}

}
