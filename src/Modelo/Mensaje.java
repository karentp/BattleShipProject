/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Karen TP
 */
public class Mensaje implements IObjeto {
    
    public String mensaje;
    
    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return mensaje;
    }

    @Override
    public FuncionServer getType() {
        return FuncionServer.MENSAJE;
    }
}
