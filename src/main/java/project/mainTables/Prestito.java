package project.mainTables;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prestito {

	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private User utente;
	@ManyToOne
	private Elemento elementoPrestato;
	private LocalDate dataInizioPrestito;
	private LocalDate DataRestituzionePrevista;
	private LocalDate DataRestituzioneEffettiva;

	public Prestito(User utente, Elemento elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {

		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		DataRestituzioneEffettiva = dataRestituzioneEffettiva;
		this.DataRestituzionePrevista = dataInizioPrestito.plusDays(30);
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", dataInizioPrestito=" + dataInizioPrestito + ", DataRestituzionePrevista="
				+ DataRestituzionePrevista + ", DataRestituzioneEffettiva=" + DataRestituzioneEffettiva + "]";
	}

}
