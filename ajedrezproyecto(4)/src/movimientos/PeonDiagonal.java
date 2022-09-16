package movimientos;

import tableroAjedrez.Tablero;

import java.util.ArrayList;

public class PeonDiagonal extends Movimiento {
    @Override
    public ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero) {
        ArrayList<String> movimientos = new ArrayList<String>();
        //TODO:12-15 se puede reducir
        int direccion = 1;
        if (tablero.tablaF.get(casilla[0]).get(casilla[1]).color.equals("\033[1;31m")) {
            direccion = -1;
        }

        try {
            for (int j = -1; j <= 1; j += 2) {
                if (casilla[1] + j < 8 && casilla[1] + j >= 0 &&
                        (tablero.tablaF.get(casilla[0] + direccion).get(casilla[1] + j) != null
                                || tablero.tablaF.get(casilla[0] + direccion).get(casilla[1] + j).color !=
                                tablero.tablaF.get(casilla[0] + direccion).get(casilla[1]).color
                        )) {

                    movimientos.add(tablero.letra.get(casilla[1] + j) + tablero.numero.get(casilla[0] + direccion));

                    if (tablero.tablaF.get(casilla[0] + direccion).get(casilla[1] + j) != null
                            && tablero.tablaF.get(casilla[0] + direccion).get(casilla[1] + j).color !=
                            tablero.tablaF.get(casilla[0] + direccion).get(casilla[1]).color
                    ) {
                        break;
                    }

                }
            }
        } catch (NullPointerException ignored) {
        }


        return movimientos;
    }
}
