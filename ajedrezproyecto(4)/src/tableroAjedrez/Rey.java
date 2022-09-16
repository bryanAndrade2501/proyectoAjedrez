package tableroAjedrez;

import movimientos.Movimiento;
import movimientos.UnoAlrededor;
import movimientos.UnoHaciaAdelante;

import java.util.ArrayList;
import java.util.Arrays;

public class Rey extends Pieza {
    protected int id = 0x2654;


    public Rey(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public Rey() {
        this.movimientos = new ArrayList<Movimiento>();
        this.movimientos.add(new UnoHaciaAdelante());
        this.movimientos.add(new UnoAlrededor());

    }


    public int getId() {
        return id;
    }
}
