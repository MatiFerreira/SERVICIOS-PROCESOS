/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package barberia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Ivan Gonzalez
 */

public class Barbero extends Thread  {
    
    Barberia barb;
    
    public Barbero (Barberia b) {
        this.barb = b;
    }
    
    @Override
    public void run() {
        do {
            try {
                barb.pelar();
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (barb.sillasL<barb.sillaenE);
    }
    
    
}
    
    

