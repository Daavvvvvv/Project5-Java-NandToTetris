/**
 * Clase ALU que representa la Unidad Aritmética Lógica de una CPU.
 */
public class ALU {
    // Tamaño de la palabra en bits utilizada en las operaciones.
    private static final int WORD_SIZE = 16;

    // Puertas lógicas AND y NOT utilizadas para las operaciones.
    private And andGate = new And();
    private Not notGate = new Not();

    /**
     * Realiza una operación aritmética o lógica basada en los parámetros proporcionados.
     *
     * @param x Array de booleanos que representa el primer operando.
     * @param y Array de booleanos que representa el segundo operando.
     * @param zx Flag para poner a cero el primer operando.
     * @param nx Flag para negar el primer operando.
     * @param zy Flag para poner a cero el segundo operando.
     * @param ny Flag para negar el segundo operando.
     * @param f Flag que determina la operación a realizar (suma o AND).
     * @param no Flag para negar el resultado de la operación.
     * @return Array de booleanos que representa el resultado de la operación.
     */
    public boolean[] compute(boolean[] x, boolean[] y, boolean zx, boolean nx, boolean zy, boolean ny, boolean f, boolean no) {
        boolean[] out;

        if (zx) { x = zeroWord(); }
        if (nx) { x = notGate.compute(x); }
        if (zy) { y = zeroWord(); }
        if (ny) { y = notGate.compute(y); }

        if (f) {
            out = addWords(x, y);
        } else {
            out = andGate.compute(x, y);
        }

        if (no) { out = notGate.compute(out); }

        return out;
    }

    /**
     * Genera un array de booleanos con todos los bits en false.
     *
     * @return Array de booleanos de longitud WORD_SIZE con todos los elementos en false.
     */
    private boolean[] zeroWord() {
        return new boolean[WORD_SIZE];
    }

    /**
     * Realiza una suma binaria entre dos arrays de booleanos.
     *
     * @param a Primer array de booleanos para la suma.
     * @param b Segundo array de booleanos para la suma.
     * @return Array de booleanos que representa la suma de 'a' y 'b'.
     */
    private boolean[] addWords(boolean[] a, boolean[] b) {
        boolean[] sum = new boolean[WORD_SIZE];
        boolean carry = false;
        for (int i = WORD_SIZE - 1; i >= 0; i--) {
            sum[i] = a[i] ^ b[i] ^ carry;
            carry = (a[i] && b[i]) || (a[i] && carry) || (b[i] && carry);
        }
        return sum;
    }
}
