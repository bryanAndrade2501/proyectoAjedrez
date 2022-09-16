package tableroAjedrez;


import com.company.LectorDeCasillas;
import movimientos.Movimiento;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Pieza {
    protected ArrayList<Movimiento> movimientos;
    public int id;
    public String color="";

    public Pieza(Movimiento... movimientos) {
        this.movimientos = new ArrayList<>(Arrays.asList(movimientos));
    }

    public boolean inicializarMovimientos(int[] casilla, Tablero tablero){

        ArrayList<String> movimientosValidos = new ArrayList<String>();
        for (Movimiento mov : movimientos) {
            movimientosValidos.addAll(mov.mostrarMovimientos(casilla, tablero));
        }
        boolean controlDeTurnos=mover(casilla,tablero,movimientosValidos);

        return controlDeTurnos;
    }

    public boolean mover(int[] casilla, Tablero tablero,ArrayList movimientosValidos){
        tablero.imprimirTablero(casilla,movimientosValidos);
        boolean controlDeTurnos = false;
        System.out.println("Los movimietos posibles son:");
        System.out.println(movimientosValidos+"\nIngrese el movimiento que desea realizar");
        int[] casillaFinal = new int[0];
        try {
            casillaFinal = LectorDeCasillas.getCasilla(tablero);
        } catch (Exception e) {
            System.out.println("\033[1;31m"+"No se ingresaron datos");
        }

        //permite ingresar solo movimientos validos
        if(movimientosValidos.contains(LectorDeCasillas.lectorCasilla)){
            tablero.tablaF.get(casillaFinal[0]).set(casillaFinal[1], tablero.tablaF.get(casilla[0]).get(casilla[1]));
            tablero.tablaF.get(casilla[0]).set(casilla[1], null);
        }else{
            System.out.println("Se ingreso un movimiento no valido");
            controlDeTurnos=true;
        }
        //TODO:Borrar
        //tablero.tablaF.get(casillaFinal[0]).set(casillaFinal[1], tablero.tablaF.get(casilla[0]).get(casilla[1]));
        //tablero.tablaF.get(casilla[0]).set(casilla[1], null);

        return controlDeTurnos;
    }



    public int getId(){
        return id;
    }


}
