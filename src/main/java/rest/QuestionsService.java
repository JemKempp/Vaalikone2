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
import data.Questions;
import data.Vastaukset;


@Path("/QuestionsService")

public class QuestionsService {
@Context
HttpServletRequest request;
@Context
HttpServletResponse response;




	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone2");

	@GET
	@Path("/getQuestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readquestion() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Questions> list = em.createQuery("select a from Questions a").getResultList();
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
		request.setAttribute("kysymyslista", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@GET
    @Path("/DeleteQuestions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuestions(@PathParam("id") int id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Questions f=em.find(Questions.class, id);
        if (f!=null) {
            em.remove(f);//The actual insertion line
        }
        em.getTransaction().commit();
        readquestion();
        //Calling the method readFish() of this service
       // List<Vastaukset> list=getVastaukset();
        //return list;
    }
}
//	@GET
//	@Path("/getQuestions")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void getQuestions() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		//And then EntityManager, which can manage the entities.
//		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
//		List<Questions> list=em.createQuery("select a from Questions a").getResultList();
		//return list;
//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
//		request.setAttribute("kysymyslista", list);
//        try {
//			rd.forward(request, response);
//		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


	
	
//	@GET
//	@Path("//{}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getOneLaptop(@PathParam("ehdokas_id") int id) {
//		String s=getCandidate(id);
//		return s;
//	}

