package movimientos;

import tableroAjedrez.Tablero;

import java.util.ArrayList;

public class EnCruz extends Movimiento {
    @Override
    public ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero) {
        ArrayList<String> movimientos = new ArrayList<String>();

        for (int is = -1; is <= 1; is += 2) {
            int i = is;
            while (casilla[0] + i < 8 && casilla[0] + i >= 0 && (tablero.tablaF.get(casilla[0] + i).get(casilla[1]) == null
                    || tablero.tablaF.get(casilla[0] + i).get(casilla[1]).color != tablero.tablaF.get(casilla[0]).get(casilla[1]).color
            )) {
                movimientos.add(tablero.letra.get(casilla[1]) + tablero.numero.get(casilla[0] + i));
                if(tablero.tablaF.get(casilla[0] + i).get(casilla[1]) != null
                        && tablero.tablaF.get(casilla[0] + i).get(casilla[1]).color != tablero.tablaF.get(casilla[0]).get(casilla[1]).color
                ){
                    break;
                }
                i += is;
            }
        }

        for (int js = -1; js <= 1; js += 2) {
            int j = js;
            while (casilla[1] + j < 8 && casilla[1] + j >= 0 && (tablero.tablaF.get(casilla[0]).get(casilla[1] + j) == null
                    || tablero.tablaF.get(casilla[0]).get(casilla[1] + j).color != tablero.tablaF.get(casilla[0]).get(casilla[1]).color
            )) {
                movimientos.add(tablero.letra.get(casilla[1] + j) + tablero.numero.get(casilla[0]));
                if (tablero.tablaF.get(casilla[0]).get(casilla[1] + j) != null
                        && tablero.tablaF.get(casilla[0]).get(casilla[1] + j).color != tablero.tablaF.get(casilla[0]).get(casilla[1]).color
                ) {
                    break;
                }
                j += js;
            }
        }

        return movimientos;
    }
}
