package com.crowd.management.hajj_roads;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class roads_status
 */
@WebServlet("/roads_status")
public class Roads_status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Roads_status() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		log("rececive http request");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		RoadsData roadData = new RoadsData(getServletContext());
		ArrayList<Road> roadsArr=roadData.getBestRoads();
		log("get the best roads from BD");

		String jsonrespose="";
		Gson gson = new GsonBuilder().create();
		jsonrespose=gson.toJson(roadsArr);
		log("jsonData"+jsonrespose);
		log("get the jsonObject");
		response.getWriter().write(jsonrespose);
		log("send the reponse");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log("rececive http request");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		RoadsData roadData = new RoadsData(getServletContext());
		ArrayList<Road> roadsArr=roadData.getBestRoads();
		log("get the best roads from BD");

		String jsonrespose="";
		Gson gson = new GsonBuilder().create();
		jsonrespose=gson.toJson(roadsArr);
		log("jsonData"+jsonrespose);
		log("get the jsonObject");
		response.getWriter().write(jsonrespose);
		log("send the reponse");
		
	}

}
