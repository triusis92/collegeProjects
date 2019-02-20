<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function populate(x, y,z)
{
	//used this java script function to display the cookies in form fields
	document.getElementById('nameID').value = x;
	document.getElementById('makeID').value = y;
	document.getElementById('modelID').value = z;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Speed Calculator</title>
</head>
<%pageContext.setAttribute("Creator","Lance",PageContext.SESSION_SCOPE); %>
<body>
<%!
//decalre global variables
String name = "";
String make = "";
String model = "";
Date date=new Date();
%>
<h1>Car Speed Calculator</h1>
<h5>Hi There</h5>
<strong>Current Time is</strong>: <%= date %><br><br>

		<FORM method="POST" ACTION="http://localhost:8080/Assignment1/skidMarkServlet">
			Please enter your name:<BR><BR>
			<input TYPE="text" id="nameID" NAME="name"><BR><BR>
				Please enter make of car:<BR><BR>
				<input type="text" id="makeID" NAME="make"><BR><BR>
				Please enter model of car:<BR><BR>
				<input type="text" id="modelID" NAME="model"><BR><BR>
				Please enter skid mark length:<BR><BR>
				<input type="text" id="skidID" NAME="skid"><BR><BR>
				Please enter breaking efficiency(%):<BR><BR>
				<input type="text" id="brakeEfficiencyID" NAME="efficiency"><BR><BR>
				Please select type of road surface:<BR><BR>
				<input type="radio" value="Cement" id="surfaceTypeOne" NAME="surface" checked>Cement<BR>
				<input type="radio" value="Asphalt" id="surfaceTypeTwo" NAME="surface">Asphalt<BR>
				<input type="radio" value="Gravel" id="surfaceTypeThree" NAME="surface">Gravel<BR>
				<input type="radio" value="Ice" id="surfaceTypeFour" NAME="surface">Ice<BR>
				<input type="radio" value="Snow" id="surfaceTypeFive" NAME="surface">Snow<BR><BR>
				
				<%
				Cookie cookies[];//array for storing cookies
				cookies = null;
				cookies = request.getCookies();//get cookies	
				if( cookies != null )//check if cookies exist
				{				      
					for(Cookie c: cookies)//loop through the cookies
					{
						if(c.getName().equals("name"))//check if cookie name matches
							name = c.getValue();//get value of the cookie
						if(c.getName().equals("make"))
							make = c.getValue();
						if(c.getName().equals("model"))
							model = c.getValue();
					}
					//populate the textfields with saved cookies
					out.write("<script>populate(\'" + name + "\',\'" + make + "\',\'" + model + "\')</script>");
				}		
					out.print("<em> Hi, Last time you were here was:</em>");
					out.print(date = new Date(session.getLastAccessedTime()));//print out the last time user was here		
				%>
				<br>
				<input type="submit" value="Calculate">
				<input TYPE="reset">				
		</FORM>
</body>
</html>