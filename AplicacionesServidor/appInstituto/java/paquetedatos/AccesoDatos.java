package paquetedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paqueteobjetos.Alumno;
import paqueteobjetos.Curso;
import paqueteobjetos.Titulacion;

public class AccesoDatos {
	private static Connection c=null;
	private static void createConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto?user=root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Titulacion> getTitulaciones() {
		createConnection();
		ArrayList<Titulacion> lista_titulaciones=new ArrayList<Titulacion>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM titulacion");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				Titulacion t=new Titulacion(id, nombre);
				lista_titulaciones.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_titulaciones;
	}
	
	public static ArrayList<Curso> getCursos() {
		createConnection();
		ArrayList<Curso> lista_cursos=new ArrayList<Curso>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM curso");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int valor=rs.getInt("valor");
				Curso c=new Curso(id, valor);
				lista_cursos.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_cursos;
	}

	public static void registrarAlumno(Alumno a) {
		// TODO Auto-generated method stub
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO alumno (nombre, titulacion, "
					+ "curso) "
					+ "VALUES(?,?,?)");
			pstmt.setString(1, a.getNombre());
			pstmt.setString(2, a.getTitulacion());
			pstmt.setInt(3, a.getCurso());
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static ArrayList<Alumno> recuperarAlumnos() {
		ArrayList<Alumno> lista_alumnos=new ArrayList<Alumno>();
		String sql="SELECT a.id, a.nombre, t.nombre, a.curso FROM alumno AS a "			
				+ "INNER JOIN titulacion AS t ON t.id=a.titulacion";
		createConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) 
			{
				int id=rs.getInt("a.id");
				String nombre=rs.getString("a.nombre");
				String titulacion=rs.getString("t.nombre");
				int curso=rs.getInt("a.curso");
				
				Alumno a=new Alumno(id, curso, nombre, titulacion);
				lista_alumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_alumnos;
	}

	public static ArrayList<Alumno> recuperarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> lista_alumnos=new ArrayList<Alumno>();
		String sql="SELECT a.id, a.nombre, t.nombre, a.curso FROM alumno AS a "			
				+ "INNER JOIN titulacion AS t ON t.id=a.titulacion WHERE t.nombre=?";
		createConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, titulo);  
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) 
			{
				int id=rs.getInt("a.id");
				String nombre=rs.getString("a.nombre");
				String titulacion=rs.getString("t.nombre");
				int curso=rs.getInt("a.curso");
				
				Alumno a=new Alumno(id, curso, nombre, titulacion);
				lista_alumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_alumnos;
	}

}
