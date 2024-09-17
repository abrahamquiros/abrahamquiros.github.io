package paqueteobjetos;

public class Titulacion {
	@Override
	public String toString() {
		return "Titulacion [id=" + id + ", nombre=" + nombre + "]";
	}

	int id;
	String nombre;
	
	public Titulacion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
