package model;


import jakarta.persistence.*;

@Entity

public class LivretA extends Compte {
	private double taux;

	
	public LivretA() {
		super();
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
