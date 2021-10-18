package Infinite.ComplaintRestServices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class ComplaintDAO {
	
	 PreparedStatement pst;   
	 Connection connection;

	 public String addComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		 String cmd="Insert into Complaint(ComplaintID,ComplaintType,CDescription,ComplaintDate,Severity)values(?,?,?,?,?)";
		 pst=connection.prepareStatement(cmd);
		 pst.setInt(1,complaint.getComplaintID());
		 pst.setString(2, complaint.getComplaintType());
		 pst.setString(3, complaint.getcDescription());
		 long d1=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(d1);
		 pst.setDate(4, date);
		 pst.setString(5, complaint.getSeverity());
		
		 pst.executeUpdate();
		 return "Record Added Sucessfully";
	 } 
	 public Complaint searchComplaint(int ComplaintID) throws ClassNotFoundException, SQLException {
		 connection= ConnectionHelper.getConnection();
		 String cmd="Select * from Complaint where ComplaintID=?";
		 pst=connection.prepareStatement(cmd);
		 pst.setInt(1, ComplaintID);
		 ResultSet rs = pst.executeQuery();
		 
		 Complaint complaint=null;
		 
		 if(rs.next()) {
			 complaint= new Complaint();
			 complaint.setComplaintID(rs.getInt("ComplaintID"));
			 complaint.setComplaintType(rs.getString("ComplaintType"));
			 complaint.setComplaintDate(rs.getDate("ComplaintDate"));
			 complaint.setcDescription(rs.getString("CDescription"));
			 complaint.setSeverity(rs.getString("Severity"));
			 complaint.setStatus((rs.getString("Status")));
			 
		 }
		 return complaint;
	 }
	 
	 public Complaint[] ShowComplaint() throws ClassNotFoundException, SQLException {
			connection=ConnectionHelper.getConnection();
			List<Complaint> complaintList = new ArrayList<Complaint>();
			String cmd = "select * from Complaint" ;
			pst=connection.prepareStatement(cmd);
			ResultSet rs= pst.executeQuery();
			Complaint complaint = new Complaint();
			while(rs.next()) {
				complaint = new Complaint();
				complaint.setComplaintID(rs.getInt("ComplaintId"));
				complaint.setComplaintType(rs.getString("ComplaintType"));
				complaint.setcDescription(rs.getString("CDescription"));
				complaint.setComplaintDate(rs.getDate("ComplaintDate"));
				complaint.setSeverity(rs.getString("Severity"));
				complaint.setStatus(rs.getString("Status"));
				complaintList.add(complaint);
			}
			return complaintList.toArray(new Complaint[complaintList.size()]);
		}
	 
	 
	 
		
	 public String check(Complaint complaint) throws ClassNotFoundException, SQLException {
			 connection=ConnectionHelper.getConnection();
			String cmd="select resolvedate from resolve where ComplaintID=?";
		     pst=connection.prepareStatement(cmd);
			pst.setInt(1,complaint.getComplaintID());
			ResultSet rs=pst.executeQuery();
		   if(rs.next()) {
			Date resolvedDate=rs.getDate("resolvedate");
			long difference = resolvedDate.getTime() - complaint.getComplaintDate().getTime();
			double daysBetween = (difference / (1000*60*60*24));
			int days=(int)daysBetween;
			days++;
			if(resolvedDate.getTime()==complaint.getComplaintDate().getTime()) {
				return "green";
			}else if(days>=5) {
				return "pink";
			}else {
				return "red";
			}
		   }
		return null;
		}
		
		public String resolve(Resolve resolve) throws ClassNotFoundException, SQLException {
			Complaint complaint=searchComplaint(resolve.getComplaintID());
			if(complaint!=null) {
		  connection=ConnectionHelper.getConnection();
				String cmd="insert into resolve(ComplaintID,ComplaintDate,ResolveDate,ResolvedBy,"
						+ "Comments) values(?,?,?,?,?)";
			     pst=connection.prepareStatement(cmd);
				pst.setInt(1, resolve.getComplaintID());
				pst.setDate(2, complaint.getComplaintDate());
				long d1=System.currentTimeMillis();
				java.sql.Date date=new java.sql.Date(d1);
				pst.setDate(3, date);
				pst.setDate(4, resolve.getResolveDate());
				pst.setString(5, resolve.getComments());
				pst.executeUpdate();
				
				cmd="update complaint set status='Resolved' where ComplaintID=?";
				PreparedStatement pst1=connection.prepareStatement(cmd);
				pst1.setInt(1, resolve.getComplaintID());
				pst1.executeUpdate();
				return "Record added";
				
			}
			return "Unknown Complaint ID";
		}
	 

	 
	
}
