package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.exception.ResourceNotFoundException;
import co.com.trasportes.web.ms.rest.modelo.Empresa;
import co.com.trasportes.web.ms.rest.repository.CiudadRepository;
import co.com.trasportes.web.ms.rest.repository.DepartamentoRepository;
import co.com.trasportes.web.ms.rest.repository.EmpresaRepository;
import co.com.trasportes.web.ms.rest.repository.PaisRepository;
import co.com.trasportes.web.ms.rest.repository.RepresentanteRepository;
import co.com.trasportes.web.ms.rest.repository.TipoDocumentoRepository;
import co.com.trasportes.web.ms.rest.repository.TipoEmpresaRepository;

@Service
public class EmpresaService {
	

	@Autowired
	private TipoEmpresaRepository tipoEmpresaRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private RepresentanteRepository representanteRepository;
	
	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> listarEmpresa(){
		return (List<Empresa>) repository.findAll();
	}
	
	public Empresa crearEmpresa(int idEmp, int idpais, int ciudad, int departamento, int represtante, Empresa empresa) {
		return tipoEmpresaRepository.findById(idEmp).map(tipEmp->{
			
			return paisRepository.findById(idpais).map(pa->{
				
		        return departamentoRepository.findById(departamento).map(dep -> {
		        	
		            return ciudadRepository.findById(ciudad).map(ciu->{
		            	
		            	return representanteRepository.findById(represtante).map(repre->{
		            		
		            		empresa.setTipoEmpresa(tipEmp);
		            		empresa.setPais(pa);
		            		empresa.setDepartamento(dep);
		            		empresa.setCiudad(ciu);
		            		empresa.setRepresentante(repre);
			    			return repository.save(empresa);
			    			
		            	}).orElseThrow(() -> new ResourceNotFoundException("Representante " + empresa.getRepresentante().getNombre() + " no encontrado"));
		            	
		            }).orElseThrow(() -> new ResourceNotFoundException("Ciudad " + empresa.getCiudad().getCiudad() + " no encontrado"));
		            
		        }).orElseThrow(() -> new ResourceNotFoundException("Departamento " + empresa.getDepartamento().getDepartamento() + " no encontrado"));
		        
		    }).orElseThrow(() -> new ResourceNotFoundException("Pais " + empresa.getPais().getPais() + " no encontrado"));
			
			
		}).orElseThrow(()-> new ResourceNotFoundException("Tipo empresa" + empresa.getTipoEmpresa().getTipoEmpresa() + "no encontrada"));
	}
}
