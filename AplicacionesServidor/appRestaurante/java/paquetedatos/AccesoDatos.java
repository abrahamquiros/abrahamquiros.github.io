package paquetedatos;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paqueteobjetos.Pedido;
import paqueteobjetos.Plato;
import paqueteobjetos.Ticket;

public class AccesoDatos {
	private static Connection c=null;
	private static void createConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_restaurante?user=root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Plato> getPrimeros() {
		createConnection();
		ArrayList<Plato> lista_primeros=new ArrayList<Plato>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_plato WHERE tipo=1");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int precio=rs.getInt("precio");
				int tipo=rs.getInt("tipo");
				String nombre=rs.getString("nombre");
				Plato p=new Plato(id, precio, tipo, nombre);
				lista_primeros.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_primeros;
	}
	
	public static ArrayList<Plato> getSegundos() {
		createConnection();
		ArrayList<Plato> lista_segundos=new ArrayList<Plato>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_plato WHERE tipo=2");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int precio=rs.getInt("precio");
				int tipo=rs.getInt("tipo");
				String nombre=rs.getString("nombre");
				Plato p=new Plato(id, precio, tipo, nombre);
				lista_segundos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_segundos;
	}
	
	public static ArrayList<Plato> getPostres() {
		createConnection();
		ArrayList<Plato> lista_postres=new ArrayList<Plato>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_plato WHERE tipo=3");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int precio=rs.getInt("precio");
				int tipo=rs.getInt("tipo");
				String nombre=rs.getString("nombre");
				Plato p=new Plato(id, precio, tipo, nombre);
				lista_postres.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_postres;
	}
	
	public static String checkUser(String usuario, String password) {
		String rol=null;
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT rol FROM t_cocinero WHERE usuario=? AND password=?");
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) 
			{
				rol=rs.getString("rol");
				return rol;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void registrarPlato(Plato p) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO t_plato (nombre, precio, tipo) "
					+ "VALUES(?,?,?)");
			pstmt.setString(1, p.getNombre());
			pstmt.setInt(2, p.getPrecio());
			pstmt.setInt(3, p.getTipo());
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static ArrayList<Plato> getPlatos() {
		createConnection();
		ArrayList<Plato> lista_platos=new ArrayList<Plato>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_plato");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int precio=rs.getInt("precio");
				int tipo=rs.getInt("tipo");
				String nombre=rs.getString("nombre");
				Plato p=new Plato(id, precio, tipo, nombre);
				lista_platos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_platos;
	}
	
	public static void borrarPlatoById(String borrar_id) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("DELETE FROM t_plato WHERE id=?");
			pstmt.setString(1, borrar_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void registrarPedido(Pedido p) {
		createConnection();
		ArrayList<Pedido> lista_pledidos=new ArrayList<Pedido>();
		try {
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO t_pedido (mesa, plato_1, plato_2, plato_3, obs, fecha_inicio, preparado, fecha_fin) "
					+ "VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, p.getMesa());
			pstmt.setString(2, p.getPlato_1());
			pstmt.setString(3, p.getPlato_2());
			pstmt.setString(4, p.getPlato_3());
			pstmt.setString(5, p.getObservaciones());
			pstmt.setString(6, p.getFecha_inicio());
			pstmt.setString(7, p.getPreparado());
			pstmt.setString(8, p.getFecha_fin());
						
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

	
	public static ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> lista_pedidos=new ArrayList<Pedido>();
		String sql="SELECT id, mesa, obs, fecha_inicio, preparado, fecha_fin,\r\n"			
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_1) AS plato_1_nombre,\r\n"
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_2) AS plato_2_nombre,\r\n"
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_3) AS plato_3_nombre\r\n"
				+ "FROM t_pedido WHERE preparado='no'";	
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int mesa=rs.getInt("mesa");
				String plato_1=rs.getString("plato_1_nombre");
				String plato_2=rs.getString("plato_2_nombre");
				String plato_3=rs.getString("plato_3_nombre");
				String obs=rs.getString("obs");
				String fecha_inicio=rs.getString("fecha_inicio");
				String preparado=rs.getString("preparado");
				String fecha_fin=rs.getString("fecha_fin");
				// Pedido(int id, int mesa, String plato_1, String plato_2, String plato_3, String fecha_inicio, String preparado, String fecha_fin)
				Pedido p=new Pedido(id, mesa, plato_1, plato_2, plato_3, obs, fecha_inicio, preparado, fecha_fin);
				lista_pedidos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_pedidos;
	}
	
	public static void pedidolistoById(String listo_id) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("UPDATE t_pedido SET preparado='si' WHERE id=?");
			pstmt.setString(1, listo_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void actualizarPedidolistoById(String listo_id, String fecha_fin) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("UPDATE t_pedido SET preparado='si', fecha_fin=? WHERE id=?");
			pstmt.setString(1, fecha_fin);
	        pstmt.setString(2, listo_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Pedido> getPedidosTotales() {
		ArrayList<Pedido> lista_pedidos=new ArrayList<Pedido>();
		String sql="SELECT id, mesa, obs, fecha_inicio, preparado, fecha_fin,\r\n"			
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_1) AS plato_1_nombre,\r\n"
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_2) AS plato_2_nombre,\r\n"
				+ "(SELECT nombre FROM t_plato WHERE t_plato.id=t_pedido.plato_3) AS plato_3_nombre\r\n"
				+ "FROM t_pedido";	
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int mesa=rs.getInt("mesa");
				String plato_1=rs.getString("plato_1_nombre");
				String plato_2=rs.getString("plato_2_nombre");
				String plato_3=rs.getString("plato_3_nombre");
				String obs=rs.getString("obs");
				String fecha_inicio=rs.getString("fecha_inicio");
				String preparado=rs.getString("preparado");
				String fecha_fin=rs.getString("fecha_fin");
				Pedido p=new Pedido(id, mesa, plato_1, plato_2, plato_3, obs, fecha_inicio, preparado, fecha_fin);
				lista_pedidos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_pedidos;
	}

	public static void exportarCSV(ArrayList<Pedido> lista_pedidos) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter("C:\\datos\\pedidos.csv");
			for(int i=0; i<lista_pedidos.size(); i++) 
			{
				fw.write(lista_pedidos.get(i).toCSV());
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Ticket getNombrePrecioTotal(String plato_1, String plato_2, String plato_3) {
		// TODO Auto-generated method stub
		Ticket t=null;
		String sql = ("SELECT nombre, precio FROM t_plato WHERE id IN (?,?,?)");
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, plato_1);
			pstmt.setString(2, plato_2);
			pstmt.setString(3, plato_3);
			ResultSet rs=pstmt.executeQuery();
			String[] nombres=new String[3];
			int[] precios=new int[3];
			int i=0;
			while (rs.next()) {
				nombres[i]=rs.getString("nombre");
				precios[i]=rs.getInt("precio");
				i++;
                
            }
			t=new Ticket(0, precios, nombres);
			t.calcularTotal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;

	}
	
	
	

	
}
