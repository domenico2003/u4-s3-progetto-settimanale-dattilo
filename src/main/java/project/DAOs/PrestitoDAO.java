package project.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import project.mainTables.Prestito;

@Slf4j
public class PrestitoDAO {
	private EntityManagerFactory emf;

	public PrestitoDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void saveElement(Prestito e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		em.close();
		log.info("prestito salvato con successo");
	}
}
