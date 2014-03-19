package project.app.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlife {
	private String dbpart;
	private Connection connect;
	private Statement stat;

	private void openDatabase() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			System.out.println(dbpart);
			connect = DriverManager.getConnection(dbpart);
			stat = connect.createStatement();
			
		} catch (SQLException e) {
			
			System.out.println("SQLException");
			System.out.println(e.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public void createDatabase(String file_str) {
		try {
			(new File(file_str)).createNewFile();
			this.open(file_str);
		} catch (IOException e) {
			
		}
	}

	public void open(String path) {
		dbpart = "jdbc:sqlite:" + path;
		openDatabase();
	}
	
	public String queary(String queary){
		this.openDatabase();
		System.out.println("start query(" + queary + ")");
		
		try {
			ResultSet output;
			output = stat.executeQuery(queary);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "aaa";
	}
}
