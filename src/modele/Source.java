/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shahin.behrooz@gmail.com
 */
public abstract class Source implements Noeud{
    private int value;
    ArrayList<Destination> destinations = new ArrayList<Destination>();
    public void addDestination(Destination dest){
        destinations.add(dest);
    }
    public int getValue() throws InvalidCircuitException{
        return value;
    }
    public List<Destination> getDestinations(){
        return destinations;
    }
    public void removeDestination(Destination dest){
        destinations.remove(dest);
    }
}
