package tn.enig.model;


public class Departement {
	int id ;
	String nom ;

	public Departement(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
                                
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Departement() {
		super();
	}
	
	

}
