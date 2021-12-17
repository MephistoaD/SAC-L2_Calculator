package calculators;

import valueobjects.L2Protocol;
import valueobjects.OutputValues;

public class AAL34Calculator implements Calculator {
    int numCeldas;
    int bytesCell = 44;
    int totalBytes = 53;

    @Override
    public OutputValues calculate(int bytes) {
         numCeldas = (int) Math.ceil(bytes / (double) bytesCell);
        int bytesLastCell = bytes % bytesCell;
        int padding = bytesCell - bytesLastCell;

        int totalBytesOfAllCells = totalBytes * numCeldas;
        return new OutputValues(L2Protocol.AAL5_ATM, totalBytesOfAllCells, numCeldas, padding);
    }
}
