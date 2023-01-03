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

public class Cliente extends Thread {

    Barberia barb;
    int id;
    int sleepTime;
    
    public Cliente (Barberia b, int i, int sleepTime) {
        this.barb = b;
        this.id = i;
        this.sleepTime = sleepTime;
    }
    
    @Override
    public void run() {
        try {
            sleep(this.sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        barb.solicitarPelado(id);
    }
    
}
