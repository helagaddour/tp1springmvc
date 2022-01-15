package tn.enig.model;

public class Employe {
	 private int id;
	    private String nom;
	    private String fonction;
	    private Projet projet;
	    private Departement departement;
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
		public String getFonction() {
			return fonction;
		}
		public void setFonction(String fonction) {
			this.fonction = fonction;
		}
		public Projet getProjet() {
			return projet;
		}
		public void setProjet(Projet projet) {
			this.projet = projet;
		}
		public Departement getDepartement() {
			return departement;
		}
		public void setDepartement(Departement departement) {
			this.departement = departement;
		}
		public Employe(int id, String nom, String fonction, Projet projet, Departement departement) {
			super();
			this.id = id;
			this.nom = nom;
			this.fonction = fonction;
			this.projet = projet;
			this.departement = departement;
		}
		@Override
		public String toString() {
			return "Employe [id=" + id + ", nom=" + nom + ", fonction=" + fonction + ", projet=" + projet
					+ ", departement=" + departement + "]";
		}
		public Employe(int id, String nom, Projet projet) {
			super();
			this.id = id;
			this.nom = nom;
			this.projet = projet;
		}
		public Employe() {
			super();
		}
		public Employe(int id, String nom, Projet projet, Departement departement) {
			super();
			this.id = id;
			this.nom = nom;
			this.projet = projet;
			this.departement = departement;
		}
		public Employe(int id, String nom) {
			super();
			this.id = id;
			this.nom = nom;
		}
	

}
