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
public class Status implements IObjeto{
    private int numJugador;
    public Status(int numJugador) {
        this.numJugador = numJugador;
    }

    public Status() {
        
    }

    public int getNumJugador() {
        return numJugador;
    }

    public void setNumJugador(int numJugador) {
        this.numJugador = numJugador;
    }

    @Override
    public FuncionServer getType() {
        return FuncionServer.STATUS;
    }
    
    
}
