package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.trasportes.web.ms.rest.modelo.Departamento;
import co.com.trasportes.web.ms.rest.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public List<Departamento> listarDepartamento(){
		return (List<Departamento>) repository.findAll();
	}
	
	public Departamento crearDepartamento(Departamento departamento) {
		return repository.save(departamento);
	}
}
