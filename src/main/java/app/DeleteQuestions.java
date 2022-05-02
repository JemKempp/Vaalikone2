package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Questions;



public class DeleteQuestions{

	@DELETE
    @Path("/DeleteQuestions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Questions> deleteQuestions(@PathParam("id") int id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Questions f=em.find(Questions.class, id);
        if (f!=null) {
            em.remove(f);//The actual insertion line
        }
        em.getTransaction().commit();
        //Calling the method readFish() of this service
        List<Questions> list=readQuestions();
        return list;
    }
}
