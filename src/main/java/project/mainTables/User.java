package project.mainTables;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String Cognome;
	private LocalDate dataDiNascita;
	private int numeroDiTessera;

	@OneToMany
	private Set<Prestito> prestiti;

	public User(String nome, String cognome, LocalDate dataDiNascita, int numeroDiTessera) {
		this.nome = nome;
		Cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", Cognome=" + Cognome + ", dataDiNascita=" + dataDiNascita
				+ ", numeroDiTessera=" + numeroDiTessera + "]";
	}
}
