package project.app.console;

import project.app.database.*;

public class conSql extends sqlife{
	
	public void select(String fild,String table,String rule){
		queary("select "+fild+" from "+table+" "+rule);
	}
	
	public void insert(String table,String value){
		queary("insert into "+table+" values( "+value+" )");
	}
	
	public void delete(String table,String rule){
		
	}
}
