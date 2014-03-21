package project.app.gui;

import java.sql.SQLException;
import java.util.ArrayList;

import project.app.database.*;
import project.app.console.*;

public class index {

	public static void main(String[] args) throws SQLException {
		conSql s = new conSql();
		s.open("./data.db");
		//s.queary("create table name ('name')");
		//s.queary("insert into name values('ccccc')");
		//s.queary("delete from name");
		s.select("*","name","");
		ArrayList<String> data = s.getOutput();
		//System.out.println(data.size());
		
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i));
		}
		
		ArrayList<String> rowname = s.rowName();
		
		for(int j=0;j<rowname.size();j++){
			System.out.println(rowname.get(j));
		}
		
	}

}
