package  calculators;
import valueobjects.InputValues;

public class AAL5Calculator implements Calculator{
    int trailer;
    int numCeldas;
    int total = 0;
    int padding;
    int bytesCell = 48;
    int aux = 40;
    int totalBytes = 53;

    @Override
    public OutputValues calculateALL5ATM(int bytes ) {

        int array[] = new int[3];
        
        if(bytes % bytesCell == 0) {
            numCeldas =(bytes / bytesCell);
        } else if (bytes > bytesCell){
            numCeldas = (bytes / bytesCell) + 1;
        }else {
            numCeldas = 1;
        }

        int rest = bytes % bytesCell;

        if(resto < aux) {
            padding = bytesCell - trailer - rest;
        } else if (rest == aux ){
            padding = 0;
        } else {
            int num = rest / aux;
            numCeldas++;
            int x = resto % aux;
            padding = aux - x + 8;
        }
        total = numCeldas * totalBytes;
        array[0] = total;
        array[1] = numCeldas;
        array[2] = padding;


        for(int i=0;i<3;i++) {
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