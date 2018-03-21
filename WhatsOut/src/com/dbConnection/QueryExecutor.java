package com.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yvan GAKUBA
 * 
 * The following class is used whenever you want to hit the database with
 * queries. It uses DBConnection to connect to database, receives queries and
 * data if needed to execute them for you
 * 
 */

public class QueryExecutor {
	
	private DBConnection con;
	/*This method is used to INSERT data in a table*/
	public boolean insert(String query, Object...values) {
		return executeCrudQuery(query, values);
	}
	/*This method is used to UPDATE data in a table*/
	public boolean update(String query, Object...values) {
		return executeCrudQuery(query, values);
	}
	/*This method is used to DELETE data from a table*/
	public boolean delete(String query, Object...values) {
		return executeCrudQuery(query, values);
	}
	/*The following method performs CRUD operation */
	private boolean executeCrudQuery(String query, Object...values) {
		try {
			prepareQuery(query, values).executeUpdate();
			return true;
		}catch(SQLException sq) {
			System.out.println("ERROR WHILE PERFORMING CRUD>> "+sq);
			return false;
		}
	}
	
	/*The following method fetches data in the database and returns a ResultSet*/
	
	public ResultSet getData(String query, Object...values) {
		ResultSet rs=null;
		try {
			rs=prepareQuery(query, values).executeQuery();
		}catch(SQLException sq) {
			System.out.println("ERROR WHILE FETCHING DATA>> "+sq);
		}
		return rs;
	}
	
	/*The following method receives the query and the array of object, loop through it
	 *  data and passes the data in the query and lastly create a preparedStatement that will
	 *  be executed by the functions that uses this one.
	 *  */
	
	public PreparedStatement prepareQuery(String query, Object...values) {
		PreparedStatement ps=null;
		try {
			ps=this.con.getCon().prepareStatement(query);
		/* 
		 * This loop goes through all the values while identifying the types of 
		 * different data passed to and casted and passed to the preparedStatement to be added to the query
		 * */	
			if(values!=null) {
				for(int i=0;i<values.length;i++) {
					if(values[i] instanceof String) {
						ps.setString(i+1, (String)values[i]);
					}else if(values[i] instanceof Integer) {
						ps.setInt(i+1, (Integer)values[i]);
					}else if(values[i] instanceof Double) {
						ps.setDouble(i+1, (Double)values[i]);
					}else if(values[i] instanceof Boolean) {
						ps.setBoolean(i+1, (Boolean)values[i]);
					}else {
						ps.setObject(i+1, values[i]);
					}
				}
			}
		}catch(SQLException sq) {
			System.out.println("ERROR WHILE FETCHING DATA>> "+sq);
		}
		return ps;
	}
	
	public QueryExecutor() {
		//when an QueryExecutor is instantiated, DBConnection that creates a connection is instantiated
		this.con=new DBConnection();
		this.con.openConnection();
	}
	
	public void closeConnection() {
		this.con.closeConnection();
	}
}
