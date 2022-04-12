package co.com.trasportes.web.ms.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.trasportes.web.ms.rest.modelo.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer>{

}
