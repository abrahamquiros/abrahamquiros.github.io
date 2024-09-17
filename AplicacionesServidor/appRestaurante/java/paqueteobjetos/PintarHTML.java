package paqueteobjetos;

import java.util.ArrayList;

public class PintarHTML {
	public static String opcionMesa() 
	{
		String nombre="mesa";
		String combo="<select name="+nombre+">";
		for(int i=1; i<7; i++) 
		{
			combo+="\n<option value="+i+">"+i+"</option>";
		}
		combo+="\n</select>";
		return combo;
	}
	
	public static String crearOpcion(int indice, ArrayList<Plato> lista_platos) 
	{
		String nombre="plato_"+indice;
		String combo="<select name="+nombre+">";
		for(int i=0; i<lista_platos.size(); i++) 
		{
			Plato p=lista_platos.get(i);
			combo+="\n<option value="+p.getId()+">"+p.getNombre()+" ("+p.getPrecio()+ "€)"+"</option>";
		}
		
		combo+="\n</select>";
		return combo;
	}
	
	public static String crearTabla(ArrayList<Plato> lista) 
	{
		String tabla="<table class='tabla_platos'><tr><th>NOMBRE</th><th>PRECIO</th><th>BORRAR</th></tr>";
		for(int i=0; i<lista.size(); i++) 
		{
			Plato p=lista.get(i);
			tabla+="<tr><td>"+p.getNombre()+"</td><td>"+p.getPrecio()+"</td>"
			+ "<td><a href='Servlet?accion=borrarPlato&id="+p.getId()+"'><img src='./img/basura.png' width='20px'></a></td></tr>";
			/*+ "<td><form action='Servlet' method='post'>"
			+ "<input type='hidden' name='accion' value='borrarPlato'>"
			+ "<input type='hidden' name='id' value='"+p.getId()+"'>"
			+ "<input type='submit' value='Borrar plato'>"
			+ "</form></td></tr>";*/
		}
		tabla+="</table>";
		return tabla;
	}
	
	public static String crearTablaPedidos(ArrayList<Pedido> lista) 
	{
		String tabla="<table class='tabla_pedido'><tr><th>MESA</th><th>PRIMERO</th><th>SEGUNDO</th><th>POSTRE</th><th>OBSERVACIONES</th>"
					+ "<th>FECHA PEDIDO</th><th>PREPARADO</th><th>FECHA PEDIDO REALIZADO</th><th>PEDIDO REALIZADO</th></tr>";
		for(int i=0; i<lista.size(); i++) 
		{
			Pedido p=lista.get(i);
			tabla+="<tr><td>"+p.getMesa()+"</td><td>"+p.getPlato_1()+"</td><td>"+p.getPlato_2()+"</td><td>"+p.getPlato_3()+"</td>"
					+ "<td>"+p.getObservaciones()+"</td><td>"+p.getFecha_inicio()+"</td><td>"+p.getPreparado()+"</td><td>"+p.getFecha_fin()+"</td>"
					+ "<td><a href='Servlet?accion=realizarPedido&id="+p.getId()+"'><img src='./img/check.png' width='20px'></a></td></tr>";
		}
		tabla+="</table>";
		return tabla;
	}
	
	public static String crearTablaPedidosRealizados(ArrayList<Pedido> lista) 
	{
		String tabla="<table class='tabla_pedido'><tr><th>MESA</th><th>PRIMERO</th><th>SEGUNDO</th><th>POSTRE</th><th>FECHA PEDIDO</th>"
					+ "<th>PREPARADO</th><th>FECHA PEDIDO REALIZADO</th></tr>";
		for(int i=0; i<lista.size(); i++) 
		{
			Pedido p=lista.get(i);
			tabla+="<tr><td>"+p.getMesa()+"</td><td>"+p.getPlato_1()+"</td><td>"+p.getPlato_2()+"</td><td>"+p.getPlato_3()+"</td>"
					+ "<td>"+p.getFecha_inicio()+"</td><td>"+p.getPreparado()+"</td><td>"+p.getFecha_fin()+"</td></tr>";				
		}
		tabla+="</table>";
		return tabla;
	}
}
