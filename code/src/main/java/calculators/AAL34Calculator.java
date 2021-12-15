package code.src.main.java.calculators;
import valueobjects.InputValues;

public class AAL34Calculator implements Calculator {
    int numCeldas;
    int bytesCell = 44;
    int totalBytes = 48;



    @Override
    public int[] calculate(int bytes) {

        int data[] = new int[3];
        int n = 0;


        numCeldas = bytes / bytesCell;

        if(bytes % bytesCell == 0) {
            numCeldas = (bytes / bytesCell);
        }else if (n > bytesCell){
            numCeldas = (bytes / bytesCell) + 1;
        }else {
            numCeldas = 1;
        }
        int resto = bytes % bytesCell;
        int padding = bytesCell - resto;

        data[0] = numCeldas * totalBytes;
        data[1] = numCeldas;
        data[2] = padding;

        for(int i = 0; i < 3; i++) {
            switch(i) {
                case 0: System.out.print("Bytes: ");
                    break;
                case 1: System.out.print("Cells: ");
                    break;
                case 2: System.out.print("Padding: ");
                    break;
            }
            System.out.println(data[i]);
        }
        return data;
    }
}
}