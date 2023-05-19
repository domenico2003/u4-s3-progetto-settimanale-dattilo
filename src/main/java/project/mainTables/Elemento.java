package project.mainTables;

import java.util.Random;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Elemento {
	@Id
	private String ISBN = generateIsbn();
	private String titolo;
	private int annoPublicazione;
	private int nPagine;
	@OneToMany
	private Set<Prestito> prestati;

	public Elemento(String titolo, int anno, int pagine) {
		setTitolo(titolo);
		setAnnoPublicazione(anno);
		setNPagine(pagine);
	}

//	public ProdottoCatalogo(String titolo, int anno, int pagine, String ISBN) {
//		setTitolo(titolo);
//		setAnnoPublicazione(anno);
//		setnPagine(pagine);
//		setISBN(ISBN);
//	}

	public static String generateIsbn() {

		Random rand = new Random();

		int digit1 = rand.nextInt(8, 10);
		int digit2 = rand.nextInt(10);
		int digit3 = rand.nextInt(10);
		int digit4 = rand.nextInt(10);
		int digit5 = rand.nextInt(10);
		int digit6 = rand.nextInt(10);
		int digit7 = rand.nextInt(10);
		int digit8 = rand.nextInt(10);
		int digit9 = rand.nextInt(10);
		int digit10 = rand.nextInt(10);
		int digit11 = rand.nextInt(10);

		int checkDigit = (digit1 * 1 + digit2 * 2 + digit3 * 3 + digit4 * 4 + digit5 * 5 + digit6 * 6 + digit7 * 7
				+ digit8 * 8 + digit9 * 9) % 11;

		String isbn = "97" + digit1 + "-" + digit2 + digit3 + "-" + digit4 + digit5 + digit6 + digit7 + digit8 + "-"
				+ digit10 + digit11 + "-" + (checkDigit == 10 ? rand.nextInt(10) : checkDigit);

		return isbn;
	}
}
