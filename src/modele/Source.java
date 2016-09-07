/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author shahin.behrooz@gmail.com
 */
public abstract class Source implements Noeud{
    private int value;
    Destination destination;
    public void setDestination(Destination dest){
        destination = dest;
    }
    public int getValue() throws InvalidCircuitException{
        return value;
    }
}
