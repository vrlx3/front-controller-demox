package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class RequestHelper {
	
	// a logger
	private static Logger logger = Logger.getLogger(RequestHelper.class);
	// an employeeService instance
	private static EmployeeService eserv = new EmployeeService(new EmployeeDAO());
	// an object mapper
	private static ObjectMapper om = new ObjectMapper(); // this is from Jackson Data Bind library
	
	
	public static void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		// extract the parameters from the HttpServlerRequest (username & password)
		
		// call the service layer...which calls the dao layer
		
		// return some response (or redirect the user) if the employee object exists in the database.
		
		
	}
	
	public static void processEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		// 1. set the content type of the response
		response.setContentType("text/html");
		
		// 2. Call the findAll() method from the Service layer and save it a list
		List<Employee> allEmployees = eserv.findAll(); // this calls our DAO layer, which retrieves all objects from the DB
		
		// 3. Marshall the list of Java Objects to JSON (using Jackson as our Object Mapper)
		String jsonString = om.writeValueAsString(allEmployees);
		
		// 4. Call the Print Writer to write it out to the client (browser) in the response body
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		
		
	}
	
	
	public static void processError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		
		
		
	}
	

}
