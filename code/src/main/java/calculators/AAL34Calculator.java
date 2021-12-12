package  calculators;
import valueobjects.InputValues;

public class AAL34Calculator implements Calculator{

    @Override
    public OutputValues calculateALL34ATM (int bytes ) {

            int array[] = new int[3];

            int numCeldas = bytes / 44;

            if(bytes % 44 == 0) {
                numCeldas = (bytes / 44);
            }else if (n > 44){
                numCeldas = (bytes / 44) + 1;
            }else {
                numCeldas = 1;
            }
            int resto = bytes % 44;
            int padding = 48 - 4 - resto;

            array[0] = numCeldas* 48;
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