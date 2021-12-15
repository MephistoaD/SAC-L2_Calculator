package code.src.main.java.calculators;
import code.src.main.java.valueobjects.InputValues;

public class EthernetCalculator implements Calculator{

    int eth_frames;
    int bytes;
    int padding;
    int bytesframemax = 1500;
    int bytesframemin= 46;
    int rest;
    int totalbytes;


    @Override
    public int[] calculate(int bytes) {
        int array[] = new int[3];

        //-------------!
        if(bytes>bytesframemin && bytes<bytesframemax)
        {
            eth_frames = 1;
        }else if (bytes<bytesframemin)
        {
            //es solo un frame y necesita padding pa llegar a 46
            eth_frames= bytes + padding;  //bytes enviados mas el padding para llegar hasta 46

        }else if (bytes>bytesframemax)
        {
            // modulo para saber cuantos frames llena, y con el resto vuelves a aplicar lo de arriba
            rest= bytes % bytesframemin;
            //resto del modulo le sumo el padding
            eth_frames= rest+ padding;

        }


        totalbytes = eth_frames * bytes;
        array[0] = totalbytes;
        array[1] = eth_frames;
        array[2] = padding;


        for(int i=0;i<3;i++) {
            switch(i) {
                case 0: System.out.print("total bytes: ");
                    break;
                case 1: System.out.print("ethernet frames: ");
                    break;
                case 2: System.out.print("padding: ");
                    break;
            }
            System.out.println(array[i]);
        }
        return array;
    }

}


