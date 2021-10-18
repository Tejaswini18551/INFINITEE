package Infinite.ComplaintRestServices;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/Complaint")
public class ComplaintService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Complaint[] ShowComplaint() throws ClassNotFoundException, SQLException {
		Complaint complaint= new Complaint();
		ComplaintDAO dao = new ComplaintDAO();
		return dao.ShowComplaint();
	}
	

		
	@GET
	@Path("{complaintID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Complaint showComplaint(@PathParam("complaintID") int ComplaintID) throws ClassNotFoundException, SQLException {
	ComplaintDAO dao= new ComplaintDAO();
	return dao.searchComplaint(ComplaintID);
	}
	
	
	
	@POST
	@Path("/addComplaint")
	@Produces(MediaType.APPLICATION_JSON)
	public String addComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		ComplaintDAO dao= new ComplaintDAO();
		return new ComplaintDAO().addComplaint(complaint);
	}
	
	@POST
	@Path("/resolve")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String resolve(Resolve resolve) throws ClassNotFoundException, SQLException {
		return new ComplaintDAO().resolve(resolve);
	}
	
}
