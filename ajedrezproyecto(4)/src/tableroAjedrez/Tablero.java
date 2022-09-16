package tableroAjedrez;

import java.util.ArrayList;
import java.util.Arrays;


public class Tablero {
    //Tabla de fichas (Guarda las posiciones de las fichas con sus datos respectivos)
    public ArrayList<ArrayList<Pieza>> tablaF = new ArrayList<>();

    //Arrays de columnas y filas del tablero (usados en impresiones, devoluciones de lectura y seleccion de casillas)
    public final ArrayList<String> letra = new ArrayList<String>(
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));
    public final ArrayList<String> numero = new ArrayList<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));

    //Colores tablero
    private final String colorCasillaNegra = "\u001B[40m";
    private final String colorCasillaBlanca = "\u001B[47m";

    //Colores de movimientos validos
    private final String colorCasillaValidaB = "\033[46m";
    private final String colorCasillaValidaN = "\033[44m";//TODO: Cambiar por: Color mov valido......comentario: azul
    private final String colorCasillaElejida = "\033[42m";
    private final String colorCasillaComer = "\033[45m";

    //Colores Fichas
    private final String colorFichasJ1 = "\033[1;34m";
    private final String colorFichasJ2 = "\033[1;31m";

    //Piezas de cada jugador
    protected ArrayList<Pieza> piezasJugador1;
    protected ArrayList<Pieza> piezasJugador2;

    //Constructor del tablero
    public Tablero(Pieza[] piezasJugador1, Pieza[] piezasJugador2) {
        this.piezasJugador1 = new ArrayList<>(Arrays.asList(piezasJugador1));
        this.piezasJugador2 = new ArrayList<>(Arrays.asList(piezasJugador2));
        this.colocarPiezas();
    }

    public void colocarPiezas() {//Funcion que inicializa las posiciones de las piezas para una partida nueva.
        //ciclo for para crear 8 arrayList dentro del ArrayList tablaF (linea 9)
        for (int i = 0; i <= 7; i++) {
            tablaF.add(i, new ArrayList<>());
        }

        //Inicializacion Piezas en sus respectivas casillas
        for (int i = 0; i <= 7; i++) {
            tablaF.get(0).add(piezasJugador1.get(i));//colocacion de  piezas en la columna 1
            tablaF.get(1).add(piezasJugador1.get(i + 8));//colocacion de piezas en la columna 2
            tablaF.get(2).add(null);//agregacion de casillas con fichas "nulas"
            tablaF.get(3).add(null);//agregacion de casillas con fichas "nulas"
            tablaF.get(4).add(null);//agregacion de casillas con fichas "nulas"
            tablaF.get(5).add(null);//agregacion de casillas con fichas "nulas"
            //(Permiten que el array tenga el numero de elementos adecuado)
            tablaF.get(6).add(piezasJugador2.get(i + 8));//colocacion de  piezas en la columna 7
            tablaF.get(7).add(piezasJugador2.get(i));//colocacion de  piezas en la columna 8

            piezasJugador1.get(i).color = colorFichasJ1;//Establece el color de las fichas del jugador 1
            piezasJugador1.get(i + 8).color = colorFichasJ1;//Establece el color de las fichas del jugador 1
            piezasJugador2.get(i).color = colorFichasJ2;//Establece el color de las fichas del jugador 2
            piezasJugador2.get(i + 8).color = colorFichasJ2;//Establece el color de las fichas del jugador 2
        }
    }

    protected String tablaG[][] = new String[10][10];//Tabla Grafica (solo para impresión)

    public void imprimirTablero() {
        int espacioVacio = 0x2004;//5 espacios Vacios equivalen a una casilla vacía

        //Inicialización del array de la tabla gráfica()
        for (String[] p : tablaG) {
            Arrays.fill(p, "");
        }

        //Colores de casillas (blancas/negras)
        for (int j = 1; j <= 8; j++) {
            for (int i = 1; i <= 8; i++) {//Inicializador cuadros negros
                tablaG[i][j] = colorCasillaNegra + (char) (espacioVacio) + (char) (espacioVacio)
                        + (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio);
                if ((i + j) % 2 == 0) {//Alternador de blancos
                    tablaG[i][j] = colorCasillaBlanca + (char) (espacioVacio) + (char) (espacioVacio)
                            + (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio);
                }

                try {//TODO: Controlar con if
                    tablaG[i][j] = tablaG[i][j].substring(0, 5) + //que es esto
                            tablaF.get(i - 1).get(j - 1).color + (char) espacioVacio +
                            (char) tablaF.get(i - 1).get(j - 1).getId();
                } catch (Exception e) {
                }
            }
        }

        //Colocacion de letras y numeros
        for (int i = 1; i <= 8; i++) {
            tablaG[0][i] = letra.get(i - 1); //coloca las letras en la columna izquierda
            tablaG[9][i] = (char) (0x2007) + letra.get(i - 1); //coloca las letras en la columna derecha
            tablaG[i][0] = (char) (0x3000) + numero.get(i - 1); //coloca las numeros en la fila superior
            tablaG[i][9] = (char) (0x3000) + numero.get(i - 1); //coloca las numeros en la fila inferior
        }

        //Impresion
        for (int j = 0; j <= 9; j++) {
            for (int i = 0; i <= 9; i++) {
                //Impresion de la tabla grafica por consola
                //tablaG: guarda los valores inicializados anteriormente (id de ficha,color,posicion,color de casilla)
                //tablaG: como primero se imprimen primero las letras y numeros de columanas y filas la primera salida
                //seria "letra+espacioVacio-->(A'  ')" luego el la linea 85 se tiene "espacio vacio+idFicha-->'  'REY"
                //la impresion sigue el siguiente patron: A+'  '+'  '+ID+'  '+'  '+ID... entre espacios se cambia de color
                //de la casilla(blanca/negra) de esta forma la ficha queda centrada en la casilla.
                System.out.print(tablaG[i][j] + (char) espacioVacio + "\033[0m");//"\033[0m" reinicia colores
            }
            System.out.println();//salto de linea cuando la fila termino de imprimir.
        }
    }

    public void imprimirTablero(int[] casilla, ArrayList<String> movimientosValidos) {
        int espacioVacio = 0x2004;//5 espacios Vacios equivalen a una casilla vacía

        //Inicialización del array de la tabla gráfica()
        for (String[] p : tablaG) {
            Arrays.fill(p, "");
        }

        //Colores de casillas (blancas/negras)
        for (int j = 1; j <= 8; j++) {
            for (int i = 1; i <= 8; i++) {//Inicializador cuadros negros
                tablaG[i][j] = colorCasillaNegra + (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio)
                        + (char) (espacioVacio) + (char) (espacioVacio);
                if ((i + j) % 2 == 0) {//Alternador de blancos
                    tablaG[i][j] = colorCasillaBlanca + (char) (espacioVacio) + (char) (espacioVacio)
                            + (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio);
                }

                try {//TODO: Controlar con if
                    tablaG[i][j] = tablaG[i][j].substring(0, 5) + //que es esto
                            tablaF.get(i - 1).get(j - 1).color + (char) espacioVacio +
                            (char) tablaF.get(i - 1).get(j - 1).getId();
                } catch (Exception e) {
                }
            }
        }

        tablaG[casilla[0] + 1][casilla[1] + 1] = colorCasillaElejida + (tablaG[casilla[0]
                + 1][casilla[1] + 1]).substring(5);
        try {
            int[] cas = new int[2];
            for (String s : movimientosValidos) {
                cas[1] = this.letra.indexOf(s.substring(0, 1));
                cas[0] = Integer.parseInt(s.substring(1, 2)) - 1;
                if (tablaG[cas[0] + 1][cas[1] + 1].substring(0, 5).equals(colorCasillaNegra)) {
                    tablaG[cas[0] + 1][cas[1] + 1] = colorCasillaValidaB + (char) (espacioVacio) +
                            (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio)
                            + (char) (espacioVacio);
                } else {
                    tablaG[cas[0] + 1][cas[1] + 1] = colorCasillaValidaN + (char) (espacioVacio) +
                            (char) (espacioVacio) + (char) (espacioVacio) + (char) (espacioVacio)
                            + (char) (espacioVacio);
                }
                if (tablaF.get(cas[0]).get(cas[1]) != null) {
                    tablaG[cas[0] + 1][cas[1] + 1] = colorCasillaComer + (char) espacioVacio
                            + tablaF.get(cas[0]).get(cas[1]).color + (char) tablaF.get(cas[0]).get(cas[1]).getId();
                }
            }
        } catch (Exception e) {

        }


        //Colocacion de letras y numeros
        for (int i = 1; i <= 8; i++) {
            tablaG[0][i] = letra.get(i - 1);
            tablaG[9][i] = (char) (0x2007) + letra.get(i - 1);
            tablaG[i][0] = (char) (0x3000) + numero.get(i - 1);
            tablaG[i][9] = (char) (0x3000) + numero.get(i - 1);
        }

        //Impresion
        for (int j = 0; j <= 9; j++) {
            for (int i = 0; i <= 9; i++) {
                System.out.print(tablaG[i][j] + (char) espacioVacio + "\033[0m");
            }
            System.out.println();
        }


    }
}



