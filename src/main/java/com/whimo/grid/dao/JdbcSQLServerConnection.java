/*
* Copyright (c) 2016 WhimiIndustries
* All rights reserved
* @author Devvrat Nigam
*/
package com.whimo.grid.dao;

public class JdbcSQLServerConnection {
	private java.sql.Connection con = null;
	//private final String url = "jdbc:sqlserver://localhost;integratedSecurity=true;DatabaseName=grid";
	private final String url = "jdbc:sqlserver://CampusAppsDB;integratedSecurity=trues";
	private final String serverName = "CampusAppsDB";
	//private final String serverName = "localhost";
	private final String portNumber = "1433";
	private final String databaseName = "grid";
	//private final String userName = "Sherlock-PC\\Sherlock";
	private final String userName = "AD\\aactech";
	private final String password = "";


	private String getConnectionUrl() {
		System.out.println("--------------"+url + serverName + ":" + portNumber + ";databaseName=" + databaseName);
		return url + serverName + ":" + portNumber + ";databaseName=" + databaseName;		
	}

	private java.sql.Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = java.sql.DriverManager.getConnection(getConnectionUrl(), userName, password);
			if (con != null) {
				System.out.println("Connection Successful!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : " + e.getMessage());
		}
		return con;
	}

	public void displayDbProperties() {
		java.sql.DatabaseMetaData dm = null;
		java.sql.ResultSet rs = null;
		try {
			con = this.getConnection();
			if (con != null) {
				dm = con.getMetaData();
				System.out.println("Driver Information");
				System.out.println("\tDriver Name: " + dm.getDriverName());
				System.out.println("\tDriver Version: " + dm.getDriverVersion());
				System.out.println("\nDatabase Information ");
				System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
				System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());
				System.out.println("Avalilable Catalogs ");
				rs = dm.getCatalogs();
				while (rs.next()) {
					System.out.println("\tcatalog: " + rs.getString(1));
				}
				rs.close();
				rs = null;
				closeConnection();
			} else {
				System.out.println("Error: No active Connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm = null;
	}

	private void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdbcSQLServerConnection obj = new JdbcSQLServerConnection();
		obj.getConnection();
		obj.displayDbProperties();
		obj.closeConnection();
	}
}
