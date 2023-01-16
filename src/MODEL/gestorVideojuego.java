package MODEL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorVideojuego {
	static DB_Connector con;
    
    public static List<String> visualizarJuegos() {
    	List<String> nombreJ = new ArrayList<String>();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT nombre FROM juegos";
    	try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
	            String nJ=rs.getString("nombre");
	            nombreJ.add(nJ);
	        }
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return nombreJ;
    }
}