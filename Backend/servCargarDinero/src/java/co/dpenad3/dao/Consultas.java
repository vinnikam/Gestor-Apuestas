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
import java.sql.SQLException;

/**
 *
 * @author Sala_704
 */
public class Consultas {
    
    private PreparedStatement objPreparedStatement;
    private Connection objConexion;
    
    //Método para cargar dinero a la cuenta
    public Datos cargarDinero(Datos obj)
    {
       objPreparedStatement = null;
        objConexion = null;
        int resInsert = 0;

        String sqlInsert="INSERT INTO tarjeta(numero, cv, cedula_jugador, fecha_exp, dinero) VALUES (?, ?, ?, ?, ?);";

        try
        {
            objConexion = ConexionBD.obtenerConexionBaseDeDatos();
            objPreparedStatement = objConexion.prepareStatement(sqlInsert);

            objPreparedStatement.setInt(1, obj.getNumero_tarjeta());
            objPreparedStatement.setInt(2, obj.getCv());
            objPreparedStatement.setInt(3, obj.getCedula());
            objPreparedStatement.setString(4, obj.getFecha_exp());
            objPreparedStatement.setInt(5, obj.getDinero());
          

            resInsert = objPreparedStatement.executeUpdate();

            objPreparedStatement.close();
            objConexion.close();

        }

        catch(SQLException e)
        {
            System.out.println("Error al insertar");
        }

        if(resInsert > 0)
        {
            return obj;
        }
        else
        {
            return null;
        }
    }
    
}
