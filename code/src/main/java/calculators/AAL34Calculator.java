package code.src.main.java.calculators;
import code.src.main.java.valueobjects.InputValues;
import code.src.main.java.valueobjects.L2Protocol;

public class AAL34Calculator implements Calculator {
    int numCeldas;
    int bytesCell = 44;
    int totalBytes = 48;

    @Override
    public code.src.main.java.valueobjects.OutputValues calculate(int bytes) {
         numCeldas = (int) Math.ceil(bytes / (double) bytesCell);
        int bytesLastCell = bytes % bytesCell;
        int padding = bytesCell - bytesLastCell;
        if (padding < 0){
            numCeldas++;
            padding += bytesCell;
        }
        int totalBytesOfAllCells = totalBytes * numCeldas;
        return new code.src.main.java.valueobjects.OutputValues(L2Protocol.AAL5_ATM, totalBytesOfAllCells, numCeldas, padding);
    }
}
