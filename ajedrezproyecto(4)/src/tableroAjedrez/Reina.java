package tableroAjedrez;

import movimientos.Diagonal;
import movimientos.EnCruz;
import movimientos.Movimiento;

import java.util.ArrayList;
import java.util.Arrays;

public class Reina extends Pieza {
    protected int id = 0x2655;

    public Reina(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public Reina() {
        this.movimientos=new ArrayList<Movimiento>();
        this.movimientos.add(new EnCruz());
        this.movimientos.add(new Diagonal());
    }


    public int getId() {
        return id;
    }

}
