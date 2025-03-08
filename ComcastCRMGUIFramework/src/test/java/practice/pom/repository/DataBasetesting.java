package practice.pom.repository;

import java.sql.ResultSet;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;

public class DataBasetesting {
	public static void main(String[] args) throws Throwable {
		DataBaseUtility db=new DataBaseUtility();
		db.getDbconnection();
		ResultSet res = db.executeselectquery("select * from project where project_name='CHATGPT';");
		while(res.next()) {
			System.out.println(res.getString(2));
		}
		db.closeDbConnection();
	}

}
