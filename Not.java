/**
* La clase Not representa un inversor lógico que niega cada elemento de un arreglo de booleanos.
*/
public class Not {
    /**
     * Realiza la operación lógica NOT (inversión) en un arreglo de booleanos.
     *
     * @param input Arreglo de booleanos que se va a negar
     * @return Un nuevo arreglo de booleanos que contiene el resultado de la operación NOT
     */
    public boolean[] compute(boolean[] input) {
        // Crea un nuevo arreglo de booleanos con la misma longitud que el arreglo de entrada
        boolean[] result = new boolean[input.length];

        // Realiza la operación NOT en cada elemento del arreglo de entrada
        for (int i = 0; i < input.length; i++) {
            result[i] = !input[i]; // Nega el valor del elemento en la posición 'i'
        }

        // Devuelve el arreglo que contiene el resultado de la operación NOT
        return result;
    }
}