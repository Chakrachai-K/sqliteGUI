package project.app.database;

import java.util.ArrayList;

public class index {

	public static void main(String[] args) {
		sqlife s = new sqlife();
		s.open("./data.db");
		//s.queary("create table name ('name')");
		//s.queary("insert into name values('ccccc')");
		s.queary("delete from name");
		s.queary("select * from name");
		ArrayList<String> data = s.getOutput();
		System.out.println(data.size());
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i));
		}
	}

}
