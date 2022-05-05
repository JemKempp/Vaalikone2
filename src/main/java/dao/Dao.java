package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data.Candidates;
import data.Questions;

public class Dao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone2");
	
	public List<Candidates> readCandidates() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidates> list = em.createQuery("select a from Candidates a").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	public String addCandidate(Candidates c) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return null;
	}
	
	public List<Candidates> editCandidates(Candidates candidate) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidates c = em.find(Candidates.class, candidate.getEhdokas_id());
		if (c!=null) {
			em.merge(candidate);
		}
		em.getTransaction().commit();
		List<Candidates> list = readCandidates();
		em.close();
		return list;
	}
	
	public Candidates getCandidateId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidates c = em.find(Candidates.class, id);
		em.getTransaction().commit();
		em.close();
		return c;
		
	}
		
		public List<Questions> readQuestions() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Questions> list = em.createQuery("select a from Questions a").getResultList();
			em.getTransaction().commit();
			return list;
		}
		
		public String addQuestion(Questions c) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return null;
		}
		
		public List<Questions> editQuestions(Questions question) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Questions c = em.find(Questions.class, question.getKysymys_id());
			if (c!=null) {
				em.merge(question);
			}
			em.getTransaction().commit();
			List<Questions> list = readQuestions();
			em.close();
			return list;
		}
		
		public Questions getQuestionId(int id) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Questions c = em.find(Questions.class, id);
			em.getTransaction().commit();
			em.close();
			return c;
		}
	}


