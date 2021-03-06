package project.app.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sqlife {
	private String dbpart;
	private Connection connect;
	private Statement stat;
	private String queary;
	private ResultSet output = null;
	private ResultSetMetaData detaleOutput = null;
	private ArrayList<String> rowname = new ArrayList<>();
	private ArrayList<String> columnName = new ArrayList<>();

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
	
	public void queary(String input){
		queary = input;
		getData();
	}
	
	private void getData(){
		
		System.out.println(queary);
		int i = 1;
		try{
			if(queary.charAt(0)=='s'||queary.charAt(0)=='S'){
				//System.out.println("input");
				output = stat.executeQuery(queary);
				detaleOutput = output.getMetaData();
				try{
					
					while(detaleOutput.getColumnLabel(i) != null){
						
						System.out.println(detaleOutput.getColumnLabel(i)+"");
						rowname.add(detaleOutput.getCatalogName(i));
						
						try {
							while((output!=null) && (output.next())){
								System.out.println(output.getString(1));
								columnName.add(output.getString(i));
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("No data");
						}
						
						i++;
					}
				}
				catch(Exception e){
					
				}
				
			}else{
				stat.execute(queary);
				System.out.println();
			}
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("queary error");
		}
		
	}
	
	public ArrayList<String> getOutput(){

		return columnName;
		
	}
	public ArrayList<String> rowName() throws SQLException{
		
		
		return rowname;
		
	}
}
