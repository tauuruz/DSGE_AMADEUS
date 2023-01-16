package amadeusDev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import MODEL.desarrollador;
import SERVICE.DB_Connector;

public class gestorDev {
	static DB_Connector con;
	
	public static desarrollador visualizarCuenta(String dev) {
		desarrollador desarrollador = new desarrollador();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM desarrolladores WHERE usuario='"+dev+"'";
        try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
				desarrollador desarrolladorR = new desarrollador(rs.getInt("id_dev"),rs.getString("usuario"),rs.getString("nombre"),rs.getString("correo"),rs.getString("contrasena"));
	            return desarrolladorR;
	        }
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return desarrollador;
    }

}