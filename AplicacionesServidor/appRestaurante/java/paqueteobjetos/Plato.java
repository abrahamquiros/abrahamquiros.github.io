package paqueteobjetos;

public class Plato {
	int id, precio, tipo;
	String nombre;
	
	public Plato(int id, int precio, int tipo, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
