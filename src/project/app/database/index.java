package project.app.database;

public class index {

	public static void main(String[] args) {
		sqlife s = new sqlife();
		s.open("./data.db");
		//s.queary("create table name ('name')");
		//s.getData("insert into name values('bbbbb')");
		//s.getData("delete from name");
		s.getData("select * from name");
		
	}

}
