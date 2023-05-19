package project.mainTables.extendedClasses;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mainTables.Elemento;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Libro extends Elemento {
	private String autore;
	private String genere;

	public Libro(String titolo, int anno, int pagine, String autore, String genere) {
		super(titolo, anno, pagine);
		setAutore(autore);
		setGenere(genere);
	}

//	public Libro(String titolo, int anno, int pagine, String autore, String genere, String ISBN) {
//		super(titolo, anno, pagine, ISBN);
//		setAutore(autore);
//		setGenere(genere);
//	}

	@Override
	public String toString() {
		return "{\n ISBN: " + this.getISBN() + ";\n titolo: " + this.getTitolo() + ";\n anno di publicazione: "
				+ this.getAnnoPublicazione() + ";\n numero pagine: " + this.getNPagine() + ";\n autore: "
				+ this.getAutore() + ";\n genere: " + this.getGenere() + ";\n}";
	}
}
