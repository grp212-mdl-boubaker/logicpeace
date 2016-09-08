/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class AND  extends PorteDoubleEntree{
    private String signe="<AND>";
    private SortiePorte sortie;
    // pour le fonctionnement refere a PorteDoubleEntree
    public AND(String nom) {
        super(nom);
        // la table pour determiner le resultat d<une operation And selon les entrees
        tableDeValeurs = new Hashtable();
        tableDeValeurs.put(new Integer(0), new Integer(0));
        tableDeValeurs.put(new Integer(1),new Integer(0));
        tableDeValeurs.put(new Integer(2),new Integer(0));
        tableDeValeurs.put(new Integer(3),new Integer(1));
    }

    @Override
    public void ajouterSortie(SortiePorte sortiePorte) {
        super.ajouterSortie(sortiePorte); 
        sortie = sortiePorte;
    }
    
    @Override
    public String getSigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + " sortie " + sortie;
    }


    
      
}
