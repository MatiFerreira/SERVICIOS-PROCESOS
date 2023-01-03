/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 *
 * @author Francis
 */
public class EjemploVideo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int DORMIR_PRODUCTOR = 1000, DORMIR_CONSUMIDOR = 2000;
        
        semaforo semaforo = new semaforo();
        
        Productor productor = new Productor(semaforo);
        Consumidor consumidor = new Consumidor(semaforo);
        Thread productorThread = new Thread(productor);
        
        productorThread.start();
        
        Thread consumidorThread = new Thread(consumidor);
        
        consumidorThread.start();
    }
    
}
