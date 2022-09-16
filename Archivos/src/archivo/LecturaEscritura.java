package archivo;

import java.io.*;
import java.io.Serializable;

public class LecturaEscritura<T> implements Serializable{
    private String nombreDeArchivo;

    public LecturaEscritura(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public void escribirArchivo(T objeto) throws IOException {
        //1. Referencia a un archivo
        File archivo = new File(nombreDeArchivo);
        //2. Definir el flujo de datos hacia el archivo
        FileOutputStream flujoDeEscritura = new FileOutputStream(archivo);
        //3. Definimos el manejador de escritura
        ObjectOutputStream manejadorDeEscritura = new ObjectOutputStream(flujoDeEscritura);
        manejadorDeEscritura.writeObject(objeto);
        //5. Cerramos el archivo
        manejadorDeEscritura.close();
    }

    public T leerArchivo() throws IOException, ClassNotFoundException {
        //1. Referencia a un archivo
        File archivo = new File(nombreDeArchivo);
        //2. Definir el flujo de datos hacia el archivo
        FileInputStream flujoDeEscritura = new FileInputStream(archivo);
        //3. Definimos el manejador de escritura
        ObjectInputStream manejadorDeEscritura = new ObjectInputStream(flujoDeEscritura);
        T objeto = (T) manejadorDeEscritura.readObject();
        //5. Cerramos el archivo
        manejadorDeEscritura.close();
        return objeto;
    }
}
