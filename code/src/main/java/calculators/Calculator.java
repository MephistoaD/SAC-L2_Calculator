package calculators;

import valueobjects.OutputValues;

// TODO: one class for each protocol implementing this interface
//  and having exactly one package-private method which is calculate()
//  (the other methods may be private)
//  The following classes should be implemented:
//  - EthernetCalculator
//  - ALL5ATMCalculator
//  - ALL34ATMCalculator
//  PLEASE: make them package-private.
//  PLEASE: consider the attributes of any object from the Package valueobjects as immutable
//  IMPORTANT: Do not touch this interface!
//             Use unittests instead to evaluate the quality of the code!

public interface Calculator {


    public static OutputValues calculateEthernet(int bytes){

        return null; // new EthernetCalculator().calculate(bytes);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static OutputValues calculateALL5ATM(int bytes ){
            int trailer = 8;
            int numCeldas = 0;
            if(bytes%48==0) {
                numCeldas=(bytes/48);
            }else if (bytes>48){
                numCeldas=(bytes/48)+1;
            }else {
                numCeldas = 1;
            }
            int resto = bytes%48;
            int array[] = new int[3];
            int total=0;
            int padding;
            if(resto<40) {
                padding = 48 - trailer - resto;
            } else if (resto == 40 ){
                padding = 0;
            } else {
                int n= resto/40;
                numCeldas++;
                int sobra = resto%40;
                padding = 40 - sobra + 8;
            }
            total = numCeldas*53;
            array[0] = total;
            array[1] = numCeldas;
            array[2] = padding;
            System.out.println("AAL5");
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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static OutputValues calculateALL34ATM(int bytes){
            System.out.println("AAL34");
            int numCeldas = bytes / 44;
            if(bytes%44==0) {
                numCeldas=(bytes/44);
            }else if (bytes>44){
                numCeldas=(n/44)+1;
            }else {
                numCeldas = 1;
            }
            int resto = bytes % 44;
            int padding = 48 - 4 - resto;
            int array[] = new int[3];
            array[0] = numCeldas* 48;
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
    OutputValues calculate(int bytes);
}
