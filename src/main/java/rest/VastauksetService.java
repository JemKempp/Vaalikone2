package rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Candidates;


@Path("/VastauksetService")

public class VastauksetService {
@Context
HttpServletRequest request;
@Context
HttpServletResponse response;

	
	@GET
	@Path("/getVastaukset")
	@Produces(MediaType.APPLICATION_JSON)
	public void getVastaukset() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
		List<Vastaukset> list=em.createQuery("select a from Vastaukset a").getResultList();
		//return list;
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showvastaukset.jsp");
		request.setAttribute("vastauslista", list);
        try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@GET
//	@Path("//{}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getOneLaptop(@PathParam("ehdokas_id") int id) {
//		String s=getCandidate(id);
//		return s;
//	}
}