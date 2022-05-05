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

import dao.Dao;
import data.Candidates;
import data.Questions;
import data.Vastaukset;


@Path("/VastauksetService")

public class VastauksetService {
@Context
HttpServletRequest request;
@Context
HttpServletResponse response;
EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
	
@GET
@Path("/getVastaukset")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void readvastaukset() {
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	@SuppressWarnings("unchecked")
	List<Vastaukset> list=em.createQuery("select a from Vastaukset a").getResultList();
	//return list;
	em.getTransaction().commit();
	RequestDispatcher rd=request.getRequestDispatcher("/jsp/showvastaukset.jsp");
	request.setAttribute("vastauslista", list);
    try {
		rd.forward(request, response);
	} catch (ServletException | IOException e) {
		e.printStackTrace();
	}
}

//@GET
//@Path("/getpena")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public List<Vastaukset> readpena() {
	//EntityManager em=emf.createEntityManager();
	//em.getTransaction().begin();
	//@SuppressWarnings("unchecked")
	//List<Vastaukset> list=em.createQuery("select a from Vastaukset a").getResultList();
	//return list;
//}

	@GET
    @Path("/DeleteVastaukset/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteVastaukset(@PathParam("id") int id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Vastaukset f=em.find(Vastaukset.class, id);
        if (f!=null) {
            em.remove(f);//The actual insertion line
        }
        em.getTransaction().commit();
        readvastaukset();
        //Calling the method readFish() of this service
       // List<Vastaukset> list=getVastaukset();
        //return list;
    }
	
	@POST
	@Path("/editvastaukset")
	@Produces(MediaType.APPLICATION_JSON)
	public void editVastaukset(@FormParam("kysymys_id")String kysymys_id, @FormParam("vastaus")String vastaus) {
		List<Vastaukset> list = new ArrayList<Vastaukset>();
		Dao dao = new Dao();
		Vastaukset c = new Vastaukset(kysymys_id, vastaus);
		list = dao.editVastaukset(c);
		request.setAttribute("vastauksetlista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showvastaukset.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
    @Path("/getvastausid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getVastausId(@PathParam("id")int id) {
        Vastaukset list = new Vastaukset();
        Dao dao = new Dao();
        list = dao.getVastausId(id);
        request.setAttribute("vastauksetlista", list);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcandidate.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
	}
}

//@PUT
//@Path("/EditVastaukset")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public void EditVastaukset(@PathParam("id") int id) {
	//EntityManager em = emf.createEntityManager();
	//em.getTransaction().begin();
	//Vastaukset v = em.find(Vastaukset.class, id);

	//if (v != null) {
		//em.merge(v);
	//}
	//em.getTransaction().commit();

	//readvastaukset();
//	return list;

	//}
//}
	


