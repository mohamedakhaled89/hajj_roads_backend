package com.crowd.management.hajj_roads;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Report_status
 */
@WebServlet("/report_status")
public class Report_status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_status() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoadsData roadData = new RoadsData(getServletContext());
		String roadReportStatusString=getRequestBody(request);
		Gson gson = new GsonBuilder().create();
		RoadReportStatus roadReportStatus= gson.fromJson(roadReportStatusString, RoadReportStatus.class);
		roadData.reportRoadStatus(roadReportStatus.getRoadID(), roadReportStatus.getStartTime(),roadReportStatus.getEndTime(),roadReportStatus.getDuration(), roadReportStatus.getStatus(),roadReportStatus.getNumOfPeople(),roadReportStatus.getEmerg_id());
		//roadData.reportRoadStatus(1, "12:30", "12:50", 20, 1, 5,2);
		response.getWriter().write("ok");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	private String getRequestBody(final HttpServletRequest request) {
	    final StringBuilder builder = new StringBuilder();
	    try (BufferedReader reader = request.getReader()) {
	        if (reader == null) {
	            log("Request body could not be read because it's empty.");
	            return null;
	        }
	        String line;
	        while ((line = reader.readLine()) != null) {
	            builder.append(line);
	        }
	        return builder.toString();
	    } catch (final Exception e) {
	        log("Could not obtain the saml request body from the http request", e);
	        return null;
	    }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoadsData roadData = new RoadsData(getServletContext());
		String roadReportStatusString=getRequestBody(request);
		Gson gson = new GsonBuilder().create();
		RoadReportStatus roadReportStatus= gson.fromJson(roadReportStatusString, RoadReportStatus.class);
		roadData.reportRoadStatus(roadReportStatus.getRoadID(), roadReportStatus.getStartTime(),roadReportStatus.getEndTime(),roadReportStatus.getDuration(), roadReportStatus.getStatus(),roadReportStatus.getNumOfPeople(),roadReportStatus.getEmerg_id());
		//roadData.reportRoadStatus(1, "12:30", "12:50", 20, 1, 5,2);
		response.getWriter().write("ok");
	}

}
