package  calculators;
import valueobjects.InputValues;

public class EthernetCalculator implements Calculator{

    int eth_frames;GUIView1
    GUIView1.form
    int bTotal;
    int padding;
    int bytesframe = 1500;

    @Override
    public  OutputValues calculateEthernet(int bytes){
        int array[] = new int[3];

        if(bytes % bytesframe == 0) {
            eth_frames =(bytes / bytesframe);
        } else if (bytes > bytesframe){
            eth_frames = (bytes / bytesframe) + 1;
        }else {
            eth_frames = 1;
        }

        int rest = bytes % bytesCell;


        btotal = eth_frames * totalBytes;
        array[0] = btotal;
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
}
