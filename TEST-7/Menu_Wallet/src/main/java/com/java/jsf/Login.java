package com.java.jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Login {
private String username;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
Connection connection;
public Connection getConnection() throws ClassNotFoundException, SQLException {
	  Class.forName("com.mysql.cj.jdbc.Driver");   
    connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/cms","root","root");
return connection;
}
public String authenticate(Login login) throws ClassNotFoundException, SQLException {
	
	connection = getConnection();
	String cmd = "select count(*) cnt from  UserAuth "
			+ " where userName=? AND password=?";
	PreparedStatement pst = connection.prepareStatement(cmd);
	pst.setString(1, login.username);
	pst.setString(2, login.password);
	ResultSet rs = pst.executeQuery();
	rs.next();
	int cnt = rs.getInt("cnt");
	if (cnt==1) {
		return "Tab.xhtml";
	}else
	{
		return "Invalid Login ";
	}
}

}
