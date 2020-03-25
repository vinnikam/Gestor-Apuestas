/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.servicios;

import co.dpenad3.dao.Consultas;
import co.dpenad3.dto.Datos;
import co.dpenad3.dto.Respuesta;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
@Path("operacion")
public class Operaciones {
    
    @Path("version")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String version(){
        return "version 1.0";
    }
    
    @Path("registrarTarjeta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registarTarjeta(Datos datos)
    {
       Respuesta r = new Respuesta();
        r.setCodigo(1);
        r.setMensajeE("Tarjeta registrada");
        
        Consultas cons = new Consultas();
        Datos d = cons.registrarTarjeta(datos);
        
        if (d == null){
            r.setCodigo(0);
            r.setMensajeE("Error al registrar la tarjeta");
        }
        
        r.setInfo(d);
        return r;
     
    }
    
}
