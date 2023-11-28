/**
* La clase Register representa un registro de 16 bits que puede cargar y almacenar datos.
*/
public class Register {
    private static final int WORD_SIZE = 16;
    /** Arreglo de booleanos para almacenar los datos del registro */
    private boolean[] data;

    /**
     * Constructor de la clase Register.
     * Inicializa el arreglo de datos del registro con un tamaño de 16 bits
     */
    public Register() {
        this.data = new boolean[WORD_SIZE];
    }

    /**
     * Carga un valor en el registro si la señal de carga (loadSignal) está activada.
     *
     * @param value      Arreglo de booleanos que contiene el valor a cargar en el registro
     * @param loadSignal Valor booleano que representa la señal de carga
     */
    public void load(boolean[] value, boolean loadSignal) {
        // Verifica si la señal de carga está activada
        if (loadSignal) {
            // Copia el valor proporcionado al arreglo de datos del registro
            System.arraycopy(value, 0, this.data, 0, WORD_SIZE);
        }
    }

    /**
     * Obtiene los bits almacenados actualmente en el registro.
     *
     * @return Un arreglo de booleanos que representa los bits almacenados en el registr
     */
    public boolean[] getBits() {
        return this.data;
    }
}