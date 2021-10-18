package Infinite.ComplaintRestClient;

import java.sql.Date;

public class Resolve {
	
	private int  complaintID ;
	 private Date  complaintDate ;
	 private Date  resolveDate;
	  private String resolvedBy;
	  private String comments ;
	public int getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public Date getResolveDate() {
		return resolveDate;
	}
	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Resolve [complaintID=" + complaintID + ", complaintDate=" + complaintDate + ", resolveDate="
				+ resolveDate + ", resolvedBy=" + resolvedBy + ", comments=" + comments + "]";
	}
	  
	
}
