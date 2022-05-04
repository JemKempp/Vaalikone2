package rest;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import data.UserData;

@Path("/loginrest")
public class LogInService {
    @Context HttpServletRequest request;
    @Context HttpServletResponse response;

    String adminUsername;
    String adminPassword;
    String MD5Password;

    @GET
    @Path("/loginpage")
    public void goToLoginPage() throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/adduser.jsp");
         dispatcher.forward(request, response); 
    }

    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    public void useraccount(@FormParam("id") String id, @FormParam("password") String password, @FormParam("username") String username, @FormParam("salt") String salt) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Server-programming-jpa");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<UserData> list=em.createQuery("SELECT a FROM ADMIN a").getResultList();
        em.getTransaction().commit();


        for (UserData admin : list) {
               adminUsername = admin.getUsername();
               adminPassword = admin.getPassword();
               System.out.println(adminUsername + ", " + adminPassword);

             }

        request.setAttribute("userProvidedUsername", username);
        request.setAttribute("password", password); 
        request.setAttribute("username", adminUsername);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/adduser.jsp");
        
    }






}















//package rest;

//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;

//import data.Candidates;


//@Path("/LogInService")

//public class LogInService {
//@Context
//HttpServletRequest request;
//@Context
//HttpServletResponse response;

	
	//@GET
	//@Path("/getLogIn")
	//@Produces(MediaType.APPLICATION_JSON)
	//public void getLogIn() {
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		//And then EntityManager, which can manage the entities.
		//EntityManager em=emf.createEntityManager();
		
	//}
//}







		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
//		List<Candidates> list=em.createQuery("select a from Candidates a").getResultList();
		//return list;
//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp");
//		request.setAttribute("ehdokaslista", list);
//       try {
//			rd.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
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


