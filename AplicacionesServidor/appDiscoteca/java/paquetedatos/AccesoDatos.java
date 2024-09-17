package paquetedatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paqueteobjetos.Reserva;


public class AccesoDatos {
	private static Connection c=null; 
	private static void createConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_discoteca?user=root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String checkUser(String usuario, String password) {
		//rol es null si el usuario no existe
		createConnection();
		String rol=null;
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT rol FROM t_usuarios WHERE usuario=? AND password=?");
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
	
	public static int getEntradasByName(String usuario) {
		createConnection();
		int entradas=0;
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT entradas FROM t_reservas WHERE usuario=?");
			pstmt.setString(1, usuario);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) 
			{
				entradas=rs.getInt("entradas");
				return entradas;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entradas;
	}

	public static void grabarReserva(Reserva r) {
		createConnection();
		ArrayList<Reserva> lista_reservas=new ArrayList<Reserva>();
		try {
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO t_reservas (usuario, fecha, entradas) "
					+ "VALUES(?,?,?)");
			pstmt.setString(1, r.getUsuario());
			pstmt.setString(2, r.getFecha());
			pstmt.setInt(3, r.getEntradas());
			
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public static ArrayList<Reserva> getReservas() {
		ArrayList<Reserva> lista_reservas=new ArrayList<Reserva>();
		String sql="SELECT id, usuario, fecha, entradas "			
				+ "FROM t_reservas";	
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				int entradas=rs.getInt("entradas");
				String usuario=rs.getString("usuario");
				String fecha=rs.getString("fecha");
				// Reserva(int id, int entradas, String usuario, String fecha)
				Reserva r=new Reserva(0, entradas, usuario, fecha);
				lista_reservas.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_reservas;
	}

	public static int entradasDisponibles() {
		int total = 0;
		int aforo = 10;
	    String sql="SELECT SUM(entradas) AS total_entradas "
	    		+ "FROM t_reservas";
	    createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				total=rs.getInt("total_entradas");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int entradas_disponibles = aforo-total;
		return entradas_disponibles;
	}

	public static boolean existeRegistro(String usuario) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_reservas WHERE usuario=?");
			pstmt.setString(1, usuario);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) 
			{
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void actualizarEntradas(String usuario, int entradas_nuevas) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("UPDATE t_reservas SET entradas = entradas + ? WHERE usuario=?");
			pstmt.setInt(1, entradas_nuevas);
			pstmt.setString(2, usuario);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void importarCSV() {        
        createConnection();      
		try {
			String ruta="C:\\datos\\usuarios.csv";
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO t_usuarios (usuario, password, rol) VALUES (?, ?, ?)");
			while(linea!=null)
			{			
				
				String [] datos=linea.split(",");
				String usuario = datos[0];
	            String password = datos[1];
	            String rol = (datos[2]);
	           
	            pstmt.setString(1, usuario);
	            pstmt.setString(2, password);
	            pstmt.setString(3, rol);
	            
	            pstmt.executeUpdate();
	            linea=br.readLine();
	            
	            
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	

}
