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
	
	public void getData(String queary){
		ResultSet output = null;
		System.out.println(queary);
		try{
			if(queary.charAt(0)=='s'||queary.charAt(0)=='S'){
				System.out.println("input");
				output = stat.executeQuery(queary);
				while((output!=null) && (output.next())){
					System.out.println(output.getString(1));
				}
			}else{
				stat.executeQuery(queary);
			}
		}catch(Exception e){
			System.out.println("error");
		}
	}
}
