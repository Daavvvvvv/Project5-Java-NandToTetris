/**
* La clase And representa una operación lógica de "AND" entre dos arreglos de booleanos.
*/
public class And {
    /**
     * Realiza la operación lógica "AND" entre dos arreglos de booleanos.
     *
     * @param a Primer arreglo de booleanos
     * @param b Segundo arreglo de booleanos
     * @return Un nuevo arreglo de booleanos que contiene el resultado de la operación "AND"
     */
    public boolean[] compute(boolean[] a, boolean[] b) {
        // Crea un nuevo arreglo de booleanos con la misma longitud que el arreglo 'a'
        boolean[] result = new boolean[a.length];

        // Realiza la operación "AND" entre los elementos correspondientes de 'a' y 'b'
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] && b[i];
        }

        // Devuelve el arreglo que contiene los resultados de las operaciones "AND"
        return result;
    }
}