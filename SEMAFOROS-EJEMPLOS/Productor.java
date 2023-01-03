/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

import java.util.Random;

/**
 * Esta clase representa el productor
 * @author Francisco Jesús Delgado Almirón
 */
public class Productor extends Thread implements Runnable
{
    private semaforo semaforo;

    

    public Productor(semaforo semaforo) 
    {
        this.semaforo = semaforo;
    }
    
    public void run() 
    {
        while(true){
            Random random = new Random();
            int data = random.nextInt(100);
            semaforo.put(data);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("ERROR: " + e);
            }
        }
    }
}
