/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Admin
 */
public interface Noeud {
    public int getValue() throws InvalidCircuitException;
    public String getNom();
}
