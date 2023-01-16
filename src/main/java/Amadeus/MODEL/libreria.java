package Amadeus.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Amadeus.SERVICE.DB_Connector;

public class libreria {
	
	static DB_Connector con;

	public static List<String> mostrarLibreria(String usuario) {
    	List<String> nombreJ = new ArrayList<String>();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		if(rs.next()) {
    			int IDuser=rs.getInt("id_usuario");
    			String sql="SELECT * FROM libreria WHERE id_usuario='"+IDuser+"'";
    	    	try {
    	    		Statement stJ=reg.createStatement();
    				ResultSet rsJ=stJ.executeQuery(sql);
    				while (rsJ.next()) {
    		            String idJ=rsJ.getString("id_juego");
    		            String sqlJ="SELECT * FROM juegos WHERE id_juego='"+idJ+"'";
    		            try {
    	    	    		Statement stJu=reg.createStatement();
    	    				ResultSet rsJu=stJu.executeQuery(sqlJ);
    	    				if (rsJu.next()) {
    	    		            String nJ=rsJu.getString("nombre");
    	    		            nombreJ.add(nJ);
    	    		        }
    	    			}catch (Exception x) {
    	    				JOptionPane.showMessageDialog(null, "ERROR: " + x);
    	    			}
    		        }
    			}catch (Exception x) {
    				JOptionPane.showMessageDialog(null, "ERROR: " + x);
    			}
    		}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return nombreJ;
    }
	
	public static List<String> mostrarLibreriaPrem() {
    	List<String> nombreJ = new ArrayList<String>();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT * FROM juegos";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		while(rs.next()) {
    			String nJ=rs.getString("nombre");
    			nombreJ.add(nJ);
    		}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return nombreJ;
    }
	
	public static List<String> mostrarJuegosDev(String usuario) {
    	List<String> nombreJ = new ArrayList<String>();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT * FROM desarrolladores WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		if(rs.next()) {
    			String nombreDev=rs.getString("nombre");
    			String sql="SELECT * FROM juegos WHERE desarrollador='"+nombreDev+"'";
    	    	try {
    	    		Statement stJ=reg.createStatement();
    				ResultSet rsJ=stJ.executeQuery(sql);
    				while (rsJ.next()) {
    					String nJ=rsJ.getString("nombre");
    					nombreJ.add(nJ);
    		        }
    			}catch (Exception x) {
    				JOptionPane.showMessageDialog(null, "ERROR: " + x);
    			}
    		}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return nombreJ;
    }
}