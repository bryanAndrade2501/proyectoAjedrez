package Menu;

import java.io.IOException;

public class MenuParaProyectos {

    public static void imprimirMenu(Opcionable tx){
        tx.devolverOpciones();
    }

    public static void elegirOpcion(Opcionable tx) throws IOException, ClassNotFoundException {
        tx.seleccionarOpcion();
    }

}
