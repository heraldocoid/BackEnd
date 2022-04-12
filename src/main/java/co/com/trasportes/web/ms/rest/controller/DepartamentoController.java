package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Departamento;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class DepartamentoController {
	
	
	@Autowired
	private DepartamentoService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public GenericResponse<List<Departamento>> list(){
	    GenericResponse<List<Departamento>> response = new GenericResponse<>();

	    try {
	        List<Departamento> all = service.listarDepartamento();
	        
	        response.setStatus(1);
	        response.setMessage("Consulta realizada satisfactoriamente.");
	        response.setValue(all);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("No se encontraron datos de representantes::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public GenericResponse<Departamento> create(@RequestBody Departamento request){
	    GenericResponse<Departamento> response = new GenericResponse<>();

	    try {
	        Departamento depa = service.crearDepartamento(request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo el departamento de manera satisfactoria.");
	        response.setValue(depa);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente error al crear el departamento::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
	
}
