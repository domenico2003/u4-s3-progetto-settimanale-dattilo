package project.DAOs;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import project.mainTables.User;

@Slf4j
public class UserDAO {
	private EntityManagerFactory emf;

	public UserDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void saveElement(User e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		em.close();
		log.info("prestito salvato con successo");
	}

	public User getByISBN(String id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		User risposta = em.find(User.class, UUID.fromString(id));
		t.commit();
		em.close();
		return risposta;
	}
}
