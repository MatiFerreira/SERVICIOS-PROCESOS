package fugacolditz;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carcel {

    public static void main(String[] args) {
        Semaphore guardiaSemaf = new Semaphore(1,true);
        Matriz m = new Matriz();
        //creacion de 3 guardias
        Guardia guardia1 = new Guardia(0, 0,guardiaSemaf,m);
        Guardia guardia2 = new Guardia(-1, -1,guardiaSemaf,m);
        Guardia guardia3 = new Guardia(-1, -1,guardiaSemaf,m);
        System.out.println("Elige el nivel de dificultad(facil, medio, dificil):");
        System.out.println("si lo escribes mal se te asigna por defecto el modo dificl asique atento a lo que escribes :)");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();


        //INICIALIZAMOS EL TABLERO
//        Matriz tablero = new Matriz();

        Herramienta pasaporte = new Herramienta("Pasaporte");
        m.AniadirHerramienta(pasaporte);
        Herramienta alicates = new Herramienta("Alicates");
        m.AniadirHerramienta(alicates);
        Herramienta uniforme = new Herramienta("Uniforme");
        m.AniadirHerramienta(uniforme);
        if (opcion.equalsIgnoreCase("facil")) {
            m.aniadirGuardia(guardia1);
            guardia1.start();
        } else if (opcion.equalsIgnoreCase("medio")) {
            m.aniadirGuardia(guardia1);
            m.aniadirGuardia(guardia2);
            guardia1.start();
            guardia2.start();
        } else {
            m.aniadirGuardia(guardia1);
            m.aniadirGuardia(guardia2);
            m.aniadirGuardia(guardia3);
            guardia1.start();
            guardia2.start();
            guardia3.start();
        }
        m.AniadirPersonaje();
        System.out.println(m.imprimirTablero());
        do {

            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            m.personaje1.mover(mov, m);

            System.out.println(m.imprimirTablero());
            if (m.personaje1.alicates && m.personaje1.pasaporte && m.personaje1.uniforme) {
                System.out.println("HAS GANADO!!!!");
                System.exit(0);
            }
            
        } while ((!m.EndGame()) && (m.personaje1.contador != 30));
        System.out.println("END GAME!");
        System.exit(0);
    }

}
