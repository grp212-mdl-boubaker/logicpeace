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
public class AND  extends Porte{
    private String signe="<AND>";
    private Hashtable tableDeValeurs;
    public AND(String nom) {
        super(nom);
        tableDeValeurs = new Hashtable();
        tableDeValeurs.put(new Integer(0), new Integer(0));
        tableDeValeurs.put(new Integer(1),new Integer(0));
        tableDeValeurs.put(new Integer(2),new Integer(0));
        tableDeValeurs.put(new Integer(3),new Integer(1));
    }

    @Override
    public String getSigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getValue() {
    EntreePorte entreePort1 = ;
    EntreePorte entreePort2 = ;
    int e1 = entreePort1.getValue();
    int e2 = entreePort2.getValue();
    Integer addresse = new Integer(e1 + e2 * 2);
    return tableDeValeurs.get(addresse).getIntValue();
    }
    
      
}
