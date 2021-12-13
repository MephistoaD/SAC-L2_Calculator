package  calculators;
import valueobjects.InputValues;

public class AAL34Calculator implements Calculator{
    int numCeldas;
    int bytesCell = 44;
    int totalBytes = 48;

    @Override
    public OutputValues calculateALL34ATM (int bytes ) {

            int array[] = new int[3];


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

            array[0] = numCeldas * totalBytes;
            array[1] = numCeldas;
            array[2] = padding;

            for(int i = 0; i < 3; i++) {
                switch(i) {
                    case 0: System.out.print("total bytes: ");
                        break;
                    case 1: System.out.print("total cells: ");
                        break;
                    case 2: System.out.print("padding: ");
                        break;
                }
                System.out.println(array[i]);
            }
            return array;
        }
    }
}