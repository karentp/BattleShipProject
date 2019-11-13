/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen TP
 */
public class Server {
    ServerSocket server;
    ArrayList<ThreadServer> clientes= new ArrayList();
    public int playerAmount;

    public Server() {
        
    }
    
    public void runServer(){
        this.playerAmount = 2;
        try {
            ServerSocket server = new ServerSocket(8082);
            System.out.println("Servidor Activo: Esperando por Clientes...");
            for (int i = 0; i < playerAmount; i++){
                Socket cliente = server.accept();
                ThreadServer threadServer = new ThreadServer(cliente, this, i);
                clientes.add(threadServer);
                threadServer.start();
                System.out.println("Se conectó el cliente: "+i);
            }
            System.out.println("El servidor está lleno, lo sentimos");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server();
        server.runServer();
    }
} 

