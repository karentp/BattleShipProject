/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Server;
import Modelo.FuncionServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen TP
 */
public class ThreadServer extends Thread {
    
    private Socket cliente;
    private Server servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private ArrayList<Socket> clientes;
    private int playerNumber;
    private boolean activo;

    public ThreadServer(Socket clienteP, Server servidorP,int playNumber) {
        this.cliente= clienteP;
        this.servidor=servidorP;
        this.playerNumber = playNumber;
        this.activo = true;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public Server getServidor() {
        return servidor;
    }

    public void setServidor(Server servidor) {
        this.servidor = servidor;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }

    public ArrayList<Socket> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Socket> clientes) {
        this.clientes = clientes;
    }
    
    
    
    public void run()
     {
        while (activo) {
            try {
                entrada = new ObjectInputStream(cliente.getInputStream());
                IObjeto packRecibido = (IObjeto) entrada.readObject();
                switch (packRecibido.getType()) {
                    case MENSAJE: {
                        for (ThreadServer threadServer : servidor.clientes){
                            if (threadServer != this)
                                this.sendPackage(packRecibido, threadServer);
                        }
                    }
                }
            }
            catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        } 
         
     }    
        
    public void sendPackage(IObjeto pack, ThreadServer serverThread) {
        try {
            salida = new ObjectOutputStream(serverThread.cliente.getOutputStream());
            salida.writeObject(pack);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

} 
