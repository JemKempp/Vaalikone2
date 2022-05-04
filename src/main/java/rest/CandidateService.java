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

	@POST
	@Path("/EditCandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCandidates(@FormParam("ehdokas_id")String ehdokas_id, @FormParam("sukunimi")String sukunimi, @FormParam("etunimi")String etunimi, 
			@FormParam("puolue")String puolue, @FormParam("kotipaikkakunta")String kotipaikkakunta, @FormParam("ika")String ika,
			@FormParam("miksi_eduskuntaan")String miksi_eduskuntaan, @FormParam("mita_asioita_haluat_edistaa")String mita_asioita_haluat_edistaa,
			@FormParam("ammatti")String ammatti) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		//List<Candidates> list = new ArrayList<Candidates>();
		List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
		em.getTransaction().commit();
		//Candidates c = new Candidates(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa,
			//	ammatti);
		request.setAttribute("ehdokaslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcandidate.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	@GET
	@Path("/getcandidateid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getCandidateId(@PathParam("id")int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
		em.getTransaction().commit();
		request.setAttribute("ehdokaslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcandidate.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
//@PUT
//@Path("/EditCandidate")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public void editCandidate (@PathParam("id") int id) {
	//EntityManager em = emf.createEntityManager();
	//em.getTransaction().begin();
	//@SuppressWarnings("unchecked")
	//List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
	//Candidates c = em.find(Candidates.class, id);

	//if (c != null) {
		//em.merge(c);
	//}
	//em.getTransaction().commit();
	//readCandidates();
	
	//String ehdokas_id=request.getParameter("ehdokas_id");
	//String etunimi=request.getParameter("etunimi");
	//String sukunimi=request.getParameter("sukunimi");
	//String puolue=request.getParameter("puolue");
	//String kotipaikkakunta=request.getParameter("kotipaikkakunta");
	//String ika=request.getParameter("ika");
	//String miksi_eduskuntaan=request.getParameter("miksi_eduskuntaan");
	//String mita_asioita_haluat_edistaa=request.getParameter("mita_asioita_haluat_edistaa");
	//String ammatti=request.getParameter("ammatti");
	
	//Candidates e=new Candidates(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
	//RequestDispatcher rd=request.getRequestDispatcher("/jsp/editcandidate.jsp");
	//request.setAttribute("ehdokaslista", list);
    //try {
		//rd.forward(request, response);
	//} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	
	//}
//}
}

//@PUT
//@Path("/EditCandidate")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public List<Candidates> EditCandidate(@PathParam("id") int id) {
	//EntityManager em = emf.createEntityManager();
	//em.getTransaction().begin();
	//Candidates c = em.find(Candidates.class, id);

	//if (c != null) {
		//em.merge(c);
	//}
	//em.getTransaction().commit();

	//List<Candidates> list = readCandidates();
	//return list;

	//}
//}
