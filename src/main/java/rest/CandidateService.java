package services;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/CandidateService")
public class CandidateService {
	
	
	@GET
	@Path("/servicename")
	@Produces(MediaType.TEXT_PLAIN)
	public String serviceName() {
		return "";
	}
	
	
	@GET
	@Path("//{}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOneLaptop(@PathParam("ehdokas_id") int id) {
		String s=getCandidate(id);
		return s;
	}
	
	
	public String getCandidate(int id) {
		ArrayList list=new ArrayList<>();
		list.add("");
		list.add("");
		list.add("");
		list.add("");
		list.add("");
		
		return list.get(id);
	}
}
