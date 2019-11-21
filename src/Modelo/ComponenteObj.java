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
public class ComponenteObj implements IObjeto {
    private Componentes tipo;
    private int precio;
    private int posX;
    private int posY;
    private int idDuenno;
    
    ComponenteObj(Componentes tipo,int precio){
        this.tipo= tipo;
        this.precio=precio;
    }
    ComponenteObj(Componentes tipo,int precio,int idDuenno){
        this.tipo= tipo;
        this.precio=precio;
        this.idDuenno=idDuenno;
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getIdDuenno() {
        return idDuenno;
    }

    public void setIdDuenno(int idDuenno) {
        this.idDuenno = idDuenno;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    

    @Override
    public FuncionServer getType() {
       return FuncionServer.COMPONENTE; 
    }
    
}
