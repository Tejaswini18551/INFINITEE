

<%@page import="java.sql.Date"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.sun.jersey.api.client.ClientResponse"%>
<%@page import="com.sun.jersey.api.client.WebResource"%>
<%@page import="com.sun.jersey.api.client.Client"%>
<%@page import="javax.ws.rs.client.Invocation"%>
<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="Infinite.ComplaintRestClient.Complaint"%>
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
Complaint complaint= new Complaint();
complaint.setComplaintID(Integer.parseInt(request.getParameter("ComplaintID")));
complaint.setComplaintType(request.getParameter("ComplaintType"));
complaint.setcDescription(request.getParameter("CDescription"));
complaint.setSeverity(request.getParameter("severity")); 


Client client = Client.create();

WebResource webResource = client
   .resource("http://localhost:8080/ComplaintRestServices/webapi/Complaint/addComplaint" );

	Gson obj = new Gson();  
	
String input = obj.toJson(complaint);


ClientResponse res = webResource.type("application/json")
   .post(ClientResponse.class, input);

if (response.getStatus() != 200) {
    throw new RuntimeException("Failed : HTTP error code : "
         + res.getStatus());
} 

//  out.println("Output from Server .... \n");

String output = res.getEntity(String.class);
out.println(output); 




%>
</body>
</html>