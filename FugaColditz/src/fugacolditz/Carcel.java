package fugacolditz;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carcel {

    public static void main(String[] args) {
        //creacion de 3 guardias
        Guardia guardia1 = new Guardia(0, 0);
        Guardia guardia2 = new Guardia(-1, -1);
        Guardia guardia3 = new Guardia(-1, -1);
        System.out.println("Elige el nivel de dificultad(facil, medio, dificil):");
        System.out.println("si lo escribes mal se te asigna por defecto el modo dificl asique atento a lo que escribes :)");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();


        //INICIALIZAMOS EL TABLERO
//        Matriz tablero = new Matriz();

        Herramienta pasaporte = new Herramienta("Pasaporte");
        guardia1.m.AniadirHerramienta(pasaporte);
        Herramienta alicates = new Herramienta("Alicates");
        guardia1.m.AniadirHerramienta(alicates);
        Herramienta uniforme = new Herramienta("Uniforme");
        guardia1.m.AniadirHerramienta(uniforme);
        if (opcion.equalsIgnoreCase("facil")) {
            guardia1.m.aniadirGuardia(guardia1);
            guardia1.start();
        } else if (opcion.equalsIgnoreCase("medio")) {
            guardia1.m.aniadirGuardia(guardia1);
            guardia1.m.aniadirGuardia(guardia2);
            guardia1.start();
            guardia2.start();
        } else {
            guardia1.m.aniadirGuardia(guardia1);
            guardia1.m.aniadirGuardia(guardia2);
            guardia1.m.aniadirGuardia(guardia3);
            guardia1.start();
            guardia2.start();
            guardia3.start();
        }
        guardia1.m.AniadirPersonaje();
        System.out.println(guardia1.m.imprimirTablero());
        do {

            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            guardia1.m.personaje1.mover(mov, guardia1.m);

            System.out.println(guardia1.m.imprimirTablero());
            if (guardia1.m.personaje1.alicates && guardia1.m.personaje1.pasaporte && guardia1.m.personaje1.uniforme) {
                System.out.println("HAS GANADO!!!!");
                System.exit(0);
            }
            if ((guardia1.m.personaje1.posicion.x == guardia1.x) && (guardia1.m.personaje1.posicion.y == guardia1.y)
                    || (guardia1.m.personaje1.posicion.x == guardia2.x) && (guardia1.m.personaje1.posicion.y == guardia2.y)
                    || (guardia1.m.personaje1.posicion.x == guardia3.x) && (guardia1.m.personaje1.posicion.y == guardia3.y)) {
                guardia1.m.perder = true;
            }
        } while ((!guardia1.m.EndGame()) && (guardia1.m.personaje1.contador != 30));
        System.out.println("END GAME!");
        System.exit(0);
    }

}
