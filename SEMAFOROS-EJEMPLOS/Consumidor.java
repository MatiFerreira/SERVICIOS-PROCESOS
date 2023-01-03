/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 * Esta clase representa al productor
 * @author Francisco Jesús Delgado Almirón
 */
public class Consumidor extends Thread implements Runnable
{
    private semaforo semaforo;

    public Consumidor(semaforo semaforo) 
    {
        this.semaforo=semaforo;
    }
    
    public void run() 
    {
        
        while(true){
            semaforo.get();
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("ERROR: " + e);
            }
        }
    }
}
