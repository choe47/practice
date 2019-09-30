package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMain {

    public static void main(String[] args) {
	Connection con = null;
	try {
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
	}
	catch (SQLException e) {

	}
	finally {
	    System.out.println("test");
	}
	// TODO 自動生成されたメソッド・スタブ

    }

}
