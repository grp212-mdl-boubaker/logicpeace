/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Editeur {
    static Dictionary dic=new Hashtable();
    static Circuit racine;
    public static Circuit creerCircuit() {
        String nom = "c" + Circuit.getNombreCircuit();
        Circuit.setNombreCircuit(Circuit.getNombreCircuit() + 1);
        racine = Circuit.getInstance(nom);
        Entree entree1 = racine.creerEntree();
        Entree entree2 = racine.creerEntree();
        Sortie sortie = racine.creerSortie();
       return racine;
    }
    //ajouterPorte
    public static void ajouterPorte(String type){
        
       racine.creerPorte(type);
    }
    ////ajouterPorte
    public static void ajouterEntree(){
        racine.creerEntree();
    }
    //ajouterPorte
    public static void ajouterSortie(){
        racine.creerSortie();
    }
    //rechercher un nom dans le dictionnaire
    public static Noeud RechercherNoeud(String nom) {
        return (Noeud)dic.get(nom);
    }
}
