package com.crowd.management.hajj_roads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletContext;

public class ConnectionManager
{
    String url;
    String userName;
    String password;
    String driver;
    Vector<Connection> connectionPool = new Vector<Connection>();
    
    public ConnectionManager(ServletContext context)
    {
	userName = context.getInitParameter("username");
	password = context.getInitParameter("password");
	url = context.getInitParameter("url");
	driver = context.getInitParameter("driver");
	userName="systemAdmin";
	password="password";
	url="jdbc:mysql://localhost:3306/hajjRoadDB";
	driver="com.mysql.jdbc.Driver";
	initializeConnectionPool();
    }
    
    private void initializeConnectionPool()
    {
	while (!checkIfConnectionPoolIsFull())
	{
	    connectionPool.addElement(createNewConnectionForPool());
	}
    }
    
    private Connection createNewConnectionForPool()
    {
	final String logHeader = "Thread: " + Thread.currentThread().getId() + ", createNewConnectionForPool ";
	Connection connection = null;
	try
	{
	    Class.forName(driver);
	    connection = DriverManager.getConnection(url, userName, password);
	} catch (Exception ex)
	{
	    System.out.println(logHeader + ex);
	    return null;
	}
	return connection;
    }
    
    private synchronized boolean checkIfConnectionPoolIsFull()
    {
	final int MAX_POOL_SIZE = 3;
	if (connectionPool.size() < MAX_POOL_SIZE)
	{
	    return false;
	}
	return true;
    }
    
    public synchronized Connection getConnectionFromPool()
    {
	Connection connection = null;
	if (connectionPool.size() > 0)
	{
	    connection = connectionPool.firstElement();
	    connectionPool.removeElementAt(0);
	}
	return connection;
    }
    
    public synchronized void returnConnectionToPool(Connection connection)
    {
	if (connection != null)
	{
	    connectionPool.addElement(connection);
	} else
	{
	    connectionPool.addElement(createNewConnectionForPool());
	}
    }
    
    public synchronized void release()
    {
	Enumeration<Connection> allConnections = connectionPool.elements();
	while (allConnections.hasMoreElements())
	{
	    Connection con = (Connection) allConnections.nextElement();
	    try
	    {
		con.close();
		
	    } catch (SQLException e)
	    {
	    }
	}
	connectionPool.removeAllElements();
    }
}