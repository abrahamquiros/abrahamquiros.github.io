package paqueteobjetos;

public class Alumno {
	int id, curso;
	String nombre, titulacion;
	
	public Alumno(int id, int curso, String nombre, String titulacion) {
		super();
		this.id = id;
		this.curso = curso;
		this.nombre = nombre;
		this.titulacion = titulacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", curso=" + curso + ", nombre=" + nombre + ", titulacion=" + titulacion + "]";
	}
	
	
}
