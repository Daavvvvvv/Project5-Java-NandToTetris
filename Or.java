/**
* La clase Or representa una operación lógica de "OR" entre dos arreglos de booleanos.
*/
public class Or {

    /**
     * Realiza la operación lógica "OR" elemento por elemento entre dos arreglos de booleanos.
     *
     * @param a Primer arreglo de booleanos
     * @param b Segundo arreglo de booleanos
     * @return Un nuevo arreglo de booleanos que contiene el resultado de la operación "OR"
     */
    public boolean[] compute(boolean[] a, boolean[] b) {
        // Crea un nuevo arreglo de booleanos con la misma longitud que el arreglo 'a'
        boolean[] result = new boolean[a.length];

        // Realiza la operación "OR" elemento por elemento entre los arreglos 'a' y 'b'
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] || b[i]; // Aplica la operación "OR" en cada elemento
        }

        // Devuelve el arreglo que contiene los resultados de las operaciones "OR"
        return result;
    }
}