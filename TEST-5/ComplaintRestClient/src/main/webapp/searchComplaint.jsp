
<%@page import="Infinite.ComplaintRestClient.Complaint"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		int a = Integer.parseInt(request.getParameter("complaintID"));
		 URL url = new URL("http://localhost:8080/ComplaintRestServices/webapi/Complaint/" +a);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }
BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       

	        String output;
	        String res="";
	        while ((output = br.readLine()) != null) {
	        	res+=output;
	            //out.println(output);
	        }
	       // out.println(res);
	       Complaint complaint= new ObjectMapper().readValue(res, Complaint.class);
	      out.println("ComplaintId is"+complaint.getComplaintID()+"<br><br>");
	       out.println("Complaint type" +complaint.getComplaintType()+"<br><br>");
	       out.println("complaint date" +complaint.getComplaintDate()+"<br><br>");
	       out.println("complaint Descrption" +complaint.getcDescription()+"<br><br>");
	       out.println("complaint Severity" +complaint.getSeverity()+"<br><br>");
	       out.println("complaint Status"+complaint.getStatus()+"<br><br>");
	    %>
</body>
</html>