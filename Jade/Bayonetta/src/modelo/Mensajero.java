package modelo;

public class Mensajero {
	private String idPaquete;
	private Paquete pack = new Paquete();
	
	public Mensajero(String idPaquete, Paquete pack) {
		super();
		this.idPaquete = idPaquete;
		this.pack = pack;
	}

	public Paquete getPack() {
		return pack;
	}

	public void setPack(Paquete pack) {
		this.pack = pack;
	}

	public String getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	
}
