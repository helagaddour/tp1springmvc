package tn.enig.model;

public class Projet {
	    int id;
	    String titre;
	    String etat;
	    Departement departement;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public Departement getDepartement() {
			return departement;
		}
		public void setDepartement(Departement departement) {
			this.departement = departement;
		}
		@Override
		public String toString() {
			return "Projet [id=" + id + ", titre=" + titre + ", etat=" + etat + ", departement=" + departement + "]";
		}
		public Projet(int id, String titre, String etat, Departement departement) {
			super();
			this.id = id;
			this.titre = titre;
			this.etat = etat;
			this.departement = departement;
		}
		public Projet() {
			super();
		}
	    
	

}
