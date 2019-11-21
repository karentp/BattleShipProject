/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Karen TP
 */
public class IdEnemigo implements IObjeto, Serializable{
    private int numEnemigo;
    private ThreadServer threadServer;
    
    public IdEnemigo(int numJugador) {
        this.numEnemigo = numJugador;
    }
    public IdEnemigo(int numJugador, ThreadServer threadServer) {
        this.numEnemigo = numJugador;
        this.threadServer= threadServer;
    }

   

    public int getNumEnemigo() {
        return numEnemigo;
    }

    public void setNumEnemigo(int numEnemigo) {
        this.numEnemigo = numEnemigo;
    }

    public ThreadServer getThreadServer() {
        return threadServer;
    }

    public void setThreadServer(ThreadServer threadServer) {
        this.threadServer = threadServer;
    }
    

    @Override
    public FuncionServer getType() {
        return FuncionServer.ENEMIGO;
    }
}
