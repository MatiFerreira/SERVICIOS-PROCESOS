/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 * Esta clase representa el almacén, es decir, el recurso que se produce y se consume (Versión sincronizada)
 * @author Francisco Jesús Delgado Almirón
 */
public class Buffer 
{
    private int contenido;
    private boolean disponible = false;
    
    /**
     * Obtiene el contenido del buffer
     * @return Contenido del buffer
     */
    public synchronized int get() 
    {
        // Mientras el buffer no esté disponible
        while (disponible == false) 
        {
            try 
            {
                // me espero a que produzcan
                wait();
            } 
            catch (InterruptedException e) {}
        }
        // Cuando vuelve a estar disponible, notifico que está disponible
        disponible = false;
        notify();
        return contenido;
    }
    
    /**
     * Inserta un valor dentro del buffer
     * @param value Valor para insertar
     */
    public synchronized void put(int value) 
    {
        // Mientras el buffer esté disponible
        while (disponible == true) 
        {
            try 
            {
                // me espero a que consuman
                wait();
            } 
            catch (InterruptedException e) {}
        }
        // Cuando vuelve a estar disponible, notifico que está disponible
        contenido = value;
        disponible = true;
        notify();
    }  
}