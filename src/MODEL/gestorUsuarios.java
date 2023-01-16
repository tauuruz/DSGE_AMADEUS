package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorUsuarios {
	
	static DB_Connector con;
	
    public static void registrarUsuario(String usuario,String nombre,String paterno,String materno,String direccion,String telefono,String correo, String password, boolean premium) {
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
        String sqlE="SELECT * FROM usuarios WHERE correo='"+correo+"'";
        try {
    		Statement st=reg.createStatement();
    		ResultSet rsE=st.executeQuery(sqlE);
			
			if(rsE.next()) {
				JOptionPane.showMessageDialog(null, "La direccion de correo ''" + correo + "'' ya se encuentra registrada.");
			}
			else {
				Statement stU=reg.createStatement();
	    		ResultSet rs=stU.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "El usuario ''" + usuario + "'' no está disponible, por favor elija otro.");
				}
				else {
					String sqlR="INSERT INTO usuarios (usuario,nombre,apellido_p,apellido_m,direccion,telefono,correo,contrasena,premium) VALUES(?,?,?,?,?,?,?,?,?)";
			    	try {
			    		PreparedStatement pst=reg.prepareStatement(sqlR);
			    		pst.setString(1, usuario);
			    		pst.setString(2, nombre);
			    		pst.setString(3, paterno);
			    		pst.setString(4, materno);
			    		pst.setString(5, direccion);
			    		pst.setString(6, telefono);
			    		pst.setString(7, correo);
			    		pst.setString(8, password);
			    		pst.setBoolean(9, premium);
			    		pst.executeUpdate();
			    		JOptionPane.showMessageDialog(null, "Usuario ''" + usuario + "'' registrado correctamente con el correo ''" + correo + "''");
					}catch (Exception x) {
						JOptionPane.showMessageDialog(null, "ERROR: " + x);
					}
				}
			}
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
    
    public static int logIn(String user, String passw) {
    	int value=0;
		con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+user+"' AND BINARY contrasena='"+passw+"'";
    	try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				value=1;
			}			
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return value;
    }
    
    public static int logInDev(String user, String passw) {
    	int value=0;
		con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM desarrolladores WHERE usuario='"+user+"' AND BINARY contrasena='"+passw+"'";
    	try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				value=1;
			}			
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return value;
    }
    
    public static void upgradeUser(String user) {
    	con = new DB_Connector();
        Connection upg = con.getConnection();
        try {
        	String sql="UPDATE usuarios SET premium ='1' WHERE usuario='"+user+"'";
        	PreparedStatement pst=upg.prepareStatement(sql);
        	pst.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Ahora eres premium ");
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
    
    public static void downgradeUser(String user) {
    	con = new DB_Connector();
        Connection upg = con.getConnection();
        try {
        	String sql="UPDATE usuarios SET premium ='0' WHERE usuario='"+user+"'";
        	PreparedStatement pst=upg.prepareStatement(sql);
        	pst.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Ya no eres premium ");
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }

}