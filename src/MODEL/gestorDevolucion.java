package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorDevolucion {
	
	static DB_Connector con;
	
	public static void devolverJuego(videojuego juego,String usuario) {
    	con = new DB_Connector();
    	Connection reg = con.getConnection();
    	try {
    		String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		if(rs.next()) {
    			int IDuser=rs.getInt("id_usuario");
    			try {
    				String sql="DELETE FROM libreria WHERE id_usuario='"+IDuser+"' AND id_juego='"+juego.getID()+"'";
    				PreparedStatement pst=reg.prepareStatement(sql);
    	    		pst.executeUpdate();
    	    		JOptionPane.showMessageDialog(null, "Se ha eliminado ''" + juego.getNombre() + "'' de tu librería.");
    			}catch (Exception x) {
    				JOptionPane.showMessageDialog(null, "ERROR: " + x);
    			}
    		}
    	}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
}