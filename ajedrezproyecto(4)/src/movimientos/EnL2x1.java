package movimientos;

import tableroAjedrez.Tablero;

import java.util.ArrayList;

public class EnL2x1 extends Movimiento {
    @Override
    public ArrayList<String> mostrarMovimientos(int[] casilla, Tablero tablero) {
        ArrayList<String> movimientos = new ArrayList<String>();
        //RESTRICCIONES
        for (int j = -2; j <= 2; j++) {
            for (int i = -2; i <= 2; i++) {
                try {
                    //Condiciones de movimiento
                    if (!(casilla[0] + i > 8 || casilla[1] + j > 8 || i == 0 || j == 0 || Math.abs(i) == Math.abs(j)
                            || tablero.tablaF.get(casilla[0]+i).get(casilla[1]+j)!=null
                    )) {
                        movimientos.add(tablero.letra.get(casilla[1] + j) + tablero.numero.get(casilla[0] + i));//Ingresar mov valido
                    }
                } catch (Exception e) {
                }
            }
        }
        return movimientos;
    }
}
