package model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity


public class AssuranceVie extends Compte{
	private LocalDate dateFin;
	private double taux;
	
	
	public AssuranceVie() {
		super();
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	

}
