package tableroAjedrez;

import movimientos.Movimiento;
import movimientos.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Peon extends Pieza {
    protected int id = 0x2659;
    protected ArrayList<Movimiento> movimientos;
    Movimiento dosHaciaAdelante = new DosHaciaAdelante();
    private boolean primerMovimiento = false;

    public Peon(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public Peon() {
        this.movimientos = new ArrayList<Movimiento>();
        this.movimientos.add(new UnoHaciaAdelante());
        this.movimientos.add(dosHaciaAdelante);
        this.movimientos.add(new PeonDiagonal());
    }

    public boolean inicializarMovimientos(int[] casilla, Tablero tablero) {

        ArrayList<String> movimientosValidos = new ArrayList<String>();
        for (Movimiento mov : movimientos) {
            movimientosValidos.addAll(mov.mostrarMovimientos(casilla, tablero));
        }
        boolean controlDeTurnos = mover(casilla, tablero, movimientosValidos);

        if (!primerMovimiento && !controlDeTurnos) {
            this.movimientos.remove(dosHaciaAdelante);
            primerMovimiento = true;
        }
        return controlDeTurnos;
    }

    public int getId() {
        return id;
    }

}
