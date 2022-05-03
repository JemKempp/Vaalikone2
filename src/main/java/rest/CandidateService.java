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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Candidates;


@Path("/CandidateService")

public class CandidateService {
@Context
HttpServletRequest request;
@Context
HttpServletResponse response;

	
	@GET
	@Path("/getCandidates")
	@Produces(MediaType.APPLICATION_JSON)
	public void getCandidates() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
		List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
		//return list;
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp");
		request.setAttribute("ehdokaslista", list);
        try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@DELETE
//    @Path("/DeleteCandidates/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<Candidates> deleteCandidates(@PathParam("id") int id) {
//        EntityManager em=emf.createEntityManager();
//        em.getTransaction().begin();
//        Candidates f=em.find(Candidates.class, id);
//        if (f!=null) {
//            em.remove(f);//The actual insertion line
//        }
//        em.getTransaction().commit();
//        //Calling the method readFish() of this service
//        List<Candidates> list=readCandidates();
//        return list;
//    }
//}
	
	
//	@GET
//	@Path("//{}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getOneLaptop(@PathParam("ehdokas_id") int id) {
//		String s=getCandidate(id);
//		return s;
//	}
}
