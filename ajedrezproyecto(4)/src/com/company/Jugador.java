package com.company;

import tableroAjedrez.Pieza;
import tableroAjedrez.Tablero;

import java.util.Arrays;

public class Jugador {
    protected Pieza[] piezas;
    protected String nombre;

    public Jugador(String nombre, Pieza... piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }


    public boolean moverPieza(Tablero tablero) {
        int[] casilla = new int[]{0, 0};
        boolean controlDeTurnosPiezaValida;
        boolean controlDeTurnosCasillaValida = false;

        System.out.print("Ingrese la casilla de la pieza que desea mover: ");
        try {//Ingreso de casillas validas
            casilla = LectorDeCasillas.getCasilla(tablero);
            if (LectorDeCasillas.lectorCasilla.equals("M")) {

            }

        } catch (Exception e) {
            controlDeTurnosCasillaValida = true;
            return controlDeTurnosCasillaValida;
        }

        tablero.imprimirTablero(casilla, null);
        if (Arrays.asList(this.piezas).contains(tablero.tablaF.get(casilla[0]).get(casilla[1]))) {//Verifica que la pieza pertenece al jugador
            controlDeTurnosPiezaValida = tablero.tablaF.get(casilla[0]).get(casilla[1]).inicializarMovimientos(casilla, tablero);
            return controlDeTurnosPiezaValida;
        } else {
            System.out.println("Se trato de mover una ficha del jugador contrincante");
            return true;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
