package co.com.trasportes.web.ms.rest.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@ManyToOne
	@JoinColumn(name="tipoEmpresa", referencedColumnName = "id")
	private TipoEmpresa tipoEmpresa;
	
	@Column(name="documento")
	private double documento;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion ;
	
	@ManyToOne
	@JoinColumn(name="ciudad", referencedColumnName = "id")
	private Ciudad ciudad;
	
	@ManyToOne
	@JoinColumn(name="departamento", referencedColumnName = "id")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="pais", referencedColumnName = "id")
	private Pais pais;
	
	@Column(name="telefono")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="reprensentante", referencedColumnName = "id")
	private Representante representante;
	
	public Empresa() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public double getDocumento() {
		return documento;
	}

	public void setDocumento(double documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	
}
