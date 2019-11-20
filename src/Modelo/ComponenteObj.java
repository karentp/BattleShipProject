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
public class ComponenteObj {
    private Componentes tipo;
    private int precio;
    ComponenteObj(Componentes tipo,int precio){
        this.tipo= tipo;
        this.precio=precio;
    }

    public Componentes getTipo() {
        return tipo;
    }

    public void setTipo(Componentes tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
