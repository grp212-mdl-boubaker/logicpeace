/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import modele.Destination;
import modele.Porte;

/**
 * a name value pair to be set in combobox
 * @author shahin.behrooz@gmail.com
 */
public class ComboObject {
    private Destination dest;
    ComboObject(Destination dest){
        this.dest = dest;
    }
    public Destination getDestination() {
        return dest;
    }

    @Override
    public String toString() {
        return dest.getNom();
    }
    
}
