package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Ciudad;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.CiudadService;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class CiudadController {
	
	@Autowired
	private CiudadService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET )
	public GenericResponse<List<Ciudad>> listCiudad(){
		
		GenericResponse<List<Ciudad>> response = new GenericResponse<>();

		try {
		    List<Ciudad> all = service.listarCiudades();
		    
		    response.setStatus(1);
		    response.setMessage("Consulta realizada satisfactoriamente.");
		    response.setValue(all);
		} catch (Exception e) {
		    response.setStatus(0);
		    response.setMessage("No se encontraron ciudades::"+e.getMessage());
		    response.setValue(null);
		}

		return response;
		
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public GenericResponse<Ciudad> createCiudad(@RequestBody Ciudad request){
		
		GenericResponse<Ciudad> response = new GenericResponse<>();

		try {
		    Ciudad ciudad = service.crearCiudad(request);
		    
		    response.setStatus(1);
		    response.setMessage("Se creo la ciudad de manera satisfactoria.");
		    response.setValue(ciudad);
		} catch (Exception e) {
		    response.setStatus(0);
		    response.setMessage("Se presento el siguiente error al crear la ciudad::"+e.getMessage());
		    response.setValue(null);
		}

		return response;
		
	}
}
