/**
 * Clase CPU que simula la funcionalidad central de una Unidad Central de Procesamiento
 */
public class CPU {
    // Registros A y D utilizados para almacenar datos y direcciones
    private ARegister aRegister;
    private DRegister dRegister;

    // ALU para realizar operaciones aritméticas y lógicas
    private ALU alu;

    // Mux16 es un multiplexor de 16 bits, utilizado para seleccionar entre dos entradas de datos
    private Mux16 mux16;

    /**
     * Constructor de la clase CPU
     * Inicia los registros, la ALU y el multiplexor
     */
    public CPU() {
        aRegister = new ARegister();
        dRegister = new DRegister();
        alu = new ALU();
        mux16 = new Mux16();
    }

    /**
     * Ejecuta una instrucción general en la CPU
     *
     * @param instruction Array de booleanos que representa la instrucción
     * @param isALoad Flag que indica si se debe cargar un valor en el registro A
     * @param isDLoad Flag que indica si se debe cargar un valor en el registro D.
     * @param isALUOp Flag que indica si se debe realizar una operación en la ALU
     */
    public void executeInstruction(boolean[] instruction, boolean isALoad, boolean isDLoad, boolean isALUOp) {
        if (isALoad) {
            aRegister.load(instruction, true);
        }

        if (isDLoad) {
            dRegister.load(instruction, true);
        }

        if (isALUOp) {
            boolean[] aluResult = alu.compute(aRegister.getBits(), dRegister.getBits(), false, false, false, false, true, false);
            dRegister.load(aluResult, true);
        }
    }

    /**
     * Ejecuta una instrucción específica de AND en la CPU
     *
     * @param instruction Array de booleanos que representa la instrucción.
     * @param isALoad Flag que indica si se debe cargar un valor en el registro A.
     * @param isDLoad Flag que indica si se debe cargar un valor en el registro D.
     * @param isALUOp Flag que indica si se debe realizar una operación en la ALU.
     * @param isAndOperation Flag que indica si la operación de la ALU debe ser un AND.
     */
    public void andInstructionInstruction(boolean[] instruction, boolean isALoad, boolean isDLoad, boolean isALUOp, boolean isAndOperation) {
        if (isALoad) {
            aRegister.load(instruction, true);
        }
    
        if (isDLoad) {
            dRegister.load(instruction, true);
        }
    
        if (isALUOp) {
            boolean zx = false, nx = false, zy = false, ny = false, f = !isAndOperation, no = false;
            boolean[] aluResult = alu.compute(aRegister.getBits(), dRegister.getBits(), false, true, false, false, false, false);
            dRegister.load(aluResult, true);
        }
    }

    /**
     * Obtiene el estado actual del registro D.
     *
     * @return El registro D.
     */
    public DRegister getDRegister() {
        return dRegister;
    }

    // Aquí se pueden agregar otros métodos según sea necesario.
}
