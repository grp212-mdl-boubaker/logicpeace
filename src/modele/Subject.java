/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author shahin.behrooz@gmail.com
 */
public interface Subject {
    public void attache(Observer obs);
    public void detache(Observer obs);
    public void notifier();
}
