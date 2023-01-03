/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Ivan Gonzalez
 */
public class Barberia {

    private Semaphore sBarbero;
    private Semaphore sCliente;
    private Semaphore sSilla;

    public int sillasL;
    public int sillaenE;

    public Barberia() {
        sBarbero = new Semaphore(1);
        sCliente = new Semaphore(0);
        sSilla = new Semaphore(1);
        sillasL = 4;
        sillaenE = sillasL;
    }

    public void pelar() {
        try {
            this.sCliente.acquire();
            System.out.println("El barbero va a pelar");
            sSilla.acquire();
            sillasL++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
        sBarbero.release();
        sSilla.release();
    }

    public void solicitarPelado(int id) {
        try {
            sSilla.acquire();
            if (sillasL > 0) {
                sillasL--; 
                System.out.println("El cliente " + id + " solicita un pelado");
                sCliente.release();
                sSilla.release();
                sBarbero.acquire();
                System.out.println("El cliente " + id + " se va.");
            } else {
                System.out.println("No hay sillas, el cliente " + id + " se va");
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
        sSilla.release();
    }

}
