package code.src.main.java.calculators;
import code.src.main.java.valueobjects.InputValues;
import code.src.main.java.valueobjects.L2Protocol;
import code.src.main.java.valueobjects.OutputValues;

public class AAL5Calculator implements code.src.main.java.calculators.Calculator {
    int bytesCell = 48;
    int totalBytes = 53;
    final int TRAILER = 8;

    @Override
    public OutputValues calculate(int bytes) {
        /* 1496 bytes / 48 bytes of payload per AAL5 packet = 31,16 (round up)→ 32 used packets (8 bytes leftover data in the last packet)

            Last ATM package:

            48 bytes of payload - 8 bytes of trailer - 8 bytes of leftover data = 32 bytes of padding

            → 32 ATM cells are going to be used, while the last one will be filled with 32 bytes of padding
        *
        * */
        int celdas = (int) Math.ceil(bytes / (double) bytesCell);
        int bytesLastCell = bytes % bytesCell;
        int padding = bytesCell - TRAILER - bytesLastCell;
        if (padding < 0){
            celdas++;
            padding += bytesCell;
        }
        int totalBytesOfAllCells = totalBytes * celdas;
        return new code.src.main.java.valueobjects.OutputValues(L2Protocol.AAL5_ATM, totalBytesOfAllCells, celdas, padding);
    }
}