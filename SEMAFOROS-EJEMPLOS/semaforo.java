
package ejemplovideo2;
import java.util.concurrent.Semaphore;

public class semaforo {
    private int item;
    
    private Semaphore semaforoconsumer = new Semaphore(0);
    private Semaphore semaforoproducer = new Semaphore(1);
    
    public void get(){
        try{
            semaforoconsumer.acquire();
        }catch(InterruptedException e){
            System.out.println("ERROR: " + e);
        }
        System.out.println("El consumidor ha consumido: " + item);
        semaforoproducer.release();
    }
    public void put(int item){
        try{
            semaforoproducer.acquire();
        }catch(InterruptedException e){
            System.out.println("ERROR: " + e);
        }
        this.item = item;
        System.out.println("El productor ha producido: " + item);
        semaforoconsumer.release();
    }
}
