package tn.enig.dao;



import java.util.List;

import tn.enig.model.*;

public interface IGestion {
	public List<Departement> getAllDepartment();
	public void addProjet(Projet c);
	public void addEmployee(Employe v);
	public List<Projet> getProjectByID(int id);
	public List<Employe> getEmployeByID(int id);
	public List<Employe> getEmployeByIDepar(int id);
    public Departement getDepartbyID(int id);
	public Projet getProjetbyID(int id);
	public List<Projet> getAllProjet();

}
