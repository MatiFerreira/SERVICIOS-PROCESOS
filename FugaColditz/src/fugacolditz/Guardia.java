package fugacolditz;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guardia extends Thread {

    int x;
    int y;
    Semaphore semaforog;
    Matriz m = new Matriz();

    public Guardia(int x, int y, Semaphore semaf, Matriz matriz) {
        this.x = x;
        this.y = y;
        this.semaforog = semaf;
        this.m = matriz;
    }

    @Override
    public void run() {
        try {
            while (!m.perder) {
                //System.out.println("ola");
                semaforog.acquire();
                moverG();
                semaforog.release();
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Guardia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void moverG() {
        try {
            int ale = (int) ((Math.random() * 4 + 1));
            switch (ale) {
                case 1:
                    //arriba
                    if ((m.tablero[this.x - 1][this.y].equalsIgnoreCase("U")) || (m.tablero[this.x - 1][this.y].equalsIgnoreCase("A"))
                            || (m.tablero[this.x - 1][this.y].equalsIgnoreCase("P")) || (m.tablero[this.x - 1][this.y].equalsIgnoreCase("G"))) {
                        moverG();
                    } else {
                        m.tablero[this.x - 1][this.y] = "G";
                        m.tablero[this.x][this.y] = "X";
                        this.x = this.x - 1;
                        if (m.tablero[this.x - 1][this.y].equalsIgnoreCase("O")) {
                            System.out.println("Te ha pillado un guardia!");
                            m.perder = true;
                        }
                    }

                    break;
                case 2:
                    //abajo
                    if ((m.tablero[this.x + 1][this.y].equalsIgnoreCase("U")) || (m.tablero[this.x + 1][this.y].equalsIgnoreCase("A"))
                            || (m.tablero[this.x + 1][this.y].equalsIgnoreCase("P")) || (m.tablero[this.x + 1][this.y].equalsIgnoreCase("G"))) {
                        moverG();
                    } else {
                        m.tablero[this.x + 1][this.y] = "G";
                        m.tablero[this.x][this.y] = "X";
                        this.x = this.x + 1;
                        if (m.tablero[this.x + 1][this.y].equalsIgnoreCase("O")) {
                            System.out.println("Te ha pillado un guardia!");
                            m.perder = true;
                        }
                        break;
                    }

                case 3:
                    //izquierda
                    if ((m.tablero[this.x][this.y - 1].equalsIgnoreCase("U")) || (m.tablero[this.x][this.y - 1].equalsIgnoreCase("A"))
                            || (m.tablero[this.x][this.y - 1].equalsIgnoreCase("P")) || (m.tablero[this.x][this.y - 1].equalsIgnoreCase("G"))) {
                        moverG();
                    } else {
                        m.tablero[this.x][this.y - 1] = "G";
                        m.tablero[this.x][this.y] = "X";
                        this.y = this.y - 1;
                        if (m.tablero[this.x][this.y - 1].equalsIgnoreCase("O")) {
                            System.out.println("Te ha pillado un guardia!");
                            m.perder = true;
                        }
                        break;
                    }

                case 4:
                    //derecha
                    if ((m.tablero[this.x][this.y + 1].equalsIgnoreCase("U")) || (m.tablero[this.x][this.y + 1].equalsIgnoreCase("A"))
                            || (m.tablero[this.x][this.y + 1].equalsIgnoreCase("P")) || (m.tablero[this.x][this.y + 1].equalsIgnoreCase("G"))) {
                        moverG();
                    } else {
                        m.tablero[this.x][this.y + 1] = "G";
                        m.tablero[this.x][this.y] = "X";
                        this.y = this.y + 1;
                        if (m.tablero[this.x][this.y + 1].equalsIgnoreCase("O")) {
                            System.out.println("Te ha pillado un guardia!");
                            m.perder = true;
                        }
                    }

                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            moverG();
        }
    }
}
