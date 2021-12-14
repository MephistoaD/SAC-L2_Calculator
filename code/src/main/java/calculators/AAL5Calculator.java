package code.src.main.java.calculators;

public class AAL5Calculator implements calculators.Calculator {
    int trailer;
    int numCeldas;
    int total = 0;
    int padding;
    int bytesCell = 48;
    int aux = 40;
    int totalBytes = 53;





    @Override
    public int[] calculate(int bytes) {
            int data[] = new int[3];

            if (bytes % bytesCell == 0) {
                numCeldas = (bytes / bytesCell);
            } else if (bytes > bytesCell) {
                numCeldas = (bytes / bytesCell) + 1;
            } else {
                numCeldas = 1;
            }

            int rest = bytes % bytesCell;

            if (rest < aux) {
                padding = bytesCell - trailer - rest;
            } else if (rest == aux) {
                padding = 0;
            } else {
                int num = rest / aux;
                numCeldas++;
                int x = rest % aux;
                padding = aux - x + 8;
            }
            total = numCeldas * totalBytes;
            data[0] = total;
            data[1] = numCeldas;
            data[2] = padding;


            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        System.out.print("Bytes: ");
                        break;
                    case 1:
                        System.out.print("Cells: ");
                        break;
                    case 2:
                        System.out.print("Padding: ");
                        break;
                }
                System.out.println(data[i]);
            }
            return data;

    }
}