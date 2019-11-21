/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import GUI.Juego;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen TP
 */
public class ThreadCliente extends Thread{
    private Socket clienteSocket;
    private Server servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private int playerNumber;
    private boolean activo;
    private int idCliente;
    private ArrayList<IdEnemigo> enemigos;
    private Cliente cliente;
    private Hashtable<IdEnemigo, ArrayList<ComponenteObj>> enemigosHashTable;
    private Enumeration keysEnemigosHash ;
    

    public ThreadCliente(Socket client) {
        this.clienteSocket = client;
        this.activo = true;
        this.enemigos= new ArrayList<IdEnemigo>();
        this.enemigosHashTable=new Hashtable<>();
    }
    

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public Socket getClienteSocket() {
        return clienteSocket;
    }

    public void setClienteSocket(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    public Server getServidor() {
        return servidor;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<IdEnemigo> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<IdEnemigo> enemigos) {
        this.enemigos = enemigos;
    }

   

    public Hashtable<IdEnemigo, ArrayList<ComponenteObj>> getEnemigosHashTable() {
        return enemigosHashTable;
    }

    public void setEnemigosHashTable(Hashtable<IdEnemigo, ArrayList<ComponenteObj>> enemigosHashTable) {
        this.enemigosHashTable = enemigosHashTable;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Enumeration getKeysEnemigosHash() {
        return keysEnemigosHash;
    }

    public void setKeysEnemigosHash(Enumeration keysEnemigosHash) {
        this.keysEnemigosHash = keysEnemigosHash;
    }
    
    
    public void setServidor(Server servidor) {
        this.servidor = servidor;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }
    
    
    
    public void run()
     {
        while (activo) {
            try {
                entrada = new ObjectInputStream(clienteSocket.getInputStream());
                IObjeto packRecibido = (IObjeto) entrada.readObject();
                if(packRecibido!=null){
                switch (packRecibido.getType()) {
                    case MENSAJE: {
                        Mensaje mensaje = (Mensaje) packRecibido;
                        System.out.println(mensaje.getMessage());
                        break;
                    }
                    case COMPONENTE:{
                        ComponenteObj componente= (ComponenteObj) packRecibido;
                        int duennoComponente= componente.getIdDuenno();
                        
                        keysEnemigosHash = enemigosHashTable.keys();
                        IdEnemigo enemigo;
                        ArrayList<ComponenteObj> enemigoComponentes;
                        
                        while( keysEnemigosHash.hasMoreElements() ){
                          enemigo =(IdEnemigo) keysEnemigosHash.nextElement();
                          if(enemigo.getNumEnemigo()==duennoComponente){
                            enemigoComponentes = enemigosHashTable.get(enemigo);
                            enemigoComponentes.add(componente);
                            enemigosHashTable.replace(enemigo, enemigoComponentes);
                            System.out.println( "Cambió el valor en: " + enemigo.getNumEnemigo());
                            break;
                          }
                        }
                        break;
                    }
                        
                  case STATUS:{
                        
                        Status status=(Status) packRecibido;
                        idCliente= status.getNumJugador();
                        cliente.setIdJugador(idCliente);
                        System.out.println("Lee numero de jugador "+idCliente);
                        break;
                    }
                    case ENEMIGO:{
                        IdEnemigo enemigo=(IdEnemigo) packRecibido;
                        System.out.println("Recibe enemigo: "+enemigo.getNumEnemigo());
                        System.out.println("Soy el jugador: "+cliente.getIdJugador());
                        if(enemigo.getNumEnemigo()!=cliente.getIdJugador()){   
                            enemigosHashTable.put(enemigo, new ArrayList<ComponenteObj>());
                            enemigos.add(enemigo);
                            System.out.println("Colocó el enemigo :"+ enemigo.getNumEnemigo()+"en el hash table");
                            Juego juego=cliente.getJuego();
                            System.out.println("Juego no nulo"+juego.getColumnas());
                            cliente.getJuego().actualizarJugadoresID();

                        }  
                        break;
                    }
                    
                }
                }
            }
            catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        } 
     }      
         
       
    public void sendPackage(IObjeto packRecibido){
        try {
            salida = new ObjectOutputStream(clienteSocket.getOutputStream());
            salida.writeObject(packRecibido);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
