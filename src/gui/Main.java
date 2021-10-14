/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.frm_login;

/**
 *
 * @author oscar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frm_login start = new frm_login();
        start.setLocationRelativeTo(null);
        start.setVisible(true);
        start.pack(); // Prompting login view as the first stage of the program.
    }
    
}
