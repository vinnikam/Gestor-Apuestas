/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dao;

import co.dpenad3.dto.Datos;
import co.dpenad3.bd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sala_704
 */
public class Consultas {

    /*public Datos registrarTarjeta(Datos obj)
    {
        Connection objConexion;
        int resInsert = 0;

        try
        {
           objConexion = ConexionBD.obtenerConexionBaseDeDatos();
           
           PreparedStatement select = objConexion.prepareStatement("SELECT cv, fecha_ven, cupo_disp FROM banco WHERE numero_tarjeta="+obj.getCedula_jugador()+";");
           ResultSet rs = select.executeQuery();
           System.out.println(obj.getNumero_tarjeta());
           while(rs.next())
           {
               rs.getInt(2);
           }

           if(rs.getInt("cv")==obj.getCv() && rs.getString("fecha_ven").equals(obj.getFecha_ven()))
           {
               System.out.println("Vamos bien");
               PreparedStatement insert = objConexion.prepareStatement("INSERT INTO tarjeta(cedula_jugador, numero_tarjeta, dinero) VALUES (?,?,?);");
               insert.setInt(1, obj.getCedula_jugador());
               insert.setLong(2, obj.getNumero_tarjeta());
               insert.setInt(3, rs.getInt("cupo_disp"));
               resInsert = insert.executeUpdate();
               insert.close();
           }
           else
           {
               System.out.println("Los datos no coinciden");
           }
          
           rs.close();
            objConexion.close();

        }

        catch(SQLException e)
        {
            System.out.println("Error al registrar Tarjeta");
        }

        if(resInsert > 0)
        {
            return obj;
        }
        else
        {
            return null;
        }
    }*/
    
    /*public Datos registrarTarjeta(Datos obj)
    {
        PreparedStatement objPreparedStatement=null;
        ResultSet objResultSet=null;
        Connection objConexion=null;
        int resInsert=0;
        
         String sqlInsert="INSERT INTO tarjeta(cedula_jugador, numero_tarjeta, dinero) VALUES(?,?,?)";
		
		try
		{
			objConexion = ConexionBD.obtenerConexionBaseDeDatos();
			objPreparedStatement = objConexion.prepareStatement(sqlInsert);
			
			objPreparedStatement.setInt(1, obj.getCedula_jugador());
			objPreparedStatement.setLong(2, obj.getNumero_tarjeta());
			objPreparedStatement.setInt(3, 1400000);

			resInsert = objPreparedStatement.executeUpdate();
			
			objPreparedStatement.close();
			objConexion.close();
			
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(resInsert > 0)
		{
			return obj;
		}
		else
		{
			return null;
		}

               
    }*/
    
    public Datos registrarTarjeta(Datos obj)
    {
        PreparedStatement objPreparedStatement=null;
        ResultSet objResultSet=null;
        Connection objConexion=null;
        
       
         String sqlSelect="SELECT cv FROM banco WHERE numero_tarjeta=4500344345914104;";
		
		try
		{
			objConexion = ConexionBD.obtenerConexionBaseDeDatos();
			objPreparedStatement = objConexion.prepareStatement(sqlSelect);
                        objResultSet= objPreparedStatement.executeQuery();
			
                        if(objResultSet==null)
                        {
                            System.out.println("Que pasa");
                        }
                        else
                        {
                            System.out.println("raro");
                            while(objResultSet.next()){
                            objResultSet.getInt("cv");
                            }
                        }
			
			
			objPreparedStatement.close();
			objConexion.close();
			
		}

		catch(Exception e)
		{
                    System.out.println("Error");
		}
		
		return obj;
    }
    
}
