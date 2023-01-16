package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorCuenta {
	static DB_Connector con;
	
	public static usuario visualizarCuenta(String user) {
    	usuario usuario = new usuario();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+user+"'";
        try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
	            usuario usuarioR = new usuario(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("nombre"),rs.getString("apellido_p"),rs.getString("apellido_m"),rs.getString("direccion"),rs.getDouble("telefono"),rs.getString("correo"),rs.getString("contrasena"),rs.getBoolean("premium"));
	            return usuarioR;
	        }
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return usuario;
    }
	
	public static void cambiarPssw(int id_usuario,String newPass) {
		int stringLength = newPass.length();
		if(stringLength<8) {
			JOptionPane.showMessageDialog(null, "La longitud de la contraseña debe ser minimo de 8 carácteres.");
		}
		else {
			con = new DB_Connector();
	        Connection reg = con.getConnection();
	        String sql="UPDATE usuarios SET contrasena='"+newPass+"' WHERE usuarios.id_usuario='"+id_usuario+"'";
	        try {
	        	PreparedStatement pst=reg.prepareStatement(sql);
	        	pst.executeUpdate();
	        	JOptionPane.showMessageDialog(null, "La contraseña se actualizó correctamente.");
			}catch (Exception x) {
				JOptionPane.showMessageDialog(null, "ERROR: " + x);
			}
		}
    }
}

