/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;
import static modele.Editeur.dic;
import static modele.Editeur.racine;

/**
 *
 * @author Admin
 */
public class Circuit implements Noeud {

    private static int nombreCircuit = 0;
    private String nom;
    private List elements = new ArrayList<Noeud>();
    private boolean modifie = false;
    static Circuit circuit;

    //Constrocteur
    public static Circuit getInstance(String nom) {
        if (circuit == null) {
            circuit = new Circuit(nom);
        }
        return circuit;
    }

    private Circuit(String nom) {
        this.nom = nom;
    }
//setteurs et getteurs

    public static int getNombreCircuit() {
        return nombreCircuit;
    }

    public static void setNombreCircuit(int nombreCircuit) {
        Circuit.nombreCircuit = nombreCircuit;
    }

    public List getElements() {
        return elements;
    }

    public void setElements(List elements) {
        this.elements = elements;
    }

    public void ajouterNoeud(Noeud element) {
        elements.add(element);
    }

    public void afficher() {
        System.out.println(this);
    }
//creation un objet de type Porte

    public Porte creerPorte(String typePorte) {
        Porte porte = null;
        EntreePorte entreePorte1 = null, entreePorte2 = null;
        SortiePorte sortiePorte = null;
        int n = Porte.getNombrePorte();
        if (n > 50) {
            return null;
        }
        String nom = "p" + n;
        Porte.setNombrePorte(n + 1);
        switch (typePorte) {
            case "OR":
                porte = new OR(nom);
                entreePorte1 = porte.creerEntreePorte();
                entreePorte2 = porte.creerEntreePorte();
                sortiePorte = porte.creerSortiePorte();
                porte.ajouterEntree(entreePorte1,0);//index 0 = premier entree
                dic.put(entreePorte1.getNom(), (Noeud) entreePorte1);
                porte.ajouterEntree(entreePorte2,1);
                dic.put(entreePorte2.getNom(), (Noeud) entreePorte2);
                porte.ajouterSortie(sortiePorte);
                dic.put(sortiePorte.getNom(), (Noeud) sortiePorte);
                break;
            case "AND":
                porte = new AND(nom);
                entreePorte1 = porte.creerEntreePorte();
                entreePorte2 = porte.creerEntreePorte();
                sortiePorte = porte.creerSortiePorte();
                porte.ajouter(entreePorte1);
                dic.put(entreePorte1.getNom(), (Noeud) entreePorte1);
                porte.ajouter(entreePorte2);
                dic.put(entreePorte2.getNom(), (Noeud) entreePorte2);
                porte.ajouter(sortiePorte);
                dic.put(sortiePorte.getNom(), (Noeud) sortiePorte);
                break;
             case "NOT":
                porte = new NOT(nom);
                entreePorte1 = porte.creerEntreePorte();
                sortiePorte = porte.creerSortiePorte();
                porte.ajouter(entreePorte1);
                dic.put(entreePorte1.getNom(), (Noeud) entreePorte1);
                porte.ajouter(sortiePorte);
                dic.put(sortiePorte.getNom(), (Noeud) sortiePorte);
                break;    
                
        }
        if (porte != null) {
            ajouterNoeud(porte);
            dic.put(porte.getNom(), (Noeud) porte);
        }
        return porte;
    }

//creation un objet de type  Entree
    public static Entree creerEntree() {
        int n = Entree.getNombreEntree();
        if (n >= 5) {
            // JOptionPane.showMessageDialog(null, "Le nombre d'entre est au maximum 5.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String nom = "e" + n;
        Entree.setNombreEntree(n + 1);
        Entree e = new Entree(nom);
        racine.ajouterNoeud(e);
        dic.put(e.getNom(), (Noeud) e);
        return e;
    }
//creation un objet de type  Sortie

    public static Sortie creerSortie() {
        String nom = "s" + Sortie.getNombreSortie();
        Sortie.setNombreSortie(Sortie.getNombreSortie() + 1);
        Sortie s = new Sortie(nom);
        racine.ajouterNoeud(s);
        dic.put(s.getNom(), (Noeud) s);
        return s;
    }
//tostring

    @Override
    public String toString() {
        return "Circuit{" + "nom=" + nom + ", elements=" + elements + '}';
    }
//lier deux noeuds

    public void lier(String txtNoeud1, String txtNoeud2) {
        Noeud noeud1 = Editeur.RechercherNoeud(txtNoeud1);
        Noeud noeud2 = Editeur.RechercherNoeud(txtNoeud2);
        if (noeud1 != null && noeud2 != null) {
            if ((noeud1 instanceof Entree) && (noeud2 instanceof EntreePorte)) {
                ((Entree) noeud1).addLien(noeud2);
                ((EntreePorte) noeud2).addLien(noeud1);

            } else if ((noeud1 instanceof Sortie) && (noeud2 instanceof SortiePorte)) {
                ((Sortie) noeud1).addLien(noeud2);
                ((SortiePorte) noeud2).addLien(noeud1);
            }
        }

    }

}
