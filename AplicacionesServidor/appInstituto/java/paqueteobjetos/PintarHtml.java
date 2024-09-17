package paqueteobjetos;

import java.util.ArrayList;

public class PintarHtml {
	public static String opcionTitulo(ArrayList<Titulacion> lista_titulaciones) 
	{
		String nombre="titulacion";
		String combo="<select name="+nombre+">";
		for(int i=0; i<lista_titulaciones.size(); i++) 
		{
			Titulacion t=lista_titulaciones.get(i);
			combo+="\n<option value="+t.getId()+">"+t.getNombre()+"</option>";
		}
		combo+="\n</select>";
		return combo;
	}
	
	public static String opcionCurso(ArrayList<Curso> lista_cursos) 
	{
		String nombre="curso";
		String combo="<select name="+nombre+">";
		for(int i=0; i<lista_cursos.size(); i++) 
		{
			Curso c=lista_cursos.get(i);
			combo+="\n<option value="+c.getId()+">"+c.getValor()+"</option>";
		}
		combo+="\n</select>";
		return combo;
	}
	
	public static String crearTabla(ArrayList<Alumno> lista) 
	{
		String tabla="<table class='tabla_alumnos'><tr><th>NOMBRE</th><th>TITULACÍON</th><th>CURSO</th></tr>";
		for(int i=0; i<lista.size(); i++) 
		{
			Alumno a=lista.get(i);
			tabla+="<tr><td>"+a.getNombre()+"</td><td>"+a.getTitulacion()+"</td><td>"+a.getCurso()+"</td></tr>";
		}
		tabla+="</table>";
		return tabla;
	}
}
