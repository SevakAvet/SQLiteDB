package com.sevak_avet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends SQLiteDB{

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver loading is succsess!\n");
			c = DriverManager.getConnection(url, name, pass);
			System.out.println("Connected!");
			s = c.createStatement();
			System.out.println("Statement created!\n");
			
			//s.executeUpdate(check);
			s.executeUpdate(createTable);
			prep = c.prepareStatement("insert into books values (NULL, ?, ?);");
			
			SQLiteDB db = new SQLiteDB();
			
			//db.insertValue("А.С.Пушкин", "Медный всадник");
		    //batch();
		    
			db.printTable();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(c!=null){
				c.close();
				System.out.println("Connection closed!");
			}
			if(s!=null){
				s.close();
				System.out.println("Statement closed!");
			}
		}
	}

}
