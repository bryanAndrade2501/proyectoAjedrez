package tableroAjedrez;

import movimientos.EnL2x1;
import movimientos.Movimiento;
import movimientos.UnoAlrededor;
import movimientos.UnoHaciaAdelante;

import java.util.ArrayList;
import java.util.Arrays;

public class Caballo extends Pieza {
    protected int id = 0x2658;
    protected Movimiento movimientoPorDefecto;


    public Caballo(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public Caballo() {
        this.movimientos = new ArrayList<Movimiento>();
        this.movimientos.add(new EnL2x1());
    }

    public int getId() {
        return id;
    }

    ;
}
