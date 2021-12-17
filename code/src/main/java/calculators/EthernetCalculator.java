package code.src.main.java.calculators;
import code.src.main.java.valueobjects.InputValues;
import code.src.main.java.valueobjects.L2Protocol;
import code.src.main.java.valueobjects.OutputValues;

public class EthernetCalculator implements Calculator{

    int eth_frames;
    int padding;
    int bytesframemax = 1500;
    int bytesframemin= 46;
    int rest;
    int totalBytesOfAllCells;


    @Override
    public OutputValues calculate(int bytes) {
        //-------------!
        if( bytes > bytesframemin && bytes < bytesframemax)
        {
            eth_frames = 1;
        }else if ( bytes < bytesframemin )
        {
            //es solo un frame y necesita padding pa llegar a 46
            eth_frames= bytes + padding;  //bytes enviados mas el padding para llegar hasta 4
        }else if (bytes > bytesframemax)
        {
            // modulo para saber cuantos frames llena, y con el resto vuelves a aplicar lo de arriba
            rest= bytes % bytesframemin;
            //resto del modulo le sumo el padding
            eth_frames= rest+ padding;
        }

        totalBytesOfAllCells = eth_frames * bytes;
        return new code.src.main.java.valueobjects.OutputValues(L2Protocol.ETHERNET, totalBytesOfAllCells,  eth_frames, padding);
    }

}


