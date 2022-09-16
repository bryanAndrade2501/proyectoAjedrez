package tableroAjedrez;

import movimientos.Diagonal;
import movimientos.Movimiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alfil extends Pieza {
    public Scanner entrada = new Scanner(System.in);
    protected int id = 0x2657;
    protected Movimiento movimientoPorDefecto;

    public Alfil(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public Alfil() {
        this.movimientoPorDefecto = new Diagonal();
    }


    public int getId() {
        return id;
    }
}
