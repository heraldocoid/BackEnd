package co.com.trasportes.web.ms.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.trasportes.web.ms.rest.exception.ResourceNotFoundException;
import co.com.trasportes.web.ms.rest.modelo.Representante;
import co.com.trasportes.web.ms.rest.repository.CiudadRepository;
import co.com.trasportes.web.ms.rest.repository.DepartamentoRepository;
import co.com.trasportes.web.ms.rest.repository.PaisRepository;
import co.com.trasportes.web.ms.rest.repository.RepresentanteRepository;
import co.com.trasportes.web.ms.rest.repository.TipoDocumentoRepository;

@Service
public class RepresentanteService {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private RepresentanteRepository repository;
	
	public List<Representante> listarRepresentantes(){
		return (List<Representante>) repository.findAll();
	}
	
	public Representante crearRepresentante(int idTipo, int idpais, int ciudad, int departamento, Representante representante) {
		return tipoDocumentoRepository.findById(idTipo).map(tipdoc->{
			return paisRepository.findById(idpais).map(pa->{
				return departamentoRepository.findById(departamento).map(dep -> {
					return ciudadRepository.findById(ciudad).map(ciu->{
						representante.setTipoDocumento(tipdoc);
						representante.setPais(pa);
						representante.setDepartamento(dep);
						representante.setCiudad(ciu);
						return repository.save(representante);
					}).orElseThrow(() -> new ResourceNotFoundException("Ciudad " + representante.getCiudad().getCiudad() + " no encontrado"));
					
				}).orElseThrow(() -> new ResourceNotFoundException("Departamento " + representante.getDepartamento().getDepartamento() + " no encontrado"));
				
			}).orElseThrow(() -> new ResourceNotFoundException("Pais " + representante.getPais().getPais() + " no encontrado"));
			
		}).orElseThrow(() -> new ResourceNotFoundException("Tipo de documento " + representante.getTipoDocumento().getTipoDocumento() + " no encontrado"));
	}
}
