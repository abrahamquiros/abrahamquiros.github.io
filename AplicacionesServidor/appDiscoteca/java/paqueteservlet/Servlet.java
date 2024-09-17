package paqueteservlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquetedatos.AccesoDatos;
import paqueteobjetos.Reserva;

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
		String accion=request.getParameter("accion");
		switch(accion) 
		{
		case "login":
			gestionarLogin(request, response);
			break;
		case "crearReserva":
			crearReserva(request, response);
			break;
		case "importar":
			importarUsuarios(request, response);
			break;
		default:
			break;
		}
	}

	private void importarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		AccesoDatos.importarCSV();		
	}

	private void crearReserva(HttpServletRequest request, HttpServletResponse response) {
		Reserva r=null;
		String usuario=request.getParameter("usuario");
		String entradas=request.getParameter("entradas");
		int entradas_int=Integer.parseInt(entradas);
		
		LocalDateTime l=LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anio=l.getYear();
		int hora = l.getHour();
		int minutos = l.getMinute();
		String fecha=dia+"/"+mes+"/"+anio+"/"+hora+"h/"+minutos+"m";
		
		boolean existeRegistro=AccesoDatos.existeRegistro(usuario);
		if(existeRegistro) 
		{
			AccesoDatos.actualizarEntradas(usuario, entradas_int);
		}
		else 
		{
			// Reserva(int id, int entradas, String usuario, String fecha)
			r=new Reserva(0, entradas_int, usuario, fecha);
			AccesoDatos.grabarReserva(r);
		}
		
	}

	private void gestionarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		String rol=AccesoDatos.checkUser(usuario, password);
		
		if(rol==null) 
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		if(rol.equals("1")) 
		{
			request.setAttribute("master", "OK");
			ArrayList<Reserva> lista_reservas=AccesoDatos.getReservas();
			request.setAttribute("lista_reservas", lista_reservas);
			request.getRequestDispatcher("mostrarreserva.jsp").forward(request, response);
		}
		else if(rol.equals("0")) 
		{
			request.setAttribute("usuario", usuario);
			int entradasPorNombre=AccesoDatos.getEntradasByName(usuario);
			System.out.println("Entradas de "+usuario+": "+ entradasPorNombre);
			request.setAttribute("entradasPorNombre", entradasPorNombre);
			int entradasDisponibles=AccesoDatos.entradasDisponibles();
			System.out.println("Entradas Disponibles: "+ entradasDisponibles);
			request.setAttribute("entradasDisponibles", entradasDisponibles);
			request.getRequestDispatcher("hacerreserva.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
