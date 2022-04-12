package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Pais;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.PaisService;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class PaisController {
	
	@Autowired
	private PaisService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public GenericResponse<List<Pais>> list(){
	    GenericResponse<List<Pais>> response = new GenericResponse<>();

	    try {
	        List<Pais> all = service.listar();
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada satisfactoriamente.");
	        response.setValue(all);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron paises::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public GenericResponse<Pais> create(@RequestBody Pais request){
	    GenericResponse<Pais> response = new GenericResponse<>();

	    try {
	        Pais pais = service.crear(request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo el pais de manera satisfactoria.");
	        response.setValue(pais);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente error al crear el pais::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
}
