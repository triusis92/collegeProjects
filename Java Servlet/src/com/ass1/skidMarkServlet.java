//Created by Lance
package com.ass1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/skidMarkServlet")
public class skidMarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//variable declarations
	private double drag=0;
	private Enumeration<String> headerNames;
	private PrintWriter out;
	private HttpSession session;
	private double speed=0;
	private static final String FILENAME="Inputs.ser";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public skidMarkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");//get user input
		String makeOfCar = request.getParameter("make");
		String modelOfCar = request.getParameter("model");

		Cookie nameCookie = new Cookie("name", name );//initialise the cookie
		Cookie carMakeCookie = new Cookie("make", makeOfCar);
		Cookie carModelCookie = new Cookie("model", modelOfCar);
		
		nameCookie.setMaxAge(60*60*24); // seconds until cookie removed
		response.addCookie(nameCookie); //save/add a cookie
		carMakeCookie.setMaxAge(60*60*24);
		response.addCookie(carMakeCookie);
		carModelCookie.setMaxAge(60*60*24);
		response.addCookie(carModelCookie);

		doGet(request,response);//call doPost method
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		out = response.getWriter();//get writer object
		session = request.getSession();//get the session object
		String title = "";
		String author=(String) session.getAttribute("Creator");//get variable value from jsp page
		Integer accessCount = new Integer(0);//initialise the count for page visits
		if (session.getAttribute("new")!=null) //check if user has been here before
		{
			title = "Thank You for using our website again!";
			Integer oldAccessCount = (Integer)session.getAttribute("accessCount");//get previous number of visits
			if (oldAccessCount != null) //check if previous number of visits is not null
			{	
				accessCount = new Integer(oldAccessCount.intValue() + 1);//increment count by 1
			}
		} else 
		{
			title = "Thank You";
			session.setAttribute("new", Boolean.FALSE);//if first time user, set a boolean flag
			accessCount = new Integer(1);//assign new count
		}
		session.setAttribute("accessCount", accessCount);//set the previous visit count 	       
		response.setContentType("text/html");

		MyBean inputs  = new MyBean(); //create an object from my bean class
		inputs.setSkid(request.getParameter("skid"));//populate the bean with user inputs
		inputs.setEfficiency(request.getParameter("efficiency"));
		inputs.setSurface(request.getParameter("surface"));
		saveInputsToFile(inputs);// save the bean object to file
		double skidMarkLength = Double.parseDouble(inputs.getSkid());//parse user inputs for the formula
		double brakeEff = Double.parseDouble(inputs.getEfficiency());
		String surfaceType = inputs.getSurface();

		if("Cement".equals(surfaceType))//compare if surface type match
		{
			drag=0.33;//an average drag taken from range of possibilities
		}
		else if("Asphalt".equals(surfaceType))
		{
			drag=0.7;
		}
		else if("Gravel".equals(surfaceType))
		{
			drag=0.6;
		}
		else if("Ice".equals(surfaceType))
		{
			drag=0.17;
		}
		else if("Snow".equals(surfaceType))
		{
			drag=0.35;
		}
		speed=Math.sqrt(30*skidMarkLength*(brakeEff/100)*drag);//formula for calculating speed

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +"transitional//en\">\n";
		//print out the result page
		out.println(docType + "<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<h2 align=\"center\">" + "You have used our website: "+accessCount +" times."+ "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>Miles per Hour</th>\n"+
				"</tr>\n");
		out.print("<tr><td>" + speed + "</td>");
		out.print("</tr>\n</table>\n");
		headerNames = request.getHeaderNames();//get header names from server
		while (headerNames.hasMoreElements()) //traverse the list of headers and print them out
		{
			String headerName = headerNames.nextElement();
			out.print("Header Name: <em>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print("</em>, Header Value: <em>" + headerValue);
			out.println("</em><br/>");
		}
			out.println("<br><br><footer align=\"center\"><em>"+"Created By "+author+"</em></footer>");
		    out.println("</body></html>");
	}
	//method for serailizing bean object and saving it to a file
	public static void saveInputsToFile(Object inputs) 
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(FILENAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(inputs);

			oos.close();
		} catch (Exception e) 
		{
			System.out.println("Could not save to file!");
			e.printStackTrace();
		}
	}
}
