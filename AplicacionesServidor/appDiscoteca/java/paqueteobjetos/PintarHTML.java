package paqueteobjetos;

import java.util.ArrayList;

public class PintarHTML {
	
	public static String opcionEntradas(int entradas_actuales, int aforo_actual) 
	{
		String nombre="entradas";
		int entradas_totales = 4;
		int entradas_restantes = entradas_totales-entradas_actuales;
		if(entradas_restantes==0) 
		{
			return("Lo siento, el ya dispone del número máximo de entradas por usuario: " + entradas_actuales);
		}
		else 
		{
			String combo="<select name="+nombre+">";
			for(int i=1; i<=entradas_restantes && i<=aforo_actual; i++) 
			{
				combo+="\n<option value="+i+">"+i+"</option>";
			}
			combo+="\n</select>";
			return combo;
		}
		
	}
	
	public static String crearTabla(ArrayList<Reserva> lista_reservas) 
	{
		int total_entradas=0;
		String tabla="<table class='tabla_reservas'>";
		tabla+="<tr><th>CLIENTE</th><th>FECHA</th><th>ENTRADAS</th></tr>";
		Reserva r=null;;
		for(int i=0; i<lista_reservas.size(); i++) 
		{
			r=lista_reservas.get(i);
			tabla+="<tr><td>"+r.getUsuario()+"</td>";
			tabla+="<td>"+r.getFecha()+"</td>";
			tabla+="<td>"+r.getEntradas()+"</td>";
			total_entradas+=r.getEntradas();
		}
		tabla+="</tr>";
		tabla+="<tr><td colspan='2'><b>ENTRADAS TOTALES</b></td><td>"+total_entradas+"</td></tr>";
		tabla+="</table>";
		return tabla;
	}
}
