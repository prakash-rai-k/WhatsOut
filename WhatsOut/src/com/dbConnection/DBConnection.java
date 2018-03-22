package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yvan GAKUBA
 * 
 * The following class is used to connect to the database.
 */
public class DBConnection {

	/* 
	 * the following are configuration you need to connect to the database
	 * To use it to your local computer, kindly change the following:
	 * Attribute:user
	 * Attribute:password
	 * match the port number of your installed MYSQL
	 *  */
	private static final String user = "root";
	private static final String password = "root";
	private static final String mySQLURL = "jdbc:mysql://127.0.0.1:3306/WhatsOutdb";

	private Connection con;

	/*Calls createConnection() function to create a connection if no connection opened*/
	public Connection openConnection() {
		if (con == null) {
			createConnection();
		}
		return con;
	}

	/* This function closes the connection to the database if opened*/
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sq) {
				System.out.println("ERROR CLOSING CONNECTION >>:" + sq);
			}
		}
	}

	/* this function creates a connection to the database */
	private void createConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(mySQLURL, user, password);
		} catch (SQLException sq) {
			System.out.println("ERROR ESTABLISHING CONNECTION>> " + sq);
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
