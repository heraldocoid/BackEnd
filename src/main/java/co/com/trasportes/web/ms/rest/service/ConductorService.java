package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.exception.ResourceNotFoundException;
import co.com.trasportes.web.ms.rest.modelo.Conductor;
import co.com.trasportes.web.ms.rest.modelo.TipoDocumento;
import co.com.trasportes.web.ms.rest.repository.CiudadRepository;
import co.com.trasportes.web.ms.rest.repository.ConductorRepository;
import co.com.trasportes.web.ms.rest.repository.DepartamentoRepository;
import co.com.trasportes.web.ms.rest.repository.PaisRepository;
import co.com.trasportes.web.ms.rest.repository.TipoDocumentoRepository;

@Service
public class ConductorService {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private ConductorRepository repository;
	
	public List<Conductor> listarConductor(){
		return ( List<Conductor> )repository.findAll();
	}
	
	public Conductor crearConductor(int idTipo, int idpais, int ciudad, int departamento, Conductor conductor) {
		return tipoDocumentoRepository.findById(idTipo).map(tipdoc->{
		    return paisRepository.findById(idpais).map(pa->{
		        return departamentoRepository.findById(departamento).map(dep -> {
		            return ciudadRepository.findById(ciudad).map(ciu->{
		            	conductor.setTipoDocumento(tipdoc);
		            	conductor.setPais(pa);
		            	conductor.setDepartamento(dep);
		            	conductor.setCiudad(ciu);
		            	return repository.save(conductor);
		            }).orElseThrow(() -> new ResourceNotFoundException("Ciudad " + conductor.getCiudad().getCiudad() + " no encontrado"));
		            
		        }).orElseThrow(() -> new ResourceNotFoundException("Departamento " + conductor.getDepartamento().getDepartamento() + " no encontrado"));
		        
		    }).orElseThrow(() -> new ResourceNotFoundException("Pais " + conductor.getPais().getPais() + " no encontrado"));
		    
		}).orElseThrow(() -> new ResourceNotFoundException("Tipo de documento " + conductor.getTipoDocumento().getTipoDocumento() + " no encontrado"));
	}
}
