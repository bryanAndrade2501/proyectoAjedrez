package movimientos;

import tableroAjedrez.Peon;
import tableroAjedrez.Pieza;
import tableroAjedrez.Tablero;

import java.util.ArrayList;

public class UnoHaciaAdelante extends Movimiento {
    protected Pieza pieza;
    protected Tablero tablero;
    protected int[] casilla;

    public UnoHaciaAdelante() {
    }

    @Override
    public ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero) {
        ArrayList<String> movimientos = new ArrayList<String>();
        int direccion = 1;
        if (tablero.tablaF.get(casilla[0]).get(casilla[1]).color.equals("\033[1;31m")) {
            direccion = -1;
        }
        if (tablero.tablaF.get(casilla[0] + direccion).get(casilla[1]) == null) {//evita que salte la pieza
            movimientos.add(tablero.letra.get(casilla[1]) + tablero.numero.get(casilla[0] + direccion));
        }
        return movimientos;
    }
}
