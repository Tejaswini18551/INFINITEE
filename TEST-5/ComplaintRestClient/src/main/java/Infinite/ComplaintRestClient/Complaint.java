package Infinite.ComplaintRestClient;

import java.sql.Date;

public class Complaint {
     
	private int complaintID ;
	 private String   complaintType ;
	  private String  cDescription ;
	  private Date complaintDate;
	 private String  severity;
	private String   status ;
	public int getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", complaintType=" + complaintType + ", cDescription="
				+ cDescription + ", complaintDate=" + complaintDate + ", severity=" + severity + ", status=" + status
				+ "]";
	}
	
	
	
}
