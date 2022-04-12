package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.modelo.Pais;
import co.com.trasportes.web.ms.rest.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository repository;
	
	public List<Pais> listar(){
		return (List<Pais>) repository.findAll();
	}
	
	public Pais crear(Pais pais) {
		return repository.save(pais);
	}
}
