package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.modelo.TipoEmpresa;
import co.com.trasportes.web.ms.rest.repository.TipoEmpresaRepository;

@Service
public class TipoEmpresaService {
	
	@Autowired
	private TipoEmpresaRepository repository;
	
	public List<TipoEmpresa> listar(){
	    return (List<TipoEmpresa>) repository.findAll();
	}

	public TipoEmpresa crear(TipoEmpresa tipoEmpresa) {
	    return repository.save(tipoEmpresa);
	}
}
