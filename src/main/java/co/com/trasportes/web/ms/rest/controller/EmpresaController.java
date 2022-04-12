package co.com.trasportes.web.ms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.trasportes.web.ms.rest.modelo.Empresa;
import co.com.trasportes.web.ms.rest.response.GenericResponse;
import co.com.trasportes.web.ms.rest.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST,RequestMethod.GET})
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public GenericResponse<List<Empresa>> listEmpresa(){
		GenericResponse<List<Empresa>> response = new GenericResponse<>();
		try {
		    List<Empresa> all = service.listarEmpresa();
		    
		    response.setStatus(1);
		    response.setMessage("Consulta realizada satisfactoriamente.");
		    response.setValue(all);
		} catch (Exception e) {
		    response.setStatus(0);
		    response.setMessage("Se presento el siguiente error al listar la empresa::"+e.getMessage());
		    response.setValue(null);
		}
		return response;
	}
	
	@RequestMapping(value = "/tipoEmpresa/{idTipoEmp}/pais/{idPais}/departamento/{idDepartamento}/ciudad/{idCiudad}/representante/{idRepe}/crear", method = RequestMethod.POST)
	public GenericResponse<Empresa> createEmpresa(@PathVariable("idTipoEmp") int idTip, @PathVariable ("idPais") int pais, 
			@PathVariable ("idCiudad") int ciud, @PathVariable ("idDepartamento") int depa, @PathVariable ("idRepe") int repre, 
			@RequestBody Empresa empresa){
		GenericResponse<Empresa> response = new GenericResponse<>();
		
		try {
		    Empresa emp = service.crearEmpresa(idTip, pais, ciud, depa, repre, empresa);
		    
		    response.setStatus(1);
		    response.setMessage("Se creo la empresa de manera satisfactoria.");
		    response.setValue(emp);
		} catch (Exception e) {
		    response.setStatus(0);
		    response.setMessage("Se presento el siguiente error al crear la empresa::"+e.getMessage());
		    response.setValue(null);
		}
		
		return response;
	}
}
