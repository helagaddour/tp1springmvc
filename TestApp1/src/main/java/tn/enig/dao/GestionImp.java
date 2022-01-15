package tn.enig.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tn.enig.model.Projet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.enig.model.Departement;
import tn.enig.model.Employe;
import tn.enig.model.Projet;
@Repository
public class GestionImp implements IGestion {
	  @Autowired
	    @Qualifier("base")
	    DataSource base;

	    public void setData(DataSource base) {
	        this.base = base;
	    }


	    public List<Departement> getAllDepartment() {
	        List<Departement> list = new ArrayList<Departement>();
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from departement");
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	                Departement dep = new Departement();
	                dep.setId(rs.getInt("id"));
	                dep.setNom(rs.getString("nom"));
	                list.add(dep);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public void addProjet(Projet p) {
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement stmt=con.prepareStatement("insert into projet (titre,etat,departement) values (?,?,?)");
	            stmt.setString(1,p.getTitre());
	            stmt.setString(2, p.getEtat());
	            stmt.setInt(3, p.getDepartement().getId());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    
	    public void addEmployee(Employe v) {
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement stmt=con.prepareStatement("insert into employe (nom,fonction,projet,departement) values (?,?,?,?)");

	            stmt.setString(1, v.getNom());
	            stmt.setString(2, v.getFonction());
	            stmt.setInt(3, v.getProjet().getId());
	            stmt.setInt(4, v.getDepartement().getId());
	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public List<Projet> getProjectByID(int id) {
	        List<Projet> list = new ArrayList<Projet>();
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from projet where departement = ?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	                Projet proj = new Projet();
	                proj.setId(rs.getInt("id"));
	                proj.setTitre(rs.getString("titre"));
	                proj.setEtat(rs.getString("etat"));

	                proj.setDepartement(this.getDepartbyID(id));
	                list.add(proj);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    public List<Projet> getAllProjet(){
	        List<Projet> listProjet = new ArrayList<Projet>();
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from projet");
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	                Projet proj = new Projet();
	                proj.setId(rs.getInt("id"));
	                proj.setTitre(rs.getString("titre"));
	                proj.setEtat(rs.getString("etat"));

	                proj.setDepartement(this.getDepartbyID(rs.getInt("departement")));
	                listProjet.add(proj);
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return listProjet;
	    }
	    
	    public List<Employe> getEmployeByID(int id) {
	        List<Employe> list = new ArrayList<Employe>();
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from employe where projet = ?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	                Employe employee = new Employe();
	                employee.setId(rs.getInt("id"));
	                employee.setNom(rs.getString("nom"));
	                employee.setFonction(rs.getString("fonction"));
	                employee.setDepartement(this.getDepartbyID(rs.getInt("departement")));
	                employee.setProjet(this.getProjetbyID(id));
	                list.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    
	    public List<Employe> getEmployeByIDepar(int id) {
	        List<Employe> listEmployes = new ArrayList<Employe>();
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from employe where departement = ?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	                Employe employee = new Employe();
	                employee.setId(rs.getInt("id"));
	                employee.setNom(rs.getString("nom"));
	                employee.setFonction(rs.getString("fonction"));
	                employee.setDepartement(this.getDepartbyID(id));
	                employee.setProjet(this.getProjetbyID(id));

	                listEmployes.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listEmployes;
	    }

	   
	    public Departement getDepartbyID(int id) {
	        Departement dep = null;
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from departement where id = ?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                dep = new Departement();
	                dep.setId(rs.getInt("id"));
	                dep.setNom(rs.getString("nom"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dep;
	    }

	    
	    public Projet getProjetbyID(int id) {
	        Projet projet = null;
	        try {
	            Connection con = base.getConnection();
	            PreparedStatement ps = con.prepareStatement("select * from projet where id = ?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                projet = new Projet();
	                projet.setId(rs.getInt("id"));
	                projet.setTitre(rs.getString("titre"));
	                projet.setEtat(rs.getString("etat"));
	                projet.setDepartement(this.getDepartbyID(rs.getInt("departement")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return projet;
	    }


		


		


	

}
