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
public class Circuit implements Noeud, Subject {

    private static int nombreCircuit = 0;
    private String nom;
    private List elements = new ArrayList<Noeud>();
    private ArrayList<Observer> lstObserver = new ArrayList<Observer>(); 
    private boolean modifie = false;
    static Circuit circuit;
    private ArrayList<Entree> entrees = new ArrayList<Entree>();
    private ArrayList<Sortie> sorties = new ArrayList<Sortie>();
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

    public void ajouterNoeud(Object element) {
        //on veut garder les entrees separement
        if (element instanceof Entree)
            entrees.add((Entree)element);
        else if (element instanceof Sortie)
            sorties.add((Sortie)element);
        elements.add(element);
        notifier();
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
                dic.put(entreePorte1.getNom(),  entreePorte1);
//                ajouterNoeud(entreePorte1);
                porte.ajouterEntree(entreePorte2,1);
                dic.put(entreePorte2.getNom(),  entreePorte2);
//                ajouterNoeud(entreePorte2);
                porte.ajouterSortie(sortiePorte);
                elements.add(porte);
                dic.put(sortiePorte.getNom(),  sortiePorte);
                //ajouterNoeud(sortiePorte);
                break;
            case "AND":
                porte = new AND(nom);
                entreePorte1 = porte.creerEntreePorte();
                entreePorte2 = porte.creerEntreePorte();
                sortiePorte = porte.creerSortiePorte();
                porte.ajouterEntree(entreePorte1,0);
                dic.put(entreePorte1.getNom(),  entreePorte1);
//                ajouterNoeud(entreePorte1);
                porte.ajouterEntree(entreePorte2,1);
                dic.put(entreePorte2.getNom(),  entreePorte2);
//                ajouterNoeud(entreePorte2);
                porte.ajouterSortie(sortiePorte);
                elements.add(porte);
                dic.put(sortiePorte.getNom(), sortiePorte);
               // ajouterNoeud(sortiePorte);
                break;
             case "NOT":
                porte = new NOT(nom);
                entreePorte1 = porte.creerEntreePorte();
                sortiePorte = porte.creerSortiePorte();
                porte.ajouterEntree(entreePorte1,0);
                dic.put(entreePorte1.getNom(), entreePorte1);
//                ajouterNoeud(entreePorte1);
                porte.ajouterSortie(sortiePorte);
                elements.add(porte);
                dic.put(sortiePorte.getNom(), sortiePorte);
            //    ajouterNoeud(sortiePorte);
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
        dic.put(e.getNom(), e);
        return e;
    }
//creation un objet de type  Sortie

    public static Sortie creerSortie() {
        String nom = "s" + Sortie.getNombreSortie();
        Sortie.setNombreSortie(Sortie.getNombreSortie() + 1);
        Sortie s = new Sortie(nom);
        racine.ajouterNoeud(s);
        dic.put(s.getNom(),  s);
        // circuit a change donc notifier les observateurs
        return s;
    }
//tostring

    @Override
    public String toString() {
        return "Circuit{" + "nom=" + nom + ", elements=" + elements + '}';
    }
//lier deux noeuds

    public void lier(String txtNoeud1, String txtNoeud2) {
        Object noeud1 = Editeur.RechercherNoeud(txtNoeud1);
        Object noeud2 = Editeur.RechercherNoeud(txtNoeud2);
        if (noeud1 != null && noeud2 != null) {
        Destination dest = getDestination(noeud1, noeud2);
        if (dest.getSource() != null)// deja connectee
            return;
        Source src = getSource(noeud1, noeud2);
        if (dest == null || src == null)
            throw new IllegalArgumentException("Les noeuds ne sont pas liables.");
        dest.setSource(src);
        }
        notifier();
    }
    public void delier(String txtNoeud1, String txtNoeud2) {
        Object noeud1 = Editeur.RechercherNoeud(txtNoeud1);
        Object noeud2 = Editeur.RechercherNoeud(txtNoeud2);
        if (noeud1 != null && noeud2 != null) {
        Destination dest = getDestination(noeud1, noeud2);
        if (dest.getSource() != null)
            dest.setSource(null);
        Source src = getSource(noeud1, noeud2);
        if (src != null)
            src.removeDestination(dest);
        }
        notifier();
    }
    // retourne celle qui est de type Source
    // utility methods just for facilitate
    private Source getSource(Object n,Object m){
        if (n instanceof Source)
            return (Source)n;
        if (m instanceof Source)
            return (Source)m;
        return null;
    }
    private Destination getDestination(Object n,Object m){
        if (n instanceof Destination)
            return (Destination)n;
        if (m instanceof Destination)
            return (Destination)m;
        return null;
    }

    @Override
    public int getValue() {
    return -1;//never called
    }
    public ArrayList<Entree> getEntrees(){
        return entrees;
    }
    public ArrayList<Sortie> getSorties(){
        return sorties;
    }

    @Override
    public void attache(Observer obs) {
        lstObserver.add(obs);
    }

    @Override
    public void detache(Observer obs) {
        lstObserver.remove(obs);
    }

    @Override
    public void notifier() {
        for (Observer obs:lstObserver)
            obs.update();
    }

    @Override
    public String getNom() {
        return nom;
    }

}
