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
    private SortiePorte sortie;
    public NOT(String nom) {
        super(nom);
        entrees = new EntreePorte[1];
        tableDeValeurs = new Hashtable();
        tableDeValeurs.put(new Integer(0), new Integer(1));
        tableDeValeurs.put(new Integer(1),new Integer(0));
    }

    @Override
    public String getSigne() {
        return super.toString() + " sortie " + sortie + " }";
    }

    @Override
    public void ajouterSortie(SortiePorte sortiePorte) {
        super.ajouterSortie(sortiePorte);
        sortie = sortiePorte;
    }
    
      
}
