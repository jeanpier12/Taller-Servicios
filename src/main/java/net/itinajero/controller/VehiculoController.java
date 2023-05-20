package net.itinajero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import net.itinajero.model.Vacante;
import net.itinajero.model.Vehiculo;
import net.itinajero.service.IVacantesService;
import net.itinajero.service.IVehiculoService;
@Controller
public class VehiculoController {
	
	  @Autowired
		private IVehiculoService serviceVehiculo;
	
	 // Inyectamos una instancia desde nuestro ApplicationContext
    @Autowired
	private IVacantesService serviceVacantes;

    //Metodo muestra me arroja la paguina del formulario e vahiculo 
	@GetMapping("/createVehiculo/{idVacante}")
	public String mostrarHome(Vehiculo vehiculo, @PathVariable Integer idVacante, Model model) {
		// Traemos el objeto vacantes  atravez de su id para poder mostrar esa informacion en la vista 
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "Vehiculos/formvehiculo";
		
	}
	
	@PostMapping("/VehiculoSave")
	
	public String guardar(Vehiculo vehiculo, @RequestParam("vacante.id") int vacanteId , Model model, RedirectAttributes attributes) {	
		// Asignar el valor de vacanteId a la columna usuario en vehiculo
		 
		  
		// Guadamos el objeto solicitud en la bd
		serviceVehiculo.guardar(vehiculo);
		attributes.addFlashAttribute("msg", "Se guardaron los datos del Vehiculo");
		attributes.addAttribute("id", vacanteId);
			
		return "redirect:/solicitudes/create/{id}";		
	}
	
	
	
	
}
