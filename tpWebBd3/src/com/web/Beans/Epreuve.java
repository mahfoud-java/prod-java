package com.web.Beans;

public class Epreuve {

	private Long id;
	private Long annee;
	private char typeEpreuve;
	private Long idTournoi;
	
	private Tournoi tournoi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnnee() {
		return annee;
	}

	public void setAnnee(Long annee) {
		this.annee = annee;
	}

	public char getTypeEpreuve() {
		return typeEpreuve;
	}

	public void setTypeEpreuve(char typeEpreuve) {
		this.typeEpreuve = typeEpreuve;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public Long getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(Long idTournoi) {
		this.idTournoi = idTournoi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((idTournoi == null) ? 0 : idTournoi.hashCode());
		result = prime * result + ((tournoi == null) ? 0 : tournoi.hashCode());
		result = prime * result + typeEpreuve;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epreuve other = (Epreuve) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (idTournoi == null) {
			if (other.idTournoi != null)
				return false;
		} else if (!idTournoi.equals(other.idTournoi))
			return false;
		if (tournoi == null) {
			if (other.tournoi != null)
				return false;
		} else if (!tournoi.equals(other.tournoi))
			return false;
		if (typeEpreuve != other.typeEpreuve)
			return false;
		return true;
	}


	
	
	

	
}
