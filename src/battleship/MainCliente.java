/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.io.IOException;

/**
 *
 * @author Paola Chinchilla
 */

//Clase principal que hará uso del cliente
public class MainCliente
{
    public static void main(String[] args) throws IOException
    {
        Cliente cliente = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cliente.startClient(); //Se inicia el cliente
    }
}