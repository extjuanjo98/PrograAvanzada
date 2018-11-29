package modelo;

import java.io.Serializable;

import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class Paquete implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tamanio;
	private String contenido;
	private String emisor;
	private DFAgentDescription receptor;
	private Router rute;
	
	
	public Paquete(int tamanio, String contenido) {
		this.tamanio = tamanio;
		this.contenido = contenido;
		this.emisor = null;
		this.receptor = null;
		this.rute=new Router();
	}
	
	public Paquete(int tamanio, String contenido, String emisor, DFAgentDescription receptor) {
		this.tamanio = tamanio;
		this.contenido = contenido;
		this.emisor = emisor;
		this.receptor = receptor;
		this.rute=null;
	}
	
	public Paquete() {
		// TODO Auto-generated constructor stub
	}

	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public DFAgentDescription getReceptor() {
		return receptor;
	}
	public void setReceptor(DFAgentDescription conexiones) {
		this.receptor = conexiones;
	}

	public Router getRute() {
		return rute;
	}

	public void setRute(Router route) {
		this.rute= route;
	}
	
	
}
