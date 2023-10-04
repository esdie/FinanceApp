package com.oracle.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class DBConnection {
	@Value("${driver.Class}")
	private  String driverClass="";
	@Value("${db.name}")
	private String uname;
	@Value("${db.pwd}")
	private String pwd;
	@Value("${db.url}")
	private String url;

public  Connection connect() {
	Connection con=null;
	try {
		Class.forName(driverClass);//load the driver class @ runtime
		 con=DriverManager.getConnection(url,uname,pwd);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	return con;
}
}