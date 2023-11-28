/**
* La clase Main contiene el método principal que simula operaciones en una CPU ficticia.
*/
public class Main {

    /**
     * Se representan números binarios, se realizan operaciones de carga y suma, y se muestra el resultado.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso)
     */
    public static void main(String[] args) {
        CPU cpu = new CPU(); // Se crea una instancia de la CPU

        boolean[] firstBinary = new boolean[16];
        firstBinary[12] = true; // 0000000000001000
        firstBinary[13] = false;  // 0000000000000100  
        firstBinary[14] = true; // 0000000000000010
        firstBinary[15] = true; // 0000000000000001

        boolean[] secondBinary = new boolean[16];
        secondBinary[12] = false; // 0000000000001000
        secondBinary[13] = true; // 0000000000000100
        secondBinary[14] = false; // 0000000000000010
        secondBinary[15] = true; // 0000000000000011 // 1111111111111100

        // Cargar el número 8 en el registro A
        cpu.executeInstruction(firstBinary, true, false, false);

        // Cargar el número 7 en el registro D
        cpu.executeInstruction(secondBinary, false, true, false);
        
        // Instrucción para sumar los valores de los registros A y D
        cpu.executeInstruction(new boolean[16], false, false, true);

        // Obtener y mostrar el resultado de la suma
        boolean[] result = cpu.getDRegister().getBits();
        int resultValue = convertBinaryToInt(result);
        System.out.println("Resultado de " + convertBinaryToInt(firstBinary) + " + " + convertBinaryToInt(secondBinary) + ":" + " " + resultValue);
    }

    /**
     * Convierte un número binario representado como un arreglo de booleanos en su equivalente decimal.
     *
     * @param binary Arreglo de booleanos que representa un número binario
     * @return El valor decimal correspondiente al número binario representado
     */
    private static int convertBinaryToInt(boolean[] binary) {
        int value = 0;
        for (int i = 0; i < binary.length; i++) {
            if (binary[binary.length - 1 - i]) {
                value += Math.pow(2, i);
            }
        }
        return value;
    }
}

