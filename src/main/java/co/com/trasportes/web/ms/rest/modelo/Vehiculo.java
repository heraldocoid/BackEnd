package co.com.trasportes.web.ms.rest.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="motor")
	private String motor;
	
	@Column(name="chasis")
	private String chasis;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="fecha_matricula")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fechaMatricula;
	
	@Column(name="pie")
	private int pie;
	
	@Column(name="sentado")
	private int sentado;
	
	@Column(name="peso_seco")
	private int pesoSeco;
	
	@Column(name="peso_bruto")
	private int pesoBruto;
	
	@Column(name="puertas")
	private int puertas;
	
	@ManyToOne
	@JoinColumn(name="marca", referencedColumnName = "id")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name="linea", referencedColumnName = "id")
	private Linea linea;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public int getPie() {
		return pie;
	}

	public void setPie(int pie) {
		this.pie = pie;
	}

	public int getSentado() {
		return sentado;
	}

	public void setSentado(int sentado) {
		this.sentado = sentado;
	}

	public int getPesoSeco() {
		return pesoSeco;
	}

	public void setPesoSeco(int pesoSeco) {
		this.pesoSeco = pesoSeco;
	}

	public int getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(int pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	
}
