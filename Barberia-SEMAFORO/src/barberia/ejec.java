/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package barberia;

import java.util.concurrent.Semaphore;

/**
 *
 * Ivan Gonzalez
 */

public class ejec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Barberia barb = new Barberia();
        
        Barbero barbero = new Barbero(barb);
        barbero.start();
        
        int numClientes = 15;
        Cliente[] clientes = new Cliente[numClientes];
    
        for (int i=0; i<numClientes; i++) {
            clientes[i] = new Cliente(barb,i,i*50);
            clientes[i].start();
        }
        
        
        
    }

}
