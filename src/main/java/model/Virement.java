package model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity

public class Virement extends Operation{
	
	private String beneficiaire;

	

	public Virement() {
		super();
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	

}
