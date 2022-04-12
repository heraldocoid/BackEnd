package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.modelo.Ciudad;
import co.com.trasportes.web.ms.rest.repository.CiudadRepository;

@Service
public class CiudadService {
	
	@Autowired
	private CiudadRepository repository;
	
	public List<Ciudad> listarCiudades() {
		return (List<Ciudad>)repository.findAll();
	}
	
	public Ciudad crearCiudad(Ciudad ciudad) {
		return repository.save(ciudad);
	}
}
