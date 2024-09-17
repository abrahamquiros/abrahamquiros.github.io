package paqueteservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquetedatos.AccesoDatos;
import paqueteobjetos.*;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("Antes de obtener las titulaciones");
		ArrayList<Titulacion> lista_titulaciones=AccesoDatos.getTitulaciones();
		System.out.println("Después de obtener las titulaciones: " + lista_titulaciones);
		request.setAttribute("lista_titulaciones", lista_titulaciones);
		
		ArrayList<Curso> lista_cursos=AccesoDatos.getCursos();
		request.setAttribute("lista_cursos", lista_cursos);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);*/
		
		String accion=request.getParameter("accion");
		if(accion==null) 
		{
			mostrarRegistro(request, response);
			
		}
		else if(accion.equals("crearalumno")) 
		{
			registroAlumno(request, response);
			
		}
		else if(accion.equals("veralumnos")) 
		{
			mostrarAlumnos(request, response);
		}
		else if(accion.equals("filtrarAlumnos")) 
		{
			mostrarPorTitulo(request, response);
		}
	}

	private void mostrarPorTitulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titulo=request.getParameter("titulo");
		ArrayList<Alumno> lista_alumnos=AccesoDatos.recuperarPorTitulo(titulo);
		request.setAttribute("lista_alumnos", lista_alumnos);
		request.getRequestDispatcher("mostraralumnos.jsp").forward(request, response);
	}

	private void mostrarAlumnos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> lista_alumnos=AccesoDatos.recuperarAlumnos();
		System.out.println("Después de obtener los alumnos: " + lista_alumnos);
		request.setAttribute("lista_alumnos", lista_alumnos);
		try {
			request.getRequestDispatcher("mostraralumnos.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registroAlumno(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Alumno a=null;
		String nombre=request.getParameter("nombre");
		String titulacion=request.getParameter("titulacion");
		String curso=request.getParameter("curso");
		int curso_int=Integer.parseInt(curso);
		
		a=new Alumno(0, curso_int, nombre, titulacion);
		AccesoDatos.registrarAlumno(a);
	};
	
	private void mostrarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Titulacion> lista_titulaciones=AccesoDatos.getTitulaciones();
		System.out.println("Después de obtener las titulaciones: " + lista_titulaciones);
		request.setAttribute("lista_titulaciones", lista_titulaciones);
		
		ArrayList<Curso> lista_cursos=AccesoDatos.getCursos();
		request.setAttribute("lista_cursos", lista_cursos);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
