package  calculators;
import valueobjects.InputValues;

public class AAL5Calculator implements Calculator{
    int trailer;
    int numCeldas;

    public AAL5Calculator() {
        trailer = 0;
        numCeldas = 8;
    }


    @Override
    public OutputValues calculateALL5ATM(int bytes ) {

        int array[] = new int[3];
        int total = 0;
        int padding;

        if(bytes %48 == 0) {
            numCeldas =(bytes/48);
        } else if (bytes > 48){
            numCeldas = (bytes/48) + 1;
        }else {
            numCeldas = 1;
        }

        int rest = bytes % 48;

        if(resto < 40) {
            padding = 48 - trailer - rest;
        } else if (rest == 40 ){
            padding = 0;
        } else {
            int num = rest/40;
            numCeldas++;
            int x = resto%40;
            padding = 40 - x + 8;
        }
        total = numCeldas*53;
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