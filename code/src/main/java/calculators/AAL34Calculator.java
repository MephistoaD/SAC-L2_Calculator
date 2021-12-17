package code.src.main.java.calculators;
import code.src.main.java.valueobjects.InputValues;
import code.src.main.java.valueobjects.L2Protocol;

public class AAL34Calculator implements Calculator {
    int numCeldas;
    int bytesCell = 44;
    int totalBytes = 48;

    @Override
    public code.src.main.java.valueobjects.OutputValues calculate(int bytes) {
        numCeldas = bytes / bytesCell;
        if(bytes % bytesCell == 0) {
            numCeldas = (bytes / bytesCell);
        }
        else if (bytes > bytesCell){
            numCeldas = (bytes / bytesCell) + 1;
        }
        else {
            numCeldas = 1;
        }
        int resto = bytes % bytesCell;
        int padding = bytesCell - resto;

        return new code.src.main.java.valueobjects.OutputValues(L2Protocol.AAL3_4_ATM, numCeldas * totalBytes, numCeldas, padding);
    }
}
