package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.TipoEmpresa;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.TipoEmpresaService;

@RestController
@RequestMapping("/tipoempresa")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class TipoEmpresaController {
	
	@Autowired
	private TipoEmpresaService service;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public GenericResponse<List<TipoEmpresa>> list(){
	    GenericResponse<List<TipoEmpresa>> response = new GenericResponse<>();

	    try {
	        List<TipoEmpresa> all = service.listar();
	        
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
	public GenericResponse<TipoEmpresa> create(@RequestBody TipoEmpresa request){
	    GenericResponse<TipoEmpresa> response = new GenericResponse<>();

	    try {
	        TipoEmpresa tipEmp = service.crear(request);
	        
	        response.setStatus(1);
	        response.setMessage("Se creo el tipo de empresa de manera satisfactoria.");
	        response.setValue(tipEmp);
	    } catch (Exception e) {
	        response.setStatus(0);
	        response.setMessage("Se presento el siguiente error al crear el tipo de empresa::"+e.getMessage());
	        response.setValue(null);
	    }

	    return response;   
	}
}
