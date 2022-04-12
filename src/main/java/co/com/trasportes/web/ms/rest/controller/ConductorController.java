package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Conductor;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.ConductorService;

@RestController
@RequestMapping("/conductor")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class ConductorController {
	
	@Autowired
	private ConductorService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public GenericResponse<List<Conductor>> listConductor(){
		GenericResponse<List<Conductor>> response = new GenericResponse<>();

		try {
            List<Conductor> all = service.listarConductor();
            
            response.setStatus(1);
            response.setMessage("Se creo el conductor de manera satisfactoria.");
            response.setValue(all);
        } catch (Exception e) {
            response.setStatus(0);
            response.setMessage("No se encontraron datos del conductor::"+e.getMessage());
            response.setValue(null);
        }
		
		return response;
	}
	
	
	@RequestMapping(value = "/tipoDocumento/{idTipoDoc}/pais/{idPais}/departamento/{idDepartamento}/ciudad/{idCiudad}/conductor", method = RequestMethod.POST)
	public GenericResponse<Conductor> createConductor(@PathVariable("idTipoDoc") int idTipo, @PathVariable ("idPais") int pais, 
			@PathVariable ("idCiudad") int ciudad, @PathVariable ("idDepartamento") int departamento, @RequestBody Conductor request){
		GenericResponse<Conductor> response = new GenericResponse<>();
		
		try {
		    Conductor condu = service.crearConductor(idTipo, pais, ciudad, departamento, request);
		    
		    response.setStatus(1);
		    response.setMessage("Se creo el conductor de manera satisfactoria.");
		    response.setValue(condu);
		} catch (Exception e) {
		    response.setStatus(0);
		    response.setMessage("Se presento el siguiente error al crear el conductor::"+e.getMessage());
		    response.setValue(null);
		}
		
		return response;
	}
}
