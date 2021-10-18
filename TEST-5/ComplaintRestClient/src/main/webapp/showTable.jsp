
<%@page import="Infinite.ComplaintRestClient.ComplaintDAO"%>
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
<table border="3">
	<tr>
		<td>Complaint ID</td>
		<td>Complaint Type</td>
		<td>Complaint Description</td>
		<td>Complaint Date</td>
		<td>Severity</td>
		<td>Status</td>
	</tr>
	<%
		URL url=new URL("http://localhost:8080/ComplaintRestServices/webapi/Complaint");
	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("GET");
     conn.setRequestProperty("Accept", "application/json");

     if (conn.getResponseCode() != 200) {
         throw new RuntimeException("Failed : HTTP error code : "
                 + conn.getResponseCode());
     }

     BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
     
     String output,res="";
     while((output=br.readLine())!=null){
    	 res+=output;
     }
     ObjectMapper obj = new ObjectMapper();
     Complaint[] arrcomplaint=obj.readValue(res, Complaint[].class);
     
     for(Complaint c: arrcomplaint){
    	 ComplaintDAO dao= new ComplaintDAO();
    	 String color=dao.check(c);
    	 if(color.equalsIgnoreCase("green")){
    		 %>
    		   <td><%=c.getComplaintID() %></td>
    	 		<td><%=c.getComplaintType() %></td>
    	 		<td><%=c.getcDescription()%></td>
    	 		<td><%=c.getComplaintDate() %></td>
    	 		<td><%=c.getSeverity() %></td>
    	 		<td><%=c.getStatus() %></td>
    	 	</tr>
    		 <% 
    	 }else if(color.equalsIgnoreCase("pink")){
    		 %>
 		 	<tr bgcolor="pink">
 	 		<td><%=c.getComplaintID() %></td>
    	 		<td><%=c.getComplaintType() %></td>
    	 		<td><%=c.getcDescription()%></td>
    	 		<td><%=c.getComplaintDate() %></td>
    	 		<td><%=c.getSeverity() %></td>
    	 		<td><%=c.getStatus() %></td>
 	 	</tr>
 		 <% 
    	 }else if(color.equalsIgnoreCase("red")){
    		 %>
  		 	<tr bgcolor="red">
  	 		<td><%=c.getComplaintID() %></td>
    	 		<td><%=c.getComplaintType() %></td>
    	 		<td><%=c.getcDescription()%></td>
    	 		<td><%=c.getComplaintDate() %></td>
    	 		<td><%=c.getSeverity() %></td>
    	 		<td><%=c.getStatus() %></td>
  	 	</tr>
  		 <% 
    	 }else{
    		 %>
     	 	<tr>
     	 		<td><%=c.getComplaintID() %></td>
    	 		<td><%=c.getComplaintType() %></td>
    	 		<td><%=c.getcDescription()%></td>
    	 		<td><%=c.getComplaintDate() %></td>
    	 		<td><%=c.getSeverity() %></td>
    	 		<td><%=c.getStatus() %></td>
     	 	</tr>
     	 <% 
    	 }
    
     }

	%>	
</table>
</body>
</html>