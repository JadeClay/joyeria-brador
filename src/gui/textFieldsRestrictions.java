/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.glass.events.KeyEvent;
import gui.frm_login;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class textFieldsRestrictions {
    public static void justNumbers(java.awt.event.KeyEvent evt){
       try{
           boolean doBeep;
       
            final char c = evt.getKeyChar();

            switch(c){
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_BACKSPACE:
                case KeyEvent.VK_DELETE:
                    doBeep = false;
                    break;
                default:
                    doBeep = !Character.isDigit(c);
            }

            if(doBeep){
                Toolkit.getDefaultToolkit().beep(); // Making a sound if the users type an unwanted key
                evt.consume();
            }
       } catch(Exception ex) {
            Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
       }
              
    }
    
    public static void justLetters(java.awt.event.KeyEvent evt){
       try{
           boolean doBeep;
       
            final char c = evt.getKeyChar();

            switch(c){
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_BACKSPACE:
                case KeyEvent.VK_DELETE:
                    doBeep = false;
                    break;
                default:
                    doBeep = !Character.isLetter(c); 
            }

            if(doBeep){
                Toolkit.getDefaultToolkit().beep(); // Making a sound if the users type an unwanted key
                evt.consume();
            }
       } catch(Exception ex) {
            Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
       }
              
    }
}
