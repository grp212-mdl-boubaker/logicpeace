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
public class OR  extends PorteDoubleEntree{
    private String signe="<OR>";
    
    public OR(String nom) {
        super(nom);
                // la table pour determiner le resultat d<une operation And selon les entrees
        tableDeValeurs = new Hashtable();
        tableDeValeurs.put(new Integer(0), new Integer(0));
        tableDeValeurs.put(new Integer(1),new Integer(1));
        tableDeValeurs.put(new Integer(2),new Integer(1));
        tableDeValeurs.put(new Integer(3),new Integer(0));

    }

    @Override
    public String getSigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
