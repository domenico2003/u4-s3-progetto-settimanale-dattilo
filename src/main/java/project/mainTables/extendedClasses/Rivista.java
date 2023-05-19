package project.mainTables.extendedClasses;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mainTables.Elemento;
import project.mainTables.enums.Periodicita;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Rivista extends Elemento {
	@Enumerated(EnumType.STRING)
	Periodicita periodicita;

	public Rivista(String titolo, int i, int pagine, Periodicita periodi) {
		super(titolo, i, pagine);
		this.periodicita = periodi;
	}

//	public Rivista(String titolo, int i, int pagine, Periodicita periodi, String ISBN) {
//		super(titolo, i, pagine, ISBN);
//		this.periodicita = periodi;
//	}

	@Override
	public String toString() {
		return "{\n ISBN: " + this.getISBN() + ";\n titolo: " + this.getTitolo() + ";\n anno di publicazione: "
				+ this.getAnnoPublicazione() + ";\n numero pagine: " + this.getNPagine() + ";\n periodicita: "
				+ this.periodicita + ";\n}";
	}
}
