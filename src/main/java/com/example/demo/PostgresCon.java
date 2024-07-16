//package com.example.demo;
//
//import java.sql.*;
//
//class PostgresCon {
//	public static void main(String args[]) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres",
//					"postgres");
////here test is database name, root is username and password  
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from company");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}