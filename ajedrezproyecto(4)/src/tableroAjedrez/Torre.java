package tableroAjedrez;

import movimientos.EnCruz;
import movimientos.Movimiento;

import java.util.ArrayList;
import java.util.Arrays;

public class Torre extends Pieza {
    protected int id = 0x2656 + 6;


    public Torre(Movimiento... movimientos) {
        this.movimientos = new ArrayList<Movimiento>(Arrays.asList(movimientos));
    }

    public Torre() {
        this.movimientos = new ArrayList<Movimiento>();
        this.movimientos.add(new EnCruz());


    }


    public int getId() {
        return id;
    }
}
