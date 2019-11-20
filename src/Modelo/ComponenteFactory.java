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
public class ComponenteFactory {    
    public ComponenteObj crearComponente(Componentes tipo) {
        ComponenteObj newComponente = null;
        
        switch(tipo){
            case FUENTEENERGÍA:
                return new ComponenteObj(tipo,12000);
            case CONECTOR:
                return new ComponenteObj(tipo,100);
            case ARMERIA:
                return new ComponenteObj(tipo,1500);
            case MERCADO:
                return new ComponenteObj(tipo,2000);
            case MINA:
                return new ComponenteObj(tipo,1000);
            case TEMPLO:
                return new ComponenteObj(tipo,2500);
            case TORPEDO:
                return new ComponenteObj(tipo,500);
            case MULTISHOT:
                return new ComponenteObj(tipo,1000);
            case BOMBA:
                return new ComponenteObj(tipo,2000);   
            case TRUMPEDO:
                return new ComponenteObj(tipo,5000);
            case REMOLINO:
                return new ComponenteObj(tipo,0);
            case BARCO:
                return new ComponenteObj(tipo,2500);
            case ACERO:
                return new ComponenteObj(tipo,0);
             
        }
        
       
        return null;
    }
}
