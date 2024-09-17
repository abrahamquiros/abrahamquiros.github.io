package paqueteobjetos;

public class Reserva {
	int id, entradas;
	String usuario, fecha;
	
	public Reserva(int id, int entradas, String usuario, String fecha) {
		super();
		this.id = id;
		this.entradas = entradas;
		this.usuario = usuario;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEntradas() {
		return entradas;
	}
	
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
}
