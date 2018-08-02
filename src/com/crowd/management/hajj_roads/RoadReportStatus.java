package com.crowd.management.hajj_roads;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;




public class RoadReportStatus {
	int roadID;
	String startTime;
	String EndTime;
	double duration;
	int status;
	int numOfPeople;
	int emerg_id;
	public int getRoadID() {
		return roadID;
	}
	public void setRoadID(int roadID) {
		this.roadID = roadID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public int getEmerg_id() {
		return emerg_id;
	}
	public void setEmerg_id(int emerg_id) {
		this.emerg_id = emerg_id;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

}
