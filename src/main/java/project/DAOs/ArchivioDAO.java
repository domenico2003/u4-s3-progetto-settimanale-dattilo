package project.DAOs;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import project.mainTables.Elemento;
import project.mainTables.Prestito;
import project.mainTables.extendedClasses.Libro;

@Getter
@Slf4j
public class ArchivioDAO {

	private EntityManagerFactory emf;

	public ArchivioDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void saveElement(Elemento e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		em.close();
		log.info(e.getClass().getSimpleName()
				+ (e.getClass().getSimpleName().contentEquals("Libro") ? " salvato" : " salvata") + " con successo");
	}

	public void removeElementByIsbn(String isbn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Elemento risposta = em.find(Elemento.class, isbn);

		em.remove(risposta);
		t.commit();
		em.close();
		log.info(risposta.getClass().getSimpleName() + " con ISBN: " + isbn
				+ (risposta.getClass().getSimpleName().contentEquals("Libro") ? " eliminato" : " eliminata")
				+ " con successo");
	}

	public Elemento getByISBN(String isbn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Elemento risposta = em.find(Elemento.class, isbn);
		t.commit();
		em.close();
		return risposta;
	}

	public List<Elemento> ricercaPerAnnoPublicazione(int dataP) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("SELECT e FROM Elemento e WHERE e.annoPublicazione = :anno ");
		q.setParameter("anno", dataP);

		List<Elemento> risposta = q.getResultList();
		t.commit();
		em.close();
		return risposta;
	}

	public List<Libro> ricercaPerAutore(String autor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :aut ");
		q.setParameter("aut", autor);

		List<Libro> risposta = q.getResultList();
		t.commit();
		em.close();
		return risposta;
	}

	public List<Elemento> ricercaPerTitolo(String titolo) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery(
				"SELECT e FROM Elemento e WHERE LOWER(e.titolo) LIKE LOWER(:tit) OR LOWER(e.titolo) LIKE LOWER(:tit1) OR LOWER(e.titolo) LIKE LOWER(:tit2) OR LOWER(e.titolo) = LOWER(:tit3)");
		q.setParameter("tit", "%" + titolo + "%");
		q.setParameter("tit1", titolo + "%");
		q.setParameter("tit2", "%" + titolo);
		q.setParameter("tit3", titolo);

		List<Elemento> risposta = q.getResultList();
		t.commit();
		em.close();
		return risposta;
	}

	public List<Prestito> prestitiScadutiNonRestituiti() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery(
				"SELECT p FROM Prestito p WHERE (p.DataRestituzionePrevista <  :data) AND (DataRestituzioneEffettiva IS NULL)  ");
		q.setParameter("data", LocalDate.now());
		List<Prestito> risposta = q.getResultList();
		t.commit();
		em.close();
		return risposta;
	}
}
