package com.company;

import tableroAjedrez.Tablero;

import java.util.Scanner;

public class LectorDeCasillas {
    public static Scanner entrada = new Scanner(System.in);
    public static String lectorCasilla;

    public static int[] getCasilla(Tablero tablero) throws Exception {
        int[] casilla = new int[2];
        lectorCasilla = entrada.nextLine().toUpperCase();

        //TODO: verificar si tiene mas de 0 si no excepcion.
        if(lectorCasilla.length()==0){
            throw new Exception("No se ingresaron datos");
        }
        casilla[1] = tablero.letra.indexOf(lectorCasilla.substring(0, 1));
        casilla[0] = Integer.parseInt(lectorCasilla.substring(1, 2)) - 1;
        return casilla;
    }
}
