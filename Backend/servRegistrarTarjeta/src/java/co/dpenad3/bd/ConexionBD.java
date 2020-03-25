/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.bd;
import co.dpenad3.utility.DCM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author dani2
 */
public class ConexionBD{

    private static Connection conexion;
    public static ConexionBD objConexionBD;

        //Método que realiza la conexión a la base de datos
	public static Connection obtenerConexionBaseDeDatos() throws SQLException {
	
		try
		{
                    Class.forName(DCM.DRIVER_BD);
                    conexion = DriverManager.getConnection(DCM.URL_BD,DCM.USUARIO_BD,DCM.CONTRSEÑA_BD);
                    System.out.println("Conectando.....");
                }
		catch(Exception e)
		{
			conexion.close();
			e.printStackTrace();
		}
		
		return conexion;
	}
}