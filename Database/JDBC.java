package Finals_prof;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {
	
	public static void main(String args[])throws Exception{
		//Lourenz
		driver();
		conductor();
		bus();
		passenger();
		
		JDBC_2 j = new JDBC_2();
		j.update(); //Jerome 2 Update - (1) Update Active status of mjeep x (2) Update mjeep no of passenger x (in this scenario, the passenger
																	// change mjeep in the middle of the ride because the mjeep he/she
																	// currently riding broke down so he/she needs to trnasfer to another mjeep
		//Cedrick														// so we're updating his/her mjeep no
		j.select();
		j.another_select();
		j.del(); //Jerome 2 Delete - (1) Delete the record of Driver whose Driver ID is 9 (2) Delete the record of Conductor whose Cond ID is 9 
								//(because we only have 8 units of mjeep and we will just insert them in the future when we have
								// new units)
		
	}
	
	static void driver() throws SQLException, IOException, ClassNotFoundException {
		String opt;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDo you want to insert data to the Driver's Table?  ");
		opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
		
		System.out.println("\t\t\tDriver's Table");
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ticketing_system";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("Connected to the database");
		
		String driver_id, driver_name;
		PreparedStatement ps = conn.prepareStatement("INSERT INTO driver_table VALUES(?,?)");
		Statement stmt = conn.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			
			System.out.print("\n\tEnter Driver_id: ");
			driver_id = br.readLine();
			System.out.print("\tEnter Driver name: ");
			driver_name = br.readLine();
			
			ps.setString(1,driver_id);
			ps.setString(2,driver_name);
			
			int i = ps.executeUpdate();
			System.out.println(i+" record added");
			System.out.print("\nDo you want to continue: ");
			String s = br.readLine();
			
		if(s.startsWith("n")){
			break;
		}
		}
		while(true);
	String sql = "SELECT * from driver_table";
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("\nThe records are :");
	System.out.println("      " + "   Driver ID" + "     Driver Name");
	while (rs.next())
	{
		driver_id = rs.getString(1);
		driver_name = rs.getString(2);
		System.out.println("Row: " + rs.getRow()+" -    "+ driver_id + "             " + driver_name);
		System.out.println();
	} //end while
	conn.close();
		
	}
		else {
			
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "ticketing_system";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "";
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			String driver_id, driver_name;
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * from driver_table";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("\nThe records are :");
			System.out.println("      " + "   Driver ID" + "     Driver Name");
			while (rs.next())
			{
				driver_id = rs.getString(1);
				driver_name = rs.getString(2); 
				System.out.println("Row: " + rs.getRow()+" -    "+ driver_id + "             " + driver_name);
				System.out.println();
			} //end while
			conn.close();
			
		}
}
	
	
	static void conductor() throws ClassNotFoundException, SQLException, IOException {
		
		String opt;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDo you want to insert data to the Conductor's Table?  ");
		opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
		
		System.out.println("\t\t\tConductor's Table");
		Connection conn1 = null;
		String url1 = "jdbc:mysql://localhost:3306/";
		String dbName1 = "ticketing_system";
		String driver1 = "com.mysql.cj.jdbc.Driver";
		String userName1 = "root";
		String password1 = "";
		Class.forName(driver1);
		conn1 = DriverManager.getConnection(url1+dbName1,userName1,password1);
		System.out.println("Connected to the database");
		
		String cond_id, cond_name;
		PreparedStatement ps1 = conn1.prepareStatement("INSERT INTO conductor_table VALUES(?,?)");
		Statement stmt1 = conn1.createStatement();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			
			System.out.print("\n\tEnter Conductor_id: ");
			cond_id = br1.readLine();
			System.out.print("\tEnter Condutor name: ");
			cond_name = br1.readLine();
			
			ps1.setString(1,cond_id);
			ps1.setString(2,cond_name);
			
			int i = ps1.executeUpdate();
			System.out.println(i+" records added");
			System.out.print("\nDo you want to continue: ");
			String s1 = br1.readLine();
			
		if(s1.startsWith("n")){
			break;
		}
		}
		while(true);
		String sql1 = "SELECT * from conductor_table";
		ResultSet rs1 = stmt1.executeQuery(sql1);
		System.out.println("\nThe records are :");
		System.out.println("      " + "   Cond ID" + "     Cond Name");
		while (rs1.next())
	{
		cond_id = rs1.getString(1);
		cond_name = rs1.getString(2); 
		System.out.println("Row: " + rs1.getRow()+" -    "+ cond_id + "             " + cond_name);
		System.out.println();
		} //end while
		conn1.close();
	}
		else {
			
			Connection conn1 = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "ticketing_system";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "";
			Class.forName(driver);
			conn1 = DriverManager.getConnection(url+dbName,userName,password);
			
			String cond_id, cond_name;
			Statement stmt1 = conn1.createStatement();
			
			String sql1 = "SELECT * from conductor_table";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			System.out.println("\nThe records are :");
			System.out.println("      " + "   Cond ID" + "     Cond Name"); 
			while (rs1.next())
			{
				cond_id = rs1.getString(1);
				cond_name = rs1.getString(2);
				System.out.println("Row: " + rs1.getRow()+" -    "+ cond_id + "          " + cond_name);
				System.out.println();
			} //end while
			conn1.close();
			
		}
		}
	
	static void bus() throws SQLException, IOException, ClassNotFoundException {
		
		String opt;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDo you want to insert data to the Bus' Table?  ");
		opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
		
		
		System.out.println("\t\t\tModern Jeep's Table");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ticketing_system";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("Connected to the database");
		
		String bus_no, is_active, driver_id, cond_id;
		PreparedStatement ps = conn.prepareStatement("INSERT INTO mjeep_table VALUES(?,?,?,?)");
		Statement stmt = conn.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			
			System.out.print("\n\tEnter Mjeep No: ");
			bus_no = br.readLine();
			System.out.print("\tEnter Active Status: ");
			is_active = br.readLine();
			System.out.print("\tEnter Driver_id: ");
			driver_id = br.readLine();
			System.out.print("\tEnter Conductor_id: ");
			cond_id = br.readLine();
			
			ps.setString(1,bus_no);
			ps.setString(2,is_active);
			ps.setString(3,driver_id);
			ps.setString(4,cond_id);
			
			int i = ps.executeUpdate();
			System.out.println(i+" records added");
			System.out.print("\nDo you want to continue: ");
			String s = br.readLine();
			
		if(s.startsWith("n")){
			break;
		}
		}
		while(true);
	String sql = "SELECT * from mjeep_table";
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("\nThe records are :");
	System.out.println("      " + "MJeep No." + "     Active Status" + "     Driver ID" + "     Cond ID");
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
	conn.close();
		
	}
		else {
			
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "ticketing_system";
			String driver = "com.mysql.cj.jdbc.Driver";
			String userName = "root";
			String password = "";
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			String bus_no, is_active, driver_id, cond_id;
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * from mjeep_table";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("\nThe records are :");
			System.out.println("      " + "MJeep No." + "     Active Status" + "     Driver ID" + "     Cond ID");
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
			conn.close();
		}
		
}
	
	static void passenger() throws SQLException, IOException, ClassNotFoundException{
		
		String opt;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDo you want to insert data to the Passenger's Table?  ");
		opt = sc.nextLine();
		
		if (opt.startsWith("y")) {
			Intro i = new Intro();
			i.firstFrame();
		}
		
		
	else {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ticketing_system";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		String pass_id, name, spoint, dest, promo, fare, date, bus_no;
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * from passenger_table";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\nThe records are :");
		System.out.println("           " + "Pass.ID" + "           Name" + "               S.Point" + "         Dest." 
				+ "           Promo" + "           Fare" +
				"         Date" + "         MJeepNo.");
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
		conn.close();
	}
		
}
		
	}
	
	
	
	
	
	
