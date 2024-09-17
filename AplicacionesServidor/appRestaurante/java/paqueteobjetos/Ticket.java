package paqueteobjetos;

public class Ticket {
	int precio_total;
	int[] precios;
	String[] platos;
	public Ticket(int precio_total, int[] precios, String[] platos) {
		super();
		this.precio_total = precio_total;
		this.precios = precios;
		this.platos = platos;
	}
	public int getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}
	public int[] getPrecios() {
		return precios;
	}
	public void setPrecios(int[] precios) {
		this.precios = precios;
	}
	public String[] getPlatos() {
		return platos;
	}
	public void setPlatos(String[] platos) {
		this.platos = platos;
	}
	
	public void calcularTotal()
	{
		this.precio_total=0;
		for(int i=0; i<precios.length; i++)
		{
			this.precio_total+=precios[i];
		}
	}
	
}
