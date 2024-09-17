package paqueteobjetos;

public class Pedido {
	int id, mesa;
	String plato_1, plato_2, plato_3, observaciones, fecha_inicio, preparado, fecha_fin;
	
	
	public Pedido(int id, int mesa, String plato_1, String plato_2, String plato_3, String observaciones,
			String fecha_inicio, String preparado, String fecha_fin) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.plato_1 = plato_1;
		this.plato_2 = plato_2;
		this.plato_3 = plato_3;
		this.observaciones = observaciones;
		this.fecha_inicio = fecha_inicio;
		this.preparado = preparado;
		this.fecha_fin = fecha_fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public String getPlato_1() {
		return plato_1;
	}

	public void setPlato_1(String plato_1) {
		this.plato_1 = plato_1;
	}

	public String getPlato_2() {
		return plato_2;
	}

	public void setPlato_2(String plato_2) {
		this.plato_2 = plato_2;
	}


	public String getPlato_3() {
		return plato_3;
	}

	public void setPlato_3(String plato_3) {
		this.plato_3 = plato_3;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getPreparado() {
		return preparado;
	}

	public void setPreparado(String preparado) {
		this.preparado = preparado;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", mesa=" + mesa + ", plato_1=" + plato_1 + ", plato_2=" + plato_2 + ", plato_3="
				+ plato_3 + ", observaciones=" + observaciones + ", fecha_inicio=" + fecha_inicio + ", preparado="
				+ preparado + ", fecha_fin=" + fecha_fin + "]";
	}

	public String toCSV() {
		String csv=fecha_inicio+","+fecha_fin+","+mesa+","+plato_1+","+plato_2+","+plato_3+","+observaciones+",";
		csv=csv.substring(0, csv.length()-1);
		csv+="\n";
		return csv;
	}
	
	
}
