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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Candidates;
import data.Questions;
import data.Vastaukset;


@Path("/CandidateService")

public class CandidateService {
@Context
HttpServletRequest request;
@Context
HttpServletResponse response;

EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
	
	@GET
	@Path("/getCandidates")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readCandidates() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
		em.getTransaction().commit();
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
	
	@GET
    @Path("/DeleteCandidates/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCandidates(@PathParam("id") int id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Candidates f=em.find(Candidates.class, id);
        if (f!=null) {
            em.remove(f);//The actual insertion line
        }
        em.getTransaction().commit();
        readCandidates();
       
    }

	
@PUT
@Path("/EditCandidate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public List<Candidates> EditCandidate(@PathParam("id") int id) {
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Candidates c = em.find(Candidates.class, id);

	if (c != null) {
		em.merge(c);
	}
	em.getTransaction().commit();

	List<Candidates> list = readCandidates();
	return list;

	}
}
	


