package movimientos;

import tableroAjedrez.Tablero;

import java.util.ArrayList;

public class UnoAlrededor extends Movimiento{
    @Override
    public ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero) {
        ArrayList<String> movimientos = new ArrayList<String>();

        try{
            for (int j = -1; j <= 1; j++) {
                for (int i = -1; i <= 1; i++) {
                    if (casilla[1] + j < 8 && casilla[1] + j >= 0 &&
                            (tablero.tablaF.get(casilla[0] + i).get(casilla[1] + j) == null
                                    || tablero.tablaF.get(casilla[0] + i).get(casilla[1] + j).color !=
                                    tablero.tablaF.get(casilla[0]).get(casilla[1]).color
                            )) {

                        movimientos.add(tablero.letra.get(casilla[1] + j) + tablero.numero.get(casilla[0] + i));

                        if (tablero.tablaF.get(casilla[0] + i).get(casilla[1] + j) != null
                                && tablero.tablaF.get(casilla[0] + i).get(casilla[1] + j).color !=
                                tablero.tablaF.get(casilla[0] + i).get(casilla[1] + j).color
                        ) {
                            break;
                        }
                    }
                }
            }
        }catch (IndexOutOfBoundsException ignore){}


        return movimientos;
    }
}
