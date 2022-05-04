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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
        
    }
	
	@POST
	@Path("/EditQuestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editQuestions(@FormParam("kysymys_id")String kysymys_id, @FormParam("kysymys")String kysymys) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		//List<Candidates> list = new ArrayList<Candidates>();
		List<Questions> list=em.createQuery("select a from Questions a").getResultList();
		em.getTransaction().commit();
		//Candidates c = new Candidates(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa,
			//	ammatti);
		request.setAttribute("kysymyslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editquestions.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	@GET
	@Path("/getquestionid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getQuestionId(@PathParam("id")int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Questions> list=em.createQuery("select a from Questions a").getResultList();
		em.getTransaction().commit();
		request.setAttribute("kysymyslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editquestion.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}

//@PUT
//@Path("/EditQuestion")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public List<Questions> EditQuestion(@PathParam("id") int id) {
	//EntityManager em = emf.createEntityManager();
	//em.getTransaction().begin();
	//Questions q = em.find(Questions.class, Questions.getKysymys_id);

	//if (q != null) {
		//em.merge(q);
	//}
	//em.getTransaction().commit();

	//List<Questions> list = readquestion();
	//return list;

	//}
//}





	
	


