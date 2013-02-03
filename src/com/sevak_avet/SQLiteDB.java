package com.sevak_avet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLiteDB {
	protected static Connection c = null;
	protected static java.sql.Statement s = null;
	protected static PreparedStatement prep = null;
	
	protected static String url = "jdbc:sqlite:books.db";
	protected static String name = "Sevak";
	protected static String pass = "123";
	
	//private static String check = "drop table if exists books;";
	
	protected static String createTable = 
			"create table if not exists books(id INTEGER PRIMARY KEY, author, name);";
		
	public void insertValue(String author, String name) throws SQLException{
		prep.setString(1, author);
		prep.setString(2, name);
		prep.addBatch();
	}
	
	public static void batch() throws SQLException{
		c.setAutoCommit(false);
	    prep.executeBatch();
	    c.setAutoCommit(true);
	}
	
	public void printTable() throws SQLException{
		ResultSet rs = s.executeQuery("select * from books");
		while(rs.next()){
			int id = rs.getInt("id");
			String author = rs.getString("author");
			String name = rs.getString("name");
			
			StringBuilder out = new StringBuilder();
			out.append(id).append("   ").append(author).append("   ").append(name);
			
			System.out.println(out.toString());
		}
		System.out.println();
	}
	
	public void clearTable() throws SQLException{
		s.executeUpdate("delete from books");
		System.err.println("Database cleared!\n");
	}
}
