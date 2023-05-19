package project;

import javax.persistence.EntityManagerFactory;

import lombok.extern.slf4j.Slf4j;
import project.DAOs.ArchivioDAO;
import project.DAOs.PrestitoDAO;
import project.DAOs.UserDAO;
import project.utils.JpaUtil.jpaUtil;

@Slf4j
public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = jpaUtil.getEntityManagerFactory();
		ArchivioDAO ad = new ArchivioDAO(emf);
		UserDAO ud = new UserDAO(emf);
		PrestitoDAO pd = new PrestitoDAO(emf);

//ESERCIZIO 1
//		Libro lib = new Libro("S.W.A.T.", 2017, 500, "Shawn Ryan", "poliziesco");
//		Rivista riv = new Rivista("tutto a caso", 2023, 100, Periodicita.semestrale);
//		ad.saveElement(lib);
//		ad.saveElement(riv);

//ESERCIZIO 2
//		ad.removeElementByIsbn("979-42-14776-71-9");//TESTATA, FUNZIONA 

//ESERCIZIO 3	
//		log.info("libro: " + ad.getByISBN("978-66-99282-64-6").toString());
//		log.info("rivista: " + ad.getByISBN("979-18-87463-02-8").toString());

//ESERCIZIO 4
		// ad.ricercaPerAnnoPublicazione(1999).stream().forEach(el ->
		// log.info(el.toString()));

//ESERCIZIO 5
		// ad.ricercaPerAutore("Shawn Ryan").stream().forEach(lib ->
		// log.info(lib.toString()));

//ESERCIZIO 6
		// ad.ricercaPerTitolo("o").stream().forEach(el -> log.info(el.toString()));//
		// case insensitive

//ESERCIZIO 7

		// CREO UTENTI
//		User Us = new User("Giulia", "Rossi", LocalDate.of(1950, 12, 25), 1233);

		// RICAVO GLI UTENTI
//		User u1 = ud.getByISBN("26f5546e-1f0e-41a1-b85e-aaaefd091f6c");
//		User u2 = ud.getByISBN("37ddb6ac-241e-42f5-930f-cdede96b399c");
//		User u3 = ud.getByISBN("5b43e7b5-d1e5-493b-9f32-adff2ce6223f");
//		User u4 = ud.getByISBN("67742599-ac67-4108-ba47-a9efa314e71b");

		// log.info(u1.toString() + "\n" + u2.toString() + "\n" + u3.toString() + "\n" +
		// u4.toString() + "\n");

		// CREO PRESTITI

//		Prestito pr = new Prestito(u4, ad.getByISBN("978-90-35084-00-2"), LocalDate.of(2015, 02, 20),
//				LocalDate.of(2015, 03, 18));

		// SALVO PRESTITI E UTENTI
//		ud.saveElement(Us);
//		pd.saveElement(pr);

		// SVOLGIMENTO ESERCIZIO 7

		// ad.elementiInPrestitoPerUtente(1232).stream().forEach(el ->
		// log.info(el.toString()));

//ESERCIZIO 8
		// ad.prestitiScadutiNonRestituiti().stream().forEach(pr ->
		// log.info(pr.toString()));

//*************************###TUTTI GLI ESERCIZI FUNZIONANO CORRETTAMENTE###************************
		emf.close();
	}

}
