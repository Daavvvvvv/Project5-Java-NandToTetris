/**
* La clase Mux16 representa un multiplexor de 16 bits que elige entre dos arreglos de booleanos basado en una señal de selección.
*/
public class Mux16 {

    /** Tamaño de palabra predeterminado para este multiplexor (16 bits) 
     * 
    */
    private static final int WORD_SIZE = 16;

    /**
     * Realiza la operación de multiplexión (MUX) de 16 bits entre dos arreglos de booleanos basado en la señal de selección.
     *
     * @param a   Primer arreglo de booleanos de 16 bits
     * @param b   Segundo arreglo de booleanos de 16 bits
     * @param sel Valor booleano que actúa como señal de selección para el multiplexor
     * @return Un nuevo arreglo de booleanos de 16 bits, resultado de la operación de multiplexión
     */
    public boolean[] compute(boolean[] a, boolean[] b, boolean sel) {
        // Crea un nuevo arreglo de booleanos para almacenar el resultado de la operación de multiplexión
        boolean[] output = new boolean[WORD_SIZE];

        // Realiza la operación de multiplexión en cada bit de los arreglos 'a' y 'b'
        for (int i = 0; i < WORD_SIZE; i++) {
            // Selecciona el bit correspondiente del arreglo 'a' o 'b' basado en el valor de 'sel'
            output[i] = sel ? b[i] : a[i];
        }

        // Devuelve el arreglo que contiene el resultado de la operación de multiplexión
        return output;
    }
}