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
import paqueteobjetos.Pedido;
import paqueteobjetos.Plato;
import paqueteobjetos.Ticket;

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
		if (accion==null) 
		{
		    mostrarPedir(request, response);
		} 
		else 
		{
		    switch(accion) {
		        case "crearPedido":
		        	grabarMostrarPedido(request, response);
		            break;
		        case "realizarPedido":
		        	preparado(request, response);
		            break;
		        case "exportar":
		        	exportarPedidos(request, response);
		            break;
		        case "irLogin":
		        	mostrarLogin(request, response);
		            break;
		        case "login":
		        	gestionarLogin(request, response);
		            break;
		        case "irInsertarPlatos":
		        	mostrarInsertarPlatos(request, response);
		            break;
		        case "crearPlato":
		        	registrarPlato(request, response);
		            break;
		        case "irBorrarPlatos":
		        	mostrarBorrarPlatos(request, response);
		            break;
		        case "borrarPlato":
		        	eliminarPlato(request, response);
		            break;
		        default:
		            // Manejar cualquier otro caso no especificado
		            break;
		    }
		}    
		
	}

	private void exportarPedidos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<Pedido> lista_pedidos=AccesoDatos.getPedidosTotales();
		AccesoDatos.exportarCSV(lista_pedidos);
	}

	private void preparado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String listo_id=request.getParameter("id");
		LocalDateTime l=LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anio=l.getYear();
		int hora = l.getHour();
		String fecha_fin=dia+"/"+mes+"/"+anio+"/"+hora+"h";
		//AccesoDatos.pedidolistoById(listo_id);
		AccesoDatos.actualizarPedidolistoById(listo_id, fecha_fin);
		ArrayList<Pedido> lista_pedidos=AccesoDatos.getPedidos();
		System.out.println("Después de obtener los pedidos realizados: " + lista_pedidos);
		request.setAttribute("lista_pedidos", lista_pedidos);
		request.setAttribute("master", "OK");
		request.getRequestDispatcher("mostrarpedidos.jsp").forward(request, response);
	}

	private void eliminarPlato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String borrar_id=request.getParameter("id");
		AccesoDatos.borrarPlatoById(borrar_id);
		ArrayList<Plato> lista_platos=AccesoDatos.getPlatos();
		request.setAttribute("lista_platos", lista_platos);
		request.setAttribute("master", "OK");
		request.getRequestDispatcher("borrarplatos.jsp").forward(request, response);
	}

	private void mostrarBorrarPlatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Plato> lista_platos=AccesoDatos.getPlatos();
		request.setAttribute("lista_platos", lista_platos);
		request.setAttribute("master", "OK");
		request.getRequestDispatcher("borrarplatos.jsp").forward(request, response);
	}

	private void registrarPlato(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Plato p=null;
		String nombre=request.getParameter("nombre");
		String precio=request.getParameter("precio");
		int precio_int=Integer.parseInt(precio);
		String tipo=request.getParameter("tipo");
		int tipo_int=Integer.parseInt(tipo);
		
		p=new Plato(0, precio_int, tipo_int, nombre);
		AccesoDatos.registrarPlato(p);
	}

	private void mostrarInsertarPlatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("master", "OK");
		request.getRequestDispatcher("insertarplatos.jsp").forward(request, response);
	}

	private void gestionarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		String rol=AccesoDatos.checkUser(usuario, password);
		//rol es null si el usuario no existe
		if(rol==null) 
		{
			ArrayList<Plato> lista_primeros=AccesoDatos.getPrimeros();
			request.setAttribute("lista_primeros", lista_primeros);
			ArrayList<Plato> lista_segundos=AccesoDatos.getSegundos();
			request.setAttribute("lista_segundos", lista_segundos);
			ArrayList<Plato> lista_postres=AccesoDatos.getPostres();
			request.setAttribute("lista_postres", lista_postres);
			request.getRequestDispatcher("insertarpedido.jsp").forward(request, response);
			
		}
		if(rol.equals("cocinero")) 
		{
			request.setAttribute("master", "OK");
			ArrayList<Pedido> lista_pedidos=AccesoDatos.getPedidos();
			System.out.println("Después de obtener los pedidos: " + lista_pedidos);
			request.setAttribute("lista_pedidos", lista_pedidos);
			request.getRequestDispatcher("mostrarpedidos.jsp").forward(request, response);
		}
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("logincocinero.jsp").forward(request, response);
	}

	private void grabarMostrarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pedido p=null;
		Ticket t=null;
		String plato_1=request.getParameter("plato_1");
		String plato_2=request.getParameter("plato_2");
		String plato_3=request.getParameter("plato_3");
		String obs=request.getParameter("observaciones");
		String mesa=request.getParameter("mesa");
		int mesa_int=Integer.parseInt(mesa);
		
		LocalDateTime l=LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anio=l.getYear();
		int hora = l.getHour();
		String fecha_inicio=dia+"/"+mes+"/"+anio+"/"+hora+"h";
		// Pedido(int id, int mesa, String plato_1, String plato_2, String plato_3, String fecha_inicio, String preparado, String fecha_fin)
		p=new Pedido(0, mesa_int, plato_1, plato_2, plato_3, obs, fecha_inicio, "no", "0");
		AccesoDatos.registrarPedido(p);
		
		// Ticket(int precio_total, String plato_1, String plato_2, String plato_3)
		
		
		
		 t=AccesoDatos.getNombrePrecioTotal(plato_1, plato_2, plato_3);
		request.setAttribute("ticket", t);
		request.getRequestDispatcher("verpedido.jsp").forward(request, response);
	}

	private void mostrarPedir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Plato> lista_primeros=AccesoDatos.getPrimeros();
		request.setAttribute("lista_primeros", lista_primeros);
		ArrayList<Plato> lista_segundos=AccesoDatos.getSegundos();
		request.setAttribute("lista_segundos", lista_segundos);
		ArrayList<Plato> lista_postres=AccesoDatos.getPostres();
		request.setAttribute("lista_postres", lista_postres);
		request.getRequestDispatcher("insertarpedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
