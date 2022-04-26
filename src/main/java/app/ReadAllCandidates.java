package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readallcandidates")
public class ReadAllCandidates extends HttpServlet {

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpacandidatecontest");
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        List<Ehdokas> list=em.createQuery("select e from Ehdokas e").getResultList();
        em.getTransaction().commit();
        request.setAttribute("ehdokaslist", list);
        RequestDispatcher rd=request.getRequestDispatcher("./jsp/readallcandidates.jsp");
        rd.forward(request, response);
  }
}