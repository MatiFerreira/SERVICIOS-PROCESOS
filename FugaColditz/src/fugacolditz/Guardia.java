package fugacolditz;

public class Guardia {
    int x;
    int y;
    public Guardia(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void moverG(Matriz matriz, Guardia g) {
        try {
            int ale = (int) ((Math.random() * 4 + 1));
            switch (ale) {
                case 1:
                    //arriba
                    if ((matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("U")) || (matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("A"))
                            || (matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("P")) || (matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("G"))) {
                        moverG(matriz, g);
                    } else {
                        matriz.tablero[g.x - 1][g.y] = "G";
                        matriz.tablero[g.x][g.y] = "X";
                        g.x = g.x - 1;
                    }
                    break;
                case 2:
                    //abajo
                    if ((matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("U")) || (matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("A"))
                            || (matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("P")) || (matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("G"))) {
                        moverG(matriz, g);
                    } else {
                        matriz.tablero[g.x + 1][g.y] = "G";
                        matriz.tablero[g.x][g.y] = "X";
                        g.x = g.x + 1;
                        break;
                    }
                case 3:
                    //izquierda
                    if ((matriz.tablero[g.x][g.y - 1].equalsIgnoreCase("U")) || (matriz.tablero[g.x][g.y - 1].equalsIgnoreCase("A"))
                            || (matriz.tablero[g.x][g.y - 1].equalsIgnoreCase("P")) || (matriz.tablero[g.x][g.y - 1].equalsIgnoreCase("G"))) {
                        moverG(matriz, g);
                    } else {
                        matriz.tablero[g.x][g.y - 1] = "G";
                        matriz.tablero[g.x][g.y] = "X";
                        g.y = g.y - 1;
                        break;
                    }
                case 4:
                    //derecha
                    if ((matriz.tablero[g.x][g.y + 1].equalsIgnoreCase("U")) || (matriz.tablero[g.x][g.y + 1].equalsIgnoreCase("A"))
                            || (matriz.tablero[g.x][g.y + 1].equalsIgnoreCase("P")) || (matriz.tablero[g.x][g.y + 1].equalsIgnoreCase("G"))) {
                        moverG(matriz, g);
                    } else {
                        matriz.tablero[g.x][g.y + 1] = "G";
                        matriz.tablero[g.x][g.y] = "X";
                        g.y = g.y + 1;
                    }
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            moverG(matriz, g);
        }
    }
}