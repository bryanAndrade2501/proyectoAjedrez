package movimientos;

import tableroAjedrez.Tablero;

import java.util.ArrayList;

public abstract class Movimiento {
    public ArrayList<String> movimientosValidos = new ArrayList<String>();
    public abstract ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero);
}
