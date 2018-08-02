package com.crowd.management.hajj_roads;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

public class RoadsData {
	
	  private final String SP_GET_BEST_ROADS = "st_roads_status";
	  private final String SP_REPORT_ROAD_STATUS="st_report_road_status";
	  private final String CN_ROAD_ID = "road_st_id";
	  private final String CN_ROAD_NAME = "road_name";
	  private final String CN_ROAD_DISTANCE = "road_st_distance";
	  private final String CN_ROAD_AVERAGE_TIME = "road_st_average_time";
	  private final String CN_ROAD_STATUS = "road_st_status_id";
	ConnectionManager dbconn;

	 RoadsData(ServletContext servletContext){
		dbconn=new ConnectionManager(servletContext);
    	
	}

	  public ArrayList<Road> getBestRoads() {
		ArrayList<Road> roadArr = new ArrayList<Road>();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try
		{
		    con = dbconn.getConnectionFromPool();
		    String sqlStmt = "";
		    sqlStmt = "{ call " + this.SP_GET_BEST_ROADS + "() }";
		    cs = con.prepareCall(sqlStmt);
		    rs = cs.executeQuery();
		    Road road;
		    while (rs.next())
		    {
		    	road = new Road();
		    	road.setRoad(rs.getInt(CN_ROAD_ID));
		    	road.setRoadName(rs.getString(CN_ROAD_NAME));
		    	road.setStatus(rs.getInt(CN_ROAD_STATUS));
		    	road.setAverageTime(rs.getDouble(CN_ROAD_AVERAGE_TIME));
		    	road.setDistance(rs.getDouble(CN_ROAD_DISTANCE));
		 
		    	roadArr.add(road);
		    }
		    rs.close();
		    cs.close();
		    dbconn.returnConnectionToPool(con);
		} catch (Exception ex)
		{
		    ex.printStackTrace();
		    dbconn.returnConnectionToPool(null);
		}
		return roadArr;
	    }
	  
	  
	  
	  
	  public void reportRoadStatus(int road_id,String startTime, String endTime, double duration, int status, int number_people, int emerg_id )
	    {
		
		String updatedOperatorID = "";
		Connection con = null;
		CallableStatement cs = null;
		try
		{
		    con = dbconn.getConnectionFromPool();
		    String sqlStmt = "";
		    sqlStmt = "{ call " + this.SP_REPORT_ROAD_STATUS + "(?,?,?,?,?,?,?) }";
		    cs = con.prepareCall(sqlStmt);
		    cs.setInt(1,road_id);
		    cs.setString(2, startTime);
		    cs.setString(3, endTime);
		    cs.setDouble(4, duration);
		    cs.setInt(5, status);
		    cs.setInt(6, number_people);
		    cs.setInt(7, emerg_id);
		    cs.execute();
		    cs.close();
		    dbconn.returnConnectionToPool(con);
		} catch (Exception ex)
		{
		    updatedOperatorID = "-10";
		    ex.printStackTrace();
		    dbconn.returnConnectionToPool(null);
		}

	    }
}
