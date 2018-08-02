package com.crowd.management.hajj_roads;

public class Road {
  
	int road;
	String RoadName;
	public String getRoadName() {
		return RoadName;
	}
	public void setRoadName(String roadName) {
		RoadName = roadName;
	}
	int status;
	double distance;
	double averageTime;
	
	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getAverageTime() {
		return averageTime;
	}
	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}
}
