package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Representante;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.RepresentanteService;

@RestController
@RequestMapping("/representante")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class RepresentanteController {
	
	@Autowired
	private RepresentanteService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public GenericResponse<List<Representante>> listRepresentante(){
		GenericResponse<List<Representante>> response = new GenericResponse<>();
		
		try {
			List<Representante> allRepre = service.listarRepresentantes();
			
			response.setStatus(1);
			response.setMessage("Consulta realizada satisfactoriamente.");
			response.setValue(allRepre);
		} catch (Exception e) {
			response.setStatus(0);
			response.setMessage("No se encontraron datos de representantes::"+e.getMessage());
			response.setValue(null);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/tipoDocumento/{idTipoDoc}/pais/{idPais}/departamento/{idDepartamento}/ciudad/{idCiudad}/representante", method = RequestMethod.POST)
	public GenericResponse<Representante> createRepresentante(@PathVariable("idTipoDoc") int idTipo, @PathVariable ("idPais") int pais, 
			@PathVariable ("idCiudad") int ciudad, @PathVariable ("idDepartamento") int departamento, @RequestBody Representante request){
		GenericResponse<Representante> response = new GenericResponse<>();
			
		try {		
			Representante repre = service.crearRepresentante(idTipo, pais, ciudad, departamento, request);
			
			response.setStatus(1);
			response.setMessage("Se creo el representante de manera satisfactoria.");
			response.setValue(repre);
		}catch (Exception e) {
			response.setStatus(0);
			response.setMessage("Se presento el siguiente error al crear el representante::"+e.getMessage());
			response.setValue(null);
		}

		return response;
	}
}
