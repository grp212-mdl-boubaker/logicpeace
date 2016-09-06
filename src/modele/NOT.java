/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class NOT  extends PorteUniEntree{
    private String signe="<NOT>";
    
    public NOT(String nom) {
        super(nom);
        tableDeValeurs = new Hashtable();
        tableDeValeurs.put(new Integer(0), new Integer(1));
        tableDeValeurs.put(new Integer(1),new Integer(0));
    }

    @Override
    public String getSigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      
}
