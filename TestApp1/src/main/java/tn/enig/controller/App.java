
package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tn.enig.model.Projet;
import tn.enig.dao.GestionImp;
import tn.enig.model.Departement;
import tn.enig.model.Employe;


@Controller
public class App {

	@Autowired
	GestionImp dao;
	
	public void setService(GestionImp dao) {
		this.dao = dao;
	}
	
	@GetMapping("/home")
	public String getAllDepartment(Model m) {
		List<Departement> liste= dao.getAllDepartment();
		m.addAttribute("liste",liste);
		return "home";		
	}
	@RequestMapping(value = "/employes/proj/{num}", method = RequestMethod.GET)
	public String getProjetByDeparID(Model m, @PathVariable("num") int num) {
		List<Employe>list=dao.getEmployeByID(num);
		m.addAttribute("list",list);
		return "/employebypr";

	}
	@RequestMapping(value = "/employes/dept/{num}", method = RequestMethod.GET)
	public String getemployeeByDeparID(Model m, @PathVariable("num") int num) {
		List<Employe>list=dao.getEmployeByIDepar(num);
		m.addAttribute("list",list);
		return "/employe";

	}
	@RequestMapping(value = "/projets/{num}", method = RequestMethod.GET)
	public String getProjetsByID(Model m, @PathVariable("num") int num) {
		List<Projet>list=dao.getProjectByID(num);
		m.addAttribute("list",list);
		return "/projet";

	}
	@RequestMapping(value="/ajoutProjet", method = RequestMethod.GET)
	public String addProjet(Model model) {
		Projet projet = new Projet() ;
		List<Departement> listD = dao.getAllDepartment();
		model.addAttribute("projet", projet);
		model.addAttribute("departement", listD);
		return ("addprojet");
	}
	@RequestMapping(value="/saveProjet", method = RequestMethod.POST)
	public String saveProjet(Model model, @ModelAttribute("projet") Projet p) {
		dao.addProjet(p);
		return ("redirect:/home");
	}
	@RequestMapping(value="/ajoutEmploye", method = RequestMethod.GET)
	public String addEmploye(Model model) {
		Employe employee = new Employe();
		List<Departement> listd = dao.getAllDepartment();
		List<Projet> listp = dao.getAllProjet();
		model.addAttribute("projet", listp);
		model.addAttribute("departement", listd);
		model.addAttribute("employe", employee);
		return ("addemploye");
	}
	@RequestMapping(value="saveEmploye", method = RequestMethod.POST)
	public String saveEmploye(Model model, @ModelAttribute("employe") Employe e) {
		dao.addEmployee(e);
		return ("redirect:/home");
	}
	}
